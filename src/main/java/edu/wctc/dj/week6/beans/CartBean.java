/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week6.beans;

import edu.wctc.dj.week6.model.Product;
import edu.wctc.dj.week6.model.ShoppingCart;
import edu.wctc.dj.week6.model.ShoppingCartService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nick
 */
@Named(value = "cartBean")
@SessionScoped
public class CartBean implements Serializable {
    
    private final String sessionId;
    private final ShoppingCart cart;
    private final ShoppingCartService cartService = new ShoppingCartService();
    
    public CartBean() {
        FacesContext facesCOntext = FacesContext.getCurrentInstance();
        sessionId = facesCOntext.getExternalContext().getSessionId(true);
        
        cart = cartService.getContents(sessionId);
    }
    
    public int getItemsInCart() {
        return cart.getItemsInCart();
    }
    public void addToCart(Product product) {
        cart.add(product);
        cartService.update(sessionId, cart);
    }
}
