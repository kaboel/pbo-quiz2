/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;


public class TrxTableModel {
    private final String[] columns; // columns String array var to store column name
    
    // Constructor
    public TrxTableModel() {
        this.columns = new String[] {
            "Nama", "Harga", "Jumlah"
        };
    }
    
    // Columname getter
    public String[] getColumnName() {
        return this.columns;
    }
}
