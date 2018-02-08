package org.wineShop.wine.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="shopping_cart")
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="wine_id")
	private Wine wine;
	
	@Column(name = "stock")
    @NotNull
    private Integer stock;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		if(user!=null && !user.getShoppingCarts().contains(this)){
			user.getShoppingCarts().add(this);
		}
	}

	public Wine getWine() {
		return wine;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
		if(wine!=null && !wine.getShoppingCarts().contains(this)){
			wine.getShoppingCarts().add(this);
		}
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
    
}
