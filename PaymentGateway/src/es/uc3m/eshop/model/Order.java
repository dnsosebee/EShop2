package es.uc3m.eshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOrder;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private BigDecimal total;

	//bi-directional many-to-one association to ApplicationUser
	@ManyToOne
	@JoinColumn(name="owner")
	private ApplicationUser applicationUser;

	//bi-directional many-to-one association to OrderProduct
	@OneToMany(mappedBy="order")
	private List<OrderProduct> orderProducts;

	public Order() {
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

	public ApplicationUser getApplicationUser() {
		return this.applicationUser;
	}

	public void setApplicationUser(ApplicationUser applicationUser) {
		this.applicationUser = applicationUser;
	}

	public List<OrderProduct> getOrderProducts() {
		return this.orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public OrderProduct addOrderProduct(OrderProduct orderProduct) {
		getOrderProducts().add(orderProduct);
		orderProduct.setOrder(this);

		return orderProduct;
	}

	public OrderProduct removeOrderProduct(OrderProduct orderProduct) {
		getOrderProducts().remove(orderProduct);
		orderProduct.setOrder(null);

		return orderProduct;
	}

}