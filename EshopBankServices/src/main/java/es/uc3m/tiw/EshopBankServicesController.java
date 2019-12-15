package es.uc3m.tiw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.eshop.model.*;
import es.uc3m.tiw.domains.ApplicationUserDAO;

@Controller
@CrossOrigin
@EntityScan("es.uc3m.eshop.model")
@ComponentScan("es.uc3m.eshop.model")
public class EshopBankServicesController {

	
	@RequestMapping("/hello")
	public @ResponseBody String helloWorld()
	{
		return "Hello World";
	}
	
	
	//1. receive the information about the card, and the total price of the purchase

	
	@RequestMapping(value = "bank", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> verifyPurchase(@RequestBody ) {
		
		
	}
	
	
	//2/validate the card number. For the card to be valid its number should have 16 numbers
//	and it should be divisible by 4, the CV2 number should have 3 digits and the date
//	should be later to the current one. 
	
//	3. If the card is valid the service will return a “transaction code” that identifies the
//			purchase, and a HTTP code 2000 to confirm that everything has been ok. If the card is
//			not valid it should return the error HTTP code 402.

	
	
	
	
	
}
