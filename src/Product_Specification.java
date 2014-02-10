/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abeshue
 */
public class Product_Specification {
    private String description;
    private float price;
    private String upc;
    
    public Product_Specification(String upc, String description, float price) {
        this.description = description;
        this.price = price;
        this.upc = upc;
    }
}
