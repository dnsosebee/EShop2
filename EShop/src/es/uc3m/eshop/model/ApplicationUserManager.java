package es.uc3m.eshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;




public class ApplicationUserManager {
	
//	private EntityManager em;
//	private EntityTransaction et;
	
	//Connecting to EshopUserServices
	ClientConfig config = new ClientConfig();
	Client client = ClientBuilder.newClient(config);
	
	public ApplicationUserManager() {
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShop");
//		em = emf.createEntityManager();
//		et = em.getTransaction();
	}
	
	public ApplicationUser findByEmail(String email) {
		
//		ApplicationUser au = em.find(ApplicationUser.class, email);
//		return au;
//		\
		System.out.println("FINDING BY EMAIL");

		WebTarget webResource = client.target("http://localhost:5812/users/" + email);
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.get();	
		int status = response.getStatus();
		
		System.out.println("Response Status: " + status);

		ApplicationUser au = response.readEntity(ApplicationUser.class);

		
		return au;
		
	}
	
	public ApplicationUser insert(ApplicationUser au) {
		
		
		System.out.println("AUM INSERT");
		
		WebTarget webResource = client.target("http://localhost:5812/users");

		
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.post(Entity.entity(au, MediaType.APPLICATION_JSON));	
		
		
		int status = response.getStatus();
		
		System.out.println("Response Status: " + status);

		
		return au;
		
//		
//		et.begin();
//		
//		em.persist(au);
//		
//		et.commit();
//		
//		return au;
	}
	
	
	public ApplicationUser login(String email, String password) {
		
		System.out.println("AUM LOGIN");
		
		WebTarget webResource = client.target("http://localhost:5812/users/" + email);	
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();	
		int status = response.getStatus();
		System.out.println("Response Status: " + status);
		
		ApplicationUser au = response.readEntity(ApplicationUser.class);
		
		if (au.getPassword().contentEquals(password))
		{
			return au;
		}
		else
		{
			au = null;
		}
	
		
//		Query query = em.createNamedQuery("ApplicationUser.login");
//		query.setParameter("email", email);
//		query.setParameter("password", password);
//		ApplicationUser au;
//		try {
//			au = (ApplicationUser) query.getSingleResult();
//		} catch (javax.persistence.NoResultException e) {
//			au = null;
//		}
		
		
		return au;
	}
	
	public List<ApplicationUser> findAll() {
		
//		Query query = em.createNamedQuery("ApplicationUser.findAll");
//		@SuppressWarnings("unchecked")
	
//		List<ApplicationUser> resultList = (List<ApplicationUser>)query.getResultList();
		
		System.out.println("FINDING ALL USERS");
		
		WebTarget webResource = client.target("http://localhost:5812/users");	
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();	
		int status = response.getStatus();
		System.out.println("Response Status: " + status);
		
		
		
		List<ApplicationUser> resultList = response.readEntity(new GenericType<List<ApplicationUser>>() {});
		

		System.out.println("GOT ALL USERS SUCCESS?");
		return resultList;
	}
	
	public ApplicationUser update(ApplicationUser au) {
//		et.begin();
//		
//		 ApplicationUser user = findByEmail(au.getEmail());
//		 if (au.getPassword() != null) {
//			 user.setPassword(au.getPassword());
//		 }
//		 user.setAddress(au.getAddress());
//		 user.setName(au.getName());
//		 user.setSurname(au.getSurname());
//		 
//		 em.merge(user);
//		et.commit();
		
		WebTarget webResource = client.target("http://localhost:5812/users/");	
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(au, MediaType.APPLICATION_JSON));
		int status = response.getStatus();
		System.out.println("Response Status: " + status);
			
		
		return au;
	}
	
	
	public List<Product> getUserWishlist(ApplicationUser au)
	{
		WebTarget webResource = client.target("http://localhost:5812/users/" + au.getEmail() + "/wishlist");	
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		int status = response.getStatus();
		System.out.println("Response Status: " + status);
		
		
		
		List<Product> wishlist = response.readEntity(new GenericType<List<Product>>() {});
		

		return wishlist;
		
		
	}
	
	
	//NOT WORKING
	public boolean delete(ApplicationUser au) {
		
		System.out.println("DELETE IN AUM");
		
		System.out.println("au email: " + au.getEmail());
		
//		ApplicationUser user = em.find(ApplicationUser.class, au.getEmail());
//		if (user == null) {
//			return false;
//		}
//		et.begin();
//		em.remove(user);
//		et.commit();
//		return true;
		
		WebTarget webResource = client.target("http://localhost:5812/users/" + au.getEmail());	
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();
		int status = response.getStatus();
		System.out.println("Response Status: " + status);
		if(status == 200)
		{
			return true;
		}
		return false;
	}
	
	public void addToWishlist(ApplicationUser au, int id) {

		
//		ApplicationUser user = findByEmail(au.getEmail());
//		Product p = em.find(Product.class, id);
//		List<Product> products = user.getProducts();
//		if (!products.contains(p)) {
//			et.begin();
//			user.getProducts().add(p);
//			em.merge(user);
//			et.commit();
//			System.out.println("should work");
//		}
		
		ApplicationUser user = findByEmail(au.getEmail());
		
		
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

	
//	public void removeFromWishlist(ApplicationUser au, int id) {
//
//		et.begin();
//		ApplicationUser user = findByEmail(au.getEmail());
//		Product p = em.find(Product.class, id);
//		user.getProducts().remove(p);
//		em.merge(user);
//		
//		et.commit();
//	}
	
	
}
