/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;

import java.util.ArrayList;

public class TrxComboModel {
    private ArrayList<Item> items; // items variable to store item objects
    
    // constructor
    public TrxComboModel() {
        this.items = new ArrayList<>();
    }
    
    // convert ArrayList<Item> to Item[] then return the result
    public Item[] toArray() {
        Item[] items = new Item[this.items.size()];
        for(int i = 0; i < items.length; i++) {
            items[i] = this.items.get(i);
        }
        return items;
    }
    
    // add item to Item list
    public void addItem(Item item) {
        this.items.add(item);
    }
}
