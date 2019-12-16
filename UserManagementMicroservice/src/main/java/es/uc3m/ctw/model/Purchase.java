package es.uc3m.ctw.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class Purchase implements Serializable{

	private static final long serialVersionUID = 1L;
	private HashMap<Product,Integer> products;
	private String card;
	private double price;
	private ApplicationUser au;
	private Date date;
	
	public HashMap<Product,Integer> getProducts() {
		return products;
	}
	public void setProducts(HashMap<Product,Integer> products) {
		this.products = products;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ApplicationUser getAu() {
		return au;
	}
	public void setAu(ApplicationUser au) {
		this.au = au;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
