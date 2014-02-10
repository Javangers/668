
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * SFSU CSC 668/868 Lab
 * Post 1
 */

/**
 * Store class
 * Opened by a manager
 * @author Yanxing
 */
public class Store {
    
    /**
     * Constructor with the store name and the address
     * @param name
     * @param address 
     */
    public Store(String name, String address){
        this.name = name;
        this.address = address;
        this.cashier = new Cashier(this);
        
        try {
            this.catalog = new Product_Catalog();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            
        }
    }
    
    /**
     * load the catalogs
     */
    public void loadCatalogs(){
        try {
            this.catalog.productReader("products.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            
        }
    }
    
    /**
     * get the name of this string
     * it will be used in the invoice
     * @return store name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * open the store by a manager
     * @param mgr manager instance
     */
    public void open(Manager mgr) {
        this.manager = mgr;
    }
    
    /**
     * receive a transaction
     * @param customer 
     */
    public void receiveTransaction(Customer customer){
        TransactionReader transReader = new TransactionReader(customer, this, 
                customer.getTrasactionFile());
        Transaction trans = transReader.getTransaction();
        
        // calculate the total and print the invoice
        this.cashier.printInvoice(customer, trans);
    }
    
    /**
     * @return catalog
     */
    public Product_Catalog getCatalog() {
        return this.catalog;
    }
    
    private Manager manager;
    private final Cashier cashier;
    private final String name;
    private final String address;
    private Product_Catalog catalog;
}