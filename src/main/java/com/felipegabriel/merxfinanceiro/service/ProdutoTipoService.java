package com.felipegabriel.merxfinanceiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipegabriel.merxfinanceiro.model.ProdutoTipo;
import com.felipegabriel.merxfinanceiro.repository.ProdutoTipoRepository;

@Service
public class ProdutoTipoService {
	
	@Autowired
	private ProdutoTipoRepository ProdutoTipoRepository;
	
	public ProdutoTipo salvarProdutoTipo(ProdutoTipo ProdutoTipo) {
		return ProdutoTipoRepository.save(ProdutoTipo);
	}
	
	public void deletarProdutoTipo(Integer pkProdutoTipo) {
		ProdutoTipoRepository.deleteById(pkProdutoTipo);
	}
	
	public ProdutoTipo buscarProdutoTipo(Integer pkProdutoTipo) {
		return ProdutoTipoRepository.findById(pkProdutoTipo).orElse(null);
	}
	
	public List<ProdutoTipo> listarProdutoTipos() {
		return ProdutoTipoRepository.findAll();
	}
}
