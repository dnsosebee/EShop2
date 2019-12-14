package es.uc3m.eshop.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;


public class ProductManager {

	// public UserApplication insert(UserApplication au)
	// public UserApplication login(String email, String password)
	// public UserApplication update(UserApplciaation au)
	// public boolean delete(UserApplication au)
	// Only for the Admin Project
	// public List<ApplicationUser> findAll()

	private EntityManager em;
	private EntityTransaction et;

	public ProductManager() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShop");
		em = emf.createEntityManager();
		et = em.getTransaction();
	}

	public Product findById(String id) {
		Product p = em.find(Product.class, Integer.parseInt(id));
		return p;
	}
	
	public List<Product> search(String term) {
		Query query = em.createQuery("SELECT p FROM Product p WHERE p.name REGEXP '" + term + "'");
		List<Product> products = new ArrayList<Product>();
		Set<Product> uniques = new HashSet<Product>();
		for (Object product:query.getResultList()) {
			uniques.add((Product) product);
		}
		Query query2 = em.createQuery("SELECT p FROM Product p WHERE p.description REGEXP '" + term + "'");
		for (Object product:query2.getResultList()) {
			uniques.add((Product) product);
		}
		for (Product p: uniques) {
			products.add(p);
		}
		return products;
	}

	public Product insert(Product p) {

		et.begin();

		em.persist(p);

		et.commit();

		return p;
	}

	public List<Product> findAll() {

		Query query = em.createQuery("SELECT p FROM Product p");
		List<Product> products = new ArrayList<Product>();
		for (Object product : query.getResultList()) {
			products.add((Product) product);
		}

		return products;
	}

	public List<Product> findAllForSeller(HttpSession session) {

		applicationuser au = (applicationuser) session.getAttribute("user");
		String userEmail = au.getEmail();

//		Query query = em.createQuery("SELECT p FROM Product p WHERE seller = " + userEmail);
		Query query = em.createQuery("SELECT p FROM Product p");

		List<Product> products = new ArrayList<Product>();
		for (Object product : query.getResultList()) {

			if (((Product) product).getSeller().contentEquals(userEmail)) {
				products.add((Product) product);
			}
		}

		return products;
	}
	
	public Product update(Product pr) {
		et.begin();

		Product product = findById(String.valueOf(pr.getIdProduct()));

		product.setName(pr.getName());
		product.setDescription(pr.getDescription());
		product.setPrice(pr.getPrice());
		product.setStock(pr.getStock());

		em.merge(pr);
		et.commit();
		return product;
	}
	
	public boolean delete(Product pr) {
		
		Product product = em.find(Product.class, pr.getIdProduct());
		
		if(product == null) {
			return false;
		}
		et.begin();
		em.remove(product);
		et.commit();
		return true;
		
	}
	
	public double calculateCart(HashMap<Product, Integer> cart)
	{
		double cartCost = 0;
		for(Map.Entry<Product, Integer> entry : cart.entrySet()) {
			
			cartCost += entry.getKey().getPrice() * entry.getValue();
		}
				
		
		return Math.round(cartCost * 100.0) / 100.0;
	}
}
