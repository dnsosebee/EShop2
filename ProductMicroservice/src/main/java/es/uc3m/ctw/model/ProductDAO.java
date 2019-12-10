package es.uc3m.ctw.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product,Integer> {
 
	List<Product> findAll();
	
	@Query("Select p from Product p where (:min is null OR p.price > :min) AND (:max is null OR p.price < :max)")
	List<Product> custom(Double min, Double max);
	
	
}
