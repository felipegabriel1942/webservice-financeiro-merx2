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
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pkusuario", nullable = false, unique = true)
	@Getter
	@Setter
	private Integer pkUsuario;
	
	@Column(nullable = false, unique = true)
	@Getter
	@Setter
	private String email;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String senha;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String token;
	
	@Getter
	@Setter
	private String foto;
	
	@Getter
	@Setter
	private String usuarioPerfil;
	
	public Usuario() {
		
	}

	public Usuario(Integer pkUsuario, String email, String senha, String token, String foto, String usuarioPerfil) {
		this.pkUsuario = pkUsuario;
		this.email = email;
		this.senha = senha;
		this.token = token;
		this.foto = foto;
		this.usuarioPerfil = usuarioPerfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((pkUsuario == null) ? 0 : pkUsuario.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((usuarioPerfil == null) ? 0 : usuarioPerfil.hashCode());
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
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (pkUsuario == null) {
			if (other.pkUsuario != null)
				return false;
		} else if (!pkUsuario.equals(other.pkUsuario))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (usuarioPerfil == null) {
			if (other.usuarioPerfil != null)
				return false;
		} else if (!usuarioPerfil.equals(other.usuarioPerfil))
			return false;
		return true;
	}
	
	
	
	
}
