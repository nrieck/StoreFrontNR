/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.nr.storefront.beans;

import edu.wctc.nr.storefront.model.Product;
import edu.wctc.nr.storefront.service.ProductService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nick
 */
@Component(value = "productBean")
@Scope("session")
public class ProductBean implements Serializable {

    @Autowired
    private ProductService productService;
    
    private String search;
    private Product product;
    private List<Product> productList;
    
    public ProductBean() {
    }

    public Product getProduct() {
        return product;
    }

    public void setSearch(String search) {
		this.search = search;
	}
    
    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    public String searchNames() {
		productList = productService.findProductNames(search);
		return "nameList";
	}
    
    public void productDetail(AjaxBehaviorEvent event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("productDetail.xhtml?id=" + product.getProductId());
        } catch (IOException ex) {
            FacesMessage msg = new FacesMessage("IOException", product.getProductId());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public String allProducts() throws Exception {
        productList = productService.getAllProductNames();
        return "productList";
    }
}
