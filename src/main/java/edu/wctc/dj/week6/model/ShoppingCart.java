
package edu.wctc.dj.week6.model;

public class ShoppingCart {
    
    private String productName;
    private String quantity;

    public ShoppingCart(String productName, String quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    
}
