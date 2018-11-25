/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;

import java.util.ArrayList;
import java.util.HashMap;


public class TrxComboModel {
    private HashMap<Float,String> items = new HashMap<>();
    
    public TrxComboModel() {
        this.items.put(new Float(30000), "Gula");
        this.items.put(new Float(10000), "Kopi");
        this.items.put(new Float(20000), "Susu");
    }
    
    public ArrayList<String> getNames() {
        ArrayList<String> str = new ArrayList<>();
        for(String item : this.items.values()) {
            str.add(item);
        }
        return str;
    }
    
    public ArrayList<Float> getPrices() {
        ArrayList<Float> flt = new ArrayList<>();
        for(float item : this.items.keySet()) {
            flt.add(item);
        }
        return flt;
    }
    
    public void addItem(float price, String name) {
        this.items.put(price, name);
    }
}
