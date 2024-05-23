package edu.pnu.coonfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//	@Bean
//	SecurityFilterChain filter(HttpSecurity http) throws Exception {
//		return http.build();
//	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(security->security
				.requestMatchers("/member/**").authenticated()
				.requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().permitAll());

		http.csrf(cf->cf.disable());

		//http.formLogin(form->{});

		http.formLogin(form->form.loginPage("/login")
				.defaultSuccessUrl("/loginSuccess", true));

		http.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied"));

		http.logout(logout->logout
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/login"));
		
		http.headers(hr->hr.frameOptions(fo->fo.disable()));
		
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


	 @Bean
	 PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }

}
