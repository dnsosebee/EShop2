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

	@RequestMapping(value = "products", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Product>> findAll(@RequestParam(required = false) Double min,
			@RequestParam(required = false) Double max, @RequestParam(required = false) String seller) {

		List<Product> list = productDAO.custom(min, max, seller);

		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "products/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> findById(@PathVariable int id) {
		Product product = productDAO.findById(id).orElse(null);
		if (product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "products", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> save(@RequestBody Product product) {
		if (productDAO.existsById(product.getIdProduct())) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		Product savedProduct = productDAO.save(product);
		return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "products", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<?> update(@RequestBody Product product) {
		Product dbProduct = productDAO.findById(product.getIdProduct()).orElse(null);
		if (dbProduct == null) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
		dbProduct.setDescription(product.getDescription());
		dbProduct.setName(product.getName());
		dbProduct.setPrice(product.getPrice());
		dbProduct.setProductImage(product.getProductImage());
		dbProduct.setSeller(product.getSeller());
		dbProduct.setStock(product.getStock());
		productDAO.save(dbProduct);
		return new ResponseEntity<Product>(dbProduct, HttpStatus.OK);
	}
		
	@RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<?> delete(@PathVariable int id) {
		Product product = productDAO.findById(id).orElse(null);
		if (product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
		productDAO.delete(product);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
		
}
