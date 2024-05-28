package edu.pnu.coonfig.filter;

import java.io.IOException;
import java.util.Optional;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import edu.pnu.domain.Member;
import edu.pnu.persistance.MemberRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@RequiredArgsConstructor
public class JWTAuthorizationFilter extends OncePerRequestFilter {
	
	// 인가 설정을 위해 사용자의 Role 정보를 읽어 들이기 위한 객체 설정
	private final MemberRepository memberRepository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse
			response, FilterChain filterChain) throws IOException, ServletException {
		String srcToken = request.getHeader("Authorization");
		// 요청 헤더에서 Authorization을 얻어온다.
		if (srcToken == null || !srcToken.startsWith("Bearer ")) { // 없거나 “Bearer ”로 시작하지 않는다면
			filterChain.doFilter(request, response);
			return;
		}
		String jwtToken = srcToken.replace("Bearer ", "");
		// 토큰에서 username 추출
		// 필터를 그냥 통과
		// 토큰에서 “Bearer ”를 제거
		String username =  JWT.require(Algorithm.HMAC256("edu.pnu.jwt")).build().verify(jwtToken).getClaim("username").asString();
		Optional<Member> opt = memberRepository.findById(username); // 토큰에서 얻은 username으로 DB를 검색해서 사용자를 검색
		if (!opt.isPresent()) {
			filterChain.doFilter(request, response);
			return;
		}
		Member findmember = opt.get();
		// DB에서 읽은 사용자 정보를 이용해서 UserDetails 타입의 객체를 생성
		User user = new User(findmember.getUsername(), findmember.getPassword(), 
				AuthorityUtils.createAuthorityList(findmember.getRole().toString()));
		// Authentication 객체를 생성 : 사용자명과 권한 관리를 위한 정보를 입력(암호는 필요 없음)
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		// 시큐리티 세션에 등록한다.
		SecurityContextHolder.getContext().setAuthentication(auth);
		filterChain.doFilter(request, response);
	}

	
}
