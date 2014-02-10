
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author abitchue
 */

public class Product_Catalog {
    HashMap catalog = new HashMap<String, Product_Specification>();

    public Product_Catalog() throws IOException {
        productReader();
    }

    public void productReader() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/file.txt"))) {
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
