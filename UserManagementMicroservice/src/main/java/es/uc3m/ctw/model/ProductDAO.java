package es.uc3m.ctw.model;

import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface ProductDAO extends CrudRepository<Product, Integer>{

	List<Product> findAll();
}
