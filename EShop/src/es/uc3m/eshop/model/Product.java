package es.uc3m.eshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idProduct;

	private String description;

	@Lob
	private byte[] image;

	private String name;

	private float price;

	private int stock;

	//bi-directional many-to-many association to ApplicationUser
	@ManyToMany
	@JoinTable(
		name="wishlist"
		, joinColumns={
			@JoinColumn(name="idProduct")
			}
		, inverseJoinColumns={
			@JoinColumn(name="email")
			}
		)
	private List<ApplicationUser> applicationUsers;

	public Product() {
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<ApplicationUser> getApplicationUsers() {
		return this.applicationUsers;
	}

	public void setApplicationUsers(List<ApplicationUser> applicationUsers) {
		this.applicationUsers = applicationUsers;
	}

}