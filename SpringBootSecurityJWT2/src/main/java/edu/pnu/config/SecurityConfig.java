package edu.pnu.config;

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

import edu.pnu.config.filter.JWTAuthenticationFilter;
import edu.pnu.config.filter.JWTAuthorizationFilter;
import edu.pnu.persistence.MemberRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	 private MemberRepository memberRepository;
	
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;
	
	 @Bean
	 PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	 
	 @Bean
	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http.csrf(csrf->csrf.disable());
		 
		 http.authorizeHttpRequests(auth->auth
				 .requestMatchers("/member/**").authenticated()
				 .requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
				 .requestMatchers("/admin/**").hasRole("ADMIN")
				 .anyRequest().permitAll());
		 
		 http.formLogin(frmLogin->frmLogin.disable());
		 http.httpBasic(basic->basic.disable());
		 
		 http.sessionManagement(ssmn->ssmn.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		 
		 http.addFilter(new JWTAuthenticationFilter(authenticationConfiguration.getAuthenticationManager()));
		 
		 http.addFilterBefore(new JWTAuthorizationFilter(memberRepository), AuthorizationFilter.class);
		 
		 return http.build();
	 }

}
