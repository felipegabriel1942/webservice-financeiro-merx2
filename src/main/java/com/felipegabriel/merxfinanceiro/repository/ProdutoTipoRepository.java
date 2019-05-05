package com.felipegabriel.merxfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipegabriel.merxfinanceiro.model.ProdutoTipo;

@Repository
public interface ProdutoTipoRepository extends JpaRepository<ProdutoTipo, Integer>{

}
