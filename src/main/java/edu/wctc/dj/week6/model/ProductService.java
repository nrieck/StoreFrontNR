/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week6.model;

import edu.wctc.week9.data.ProductDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author L117student
 */
public class ProductService {
   
    public Product getProductName(String id) {
        // TODO
        return null;
    }
    
    public List<Product> getAllProductNames() throws Exception {
        ProductDAO productDao = new ProductDAO();
        List<Product> productList = productDao.getProducts();
        
        return productList;
    }
    
    public List<Product> findProductNames(String search) {
        // TODO
        return null;
    }
}
