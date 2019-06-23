package com.felipegabriel.merxfinanceiro.dto.filter;

import lombok.Getter;
import lombok.Setter;

public class CondicaoPesquisaDTO {
	
	@Getter
	@Setter
	private String valorCondicao;
	
	@Getter
	@Setter
	private String valorCondicaoLabel;
	
	@Getter
	@Setter
	private String label;
}
