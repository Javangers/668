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

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the upc
     */
    public String getUpc() {
        return upc;
    }

    /**
     * @param upc the upc to set
     */
    public void setUpc(String upc) {
        this.upc = upc;
    }
}
