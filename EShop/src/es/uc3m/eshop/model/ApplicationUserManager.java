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
	
	public ApplicationUser findByEmail(String email) {
		ApplicationUser au = em.find(ApplicationUser.class, email);
		return au;
	}
	
	public ApplicationUser insert(ApplicationUser au) {
		
		et.begin();
		
		em.persist(au);
		
		et.commit();
		
		return au;
	}
	
	
	public ApplicationUser login(String email, String password) {
		
		
		Query query = em.createNamedQuery("ApplicationUser.login");
		query.setParameter("email", email);
		query.setParameter("password", password);
		ApplicationUser au;
		try {
			au = (ApplicationUser) query.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			au = null;
		}
		
		
		return au;
	}
	
	public List<ApplicationUser> findAll() {
		
		Query query = em.createNamedQuery("ApplicationUser.findAll");
		@SuppressWarnings("unchecked")
		List<ApplicationUser> resultList = (List<ApplicationUser>)query.getResultList();
		return resultList;
	}
	
	public ApplicationUser update(ApplicationUser au) {
		et.begin();
		
		 ApplicationUser user = findByEmail(au.getEmail());
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
	
	public boolean delete(ApplicationUser au) {
		
		ApplicationUser user = em.find(ApplicationUser.class, au.getEmail());
		if (user == null) {
			return false;
		}
		et.begin();
		em.remove(user);
		et.commit();
		return true;
	}
	
	public void addToWishlist(ApplicationUser au, int id) {

		
		ApplicationUser user = findByEmail(au.getEmail());
		Product p = em.find(Product.class, id);
		List<Product> products = user.getProducts();
		if (!products.contains(p)) {
			et.begin();
			user.getProducts().add(p);
			em.merge(user);
			et.commit();
		}
	}
	
	public void removeFromWishlist(ApplicationUser au, int id) {

		et.begin();
		ApplicationUser user = findByEmail(au.getEmail());
		Product p = em.find(Product.class, id);
		user.getProducts().remove(p);
		em.merge(user);
		
		et.commit();
	}
	
	
}
