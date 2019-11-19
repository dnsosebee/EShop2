package es.uc3m.eshop.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the OrderProduct database table.
 * 
 */
@Embeddable
public class OrderProductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idProduct;

	@Column(insertable=false, updatable=false)
	private int idOrder;

	public OrderProductPK() {
	}
	public int getIdProduct() {
		return this.idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getIdOrder() {
		return this.idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrderProductPK)) {
			return false;
		}
		OrderProductPK castOther = (OrderProductPK)other;
		return 
			(this.idProduct == castOther.idProduct)
			&& (this.idOrder == castOther.idOrder);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProduct;
		hash = hash * prime + this.idOrder;
		
		return hash;
	}
}