package es.uc3m.eshop.model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ProductManager {

	public Product findById(String id) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:15802").path("products").path(id);
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		int status = response.getStatus();
		if (status == 200) {
			return response.readEntity(Product.class);
		}
		return null;
	}

	public List<Product> search(Integer min, Integer max, String keyword) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:15802").path("products").queryParam("min", min)
				.queryParam("max", max).queryParam("searchTerm", keyword);
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		int status = response.getStatus();
		if (status == 200) {
			return response.readEntity(new GenericType<List<Product>>() {
			});
		}
		return null;
	}

	public Product insert(Product p) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:15802").path("products");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(p, MediaType.APPLICATION_JSON));
		int status = response.getStatus();
		if (status == 201) {
			return response.readEntity(Product.class);
		}
		return null;
	}

	public List<Product> findAll() {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:15802").path("products");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		int status = response.getStatus();
		if (status == 200) {
			return response.readEntity(new GenericType<List<Product>>() {
			});
		}
		return null;
	}

	public List<Product> findAllForSeller(HttpSession session) {

		ApplicationUser au = (ApplicationUser) session.getAttribute("user");
		String userEmail = au.getEmail();
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:15802").path("products").queryParam("seller",
				userEmail);
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		int status = response.getStatus();
		if (status == 200) {
			return response.readEntity(new GenericType<List<Product>>() {
			});
		}
		return null;
	}

	public Product update(Product pr) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:15802").path("products");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(pr, MediaType.APPLICATION_JSON));
		int status = response.getStatus();
		if (status == 200) {
			return response.readEntity(Product.class);
		}
		return null;
	}

	public boolean delete(Product pr) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:15802").path("products")
				.path(((Integer) pr.getIdProduct()).toString());
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();
		int status = response.getStatus();
		if (status == 200) {
			return true;
		}
		return false;

	}

	public double calculateCart(HashMap<Product, Integer> cart) {
		double cartCost = 0;
		for (Map.Entry<Product, Integer> entry : cart.entrySet()) {

			cartCost += entry.getKey().getPrice() * entry.getValue();
		}

		return Math.round(cartCost * 100.0) / 100.0;
	}
}
