/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;


public class Item {
    private final String name; // name variable to store item name
    private float price; // price variable to store item price
    private int qty; // qty variable to store item qty
    
    // Constructor
    public Item(String name, int qty) {
        this.name = name;
        this.qty = qty;
        switch(name) { // Set price for specific items
            case "Kopi" : this.price = 10000; break;
            case "Susu" : this.price = 20000; break;
            case "Gula" : this.price = 30000; break;
        }
    }
    
    // name Getter
    public String getName() {
        return this.name;
    }
    
    // price Getter
    public float getPrice() {
        return this.price;
    }
    
    // returns result of item * qty
    public float getTotal() {
        return this.price * this.qty;
    }
    
    // qty setter
    public void setQty(int qty) {
        this.qty = qty;
    }
    
    // qty getter
    public int getQty() {
        return this.qty;
    }
}
