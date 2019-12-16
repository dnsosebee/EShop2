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
	
	//Returns a status 200 random int if the card details are correct
	//402 if card is not validated

	@RequestMapping(value = "bank", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> verifyPurchase(@RequestBody BankVerification verification) {
		
		String numberValidationRegex = "^[0-9]{16}$";
		String cardExpiryRegex = "[0-1]{1}[0-9]{1}\\/[0-9]{2}";
		String cardSecurityRegex = "[0-9]{3}";
		
		
		String cardNumber = verification.getCardNumber().replaceAll("\\s","");


		if (	Integer.parseInt(cardNumber)% 4 == 0 &&
				cardNumber.matches(numberValidationRegex) && 
				verification.getCardExpiry().matches(cardExpiryRegex) && 
				verification.getCardSecurity().matches(cardSecurityRegex)				)
		{
			
			int randomNumber = (int) (Math.random() * 1000000);
			
			System.out.println(randomNumber);
			
			return new ResponseEntity<Integer>(randomNumber, HttpStatus.OK);
		}
		
		
		
		return new ResponseEntity<>(HttpStatus.PAYMENT_REQUIRED);
	}
	
	
	
	
	
}
