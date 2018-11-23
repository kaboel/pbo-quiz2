/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Transact {
    private int id = 0;
    private final String code;
    private ArrayList<Item> items;
    private float total;
    
    public Transact(int id) {
        this.id += id;
        this.code = setCode();
    }
    
    private String setCode() {
        String dt = new SimpleDateFormat("yyMMdd").format(new Date());
        String code = String.format(dt+"%02d", this.id);
        return code;
    }
    
    public float setTotal() {
        float total = 0;
        for (Item item : this.items) {
            total += item.getPrice();
        }
        return total;
    }
    
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    
    public String getCode() {
        return code;
    }
}
