/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week6.beans;

import edu.wctc.dj.week6.model.Product;
import edu.wctc.dj.week6.model.ProductService;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Nick
 */
@Named(value = "productBean")
@SessionScoped
public class ProductBean implements Serializable {

    private final ProductService productService = new ProductService();
    private Product product;
    private List<Product> productList;
    public ProductBean() {
    }

    public Product getProduct() {
        return product;
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
    
    public void productDetail(AjaxBehaviorEvent event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("productDetail.xhtml?id=" + product.getProductId());
        } catch (IOException ex) {
            FacesMessage msg = new FacesMessage("IOException", product.getProductId());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public String allProducts() {
        productList = productService.getAllProductNames();
        return "productList";
    }
}
