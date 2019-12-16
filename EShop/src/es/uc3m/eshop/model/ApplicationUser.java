package es.uc3m.eshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the applicationUser database table.
 * 
 */
public class ApplicationUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;

	private String address;

	private String name;

	private String password;

	private int role;

	private String surname;

	//bi-directional many-to-one association to OldProduct
//	private List<OldProduct> oldProducts;
//
//	//bi-directional many-to-many association to Product
//	private List<Product> products;

	public ApplicationUser() {
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

//	public List<OldProduct> getOldProducts() {
//		return this.oldProducts;
//	}
//
//	public void setOldProducts(List<OldProduct> oldProducts) {
//		this.oldProducts = oldProducts;
//	}
//
//	public OldProduct addOldProduct(OldProduct oldProduct) {
//		getOldProducts().add(oldProduct);
//		oldProduct.setApplicationUser(this);
//
//		return oldProduct;
//	}
//
//	public OldProduct removeOldProduct(OldProduct oldProduct) {
//		getOldProducts().remove(oldProduct);
//		oldProduct.setApplicationUser(null);
//
//		return oldProduct;
//	}
//
//	public List<Product> getProducts() {
//		return this.products;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}

}