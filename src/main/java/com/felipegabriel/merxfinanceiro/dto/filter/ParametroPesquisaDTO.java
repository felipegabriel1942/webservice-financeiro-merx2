package com.felipegabriel.merxfinanceiro.dto.filter;

import lombok.Getter;
import lombok.Setter;

public class ParametroPesquisaDTO {
	
	@Getter
	@Setter
	private CampoPesquisaDTO campo;
	
	@Getter
	@Setter
	private CondicaoPesquisaDTO condicao;
	
	@Getter
	@Setter
	private String parametro1;
	
	@Getter
	@Setter
	private String parametro2;
	
	@Getter
	@Setter
	private Integer tamanho;
	
	@Getter
	@Setter
	private Integer pagina;

}
