package com.felipegabriel.merxfinanceiro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipegabriel.merxfinanceiro.model.ListaCompras;
import com.felipegabriel.merxfinanceiro.model.ListaComprasProduto;
import com.felipegabriel.merxfinanceiro.repository.ListaComprasProdutoRepository;

@Service
public class ListaComprasProdutoService {

	@Autowired
	private ListaComprasProdutoRepository ListaComprasProdutoRepository;

	public ListaComprasProduto salvarListaComprasProduto(ListaComprasProduto ListaComprasProduto) {
		return ListaComprasProdutoRepository.save(ListaComprasProduto);
	}

	public void deletarListaComprasProduto(Integer pkListaComprasProduto) {
		ListaComprasProdutoRepository.deleteById(pkListaComprasProduto);
	}

	public ListaComprasProduto buscarListaComprasProduto(Integer pkListaComprasProduto) {
		return ListaComprasProdutoRepository.findById(pkListaComprasProduto).orElse(null);
	}

	public List<ListaComprasProduto> listarListaComprasProduto() {
		return ListaComprasProdutoRepository.findAll();
	}

	public List<ListaComprasProduto> listarListaComprasProdutoPorLista(ListaCompras listaCompras) {
		return listarListaComprasProduto().stream()
				.filter(x -> x.getFkListaCompras().getPkListaCompras() == listaCompras.getPkListaCompras())
				.collect(Collectors.toList());
	}
}
