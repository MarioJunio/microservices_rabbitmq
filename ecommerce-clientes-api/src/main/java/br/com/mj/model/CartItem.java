package br.com.mj.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartItem {
	
	private String id;
	private Produto produto;
	private int quantidade;
	private BigDecimal valor;
}
