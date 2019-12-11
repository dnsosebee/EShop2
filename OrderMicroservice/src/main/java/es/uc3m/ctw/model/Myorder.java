package es.uc3m.ctw.model;


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
public class Myorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idorder")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrder;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String owner;

	private BigDecimal total;

	//bi-directional many-to-one association to OldProduct
	@OneToMany(mappedBy="myOrderBean")
	private List<Oldproduct> oldProducts;

	public Myorder() {
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

	public List<Oldproduct> getOldProducts() {
		return this.oldProducts;
	}

	public void setOldProducts(List<Oldproduct> oldProducts) {
		this.oldProducts = oldProducts;
	}

	public Oldproduct addOldProduct(Oldproduct oldProduct) {
		getOldProducts().add(oldProduct);
		oldProduct.setMyOrderBean(this);

		return oldProduct;
	}

	public Oldproduct removeOldProduct(Oldproduct oldProduct) {
		getOldProducts().remove(oldProduct);
		oldProduct.setMyOrderBean(null);

		return oldProduct;
	}

}