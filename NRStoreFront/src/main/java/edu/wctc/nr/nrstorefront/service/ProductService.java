/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.nr.nrstorefront.service;

import edu.wctc.nr.nrstorefront.data.dao.IProductDAO;
import edu.wctc.nr.nrstorefront.model.Product;
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
        return productDao.getOne(id);
    }

    public List<Product> getAllProductNames() throws Exception {
        return productDao.findAll();
    }

    public List<Product> findProductNames(String search) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("product", startsWith().ignoreCase());
        Product product = new Product();
        product.setProductName(search);
        return productDao.findAll(Example.of(product, matcher));
    }

    public void createProduct(Product product) {
        productDao.save(product);
    }

    public void updateProduct(Product product) {
        productDao.save(product);
    }

    public void deleteProduct(String id) {
        productDao.deleteById(id);
    }
}
