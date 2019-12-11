package es.uc3m.ctw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.uc3m.ctw.model.Message;
import es.uc3m.ctw.model.MessageDAO;

@Controller
public class MessageController {

	@Autowired
	MessageDAO messageDAO;

	@RequestMapping(value = "messages", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Message>> getMessages(@RequestParam String recipient,
			@RequestParam Boolean shopper) {

		List<Message> list = messageDAO.custom(recipient, shopper);

		return new ResponseEntity<List<Message>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "messages", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Message> sendMessage(@RequestBody Message message) {
		Message addedMessage = messageDAO.save(message);
		
		return new ResponseEntity<Message>(addedMessage, HttpStatus.OK);
	}
}
