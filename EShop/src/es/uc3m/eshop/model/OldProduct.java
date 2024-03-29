package es.uc3m.eshop.model;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;


/**
 * The persistent class for the oldProduct database table.
 * 
 */
public class OldProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idOldProduct;

	private String description;

	private String name;

	private float pricePerUnit;

	private byte[] productImage;

	private int units;

	private String applicationUser;

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

	public byte[] getProductImage() {
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

	public String getApplicationUser() {
		return this.applicationUser;
	}

	public void setApplicationUser(String applicationUser) {
		this.applicationUser = applicationUser;
	}
	
	public String getImageString() {
		StringBuilder sb = new StringBuilder();
		sb.append("data:image/png;base64,");
		sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(this.getProductImage(), false)));
		return sb.toString();	
	}

}