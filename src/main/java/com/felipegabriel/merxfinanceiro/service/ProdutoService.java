package com.felipegabriel.merxfinanceiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipegabriel.merxfinanceiro.model.Produto;
import com.felipegabriel.merxfinanceiro.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository ProdutoRepository;
	
	public Produto salvarProduto(Produto Produto) {
		return ProdutoRepository.save(Produto);
	}
	
	public void deletarProduto(Integer pkProduto) {
		ProdutoRepository.deleteById(pkProduto);
	}
	
	public Produto buscarProduto(Integer pkProduto) {
		return ProdutoRepository.findById(pkProduto).orElse(null);
	}
	
	public List<Produto> listarProdutos() {
		return ProdutoRepository.findAll();
	}
}
