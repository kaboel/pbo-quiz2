/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;


public class Item {
    private final String name;
    private float price;
    private int qty;
    
    public Item(String name, int qty) {
        this.name = name;
        this.qty = qty;
        switch(name) {
            case "Kopi" : this.price = 10000; break;
            case "Susu" : this.price = 20000; break;
            case "Gula" : this.price = 30000; break;
        }
    }
    
    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }
    
    public float getTotal() {
        return this.price * this.qty;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }
    public int getQty() {
        return this.qty;
    }
}
