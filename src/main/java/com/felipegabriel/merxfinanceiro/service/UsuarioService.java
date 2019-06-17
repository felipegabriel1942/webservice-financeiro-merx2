package com.felipegabriel.merxfinanceiro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	public Usuario editarUsuario(Usuario usuario) {
		if (usuario.getSenha() != null) {
			usuario.setSenha(pe.encode(usuario.getSenha()));
		} else {
			usuario.setSenha(buscarUsuario(usuario.getPkUsuario()).getSenha());
		}
		return usuarioRepository.save(usuario);
	}

	public void deletarUsuario(Integer pkUsuario) {
		usuarioRepository.deleteById(pkUsuario);
	}

	public Usuario buscarUsuario(Integer pkUsuario) {
		return usuarioRepository.findById(pkUsuario).orElse(null);
	}

	public Usuario buscarUsuarioPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	public List<Usuario> buscarUsuarioPorNome(String nome) {
		return usuarioRepository.findAll().stream().filter(x -> x.getNome().toUpperCase().contains(nome.toUpperCase()))
				.collect(Collectors.toList());
	}
	
	public Page<Usuario> listarUsuariosPorPaginacao(Integer pagina, Integer tamanho) {
		PageRequest pageRequest = PageRequest.of(pagina, tamanho);
		return usuarioRepository.findAll(pageRequest);
	}
	
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

}
