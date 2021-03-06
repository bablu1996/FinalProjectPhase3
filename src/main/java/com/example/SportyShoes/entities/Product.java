package com.example.SportyShoes.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@Column(name = "product_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, 
			mappedBy = "products", targetEntity = Order.class)
	private Set<Order> order = new HashSet<>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

}
