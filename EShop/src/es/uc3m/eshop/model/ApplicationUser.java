package es.uc3m.eshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the applicationUser database table.
 * 
 */
@Entity
@NamedQueries(value= {
@NamedQuery(name="ApplicationUser.findAll", query="SELECT a FROM ApplicationUser a"),
@NamedQuery(name="ApplicationUser.login", query="SELECT a FROM ApplicationUser a  where a.email = :email and a.password = :password")
})
public class ApplicationUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String address;

	private String name;

	private String password;

	private int role;

	private String surname;

	//bi-directional many-to-many association to Product
	@ManyToMany(mappedBy="applicationUsers")
	private List<Product> products;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="applicationUser")
	private List<Order> orders;

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

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setApplicationUser(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setApplicationUser(null);

		return order;
	}

}