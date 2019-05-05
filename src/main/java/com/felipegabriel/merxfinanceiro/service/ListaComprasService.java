package com.felipegabriel.merxfinanceiro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipegabriel.merxfinanceiro.model.ListaCompras;
import com.felipegabriel.merxfinanceiro.model.Usuario;
import com.felipegabriel.merxfinanceiro.repository.ListaComprasRepository;

@Service
public class ListaComprasService {

	@Autowired
	private ListaComprasRepository ListaComprasRepository;

	public ListaCompras salvarListaCompras(ListaCompras ListaCompras) {
		return ListaComprasRepository.save(ListaCompras);
	}

	public void deletarListaCompras(Integer pkListaCompras) {
		ListaComprasRepository.deleteById(pkListaCompras);
	}

	public ListaCompras buscarListaCompras(Integer pkListaCompras) {
		return ListaComprasRepository.findById(pkListaCompras).orElse(null);
	}

	public List<ListaCompras> listarListaCompras() {
		return ListaComprasRepository.findAll();
	}

	public List<ListaCompras> listarListaComprasPorUsuario(Usuario usuario) {
		return listarListaCompras().stream().filter(x -> x.getFkUsuario().getPkUsuario() == usuario.getPkUsuario())
				.collect(Collectors.toList());
	}
}
