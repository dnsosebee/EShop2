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

import es.uc3m.ctw.model.Myorder;
import es.uc3m.ctw.model.MyOrderDAO;
import es.uc3m.ctw.model.OldProductDAO;
import es.uc3m.ctw.model.Oldproduct;

@Controller
public class OrderController {

	@Autowired
	MyOrderDAO myOrderDAO;
	
	@Autowired
	OldProductDAO oldProductDAO;

	@RequestMapping(value = "orders", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Myorder>> findAll(@RequestParam String owner) {

		List<Myorder> list = myOrderDAO.findByOwner(owner);

		return new ResponseEntity<List<Myorder>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "orders", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Myorder> addOrder(@RequestBody Myorder myorder) {
		Myorder savedOrder = myOrderDAO.save(myorder);
		for (Oldproduct oldproduct : savedOrder.getOldProducts()) {
			oldproduct.setMyOrderBean(savedOrder);
			oldProductDAO.save(oldproduct);
		}
		return new ResponseEntity<Myorder>(savedOrder, HttpStatus.OK);
	}
}
