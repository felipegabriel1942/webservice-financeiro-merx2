package com.felipegabriel.merxfinanceiro.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.felipegabriel.merxfinanceiro.security.UsuarioDetails;

public class UserService {
	
	public static UsuarioDetails authenticated() {
		try {
			return (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
