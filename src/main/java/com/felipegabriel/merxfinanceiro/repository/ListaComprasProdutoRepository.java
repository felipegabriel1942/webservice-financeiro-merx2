package com.felipegabriel.merxfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipegabriel.merxfinanceiro.model.ListaComprasProduto;

@Repository
public interface ListaComprasProdutoRepository extends JpaRepository<ListaComprasProduto, Integer>{

}
