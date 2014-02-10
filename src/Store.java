
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abeshue
 */
public class Store {
    private final String address;
    private final String name;
    private boolean isOpen;
    private final Product_Catalog product_catalog;
    
    public Store() throws IOException{
        isOpen = true;
        name = "Javengers";
        address = "1900 Holloway ave, SF, CA";
        product_catalog = new Product_Catalog();
    }
    
    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    public boolean getIsOpen() {
        return isOpen;
    }
}
