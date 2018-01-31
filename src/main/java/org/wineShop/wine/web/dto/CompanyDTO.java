package org.wineShop.wine.web.dto;



public class CompanyDTO {

	private Long id;
	private String name;
	private String pib;
	private String country;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long newsId) {
		this.id = newsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String title) {
		this.name = title;
	}
	public String getPib() {
		return pib;
	}
	public void setPib(String tagline) {
		this.pib = tagline;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String text) {
		this.country = text;
	}

	
	
	
}
