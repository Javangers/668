
/*
 * SFSU CSC 668/868 Lab
 * Post 2
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Yanxing
 */
public interface IRMIInterface extends Remote{
    /**
     * @return The number of the products
     * @throws java.rmi.RemoteException
     */
    public int getNumProducts() throws RemoteException;
    
    /**
     * @param id the id of the products
     * @return UPC
     * @throws RemoteException 
     */
    public String getUpcByID(int id) throws RemoteException;
    
    /**
     * @param upc
     * @return price
     * @throws RemoteException 
     */
    public float getPriceByUpc(String upc) throws RemoteException;
    
    /**
     * @param upc
     * @return description
     * @throws RemoteException 
     */
    public String getDescriptionByUpc(String upc) throws RemoteException;
    
    /**
     * @return get payment types, should be tokenized to get every single payment
     * @throws RemoteException 
     */
    public String getPaymentTypes() throws RemoteException;
    
    /**
     * @return The date&time of the server
     * @throws RemoteException 
     */
    public String getDateTime() throws RemoteException;
    
    /**
     * @param customer
     * @param trans serialized string, including UPC and quantities
     * @return if done without error
     * @throws RemoteException 
     */
    public boolean addTransaction(String customer, String trans, 
            String payment, String paymentParams) throws RemoteException;
}
