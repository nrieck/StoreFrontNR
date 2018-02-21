/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week4.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author L117student
 */
public class ProductService {
    
    private List<Product> productList = Arrays.asList(
            new Product("1", "Cookie", 2.55),
            new Product("2", "Apple", 1.25),
            new Product("3", "Pie", 4.99),
            new Product("4", "Donout", 2.99),
            new Product("5", "Chips", 3.99)
    );
   
    public Product getProductName(String id) {
        Product theProductName = null;
        for (Product productName : productList) {
            if (productName.getProductId().equals(id)) {
                theProductName = productName;
            }
        }
        return theProductName;
    }
    
    public List<Product> getAllProductNames() {
        return productList;
    }
    
    public List<Product> findProductNames(String search) {
        search = search.toLowerCase();
        List<Product> theList = new ArrayList();
        for (Product productName : productList) {
            if (productName.getProductName().toLowerCase().startsWith(search)) {
                theList.add(productName);
            }
        }
        return theList;
    }
}
