package es.uc3m.eshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduct;

	private String description;

	private String name;

	private float price;

	@Lob
	@Column(name="product_image")
	private byte[] productImage;

	private String seller;

	private int stock;

	//bi-directional many-to-one association to OrderProduct
	@OneToMany(mappedBy="product")
	private List<OrderProduct> orderProducts;

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

	public List<OrderProduct> getOrderProducts() {
		return this.orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public OrderProduct addOrderProduct(OrderProduct orderProduct) {
		getOrderProducts().add(orderProduct);
		orderProduct.setProduct(this);

		return orderProduct;
	}

	public OrderProduct removeOrderProduct(OrderProduct orderProduct) {
		getOrderProducts().remove(orderProduct);
		orderProduct.setProduct(null);

		return orderProduct;
	}

	public List<ApplicationUser> getApplicationUsers() {
		return this.applicationUsers;
	}

	public void setApplicationUsers(List<ApplicationUser> applicationUsers) {
		this.applicationUsers = applicationUsers;
	}

}