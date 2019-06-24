package com.felipegabriel.merxfinanceiro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.felipegabriel.merxfinanceiro.dto.filter.ParametroPesquisaDTO;
import com.felipegabriel.merxfinanceiro.filter.UsuarioFilter;
import com.felipegabriel.merxfinanceiro.model.Usuario;
import com.felipegabriel.merxfinanceiro.repository.UsuarioRepository;
import com.felipegabriel.merxfinanceiro.utils.SearchCriteria;

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

	public Page<Usuario> listarUsuariosPorPaginacaoFilter(List<ParametroPesquisaDTO> parametros) {
		PageRequest pageRequest = PageRequest.of(parametros.get(0).getPagina(), (parametros.get(0).getTamanho()));
		UsuarioFilter filterPkUsuario = null;
		UsuarioFilter filterNome = null;
		UsuarioFilter filterDataNascimento = null;
		UsuarioFilter filterPerfil = null;

		for (ParametroPesquisaDTO p : parametros) {
			if (p.getCampo().getNomeCampoObjeto().equals("pkUsuario")) {
				filterPkUsuario = new UsuarioFilter(new SearchCriteria("pkUsuario", p.getCondicao().getValorCondicao(),
						p.getParametro1(), p.getParametro2()));
			}

			if (p.getCampo().getNomeCampoObjeto().equals("nome")) {
				filterNome = new UsuarioFilter(new SearchCriteria("nome", p.getCondicao().getValorCondicao(),
						p.getParametro1(), p.getParametro2()));
			}
			
			if (p.getCampo().getNomeCampoObjeto().equals("usuarioPerfil")) {
				filterPerfil = new UsuarioFilter(new SearchCriteria("usuarioPerfil", p.getCondicao().getValorCondicao(),
						p.getParametro1(), p.getParametro2()));
			}

			if (p.getCampo().getNomeCampoObjeto().equals("dataNascimento")) {
				filterDataNascimento = new UsuarioFilter(new SearchCriteria("dataNascimento",
						p.getCondicao().getValorCondicao(), p.getParametro1(), p.getParametro2()));
			}
		}

		Page<Usuario> resultado = usuarioRepository
				.findAll(Specification.where(filterPkUsuario).and(filterNome).and(filterDataNascimento).and(filterPerfil), pageRequest);

		return resultado;
	}

}
