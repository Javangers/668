/*
 * SFSU CSC 668/868 Lab
 * Post 1
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * transaction reader class
 * this class will load the transaction file from the disk
 * and create an transaction object
 * @author Yanxing
 */
public class TransactionReader {
    
    /**
     * Constructor
     * @param customer customer
     * @param store store instance
     * @param filename transaction file
     */
    public TransactionReader(Customer customer, Store store, String filename){
        this.customer = customer;
        this.transaction = new Transaction();
        loadFile(filename);
    }
    
    /**
     * @return get the object instance of the transaction
     */
    public Transaction getTransaction(){
        return this.transaction;
    }

    /**
     * extract the customer name from the text file
     * @param line the string of line
     * @return customer name
     */
    private String extractCustomer(String line) {
        String name = "";
        if (line != null) {
            // if there is an "Identifying information" tag, just extract the 
            // following part of the line, otherwise the whole line is the name
            // of the customer
            String idRegex = "(?i)Identifying information:*";
            name = line.replaceAll(idRegex, "").trim();

            //System.out.println(customer);
        } else {
            // invalid input file
            System.out.println("Invalid input file");
        }
        return name;
    }

    /**
     * extract the item or payment
     * @param line line string
     */
    private void extractItemOrPayment(String line) {
        // before the last line are items
        String itemRegex = "(?i)Item:*";

        // the last valid line should be payment
        String paymentRegex = "(?i)Payment:*";

        String item = null;
        String payment = null;

        // match the regex and test if this line is an item
        Matcher matcher = Pattern.compile(itemRegex).matcher(line);
        if (matcher.find()) {
            item = line.replaceAll(itemRegex, "").trim();
        } else {
            matcher = Pattern.compile(paymentRegex).matcher(line);
            if (matcher.find()) {
                payment = line.replaceAll(paymentRegex, "").trim();
            }
        }

        // deal with the item
        if (item != null) {
            //System.out.println(item);
            StringTokenizer st = new StringTokenizer(item);
            TransactionItem itemToAdd;
            if (st.countTokens() == 1) {
                itemToAdd = new TransactionItem(st.nextToken());
                this.transaction.addItem(itemToAdd);
            } else if (st.countTokens() == 2) {
                itemToAdd = new TransactionItem(st.nextToken());
                itemToAdd.setQuantity(Integer.parseInt(st.nextToken()));
                this.transaction.addItem(itemToAdd);
            } else {
                System.out.println("Invalid item input");
            }
            // deal with the payment
        } else if (payment != null) {
            //System.out.println(payment);
            StringTokenizer st = new StringTokenizer(payment);
            if (st.countTokens() != 2) {
                System.out.println("Invalid payment input");
            } else {
                String paymentType = st.nextToken();
                String param = st.nextToken();

                // check the payment type and use payment factory to create the 
                // real payment instance
                // the parameter should be provided, i.e. how much cash or card#
                if (paymentType.matches("(?i)cash*")) {
                    param = param.replaceAll("\\$", "");
                    this.transaction.setPayment(
                            PaymentFactory.PaymentType.PAYMENT_CASH, param);
                }else if (paymentType.matches("(?i)check*")) {
                    // actually parameter is not needed for check payment
                    this.transaction.setPayment(
                            PaymentFactory.PaymentType.PAYMENT_CHECK, param);
                }
                else if (paymentType.matches("(?i)credit*")) {
                    this.transaction.setPayment(
                            PaymentFactory.PaymentType.PAYMENT_CREDIT_CARD, param);
                }
            }
        } else {
            // invalid input file
            System.out.println("Invalid input file");
        }
    }

    /**
     * load the transaction text file
     * @param fileName file name
     */
    private void loadFile(String fileName){
        FileReader file = null;
        try {
            file = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(file);
            
            // first line, customer name
            String line = reader.readLine();
            String customerName = extractCustomer(line);
            
            this.customer.setName(customerName);
            
            // the rest of the file
            while ((line = reader.readLine()) != null) {
                extractItemOrPayment(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    // Ignore issues during closing 
                }
            }
        }
    }
    
    private final Transaction transaction;
    
    private final Customer customer;
}