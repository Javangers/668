/*
 * SFSU CSC 668/868 Lab
 * Post 1
 */

/**
 * Customer class
 * @author Yanxing
 */
public class Customer {
    
    /**
     * Constructor
     */
    public Customer() {
        this.name = "";
    }
    
    /**
     * @return name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * set the customer from the transaction file
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return transaction file name
     * in this lab we always use transaction.txt
     */
    public String getTrasactionFile() {
        return "transaction.txt";
    }
    
    /**
     * buy the items in a particular store
     * @param store the specific store instance
     */
    public void doTransaction(Store store) {
        store.receiveTransaction(this);
    }
    
    private String name;
}