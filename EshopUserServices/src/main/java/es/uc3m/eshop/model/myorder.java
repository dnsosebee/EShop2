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
public class myorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idorder")
	private int idOrder;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String owner;

	private BigDecimal total;

	//bi-directional many-to-one association to OldProduct
	@OneToMany(mappedBy="myOrderBean")
	private List<oldproduct> oldProducts;

	public myorder() {
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

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<oldproduct> getOldProducts() {
		return this.oldProducts;
	}

	public void setOldProducts(List<oldproduct> oldProducts) {
		this.oldProducts = oldProducts;
	}

	public oldproduct addOldProduct(oldproduct oldProduct) {
		getOldProducts().add(oldProduct);
		oldProduct.setMyOrderBean(this);

		return oldProduct;
	}

	public oldproduct removeOldProduct(oldproduct oldProduct) {
		getOldProducts().remove(oldProduct);
		oldProduct.setMyOrderBean(null);

		return oldProduct;
	}

}