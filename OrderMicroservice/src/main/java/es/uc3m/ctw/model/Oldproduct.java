package es.uc3m.ctw.model;


import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the oldProduct database table.
 * 
 */
@Entity
public class Oldproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idoldproduct;

	private String description;

	private String name;

	private float priceperunit;

	private byte[] productimage;

	private int units;


	@Column(name="seller")
	private String applicationUser;

	//bi-directional many-to-one association to MyOrder
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="myorder")
	
	private Myorder myOrderBean;

	public Oldproduct() {
	}

	public int getIdOldProduct() {
		return this.idoldproduct;
	}

	public void setIdOldProduct(int idOldProduct) {
		this.idoldproduct = idOldProduct;
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
		return this.priceperunit;
	}

	public void setPricePerUnit(float pricePerUnit) {
		this.priceperunit = pricePerUnit;
	}

	public byte[] getProductImage() {
		return this.productimage;
	}

	public void setProductImage(byte[] productImage) {
		this.productimage = productImage;
	}

	public int getUnits() {
		return this.units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public String getApplicationUser() {
		return this.applicationUser;
	}

	public void setApplicationUser(String applicationUser) {
		this.applicationUser = applicationUser;
	}

	public Myorder getMyOrderBean() {
		return this.myOrderBean;
	}

	public void setMyOrderBean(Myorder myOrderBean) {
		this.myOrderBean = myOrderBean;
	}

}