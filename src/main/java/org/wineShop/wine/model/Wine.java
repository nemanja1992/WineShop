package org.wineShop.wine.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Wine {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String name;
	@Column
	private Double alcoholPercent;
	@Column
	private Date vintage;
	@ManyToOne(fetch=FetchType.EAGER)
	private Company company;
	@ManyToOne(fetch=FetchType.EAGER)
	private Type type;
	
	
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
	public Date getVintage() {
		return vintage;
	}
	public void setVintage(Date commentDate) {
		this.vintage = commentDate;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
		if(company!=null && !company.getListOfWines().contains(this)){
			company.getListOfWines().add(this);
		}
	}
	public Type getType() {
		return type;
	}
	public void setType (Type type){
		this.type = type;
		if(type!=null && !type.getWineList().contains(this)){
			type.getWineList().add(this);
		}
	}
	public Double getAlcoholPercent() {
		return alcoholPercent;
	}
	public void setAlcoholPercent(Double alcoholPercent) {
		this.alcoholPercent = alcoholPercent;
	}
	
	
	
	
	
}
