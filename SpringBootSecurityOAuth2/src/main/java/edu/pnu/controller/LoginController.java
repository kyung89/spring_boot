package edu.pnu.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/login")
	public void login() {
		System.out.println("login 요청");
	}
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
		System.out.println(
				"loginSuccess 요청");
	}

	@GetMapping("/accessDenied")
	public void accessDenied() {
		System.out.println("accessDenied");
	}

	@GetMapping("/auth")
	public @ResponseBody ResponseEntity<?> auth(@AuthenticationPrincipal User user) {

		if (user == null) {
			return ResponseEntity.ok("로그인 상태가 아닙니다.");
		}
		return ResponseEntity.ok(user);
	}

	@GetMapping("/join")
	public void join() {
	}

	@PostMapping("/join")
	public String joinProc(Member member) {
		memberService.save(member);
		return "welcome";
	}

	// 로그인세션정보확인용URL
	@GetMapping("/oauth")
	public @ResponseBody String auth(@AuthenticationPrincipal OAuth2User user) {
		if (user == null) return "OAuth2:null";
		// 자동회원가입을한다면이용할정보확인
		System.out.println("attributes:" + user.getAttributes());
		return "OAuth2:" + user;
	}
}
