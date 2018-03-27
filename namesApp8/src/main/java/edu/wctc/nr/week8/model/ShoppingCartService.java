/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.nr.week8.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author L117student
 */
public class ShoppingCartService {

    private static final Map<String, ShoppingCart> contents = new HashMap<>();

    // if getting error here go to properties on the project // sources and change from 1.7 to 1.8
    public ShoppingCart getContents(String sessionId) {
        ShoppingCart cart = contents.computeIfAbsent(sessionId,(String s) -> new ShoppingCart());
        return contents.get(sessionId);
    }

    public void update(String sessionId, ShoppingCart cart) {
        contents.put(sessionId, cart);
    }

    public void delete(String sessionId) {
        contents.remove(sessionId);
    }

}
