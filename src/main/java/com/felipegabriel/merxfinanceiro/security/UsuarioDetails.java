package com.felipegabriel.merxfinanceiro.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

public class UsuarioDetails implements UserDetails {


	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String senha;
	
	@Setter
	private Collection<? extends GrantedAuthority> authorities;
	
	public UsuarioDetails(Integer id, String email, String senha) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
	}	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
