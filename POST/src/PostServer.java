/*
 * SFSU CSC 668/868 Lab
 * Post 1
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yanxing
 */
public final class PostServer extends UnicastRemoteObject
        implements IRMIInterface {
    
    Manager manager;
    
    Store store;
    
    public PostServer() throws RemoteException {
        super(0);    // required to avoid the 'rmic' step, see below
        initBackend();
    }
    
    /**
     * return the product list
     */
    @Override
    public int getNumProducts(){
        return this.store.getCatalog().getNumProducts();
    }
    
    /**
     * @param id the id of the products
     * @return UPC 
     */
    @Override
    public String getUpcByID(int id){
        return this.store.getCatalog().getProductByID(id).getUpc();
    }
    
    /**
     * @param upc
     * @return price
     */
    @Override
    public float getPriceByUpc(String upc){
        return this.store.getCatalog().getItemPrice(upc);
    }
    
    /**
     * @param upc
     * @return description
     */
    @Override
    public String getDescriptionByUpc(String upc) {
        return this.store.getCatalog().getItemDescription(upc);
    }
    
    /**
     * @return Payment types
     */
    @Override
    public String getPaymentTypes() {
        return PaymentFactory.getPayments();
    }
    
    /**
     * Do the transaction
     * @param payment
     * @param paymentParams
     * @return if done successfully
     */
    @Override
    public boolean addTransaction(String customer, String trans,
            String payment, String paymentParams) {
        
        Customer cus = new Customer();
        cus.setName(customer);
        Transaction transaction = new Transaction(cus);
        transaction.setPaymentByString(payment, paymentParams);
        
        StringTokenizer tokenizer;
        tokenizer = new StringTokenizer(trans,",");
        while(tokenizer.hasMoreTokens()) {
            String row = tokenizer.nextToken();
            String[] parts = row.split(" ");
            if (parts.length != 2){
                System.out.println("Invalid transaction!");
                return false;
            }
            transaction.addItem(new TransactionItem(parts[0],Integer.parseInt(parts[1])));
        }
        
        this.store.receiveTransaction(transaction);
        return true;
    }
    
    /**
     * @return Date and time
     */
    @Override
    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("\tMM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String datetime = dateFormat.format(date);
        return datetime;
    }
    
    public void initBackend()
    {
        // create a manater
        this.manager = new Manager();
        
        // open a store
        this.store = manager.openStore("Target","Junction 380");
        
        // set up the post
        manager.setupPost();
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        System.out.println("RMI server starting");
 
        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099); 
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }
        
        try {
            PostServer serverObj = new PostServer();
            // Bind this object instance to the name "RmiServer"
            Naming.rebind("//localhost/RmiServer", serverObj);
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(PostServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("PeerServer bound in registry");
        
        // receive transactions from file
        //store.receiveTransaction();
        
        // close
        //manager.closeStore();
    }
}
