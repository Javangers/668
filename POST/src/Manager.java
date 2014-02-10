/*
 * SFSU CSC 668/868 Lab
 * Post 1
 */

/**
 * Manager class
 * Open a store, set up the post and load the item catalogs
 * @author Yanxing
 */
public class Manager {
    public Manager(){   
    }
    
    /**
     * set up the post and load the item catalogs from the database
     * in this lab we just simply load from a text file
     */
    public void setupPost(){
        this.activeStore.loadCatalogs();
    }
    
    /**
     * open a store
     * @return store instance
     */
    public Store openStore(String name, String address){
        //open a store
        this.activeStore = new Store(name, address);
        return this.activeStore;
    }
    
    /**
     * @return get the active store
     */
    public Store getActiveStore(){
        return this.activeStore;
    }
    
    /**
     * close store
     */
    public void closeStore(){
        this.activeStore = null;
    }
    
    private Store activeStore;
}