/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.nr.nrstorefront.beans;

import edu.wctc.nr.nrstorefront.model.Product;
import edu.wctc.nr.nrstorefront.model.ShoppingCart;
import edu.wctc.nr.nrstorefront.service.ShoppingCartService;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component(value = "cartBean")
@Scope("Session")
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
