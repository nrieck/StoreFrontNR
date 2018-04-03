/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.week9.data;

import edu.wctc.dj.week6.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nick
 */
public class ProductDAO {
    
    public List<Product> getProducts() throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionUtil.getConnection();
            stmt = conn.prepareStatement("select * from product");
            rs = stmt.executeQuery();
            
            List<Product> productList = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                
                Product product = new Product(id, name, price);
                
                productList.add(product);
            }
            
            return productList;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }
}
