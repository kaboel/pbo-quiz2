/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;

import java.util.*;

public class Transact {
    private final String code;
    private ArrayList<Item> items = new ArrayList<>();
    private float total;
    
    public Transact(String code, ArrayList<Item> items) {
        this.code = code;
        this.items = items;
    }
    
    public float getTotal() {
        float total = 0;
        for (Item item : this.items) {
            total += item.getPrice();
        }
        return total;
    }
    
    public String prtDetail() {
        String str = "";
        str += "Kode\t\t: "+ this.code +"\n";
        str += "Daftar Belanja : \n";
        for(Item item : this.items) {
            str += "\t"+ item.getName() +"(x"+ item.getQty() +") : "+ item.getTotal() +"\n";
        }
        str += "Total\t\t: "+ this.getTotal();
        return str;
    }
}
