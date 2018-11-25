package net.yash.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // it refers to table or the data
public class Category {
	
	/* PRIVATE PARTS*/
	@Id  //
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO GENERATING THE IDENTITY 
	private int id;
	
	private String description;
	private String name;
	
	@Column(name = "image_url") //To manage The variable used here and sql coloumn field should be same
	private String imageURL;
	
	@Column(name = "is_active") //To manage The variable used here and sql coloumn field should be same
	private boolean active = true;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageURL;
	}
	public void setImageUrl(String imageUrl) {
		this.imageURL = imageUrl;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	//this method created after the queries generation.
	@Override
	public String toString() {
		return "Category [id=" + id + ", description=" + description + ", name=" + name + ", imageUrl=" + imageURL
				+ ", active=" + active + "]";
	} 
	
	
	
}
