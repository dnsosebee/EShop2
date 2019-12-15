package es.uc3m.eshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class ApplicationUserManager {
	
	private EntityManager em;
	private EntityTransaction et;
	
	public ApplicationUserManager() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShop");
		em = emf.createEntityManager();
		et = em.getTransaction();
	}
	
	public applicationuser findByEmail(String email) {
		applicationuser au = em.find(applicationuser.class, email);
		return au;
	}
	
	public applicationuser insert(applicationuser au) {
		
		et.begin();
		
		em.persist(au);
		
		et.commit();
		
		return au;
	}
	
	
	public applicationuser login(String email, String password) {
		
		
		Query query = em.createNamedQuery("ApplicationUser.login");
		query.setParameter("email", email);
		query.setParameter("password", password);
		applicationuser au;
		try {
			au = (applicationuser) query.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			au = null;
		}
		
		
		return au;
	}
	
	public List<applicationuser> findAll() {
		
		Query query = em.createNamedQuery("ApplicationUser.findAll");
		@SuppressWarnings("unchecked")
		List<applicationuser> resultList = (List<applicationuser>)query.getResultList();
		return resultList;
	}
	
	public applicationuser update(applicationuser au) {
		et.begin();
		
		 applicationuser user = findByEmail(au.getEmail());
		 if (au.getPassword() != null) {
			 user.setPassword(au.getPassword());
		 }
		 user.setAddress(au.getAddress());
		 user.setName(au.getName());
		 user.setSurname(au.getSurname());
		 
		 em.merge(user);
		et.commit();
		return user;
	}
	
	public boolean delete(applicationuser au) {
		
		applicationuser user = em.find(applicationuser.class, au.getEmail());
		if (user == null) {
			return false;
		}
		et.begin();
		em.remove(user);
		et.commit();
		return true;
	}
	
	public void addToWishlist(applicationuser au, int id) {

		
		applicationuser user = findByEmail(au.getEmail());
		Product p = em.find(Product.class, id);
		List<Product> products = user.getProducts();
		if (!products.contains(p)) {
			et.begin();
			user.getProducts().add(p);
			em.merge(user);
			et.commit();
			System.out.println("should work");
		}
	}
	
	public void removeFromWishlist(applicationuser au, int id) {

		et.begin();
		applicationuser user = findByEmail(au.getEmail());
		Product p = em.find(Product.class, id);
		user.getProducts().remove(p);
		em.merge(user);
		
		et.commit();
	}
	
	
}
