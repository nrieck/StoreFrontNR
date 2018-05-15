/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.nr.nrstorefront.service;

import edu.wctc.nr.nrstorefront.model.ShoppingCart;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShoppingCartService {
    private static final Map<String, ShoppingCart> contents = new HashMap<>();
    
    public ShoppingCart getContents(String sessionId) {
        ShoppingCart cart = contents.computeIfAbsent(sessionId, (String t) -> new ShoppingCart());
        
//        ShoppingCart cart = contents.computeIfAbsent(sessionId, new Function<String, ShoppingCart>() {
//            @Override
//            public ShoppingCart apply(String t) {
//                return new ShoppingCart();
//            }
//        });
        
        return cart;
    }
    
    public void update(String sessionId, ShoppingCart cart) {
        contents.put(sessionId, cart);
    }
    
    public void delete(String sessionId) {
        contents.remove(sessionId);
    }
    
}
