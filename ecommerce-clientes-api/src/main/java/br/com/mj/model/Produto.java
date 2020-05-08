package br.com.mj.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Produto {
	
	private String id;
	private String nome;
	private BigDecimal valor;
}
