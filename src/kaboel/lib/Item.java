/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;


public class Item {
    private final String name; // name variable to store item name
    private final float price; // price variable to store item price
    private int qty; // qty variable to store item qty
    
    // Double parameter Constructor for Jcombobox population
    public Item(String name, float price) {
        this.name = name;
        this.price = price;
    }
    
    // Full Constructor for Transaction's set items
    public Item(String name, float price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }
    
    // price Getter
    public float getPrice() {
        return this.price;
    }
    
    // name Getter
    public String getName() {
        return this.name;
    }
    
    // qty getter
    public int getQty() {
        return this.qty;
    }
    
    // returns result of item * qty
    public float getTotal() {
        return this.price * this.qty;
    }
    
    @Override // Override toString() method to handle the combobox object
    public String toString() {
        return this.name;
    }
}
