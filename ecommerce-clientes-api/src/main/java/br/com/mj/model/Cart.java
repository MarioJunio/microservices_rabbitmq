package br.com.mj.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Cart {
	
	private String id;
	private List<CartItem> items = new ArrayList<>();
}
