/*
 * SFSU CSC 668/868 Lab
 * Post 1
 */

/**
 * Item class
 * @author Yanxing
 */
public class Item {
    private String upc;
    private String description;
    private float  price;
    
    /**
     * Constructor
     */
    public Item() {
        price = 0;
    }

    /**
     * @return upc string
     */
    public String getUpc() {
        return upc;
    }

    /**
     * @param upc 
     */
    public void setUpc(String upc) {
        this.upc = upc;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * @return price
     */
    public float getPrice() {
        return price;
    }
    
    /**
     * @param price 
     */
    public void setPrice(float price) {
        this.price = price;
    }
}