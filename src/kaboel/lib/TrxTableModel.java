/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package kaboel.lib;

import javax.swing.table.*;

public class TrxTableModel extends DefaultTableModel {
    private String[] columns;
    
    public TrxTableModel() {
        this.columns = new String[] {
            "Nama", "Harga", "Jumlah"
        };
    }

    public String[] getColumnName() {
        return this.columns;
    }

    @Override
    public void setRowCount(int i) {
        super.setRowCount(0);
    }

    @Override
    public void addRow(Object[] os) {
        super.addRow(os);
    }

    @Override
    public void removeRow(int i) {
        super.removeRow(i); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
