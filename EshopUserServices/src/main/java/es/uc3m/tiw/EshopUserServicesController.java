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
public class EshopUserServicesController {

	@Autowired
	ApplicationUserDAO dao;

	// testing
	@RequestMapping("/hello")
	public @ResponseBody String home() {
		return "Hello World";
	}

	// get a list of all users
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<applicationuser>> getAll() {

		List<applicationuser> ApplicationUsers;

		ApplicationUsers = dao.findAll();

		return new ResponseEntity<>(ApplicationUsers, HttpStatus.OK);
	}

	// get single user by primary key string
	@RequestMapping(value = "users/{email}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getUserByEmail(@PathVariable String email) {
		applicationuser findUser = dao.findById(email).orElse(null);

		if (findUser == null) {
			return new ResponseEntity<applicationuser>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<applicationuser>(findUser, HttpStatus.OK);
	}

	// edit user with put
	@RequestMapping(value = "users", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<?> editUser(@RequestBody applicationuser user) {

		applicationuser editUser = dao.findById(user.getEmail()).orElse(null);

		if (editUser == null) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}

		editUser.setAddress(user.getAddress());
		editUser.setName(user.getName());
		editUser.setPassword(user.getPassword());
		editUser.setSurname(user.getSurname());
		editUser.setRole(user.getRole());

		dao.save(editUser);

		return new ResponseEntity<applicationuser>(editUser, HttpStatus.OK);

	}

	// delete user
	@RequestMapping(value = "users/{email}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<?> deleteUser(@PathVariable String email) {

		System.out.println("DELETE USER IN MICROSERVICE");

		System.out.println("EMAIL STRING: " + email);

		applicationuser deleteUser = dao.findById(email).orElse(null);

		System.out.println("deleteUser Products: " + deleteUser.getProducts());

		for (Product product : deleteUser.getProducts()) {

			System.out.println("product: " + product.getName());
		}

		System.out.println("CAN'T FIND USER?");
		if (deleteUser == null) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}

		dao.delete(deleteUser);
		return new ResponseEntity<applicationuser>(HttpStatus.OK);
	}
	// add new user with post

	@RequestMapping(value = "users", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> addUser(@RequestBody applicationuser user) {
		if (dao.existsById(user.getEmail())) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		dao.save(user);
		return new ResponseEntity<applicationuser>(user, HttpStatus.CREATED);

	}

	// get user wishlist
	// added json ignore on applicationUsers
	@RequestMapping(value = "users/{email}/wishlist", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getUserWishlist(@PathVariable String email) {

		applicationuser wishListUser = dao.findById(email).orElse(null);
		List wishlistProducts = wishListUser.getProducts();
		return new ResponseEntity<List<Product>>(wishlistProducts, HttpStatus.OK);
	}
/**
	
	//add item to wishlist
	@RequestMapping(value = "users/{email}/wishlist/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> addtoWishlist(@PathVariable String email, @PathVariable int id)
	{
		
		applicationuser wishListUser = dao.findById(email).orElse(null);
		List wishlistProducts = wishListUser.getProducts();
		
		newProduct = 
		
		wishlistProducts.add(newProduct)
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	///remove item from wishlist
	
	

**/
}