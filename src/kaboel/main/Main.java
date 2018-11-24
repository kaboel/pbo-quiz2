/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package kaboel.main;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import kaboel.lib.*;

public class Main extends javax.swing.JFrame {
    private int id = 0;
    private String code;
    private DefaultTableModel tbModel;
    private ArrayList<Item> cart = new ArrayList<>();

    public Main() {
        TrxTableModel model = new TrxTableModel();
        this.tbModel = new DefaultTableModel(model.getColumnName(), 0);
        
        initComponents();
    }
    
    private String setCode() {
        this.incId();
        String dt = new SimpleDateFormat("yyMMdd").format(new Date());
        this.code = String.format(dt+"%02d", this.id);
        return code;
    }
    
    private void incId() {
        this.id += 1;
    }
    
    private void decId() {
        this.id -= 1;
    }
    
    private void updateQty(String name, int qty) {
        int add = 1;
        ArrayList<String> item = new ArrayList<>();
        for (int i = 0; i < tbModel.getRowCount(); i++){
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        for(int i = 0; i < item.size(); i++) {
            if(item.get(i).equals(name)) {
                tbModel.setValueAt(qty+add, i, 2);  
            } 
        }
    } 
    
    private int getQtyAt(String name) {
        int qty = 0;
        ArrayList<String> item = new ArrayList<>();
        for (int i = 0; i < tbModel.getRowCount(); i++){
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        for(int i = 0; i < item.size(); i++) {
            if(item.get(i).equals(name)) {
                qty = new Integer(tbModel.getValueAt(i, 2).toString());  
            } 
        }
        return qty;
    }
    
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
    
    private boolean isEmpty() {
        return this.tblListItems.getModel().getRowCount()<=0;
    }
    
    private void cartCheck() {
        if(isEmpty()) {
            this.btnSave.setEnabled(false);
            this.btnRmv.setEnabled(false);
        } else {
            this.btnSave.setEnabled(true);
            this.btnRmv.setEnabled(true);
        }
    }
    
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

        comboItems.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gula", "Kopi", "Susu" }));
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
        String name = this.comboItems.getSelectedItem().toString();
        int qty = new Integer(this.txtJml.getText());
        Item item = new Item(name, qty);
        if(isDuplicate(name)) {
            int add = getQtyAt(name);
            updateQty(name, add);
        } else {
            Object[] obj = {
                item.getName(),
                item.getPrice(),
                item.getQty()
            };
            tbModel.addRow(obj);
        }
        this.cartCheck();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRmvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRmvActionPerformed
        if(tblListItems.getSelectedRow()<0) {
            String str = "Pilih item yang ingin dihapus !";
            JOptionPane.showMessageDialog(this, str, "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int count = tblListItems.getSelectedRows().length;
            for(int i = 0; i < count; i++) {
                tbModel.removeRow(tblListItems.getSelectedRow());
            }
        }
        this.cartCheck();
    }//GEN-LAST:event_btnRmvActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            for (int i = 0; i < tbModel.getRowCount(); i++){
                String name = tbModel.getValueAt(i, 0).toString();
                int qty = new Integer(tbModel.getValueAt(i, 2).toString());
                this.cart.add(new Item(name, qty));
            }
            Transact Trx = new Transact(this.code, this.cart);
            StringBuilder str = new StringBuilder();
            str.append(Trx.prtDetail());
            JOptionPane.showMessageDialog(this, str, "Detil Transaksi", JOptionPane.INFORMATION_MESSAGE);
            newTrx();
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
