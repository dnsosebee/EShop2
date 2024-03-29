package es.uc3m.ctw.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Integer> {

	List<Product> findAll();

	@Query("Select p from Product p where (:min is null OR p.price > :min) AND (:max is null OR p.price < :max) AND (:seller is null OR p.seller = :seller) AND (:keyword is null OR UPPER(p.name) like CONCAT('%',UPPER(:keyword),'%') OR UPPER(p.description) like CONCAT('%',UPPER(:keyword),'%') )")
	List<Product> custom(Double min, Double max, String seller, String keyword);
}
