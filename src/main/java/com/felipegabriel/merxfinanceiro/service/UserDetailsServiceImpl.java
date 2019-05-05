package com.felipegabriel.merxfinanceiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.felipegabriel.merxfinanceiro.model.Usuario;
import com.felipegabriel.merxfinanceiro.repository.UsuarioRepository;
import com.felipegabriel.merxfinanceiro.security.UsuarioDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UsuarioDetails(usuario.getPkUsuario(), usuario.getEmail(), usuario.getSenha());
	}

}
