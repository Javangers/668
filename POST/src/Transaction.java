/*
 * SFSU CSC 668/868 Lab
 * Post 1
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Transaction class
 * this class contains a number of transaction items
 * see the ArrayList below
 * @author Yanxing
 */
public class Transaction {
    private final ArrayList<TransactionItem> items;
    private IPayment payment;
    
    /**
     * Constructor
     */
    public Transaction(){
        this.items = new ArrayList<>();
    }
    
    /**
     * @return payment
     */
    public IPayment getPayment(){
        return this.payment;
    }
    
    /**
     * add an item
     * @param item 
     */
    public void addItem(TransactionItem item){
        this.items.add(item);
    }
    
    /**
     * get the number of different items
     * not the total quantity
     * @return size of the items array list
     */
    public int getNumItems(){
        return this.items.size();
    }
   
    /**
     * set the payment type
     * @param type payment type enum
     * @param param parameter for creating the payment
     */
    public void setPayment(PaymentFactory.PaymentType type, String param){
        this.payment = PaymentFactory.createPayment(type, param);
    }
    
    /**
     * @return iterator of the items
     */
    public Iterator<TransactionItem> getItemIterator() {
        return this.items.iterator();
    }
}
