package es.uc3m.eshop.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OrderProduct database table.
 * 
 */
@Entity
@NamedQuery(name="OrderProduct.findAll", query="SELECT o FROM OrderProduct o")
public class OrderProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@EmbeddedId
	private OrderProductPK id;

	private int quantity;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;

	//bi-directional many-to-one association to MyOrder
	@ManyToOne
	@JoinColumn(name="idOrder")
	private MyOrder myOrder;

	public OrderProduct() {
	}

	public OrderProductPK getId() {
		return this.id;
	}

	public void setId(OrderProductPK id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public MyOrder getMyOrder() {
		return this.myOrder;
	}

	public void setMyOrder(MyOrder myOrder) {
		this.myOrder = myOrder;
	}

}