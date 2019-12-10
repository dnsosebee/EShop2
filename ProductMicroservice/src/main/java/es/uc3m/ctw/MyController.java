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

import es.uc3m.ctw.model.Product;
import es.uc3m.ctw.model.ProductDAO;

@Controller
public class MyController {

	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="products", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Product>> findAll(@RequestParam(required = false) Double min, @RequestParam(required = false) Double max) {
		
		List<Product> list = productDAO.custom(min, max);
		
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="products/{id}", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> findById(@PathVariable int id) {
		Product product = productDAO.findById(id).orElse(null);
		if (product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value="products", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> save(@RequestBody Product product) {
		if (productDAO.existsById(product.getIdProduct())) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		Product savedProduct = productDAO.save(product);
		return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
	}
}
