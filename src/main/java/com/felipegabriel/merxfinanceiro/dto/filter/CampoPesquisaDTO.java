package com.felipegabriel.merxfinanceiro.dto.filter;

import lombok.Getter;
import lombok.Setter;

public class CampoPesquisaDTO {
	
	@Getter
	@Setter
	private String nomeCampoObjeto;
	
	@Getter
	@Setter
	private String nomeCampoLabel;
	
	@Getter
	@Setter
	private String tipo;
}
