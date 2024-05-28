package edu.pnu.coonfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

import edu.pnu.coonfig.filter.JWTAuthenticationFilter;
import edu.pnu.coonfig.filter.JWTAuthorizationFilter;
import edu.pnu.persistance.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	 private final OAuth2SuccessHandler successHandler;
	 private final MemberRepository memberRepository;
	 private final AuthenticationConfiguration authenticationConfiguration;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable());

		http.authorizeHttpRequests(auth->auth
				.requestMatchers("/member/**").authenticated()
				.requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().permitAll());


		//http.formLogin(frmLogin->frmLogin.disable());
		http.httpBasic(basic->basic.disable());

		http.sessionManagement(ssm->ssm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		// 스프링 시큐리티가 등록한 필터체인의 뒤에 작성한 필터를 추가한다.
		 http.addFilter(new JWTAuthenticationFilter(
		 authenticationConfiguration.getAuthenticationManager()));
		 
		 http.addFilterBefore(new JWTAuthorizationFilter(memberRepository), AuthorizationFilter.class);
				 
		 http.oauth2Login(oauth2->oauth2.successHandler(successHandler));
		 
		return http.build();
	}

	@Autowired
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.inMemoryAuthentication()
//		.withUser("manager")
//		.password("{noop}abcd")
//		.roles("MANAGER");
//
//		auth.inMemoryAuthentication()
//		.withUser("admin")
//		.password("{noop}abcd")
//		.roles("ADMIN");
		}



}
