package com.felipegabriel.merxfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipegabriel.merxfinanceiro.model.ListaCompras;

@Repository
public interface ListaComprasRepository extends JpaRepository<ListaCompras, Integer>{

}
