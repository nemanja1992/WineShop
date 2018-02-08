package org.wineShop.wine.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name= "user")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column
	@NotNull
	private String name;
	@Email
	@Column
	@NotNull
	private String email;
	@Column
	@NotNull
	private String password;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<ShoppingCart> shoppingCarts = new HashSet<>();
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}
	public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}
	
	

}
