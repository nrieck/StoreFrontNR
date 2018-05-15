/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.nr.nrstorefront.rest;

import edu.wctc.nr.nrstorefront.model.Product;
import edu.wctc.nr.nrstorefront.service.ProductService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Nick
 */
public class NameController {
        @Autowired
	private ProductService productService;

	// Create (i.e., POST)
	@RequestMapping(method = POST, path = "/product")
	public void createName(@RequestBody Product product) {
		productService.createProduct(product);
	}

	// Read (i.e., GET)
	@RequestMapping(method = GET, path = "/product")
	public List<Product> getNames() throws Exception {
		List<Product> productList = productService.getAllProductNames();
		return productList;
	}

	@RequestMapping(method = GET, path = "/product/{id}")
	public Product getName(@PathVariable String id) {
		Product name = productService.getProductName(id);
		return name;
	}

	// Update (i.e., PUT)
	@RequestMapping(method = PUT, path = "/product")
	public void updateName(@RequestBody Product product) {
		productService.updateProduct(product);
	}

	// Delete
	@RequestMapping(method = DELETE, path = "/product/{id}")
	public void deleteName(@PathVariable String id) {
		productService.deleteProduct(id);
	}
}
