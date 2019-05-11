package com.felipegabriel.merxfinanceiro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.SessionManagementFilter;

import com.felipegabriel.merxfinanceiro.security.CorsFilter;
import com.felipegabriel.merxfinanceiro.security.JWTAuthenticationFilter;
import com.felipegabriel.merxfinanceiro.security.JWTAuthorizationFilter;
import com.felipegabriel.merxfinanceiro.security.JWTUtil;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JWTUtil jwtUtil;

	@Bean
	CorsFilter corsFilter() {
		CorsFilter filter = new CorsFilter();
		return filter;
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(corsFilter(), SessionManagementFilter.class).csrf().disable().authorizeRequests()
		.antMatchers("/login").permitAll().anyRequest().authenticated().and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil))
		.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));

	}

	/*
	 * @Bean CorsConfigurationSource corsConfigurationSource() { CorsConfiguration
	 * configuration = new CorsConfiguration();
	 * configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE",
	 * "HEAD")); UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
	 * configuration); return source; }
	 */

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
