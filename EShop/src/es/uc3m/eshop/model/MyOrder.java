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
	
	private String date;

	private String owner;

	private BigDecimal total;

	//bi-directional many-to-one association to OldProduct
	@OneToMany(mappedBy="myOrderBean")
	private List<OldProduct> oldProducts;

	public MyOrder() {
	}

	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
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

	public List<OldProduct> getOldProducts() {
		return this.oldProducts;
	}

	public void setOldProducts(List<OldProduct> oldProducts) {
		this.oldProducts = oldProducts;
	}

	public OldProduct addOldProduct(OldProduct oldProduct) {
		getOldProducts().add(oldProduct);
		oldProduct.setMyOrderBean(this);

		return oldProduct;
	}

	public OldProduct removeOldProduct(OldProduct oldProduct) {
		getOldProducts().remove(oldProduct);
		oldProduct.setMyOrderBean(null);

		return oldProduct;
	}

}