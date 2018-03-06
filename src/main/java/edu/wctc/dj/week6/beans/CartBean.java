/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week6.beans;

import edu.wctc.dj.week6.model.ShoppingCart;
import edu.wctc.dj.week6.model.ShoppingCartService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Nick
 */
@Named(value = "cartBean")
@SessionScoped
public class CartBean implements Serializable {
    
    private final ShoppingCartService shoppingCartService = new ShoppingCartService();
    private ShoppingCart shoppingCart;
    private List<ShoppingCart> shoppingCartList;
    
    public CartBean() {
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<ShoppingCart> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(List<ShoppingCart> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }
    
    public String allProducts() {
        shoppingCartList = shoppingCartService.getAllProductNames();
        return "productList";
    }
}
