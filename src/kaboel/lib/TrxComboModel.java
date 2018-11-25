/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;

import java.util.ArrayList;
import java.util.HashMap;


public class TrxComboModel {
    private HashMap<String,Float> items = new HashMap<>();
    
    public TrxComboModel() {
        this.items.put("Gula", new Float(30000));
        this.items.put("Kopi", new Float(10000));
        this.items.put("Susu", new Float(20000));
        this.items.put("Tepung", new Float(10000));
    }
    
    public ArrayList<String> getNames() {
        ArrayList<String> str = new ArrayList<>();
        for(String item : this.items.keySet()) {
            str.add(item);
        }
        return str;
    }
    
    public ArrayList<Float> getPrices() {
        ArrayList<Float> flt = new ArrayList<>();
        for(float item : this.items.values()) {
            flt.add(item);
        }
        return flt;
    }
    
    public void addItem(String name, float price) {
        this.items.put(name, price);
    }
}
