package es.uc3m.eshop.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oldProduct database table.
 * 
 */
@Entity
public class oldproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idoldproduct")
	private int idOldProduct;

	private String description;

	private String name;

	@Column(name = "priceperunit")
	private float pricePerUnit;

	@Column(name = "productimage")
	private byte[] productImage;

	private int units;

	//bi-directional many-to-one association to ApplicationUser
	@ManyToOne
	@JoinColumn(name="seller")
	private applicationuser applicationUser;

	//bi-directional many-to-one association to MyOrder
	@ManyToOne
	@JoinColumn(name="myorder")
	private myorder myOrderBean;

	public oldproduct() {
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

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public int getUnits() {
		return this.units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public applicationuser getApplicationUser() {
		return this.applicationUser;
	}

	public void setApplicationUser(applicationuser applicationUser) {
		this.applicationUser = applicationUser;
	}

	public myorder getMyOrderBean() {
		return this.myOrderBean;
	}

	public void setMyOrderBean(myorder myOrderBean) {
		this.myOrderBean = myOrderBean;
	}

}