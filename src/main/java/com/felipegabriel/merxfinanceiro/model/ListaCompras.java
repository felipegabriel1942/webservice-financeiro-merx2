package com.felipegabriel.merxfinanceiro.model;

import java.util.Date;

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
@Table(name = "lista_compras")
public class ListaCompras {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pklistacompras", nullable = false, unique = true)
	@Getter
	@Setter
	private Integer pkListaCompras;
	
	@JoinColumn(nullable = false)
	@Getter
	@Setter
	private String descricao;
	
	@JoinColumn(nullable = false)
	@Getter
	@Setter
	private Date data;
	
	@JoinColumn(nullable = false)
	@Getter
	@Setter
	private double listaValor;
	
	@JoinColumn(name = "fkusuario", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@Getter
	@Setter
	private Usuario fkUsuario;
	
	public ListaCompras() {

	}

	public ListaCompras(Integer pkListaCompras, String descricao, Date data, double listaValor, Usuario fkUsuario) {
		this.pkListaCompras = pkListaCompras;
		this.descricao = descricao;
		this.data = data;
		this.listaValor = listaValor;
		this.fkUsuario = fkUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fkUsuario == null) ? 0 : fkUsuario.hashCode());
		long temp;
		temp = Double.doubleToLongBits(listaValor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((pkListaCompras == null) ? 0 : pkListaCompras.hashCode());
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
		ListaCompras other = (ListaCompras) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fkUsuario == null) {
			if (other.fkUsuario != null)
				return false;
		} else if (!fkUsuario.equals(other.fkUsuario))
			return false;
		if (Double.doubleToLongBits(listaValor) != Double.doubleToLongBits(other.listaValor))
			return false;
		if (pkListaCompras == null) {
			if (other.pkListaCompras != null)
				return false;
		} else if (!pkListaCompras.equals(other.pkListaCompras))
			return false;
		return true;
	}
	
	
}
