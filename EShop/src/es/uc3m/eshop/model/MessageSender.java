package es.uc3m.eshop.model;

public class MessageSender {
	
	public void sendSuccessMessage(String email, int idOrder) {
		Message message = new Message();
		message.setBody("Your order has been placed successfully and is being processed. The confirmation number of this order is " + idOrder + ". Please check your order history for more information about this order.");
		message.setSubject("Your Order Has Been Placed!");
		message.setSender(email);
		message.setRecipient(email);
		MessageManager messageManager = new MessageManager();
		messageManager.sendMessage(message);
	}

	public void sendFailureMessage(String email) {
		Message message = new Message();
		message.setBody("Your order could not be placed because an item was out of stock, or payment info was incorrerct. We apologize for the inconvenience.");
		message.setSubject("Your Order Was NOT Placed!");
		message.setSender(email);
		message.setRecipient(email);
		MessageManager messageManager = new MessageManager();
		messageManager.sendMessage(message);
	}
}