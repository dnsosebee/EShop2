package es.uc3m.ctw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.uc3m.ctw.model.Myorder;
import es.uc3m.ctw.model.MyOrderDAO;
import es.uc3m.ctw.model.Oldproduct;
import es.uc3m.ctw.model.OldProductDAO;

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
}
