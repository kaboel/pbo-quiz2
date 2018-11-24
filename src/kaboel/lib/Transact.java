/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;

import java.util.*;

public class Transact {
    private final String code; // code variable to store Transaction code
    private ArrayList<Item> items = new ArrayList<>(); // items variable to store Items 
    private float total; // total variable to store total
    
    // Constructor
    public Transact(String code, ArrayList<Item> items) {
        this.code = code;
        this.items = items;
    }
    
    // Total setter
    public void setTotal() {
        float total = 0;
        for (Item item : this.items) {
            total += item.getTotal();
        }
        this.total = total;
    }
    
    // Transaction Output
    public String prtDetail() { 
        setTotal();
        String str = "";
        str += "Kode\t\t: "+ this.code +"\n";
        str += "Daftar Belanja : \n";
        for(Item item : this.items) {
            str += "\t"+ item.getName() +"(x"+ item.getQty() +") : "+ item.getTotal() +"\n";
        }
        str += "Total\t\t: "+ this.total;
        return str;
    }
}
