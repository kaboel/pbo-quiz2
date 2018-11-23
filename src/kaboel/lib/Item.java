/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;


public class Item {
    private final String name;
    private final float price;
    private int qty;
    
    public Item(String name, float price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price * this.qty;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }
    public int getQty() {
        return this.qty;
    }
}
