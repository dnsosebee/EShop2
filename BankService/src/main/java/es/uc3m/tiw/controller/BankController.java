package es.uc3m.tiw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.uc3m.eshop.model.*;



@Controller
@CrossOrigin
public class BankController {

	
	@RequestMapping(method = RequestMethod.POST, value="/purchase")
	public @ResponseBody Purchase savePurchase(@RequestBody @Validated Purchase inPurchase) {
		System.out.println("RECEIVED THE PURCHASE POST IN THE BANK BOY");
		
		System.out.println(inPurchase.getCard());
		return inPurchase;
	}

}
