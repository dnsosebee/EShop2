package es.uc3m.ctw.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MessageDAO extends CrudRepository<Message, Integer> {

	@Query("Select m from Message m where m.recipient = :recipient OR (:shopper = true AND m.recipient is null)")
	public List<Message> custom(String recipient, Boolean shopper);

}
