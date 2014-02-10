/*
 * SFSU CSC 668/868 Lab
 * Post 1
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author abeshue
 */

public class Product_Catalog {
    HashMap catalog = new HashMap<>();

    public Product_Catalog() throws IOException {
    }
    
    /**
     * check the database if the item is in the stock
     * @param upc
     * @return 
     */
    public boolean itemInStocks(String upc) {
        return this.catalog.containsKey(upc);
    }
    
    /**
     * @param upc
     * @return item price
     * if not in stock, return 0
     */
    public float getItemPrice(String upc) {
        Product_Specification item = (Product_Specification)this.catalog.get(upc);
        if(item == null){
            return 0;
        }else{
            return item.getPrice();
        }
    }

    /**
     * read the database from file
     * @param filename
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void productReader(String filename) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String UPC, description;
            float price;
            Product_Specification item;
            String line = br.readLine();

            while (line != null) {
                UPC = line.substring(0, 4);
                description = line.substring(9, 29);
                price = Float.valueOf(line.substring(34));
                
                item = new Product_Specification(UPC, description, price);
                catalog.put(UPC, item);
                
                //System.out.print(UPC + " " + description + " " + price);
                
                line = br.readLine();
            }
        } catch (IOException e) {
            System.err.print("File not found!");
        }
    }
}
