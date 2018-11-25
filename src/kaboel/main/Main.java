/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package kaboel.main;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import kaboel.lib.*;

public class Main extends javax.swing.JFrame {
    private int id = 0; // id variable for Transaction code iteration control
    private String code; // code variable for Transaction code
    private DefaultComboBoxModel cbModel; // Jcombobox model
    private DefaultTableModel tbModel; // Jtable model 
    private ArrayList<Item> cart = new ArrayList<>(); // cart variable to store each Transaction items

    public Main() {
        TrxComboModel comboModel = new TrxComboModel();
        this.cbModel = new DefaultComboBoxModel<>(comboModel.getNames().toArray()); // Set Combo items
        
        TrxTableModel tableModel = new TrxTableModel(); 
        this.tbModel = new DefaultTableModel(tableModel.getColumnName(), 0); // Set Table Column name
        
        initComponents();
    }
    
    // Set code function
    private String setCode() {
        this.incId();
        String dt = new SimpleDateFormat("yyMMdd").format(new Date()); // get Current date as String;
        this.code = String.format(dt+"%02d", this.id);  // then merge it with id with 0 pad
        return code;
    }
    
    // id increment
    private void incId() {
        this.id += 1;
    }
    
    // id decrement
    private void decId() {
        this.id -= 1;
    }
    
    private Object[] addItem(String name, int qty) {
        float price = 0;
        TrxComboModel items = new TrxComboModel();
        for(int i = 0; i < items.getNames().size(); i++) {
            if(name.equalsIgnoreCase(items.getNames().get(i))) {
                price = items.getPrices().get(i);
            }
        } 
        Object[] obj = {
          name,
          price,
          qty
        };
        return obj;
    }
    
    private Object[] getItem(Item item) {
        Object[] obj = {
            item.getName(),
            item.getPrice(),
            item.getQty()
        };
        return obj;
    }
    
    // update qty function 
    private void updateQty(String name, int add) {
        ArrayList<String> item = new ArrayList<>();
        for (int i = 0; i < tbModel.getRowCount(); i++){
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        for(int i = 0; i < item.size(); i++) {
            if(item.get(i).equals(name)) {
                int qty = new Integer(tbModel.getValueAt(i, 2).toString());
                tbModel.setValueAt(qty+add, i, 2);  
            } 
        }
    } 
    
    // check if the item selected is a duplicate of a previously selected item
    private boolean isDuplicate(String name) {
        boolean result = false;
        ArrayList<String> item = new ArrayList<>();
        for (int i = 0; i < tbModel.getRowCount(); i++){
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        for(String i : item) {
            if(i.equals(name)) {
                result = true;
            } 
        }
        return result;
    } 
    
    // check if the table is empty
    private boolean isEmpty() {
        return this.tblListItems.getModel().getRowCount()<=0;
    }
    
    // disable Remove and Save button if the table is empty
    private void cartCheck() {
        if(isEmpty()) {
            this.btnSave.setEnabled(false);
            this.btnRmv.setEnabled(false);
        } else {
            this.btnSave.setEnabled(true);
            this.btnRmv.setEnabled(true);
        }
    }
    
    // commit new Transaction after a succesful transaction is finished
    private void newTrx() {
        this.txtJml.setText("");
        this.txtCode.setText("");
        this.btnNew.setEnabled(true);
        this.btnSave.setEnabled(false);
        this.btnCncl.setEnabled(false);
        this.btnAdd.setEnabled(false);
        this.btnRmv.setEnabled(false);
        this.txtJml.setEnabled(false);
        this.comboItems.setEnabled(false);
        this.tbModel.setRowCount(0);
        this.cart.clear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtJml = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        comboItems = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListItems = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnCncl = new javax.swing.JButton();
        btnRmv = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaksi");

        txtJml.setEnabled(false);

        txtCode.setEnabled(false);

        comboItems.setModel(this.cbModel);
        comboItems.setEnabled(false);

        jLabel1.setText("Code");

        jLabel2.setText("Items");

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblListItems.setModel(this.tbModel);
        jScrollPane1.setViewportView(tblListItems);

        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCncl.setText("Cancel");
        btnCncl.setEnabled(false);
        btnCncl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCnclActionPerformed(evt);
            }
        });

        btnRmv.setText("Remove");
        btnRmv.setEnabled(false);
        btnRmv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRmvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboItems, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtJml, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCode))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRmv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCncl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnNew))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRmv))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCncl))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        this.txtJml.setText("1");
        this.btnNew.setEnabled(false);
        this.btnCncl.setEnabled(true);
        this.btnAdd.setEnabled(true);
        this.txtJml.setEnabled(true);
        this.comboItems.setEnabled(true);
        this.txtCode.setText(this.setCode());
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnCnclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCnclActionPerformed
        newTrx();
        this.decId();
    }//GEN-LAST:event_btnCnclActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String name = this.comboItems.getSelectedItem().toString(); // get selected item on the comboItems then;
        int qty = new Integer(this.txtJml.getText()); // get txtJml text as an Integer then;
        if(isDuplicate(name)) { // check if an item is a duplicate;
            updateQty(name, qty); // if so, add only the qty cell with the new inputed qty
        } else {
            tbModel.addRow(addItem(name, qty));
        }
        this.cartCheck();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRmvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRmvActionPerformed
        if(tblListItems.getSelectedRow()<0) { // check if theres a row selected;
            String str = "Pilih item yang ingin dihapus !"; // if theres none, dialog will appear
            JOptionPane.showMessageDialog(this, str, "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int count = tblListItems.getSelectedRows().length; // if theres a row selected, a row will be removed
            for(int i = 0; i < count; i++) {
                tbModel.removeRow(tblListItems.getSelectedRow());
            }
        }
        this.cartCheck();
    }//GEN-LAST:event_btnRmvActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            for (int i = 0; i < tbModel.getRowCount(); i++) {                   // loop each rows of the table then;
                String name = tbModel.getValueAt(i, 0).toString();              // store the name and the qty into variables then;
                float price = new Float(tbModel.getValueAt(i, 1).toString());   // add each result to cart global variable as an Item object 
                int qty = new Integer(tbModel.getValueAt(i, 2).toString());     //
                this.cart.add(new Item(name, price, qty));                      //
            }
            Transact Trx = new Transact(this.code, this.cart); // instantiate Transact class with the current code and previously ommited cart
            StringBuilder str = new StringBuilder(); // Stringbuilder to handle the transaction output
            str.append(Trx.prtDetail()); // append transaction output
            JOptionPane.showMessageDialog(this, str, "Detil Transaksi", JOptionPane.INFORMATION_MESSAGE); // call the dialog with the stringbuilder's string
            newTrx(); // start a new transaction after;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param argv the command line arguments
     */
    public static void main(String argv[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCncl;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRmv;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboItems;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListItems;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtJml;
    // End of variables declaration//GEN-END:variables
}
