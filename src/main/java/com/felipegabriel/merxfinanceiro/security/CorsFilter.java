package com.felipegabriel.merxfinanceiro.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
		
	}


	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		 	HttpServletResponse response = (HttpServletResponse) servletResponse;
	        HttpServletRequest request = (HttpServletRequest) servletRequest;
	        request.getMethod();
	        response.setHeader("Access-Control-Allow-Origin", "*");
	        response.setHeader("Access-Control-Allow-Credentials", "true");
	        
	        
	        
	        if ("OPTIONS".equals(request.getMethod())) {
	            response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
	            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
	            response.setHeader("Access-Control-Max-Age", "3600");

	            response.setStatus(HttpServletResponse.SC_OK);
	        } else {
	        	filterChain.doFilter(request, response);
	        }
		
	}

	
	@Override
	public void destroy() {
		
	}


}
