package es.uc3m.eshop.model;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTypeDeserializer;
import javax.json.bind.annotation.JsonbTypeSerializer;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

/**
 * The persistent class for the product database table.
 * 
 */

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idProduct;

	private String description;

	private String name;

	private float price;

	@JsonbTypeDeserializer(BytesSerializerDeserializer.class)
	@JsonbTypeSerializer(BytesSerializerDeserializer.class)
	private byte[] productImage;

	private String seller;

	private int stock;


	public Product() {
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
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

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public byte[] getProductImage() {
		return this.productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public String getSeller() {
		return this.seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
public String getImageString() {
		StringBuilder sb = new StringBuilder();
		sb.append("data:image/png;base64,");
		sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(this.getProductImage(), false)));
		return sb.toString();	
	}

}