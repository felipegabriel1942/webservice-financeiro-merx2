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
@Table(name = "lista_compras_produto")
public class ListaComprasProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pklistaproduto", nullable = false, unique = true)
	@Getter
	@Setter
	private Integer pkListaProduto;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private Integer quantidade;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private double produtovalor;
	
	@JoinColumn(name = "fkproduto", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@Getter
	@Setter
	private Produto fkProduto;
	
	@JoinColumn(name = "fklistacompras", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@Getter
	@Setter
	private ListaCompras fkListaCompras;
	
	public ListaComprasProduto() {
		
	}

	public ListaComprasProduto(Integer pkListaProduto, Integer quantidade, double produtovalor, Produto fkProduto,
			ListaCompras fkListaCompras) {
		super();
		this.pkListaProduto = pkListaProduto;
		this.quantidade = quantidade;
		this.produtovalor = produtovalor;
		this.fkProduto = fkProduto;
		this.fkListaCompras = fkListaCompras;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fkListaCompras == null) ? 0 : fkListaCompras.hashCode());
		result = prime * result + ((fkProduto == null) ? 0 : fkProduto.hashCode());
		result = prime * result + ((pkListaProduto == null) ? 0 : pkListaProduto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(produtovalor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
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
		ListaComprasProduto other = (ListaComprasProduto) obj;
		if (fkListaCompras == null) {
			if (other.fkListaCompras != null)
				return false;
		} else if (!fkListaCompras.equals(other.fkListaCompras))
			return false;
		if (fkProduto == null) {
			if (other.fkProduto != null)
				return false;
		} else if (!fkProduto.equals(other.fkProduto))
			return false;
		if (pkListaProduto == null) {
			if (other.pkListaProduto != null)
				return false;
		} else if (!pkListaProduto.equals(other.pkListaProduto))
			return false;
		if (Double.doubleToLongBits(produtovalor) != Double.doubleToLongBits(other.produtovalor))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		return true;
	}
	
	
	
	
}
