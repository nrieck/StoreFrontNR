/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week10.week10.services;

import edu.wctc.dj.week10.data.dao.IProductDAO;
import edu.wctc.dj.week10.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
   
    @Autowired
    private IProductDAO productDao;
    
    public Product getProductName(String id) {
        return productDao.findOne(id);
    }
    
    public List<Product> getAllProductNames() throws Exception {
        return productDao.findAll();
    }
    
    public List<Product> findProductNames(String search) {
        ExampleMatcher matcher = ExampleMatcher.matching()
			.withMatcher("name", startsWith().ignoreCase());
		Product product = new Product();
		product.setProductName(search);
		return productDao.findAll(Example.of(product, matcher));
	}
    }