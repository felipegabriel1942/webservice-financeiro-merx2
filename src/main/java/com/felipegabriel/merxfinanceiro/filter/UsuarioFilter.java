package com.felipegabriel.merxfinanceiro.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.felipegabriel.merxfinanceiro.model.Usuario;
import com.felipegabriel.merxfinanceiro.utils.SearchCriteria;

public class UsuarioFilter implements Specification<Usuario> {

	private static final long serialVersionUID = 1L;

	private SearchCriteria criteria;

	public UsuarioFilter(final SearchCriteria criteria) {
		super();
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		switch (criteria.getOperation()) {
		case "CONTEM":
			return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue1() + "%");
		case "INICIA_COM":
			return builder.like(root.get(criteria.getKey()), criteria.getValue1() + "%");
		case "IGUAL":
			return builder.like(root.get(criteria.getKey()), criteria.getValue1().toString());
		case "MAIOR":
			return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue1().toString());
		case "MENOR":
			return builder.lessThan(root.get(criteria.getKey()), criteria.getValue1().toString());
		case "MAIOR_IGUAL":
			return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue1().toString());
		case "MENOR_IGUAL":
			return builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue1().toString());
		case "ENTRE":
			return builder.and(
					builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue1().toString()),
					builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue2().toString()));
		case "MAIOR_DATE":
			try {
				return builder.greaterThan(root.get(criteria.getKey()),
						dateFormat.parse(criteria.getValue1().toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		case "MENOR_DATE":
			try {
				return builder.lessThan(root.get(criteria.getKey()), dateFormat.parse(criteria.getValue1().toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		case "MAIOR_IGUAL_DATE":
			try {
				return builder.greaterThanOrEqualTo(root.get(criteria.getKey()),
						dateFormat.parse(criteria.getValue1().toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		case "MENOR_IGUAL_DATE":
			try {
				return builder.lessThanOrEqualTo(root.get(criteria.getKey()),
						dateFormat.parse(criteria.getValue1().toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		case "ENTRE_DATE":
			try {
				return builder.and(
						builder.greaterThanOrEqualTo(root.get(criteria.getKey()),
								dateFormat.parse(criteria.getValue1().toString())),
						builder.lessThanOrEqualTo(root.get(criteria.getKey()),
								dateFormat.parse(criteria.getValue2().toString())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		default:
			return null;
		}

	}

}
