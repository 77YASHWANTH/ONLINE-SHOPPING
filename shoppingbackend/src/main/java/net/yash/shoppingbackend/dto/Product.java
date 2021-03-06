package net.yash.shoppingbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	//Private Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore //By using this annotation we can ignore this attribute not to converting to json format. 
	private String code;
	
	@NotBlank(message = "Please Enter The Product Name!")
	private String name;
	
	@NotBlank(message = "Please Enter The Brand Name")
	private String brand;
	
	
	@NotBlank(message = "Please Enter The Description")
	private String description;
	
	@Column(name = "unit_price")
	@Min(value=1,message = "Price Cannot Be Less Than 1!")
	private double unitPrice;
	@Column
	private int quantity;
	
	@Column(name = "is_active")	
	@JsonIgnore //By using this annotation we can ignore this attribute not to converting to json format. 
	private boolean active;
	
	@Column(name = "category_id")
	@JsonIgnore //By using this annotation we can ignore this attribute not to converting to json format. 
	private int categoryId;
	
	@Column(name = "supplier_id")
	@JsonIgnore //By using this annotation we can ignore this attribute not to converting to json format. 
	private int supplierId;
	
	@JsonIgnore //By using this annotation we can ignore this attribute not to converting to json format. 
	private int purchases;
	
	@JsonIgnore //By using this annotation we can ignore this attribute not to converting to json format. 
	private int views; 
	
	@Transient
	private MultipartFile file; 
	
	
	
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	//Default Constructor 
	public Product() { // using for creating random id
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	//Setters And Getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getPurchases() {
		return purchases;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views="
				+ views + "]";
	}
	
	
	
	
}
