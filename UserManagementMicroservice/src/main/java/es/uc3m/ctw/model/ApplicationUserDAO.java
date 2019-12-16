package es.uc3m.ctw.model;

import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface ApplicationUserDAO extends CrudRepository<ApplicationUser, String>{

	List<ApplicationUser> findAll();
}
