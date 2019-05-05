package com.felipegabriel.merxfinanceiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkproduto", nullable = false, unique = true)
	@Getter
	@Setter
	private Integer pkProduto;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String descricao;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private double valor;
	
	@Getter
	@Setter
	private String foto;
	
	@JoinColumn(name = "fkprodutotipo", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@Getter
	@Setter
	private ProdutoTipo fkProdutoTipo;
	
	public Produto() {
	
	}
	
	public Produto(Integer pkProduto, String descricao, double valor, String foto, ProdutoTipo fkProdutoTipo) {
		this.pkProduto = pkProduto;
		this.descricao = descricao;
		this.valor = valor;
		this.foto = foto;
		this.fkProdutoTipo = fkProdutoTipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fkProdutoTipo == null) ? 0 : fkProdutoTipo.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((pkProduto == null) ? 0 : pkProduto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fkProdutoTipo == null) {
			if (other.fkProdutoTipo != null)
				return false;
		} else if (!fkProdutoTipo.equals(other.fkProdutoTipo))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (pkProduto == null) {
			if (other.pkProduto != null)
				return false;
		} else if (!pkProduto.equals(other.pkProduto))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	
	

}
