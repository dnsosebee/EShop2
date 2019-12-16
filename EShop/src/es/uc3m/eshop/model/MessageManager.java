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

public class MessageManager {

	public List<Message> getMessages(String recipient, boolean shopper) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:15803").path("messages")
				.queryParam("recipient", recipient).queryParam("shopper", shopper);
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		int status = response.getStatus();
		if (status == 200) {
			return response.readEntity(new GenericType<List<Message>>() {
			});
		}
		return null;
	}
	
	public Message sendMessage(Message message) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:15803").path("messages");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(message, MediaType.APPLICATION_JSON));
		int status = response.getStatus();
		if (status == 201) {
			return response.readEntity(Message.class);
		}
		return null;
	}
}
