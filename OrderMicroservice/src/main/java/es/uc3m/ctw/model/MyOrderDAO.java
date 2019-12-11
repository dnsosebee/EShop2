package es.uc3m.ctw.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MyOrderDAO extends CrudRepository<Myorder, Integer> {

	public List<Myorder> findByOwner(String owner);
}
