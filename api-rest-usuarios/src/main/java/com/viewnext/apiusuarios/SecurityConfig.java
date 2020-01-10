package com.viewnext.apiusuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.viewnext.apiusuarios.servicios.ServicioUsuarios;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private ServicioUsuarios srvUsu;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPassEnc = new BCryptPasswordEncoder();
		return bCryptPassEnc;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(srvUsu)
			.passwordEncoder(encoder);
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//				.password("123")
//				.roles("ADMIN")
//			.and()
//				.withUser("user")
//				.password("123")
//			.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
		
}
