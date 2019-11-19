package es.uc3m.eshop.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class OrderManager {

	private EntityManager em;
	private EntityTransaction et;
	
	public Order insert(Order order) {
		
		et.begin();
		
		em.persist(order);
		
		et.commit();
		
		return order;
		
	}

public OrderProductPK insert(OrderProductPK pk) {
		
		et.begin();
		
		em.persist(pk);
		
		et.commit();
		
		return pk;
		
	}

public OrderProduct insert(OrderProduct op) {
	
	et.begin();
	
	em.persist(op);
	
	et.commit();
	
	return op;
	
}

}
