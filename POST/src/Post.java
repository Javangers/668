/*
 * SFSU CSC 668/868 Lab
 * Post 1
 */

/**
 * main class
 * @author Yanxing
 */
public class Post {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create a manater
        Manager manager = new Manager();
        
        // open a store
        Store store = manager.openStore();
        
        // set up the post
        manager.setupPost();
        
        // here comes a customer
        Customer customer = new Customer();
        
        // buy
        customer.doTransaction(store);
        
        // close
        manager.closeStore();
    }
}