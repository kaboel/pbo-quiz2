/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;

import javax.swing.table.*;

public class TrxTableModel extends DefaultTableModel {
    private String[] columns; // columns String array var to store column name
    
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
