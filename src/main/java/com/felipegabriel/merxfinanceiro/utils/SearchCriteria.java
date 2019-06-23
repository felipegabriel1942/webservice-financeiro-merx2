package com.felipegabriel.merxfinanceiro.utils;

import lombok.Getter;
import lombok.Setter;

public class SearchCriteria {

	@Getter
	@Setter
    private String key;
	
	@Getter
	@Setter
    private String operation;
	
	@Getter
	@Setter
    private Object value1;
	
	@Getter
	@Setter
    private Object value2;

    public SearchCriteria() {

    }

	public SearchCriteria(String key, String operation, Object value1, Object value2) {
		super();
		this.key = key;
		this.operation = operation;
		this.value1 = value1;
		this.value2 = value2;
	}

}
