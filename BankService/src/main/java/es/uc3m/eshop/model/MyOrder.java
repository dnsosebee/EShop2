package es.uc3m.eshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the myOrder database table.
 * 
 */
@Entity
@NamedQuery(name="MyOrder.findAll", query="SELECT m FROM MyOrder m")
public class MyOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idOrder;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private BigDecimal total;

	//bi-directional many-to-one association to OrderProduct
	@OneToMany(mappedBy="myOrder")
	private List<OrderProduct> orderProducts;

	//bi-directional many-to-one association to ApplicationUser
	@ManyToOne
	@JoinColumn(name="owner")
	private ApplicationUser applicationUser;

	public MyOrder() {
	}

	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<OrderProduct> getOrderProducts() {
		return this.orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public OrderProduct addOrderProduct(OrderProduct orderProduct) {
		getOrderProducts().add(orderProduct);
		orderProduct.setMyOrder(this);

		return orderProduct;
	}

	public OrderProduct removeOrderProduct(OrderProduct orderProduct) {
		getOrderProducts().remove(orderProduct);
		orderProduct.setMyOrder(null);

		return orderProduct;
	}

	public ApplicationUser getApplicationUser() {
		return this.applicationUser;
	}

	public void setApplicationUser(ApplicationUser applicationUser) {
		this.applicationUser = applicationUser;
	}

}