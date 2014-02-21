/*
 * SFSU CSC 668/868 Lab
 * Post 1
 */

/**
 * Transaction item class used for the customer
 * contained in transaction.txt file
 * @author Yanxing
 */
public class TransactionItem {
    private String Upc;
    private int    quantity;
    
    /**
     * Constructor with the upc of the item
     * @param upc 
     */
    public TransactionItem(String upc) {
        this.Upc = upc;
        this.quantity = 1;
    }
    
    /**
     * Constructor with the upc of the item
     * @param upc 
     * @param quantity 
     */
    public TransactionItem(String upc, int quantity) {
        this.Upc = upc;
        this.quantity = quantity;
    }
    
    /**
     * @return upc
     */
    public String getUpc() {
        return Upc;
    }
    
    /**
     * @param upc 
     */
    public void setUpc(String upc) {
        this.Upc = upc;
    }
    
    /**
     * @return quantity of this item
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * @param quantity 
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}