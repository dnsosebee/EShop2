package es.uc3m.eshop.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oldProduct database table.
 * 
 */
@Entity
@NamedQuery(name="OldProduct.findAll", query="SELECT o FROM OldProduct o")
public class OldProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idOldProduct;

	private String description;

	private String name;

	private float pricePerUnit;

	private Object productImage;

	private int units;

	//bi-directional many-to-one association to ApplicationUser
	@ManyToOne
	@JoinColumn(name="seller")
	private ApplicationUser applicationUser;

	//bi-directional many-to-one association to MyOrder
	@ManyToOne
	@JoinColumn(name="myOrder")
	private MyOrder myOrderBean;

	public OldProduct() {
	}

	public int getIdOldProduct() {
		return this.idOldProduct;
	}

	public void setIdOldProduct(int idOldProduct) {
		this.idOldProduct = idOldProduct;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPricePerUnit() {
		return this.pricePerUnit;
	}

	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Object getProductImage() {
		return this.productImage;
	}

	public void setProductImage(Object productImage) {
		this.productImage = productImage;
	}

	public int getUnits() {
		return this.units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public ApplicationUser getApplicationUser() {
		return this.applicationUser;
	}

	public void setApplicationUser(ApplicationUser applicationUser) {
		this.applicationUser = applicationUser;
	}

	public MyOrder getMyOrderBean() {
		return this.myOrderBean;
	}

	public void setMyOrderBean(MyOrder myOrderBean) {
		this.myOrderBean = myOrderBean;
	}

}