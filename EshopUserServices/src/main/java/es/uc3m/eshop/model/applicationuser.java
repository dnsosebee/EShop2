package es.uc3m.eshop.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the applicationUser database table.
 * 
 */
@Entity
public class applicationuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String address;

	private String name;

	private String password;

	private int role;

	private String surname;

	//bi-directional many-to-one association to OldProduct
	@OneToMany(mappedBy="applicationUser")
	@JsonIgnore
	private List<oldproduct> oldProducts;

	//bi-directional many-to-many association to Product
	@ManyToMany(mappedBy="applicationUsers")
	@JsonIgnore
	private List<Product> products;

	public applicationuser() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return this.role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<oldproduct> getOldProducts() {
		return this.oldProducts;
	}

	public void setOldProducts(List<oldproduct> oldProducts) {
		this.oldProducts = oldProducts;
	}

	public oldproduct addOldProduct(oldproduct oldProduct) {
		getOldProducts().add(oldProduct);
		oldProduct.setApplicationUser(this);

		return oldProduct;
	}

	public oldproduct removeOldProduct(oldproduct oldProduct) {
		getOldProducts().remove(oldProduct);
		oldProduct.setApplicationUser(null);

		return oldProduct;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}