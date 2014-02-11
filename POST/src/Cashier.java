
/*
 * SFSU CSC 668/868 Lab
 * Post 1
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;


/**
 * Cashier class
 * accept the payment and output the invoice
 * @author Yanixng
 */
public class Cashier {
    
    /**
     * constructor
     * @param store
     */
    public Cashier(Store store) {
        this.store = store;
        
        //print the store name
        System.out.println(store.getName());
        System.out.println();
    }
    
    /**
     * output the invoice
     * @param transaction transaction object
     */
    public void printInvoice(Transaction transaction){
        
        Customer customer = transaction.getCustomer();
        
        System.out.println(customer.getName() + getDateTime());
        
        float total = 0;
        
        Iterator<TransactionItem> it = transaction.getItemIterator();
        
        // check every item
        while (it.hasNext()){
            TransactionItem item = it.next();
            String upc = item.getUpc();
            
            if(this.store.getCatalog().itemInStocks(upc)){
                float price = this.store.getCatalog().getItemPrice(upc);
                float subtotal = price * item.getQuantity();
                total += subtotal;
                
                System.out.println(upc + ": " + item.getQuantity() + " @ " +
                        price + " subtotal: " + subtotal);
            }
        }
        
        // print the result
        IPayment payment = transaction.getPayment();
        payment.printResult(total);
        
        System.out.println();
    }
    
    //private String 
    
    /**
     * get the current date time
     * @return a string of date time
     */
    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("\tMM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String datetime = dateFormat.format(date);
        return datetime;
    }
    
    private final Store store;
}
