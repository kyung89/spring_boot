package edu.pnu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private SecurityUserDetailsService userDetailsService;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

		security.userDetailsService(userDetailsService);
		
		security.authorizeHttpRequests(auth->auth
				.requestMatchers("/", "/system/**").permitAll()
				.requestMatchers("/board/**").authenticated()
				.requestMatchers("/admin/**").hasAnyRole("ADMIN")
				);
		
		security.csrf(csrf->csrf.disable());
		
		security.formLogin(frmLogin->frmLogin.loginPage("/system/login")
				.defaultSuccessUrl("/board/getBoardList", true));
		security.exceptionHandling(ex->ex.accessDeniedPage("/system/accessDenied"));
		
		security.logout(logout->logout
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/"));
		
		return security.build();
	}
	
	 @Bean
	 PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }

}
