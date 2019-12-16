package es.uc3m.eshop.model;

import java.util.List;

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

	//Connecting to EshopUserServices
	ClientConfig config = new ClientConfig();
	Client client = ClientBuilder.newClient(config);
	
	public ApplicationUserManager() {}
	
	public ApplicationUser findByEmail(String email) {

		System.out.println("FINDING BY EMAIL");

		WebTarget webResource = client.target("http://localhost:15812/users/" + email);
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.get();	
		int status = response.getStatus();
		
		System.out.println("Response Status: " + status);

		ApplicationUser au = response.readEntity(ApplicationUser.class);

		return au;
		
	}
	
	public ApplicationUser insert(ApplicationUser au) {
		
		
		System.out.println("AUM INSERT");
		
		WebTarget webResource = client.target("http://localhost:15812/users");

		
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.post(Entity.entity(au, MediaType.APPLICATION_JSON));	
		
		int status = response.getStatus();
		
		System.out.println("Response Status: " + status);
		
		return au;
		
	}
	
	
	public ApplicationUser login(String email, String password) {
		
		System.out.println("AUM LOGIN");
		
		WebTarget webResource = client.target("http://localhost:15812/users/" + email);	
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();	
		int status = response.getStatus();
		System.out.println("Response Status: " + status);
		
		ApplicationUser au = response.readEntity(ApplicationUser.class);
		
		if (au == null) {
			return null;
		}
		
		if (au.getPassword().contentEquals(password))
		{
			return au;
		}
		else
		{
			au = null;
		}
	
		return au;
	}
	
	public List<ApplicationUser> findAll() {

		System.out.println("FINDING ALL USERS");
		
		WebTarget webResource = client.target("http://localhost:15812/users");	
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();	
		int status = response.getStatus();
		System.out.println("Response Status: " + status);
		
		List<ApplicationUser> resultList = response.readEntity(new GenericType<List<ApplicationUser>>() {});
		

		System.out.println("GOT ALL USERS SUCCESS?");
		return resultList;
	}
	
	public ApplicationUser update(ApplicationUser au) {
		
		WebTarget webResource = client.target("http://localhost:15812/users/");	
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(au, MediaType.APPLICATION_JSON));
		int status = response.getStatus();
		System.out.println("Response Status: " + status);	
		
		return au;
	}
	
	
	public List<Product> getUserWishlist(ApplicationUser au)
	{
		WebTarget webResource = client.target("http://localhost:15812/users/" + au.getEmail() + "/wishlist_products");	
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

		WebTarget webResource = client.target("http://localhost:15812/users/" + au.getEmail());	
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
	
	public boolean addToWishlist(ApplicationUser au, Integer id) {
		
		WebTarget webResource = client.target("http://localhost:15812/users/" + au.getEmail() + "/wishlist_products");	
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		ProductManager pm = new ProductManager();
		Product p = pm.findById(id.toString());
		Response response = invocationBuilder.post(Entity.entity(p, MediaType.APPLICATION_JSON));
		int status = response.getStatus();
		System.out.println("Response Status: " + status);
		if(status == 200)
		{
			return true;
		}
		return false;
	}

	
	public boolean removeFromWishlist(ApplicationUser au, Integer id) {
		
		WebTarget webResource = client.target("http://localhost:15812/users/" + au.getEmail() + "/wishlist_products/" + id.toString());	
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
	
}
