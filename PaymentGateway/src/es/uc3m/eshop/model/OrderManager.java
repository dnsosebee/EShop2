package es.uc3m.eshop.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderManager {

	private EntityManager em;
	private EntityTransaction et;

	
	public OrderManager() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShop");
		em = emf.createEntityManager();
		et = em.getTransaction();
	}
	
	public MyOrder insert(MyOrder order) {
		
		et.begin();
		
		em.persist(order);
		
		et.commit();
		
		return order;
		
	}
	
	public MyOrder findById(int id) {
		
		MyOrder mo = em.find(MyOrder.class, id);
		
		return mo;
		
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