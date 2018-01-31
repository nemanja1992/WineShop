package org.wineShop.wine.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Company {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String name;
	@Column
	private String pib;
	@Column
	private String country;
	@OneToMany(mappedBy="company",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Wine> listOfWines;
	
	
	
	
	public Company() {
		super();
	}
	
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


	public List<Wine> getListOfWines() {
		return listOfWines;
	}
	public void setListOfWines(List<Wine> listOfComments) {
		this.listOfWines = listOfComments;
	}
	public void  addWine(Wine wine){
		this.listOfWines.add(wine);
		if(!this.equals(wine.getCompany())){
			wine.setCompany(this);
		}
	}


	
	
}
