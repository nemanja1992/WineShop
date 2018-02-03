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
public class Type {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String name;
	@OneToMany(mappedBy="type",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Wine> wineList;
	
	
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
	public List<Wine> getWineList() {
		return wineList;
	}
	public void setWineList(List<Wine> wineList) {
		this.wineList = wineList;
	}

	public void addWine (Wine wine){
		this.wineList.add(wine);
		
		if(!this.equals(wine.getType())){
			wine.setType(this);
		}
	}
	
	
}
