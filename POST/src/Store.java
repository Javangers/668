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
     * check the database if the item is in the stock
     * @param upc
     * @return 
     */
    public boolean itemInStocks(String upc) {
        return true;
    }
    
    /**
     * @param upc
     * @return item price
     * if not in stock, return 0
     */
    public float getItemPrice(String upc) {
        return 0;
    }
    
    private Manager manager;
    private final Cashier cashier;
    private final String name;
    private final String address;
}