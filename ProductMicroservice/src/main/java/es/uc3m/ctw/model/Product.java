package es.uc3m.ctw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idproduct")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;
	
	private String name;
	
	private String description;
	
	private double price;
	
	private int stock;
	
	private byte[] product_image;
	
	private String seller;

	public byte[] getProductImage() {
		return product_image;
	}

	public void setProductImage(byte[] productImage) {
		this.product_image = productImage;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	
}
