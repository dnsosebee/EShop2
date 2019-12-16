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

public class OrderManager {

	public MyOrder insert(MyOrder order) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:15804").path("orders");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(order, MediaType.APPLICATION_JSON));
		int status = response.getStatus();
		if (status == 201) {
			return response.readEntity(MyOrder.class);
		}
		return null;
	}

	public List<MyOrder> getUserOrders(String email) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:15804").path("orders").queryParam("owner", email);
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		int status = response.getStatus();
		if (status == 200) {
			return response.readEntity(new GenericType<List<MyOrder>>() {
			});
		}
		return null;
	}

	public MyOrder findById(String id) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:15804").path("orders").path(id);
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		int status = response.getStatus();
		if (status == 200) {
			return response.readEntity(MyOrder.class);
		}
		return null;
	}

}