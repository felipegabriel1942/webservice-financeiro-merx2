package com.felipegabriel.merxfinanceiro.dto;

import lombok.Getter;
import lombok.Setter;

public class CredenciaisDTO {
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String senha;
	
	
	public CredenciaisDTO() {
		
	}
	
	public CredenciaisDTO(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	

}
