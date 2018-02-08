package org.wineShop.wine.web.dto;

import java.util.Date;

public class ShoppingCartDTO {
	
	private Long id;
	private Integer stock;
	private double amount;
	private String status;
	private Date date;
	private Long userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private Long wineId;
	private String wineName;
	private int wineQuantity;
	private Double winePrice;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Long getWineId() {
		return wineId;
	}
	public void setWineId(Long wineId) {
		this.wineId = wineId;
	}
	public String getWineName() {
		return wineName;
	}
	public void setWineName(String wineName) {
		this.wineName = wineName;
	}
	public int getWineQuantity() {
		return wineQuantity;
	}
	public void setWineQuantity(int wineQuantity) {
		this.wineQuantity = wineQuantity;
	}
	public Double getWinePrice() {
		return winePrice;
	}
	public void setWinePrice(Double winePrice) {
		this.winePrice = winePrice;
	}
	
	
	
}
