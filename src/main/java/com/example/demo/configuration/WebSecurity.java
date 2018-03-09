package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.service.UserSecurityService;

@Configuration
@EnableWebSecurity
public class WebSecurity  extends WebSecurityConfigurerAdapter{

	@Autowired
	@Qualifier("userSecurityService")
	private UserSecurityService userdetailsdervice;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userdetailsdervice);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			.antMatchers("/login").permitAll() //Permitimos el acceso a LOGIN
			.anyRequest().authenticated() // Cualquier otra URL necesita autenticación
			.and()
			// Las peticiones de la URL LOGIN pasan estos Filtros
			.addFilterBefore(new LoginFilter("/login", authenticationManager())
					, UsernamePasswordAuthenticationFilter.class)
			
			// Otras peticiones validarán previamente el token
			.addFilterBefore(new JwtFilter()
					, UsernamePasswordAuthenticationFilter.class);
	}

}
