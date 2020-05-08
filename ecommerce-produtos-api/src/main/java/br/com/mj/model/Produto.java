package br.com.mj.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Produto {
	
	public Produto(String id) {
		this.id = id;
	}
	
	private String id;
	private String nome;
	private BigDecimal valor;
}
