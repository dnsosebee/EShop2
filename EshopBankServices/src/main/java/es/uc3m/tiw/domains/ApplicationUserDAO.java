package es.uc3m.tiw.domains;

import java.util.List;

import es.uc3m.eshop.model.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RestResource

public interface ApplicationUserDAO extends CrudRepository<applicationuser, String>{

	List<applicationuser> findAll();
}
