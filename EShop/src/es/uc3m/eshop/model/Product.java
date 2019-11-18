package es.uc3m.eshop.model;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import java.util.List;


/**
 * The persistent class for the Product database table.
 * 
 */
@Entity
@NamedQueries(value= {
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
})
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idProduct;

	private String description;

	@Lob
	private byte[] product_image;
	
	private String name;

	private float price;

	private int stock;
	
	private String seller;

	//bi-directional many-to-many association to ApplicationUser
	@ManyToMany
	@JoinTable(
		name="wishlist"
		, joinColumns={
			@JoinColumn(name="idProduct")
			}
		, inverseJoinColumns={
			@JoinColumn(name="email")
			}
		)
	private List<ApplicationUser> applicationUsers;

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

	public byte[] getImage() {
		return this.product_image;
	}

	public void setImage(byte[] image) {
		this.product_image = image;
	}
	
	public String getImageString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("data:image/png;base64,");
		sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(this.getImage(), false)));
		return sb.toString();	
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

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<ApplicationUser> getApplicationUsers() {
		return this.applicationUsers;
	}

	public void setApplicationUsers(List<ApplicationUser> applicationUsers) {
		this.applicationUsers = applicationUsers;
	}
	
	public String getSeller() {
		return this.seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}
}