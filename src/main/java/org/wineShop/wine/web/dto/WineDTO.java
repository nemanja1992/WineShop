package org.wineShop.wine.web.dto;

import java.sql.Date;

public class WineDTO {

	
	private Long id;
	private String name;
	private Double alcoholPercent;
	private Double price;
	private int quantity;
	private Date vintage;
	private Long companyId;
	private String companyName;
	private String companyPib;
	private String companyCountry;
	private Long typeId;
	private String typeName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long commentId) {
		this.id = commentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String commentAuthorName) {
		this.name = commentAuthorName;
	}

	public Double getAlcoholPercent() {
		return alcoholPercent;
	}
	public void setAlcoholPercent(Double alcoholPercent) {
		this.alcoholPercent = alcoholPercent;
	}
	public Date getVintage() {
		return vintage;
	}
	public void setVintage(Date commentDate) {
		this.vintage = commentDate;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long newsId) {
		this.companyId = newsId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String title) {
		this.companyName = title;
	}
	public String getCompanyPib() {
		return companyPib;
	}
	public void setCompanyPib(String tagline) {
		this.companyPib = tagline;
	}
	public String getCompanyCountry() {
		return companyCountry;
	}
	public void setCompanyCountry(String text) {
		this.companyCountry = text;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
