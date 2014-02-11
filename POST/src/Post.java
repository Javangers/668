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
        Store store = manager.openStore("Target","Junction 380");
        
        // set up the post
        manager.setupPost();
        
        // receive transactions from file
        store.receiveTransaction();
        
        // close
        manager.closeStore();
    }
}