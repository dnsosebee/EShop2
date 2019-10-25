package es.uc3m.eshop.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ApplicationUserManager {

	
	
	// public UserApplication insert(UserApplication au)
	// public UserApplication login(String email, String password)
	// public UserApplication update(UserApplciaation au)
	// public boolean delete(UserApplication au)
	// Only for the Admin Project
	// public List<ApplicationUser> findAll()
	
	
	private EntityManager em;
	private EntityTransaction et;
	
	public ApplicationUserManager() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShop");
		em = emf.createEntityManager();
		et = em.getTransaction();
	}
	
	public ApplicationUser insert(ApplicationUser au) {
		
		et.begin();
		
		em.persist(au);
		
		et.commit();
		
		return au;
	}
}
