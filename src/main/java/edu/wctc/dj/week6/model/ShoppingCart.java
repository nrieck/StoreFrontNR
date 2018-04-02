
package edu.wctc.dj.week6.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable{
    
    private final List<Product> contents = new ArrayList<>();
    
    public List<Product> getContents() {
        return contents;
    }
    
    public int getItemsInCart() {
        return contents.size();
    }
    
    public void add(Product product) {
        contents.add(product);
    }
    
    public void remove(Product product) {
        contents.remove(product);
    }
    
    public void removeAll() {
        contents.clear();
    }
    
    
}
