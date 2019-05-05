package com.felipegabriel.merxfinanceiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produto_tipo")
public class ProdutoTipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkprodutotipo", nullable = false, unique = true)
	@Getter
	@Setter
	private Integer pkProdutoTipo;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String descricao;
	
	@Getter
	@Setter
	private String foto;
	
	public ProdutoTipo() {
		
	}

	public ProdutoTipo(Integer pkProdutoTipo, String descricao, String foto) {
		this.pkProdutoTipo = pkProdutoTipo;
		this.descricao = descricao;
		this.foto = foto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((pkProdutoTipo == null) ? 0 : pkProdutoTipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoTipo other = (ProdutoTipo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (pkProdutoTipo == null) {
			if (other.pkProdutoTipo != null)
				return false;
		} else if (!pkProdutoTipo.equals(other.pkProdutoTipo))
			return false;
		return true;
	}
	
	
}
