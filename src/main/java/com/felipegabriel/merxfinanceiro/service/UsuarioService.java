package com.felipegabriel.merxfinanceiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.felipegabriel.merxfinanceiro.model.Usuario;
import com.felipegabriel.merxfinanceiro.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public Usuario salvarUsuario(Usuario usuario) {
		usuario.setSenha(pe.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}
	
	public void deletarUsuario(Integer pkUsuario) {
		usuarioRepository.deleteById(pkUsuario);
	}
	
	public Usuario buscarUsuario(Integer pkUsuario) {
		return usuarioRepository.findById(pkUsuario).orElse(null);
	}
	
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarUsuarioPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
}
