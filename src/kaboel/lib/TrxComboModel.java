/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;

import java.util.ArrayList;

public class TrxComboModel {
    private ArrayList<Item> items; // items variable to store item objects
    
    // Constructor
    public TrxComboModel() {
        this.items = new ArrayList<>();
    }
    
    // Convert ArrayList<Item> to Item[] then return the result
    public Item[] toArray() {
        Item[] items = new Item[this.items.size()];
        for(int i = 0; i < items.length; i++) {
            items[i] = this.items.get(i);
        }
        return items;
    }
    
    // Add item to items ArrayList<>
    public void addItem(String name, float price) {
        Item item = new Item(name, price);
        this.items.add(item);
    }
}
