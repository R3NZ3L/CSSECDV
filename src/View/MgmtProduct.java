/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SQLite;
import Model.Product;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author beepxD
 */
public class MgmtProduct extends javax.swing.JPanel {

    public SQLite sqlite;
    public DefaultTableModel tableModel;
    
    private int role;
    private String currUsername;
    
    public MgmtProduct(SQLite sqlite, int role) {
        initComponents();
        this.sqlite = sqlite;
        tableModel = (DefaultTableModel)table.getModel();
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        
        this.role = role;
        
        if (this.role == 2) {
            addBtn.setVisible(false);
            addBtn.setEnabled(false);
            editBtn.setVisible(false);
            editBtn.setEnabled(false);
            deleteBtn.setVisible(false);
            deleteBtn.setEnabled(false);
        }
        else if (this.role == 3 || this.role == 4) {
            purchaseBtn.setVisible(false);
            purchaseBtn.setEnabled(false);
        }
//        UNCOMMENT TO DISABLE BUTTONS
//        purchaseBtn.setVisible(false);
//        addBtn.setVisible(false);
//        editBtn.setVisible(false);
//        deleteBtn.setVisible(false);
    }

    public void init(String username){
        this.currUsername = username;
        
        //      CLEAR TABLE
        for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
            tableModel.removeRow(0);
        }
        
//      LOAD CONTENTS
        ArrayList<Product> products = sqlite.getProduct();
        for(int nCtr = 0; nCtr < products.size(); nCtr++){
            tableModel.addRow(new Object[]{
                products.get(nCtr).getName(), 
                products.get(nCtr).getStock(), 
                products.get(nCtr).getPrice()});
        }
        
    }
    
    public void designer(JTextField component, String text){
        component.setSize(70, 600);
        component.setFont(new java.awt.Font("Tahoma", 0, 18));
        component.setBackground(new java.awt.Color(240, 240, 240));
        component.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        component.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), text, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12)));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        purchaseBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Stock", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(24);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(1).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        purchaseBtn.setBackground(new java.awt.Color(255, 255, 255));
        purchaseBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        purchaseBtn.setText("PURCHASE");
        purchaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseBtnActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(255, 255, 255));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(255, 255, 255));
        editBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editBtn.setText("EDIT");
        editBtn.setToolTipText("");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(purchaseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purchaseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void purchaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            JTextField stockFld = new JTextField("0");
            designer(stockFld, "PRODUCT STOCK");

            Object[] message = {
                "How many " + tableModel.getValueAt(table.getSelectedRow(), 0) + " do you want to purchase?", stockFld
            };

            int result = JOptionPane.showConfirmDialog(null, message, "PURCHASE PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

            if (result == JOptionPane.OK_OPTION) {
                // System.out.println(stockFld.getText());
                
                String name = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
                int numPurchased = Integer.parseInt(stockFld.getText());
                
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                String timestamp = df.format(new Date());
                
                this.sqlite.purchaseProduct(name, numPurchased);
                this.sqlite.addHistory(this.currUsername, name, numPurchased, timestamp);
            }
        }
    }//GEN-LAST:event_purchaseBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        JTextField nameFld = new JTextField();
        JTextField stockFld = new JTextField();
        JTextField priceFld = new JTextField();

        designer(nameFld, "PRODUCT NAME");
        designer(stockFld, "PRODUCT STOCK");
        designer(priceFld, "PRODUCT PRICE");

        Object[] message = {
            "Insert New Product Details:", nameFld, stockFld, priceFld
        };

        int result = JOptionPane.showConfirmDialog(null, message, "ADD PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

        if (result == JOptionPane.OK_OPTION) {
            // System.out.println(nameFld.getText());
            // System.out.println(stockFld.getText());
            // System.out.println(priceFld.getText());
            
            String name = nameFld.getText();
            int stock = Integer.parseInt(stockFld.getText());
            float price = Float.parseFloat(priceFld.getText());
            
            String desc = "";
            if (role == 3) {
                desc += "Staff";
            } else if (role == 4) {
                desc += "Manager";
            }
            desc += " [" + this.currUsername + "] added [" + name + "] to products";
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            String timestamp = df.format(new Date());
            
            this.sqlite.addProduct(name, stock, price);
            this.sqlite.addLogs("NOTICE", this.currUsername, desc, timestamp);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            JTextField nameFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 0) + "");
            JTextField stockFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 1) + "");
            JTextField priceFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 2) + "");
            
            String oldName = nameFld.getText();
            
            designer(nameFld, "PRODUCT NAME");
            designer(stockFld, "PRODUCT STOCK");
            designer(priceFld, "PRODUCT PRICE");
            
            Object[] message = {
                "Edit Product Details:", nameFld, stockFld, priceFld
            };

            int result = JOptionPane.showConfirmDialog(null, message, "EDIT PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
            
            if (result == JOptionPane.OK_OPTION) {
                // System.out.println(nameFld.getText());
                // System.out.println(stockFld.getText());
                // System.out.println(priceFld.getText());
                String newName = nameFld.getText();
                int newStock = Integer.parseInt(stockFld.getText());
                float newPrice = Float.parseFloat(priceFld.getText());
                
                String desc = "";
                if (role == 3) {
                    desc += "Staff";
                } else if (role == 4) {
                    desc += "Manager";
                }
                desc += " [" + this.currUsername + "] edited [" + oldName + "] from products";
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                String timestamp = df.format(new Date());
                
                this.sqlite.editProduct(oldName, newName, newStock, newPrice);
                this.sqlite.addLogs("NOTICE", this.currUsername, desc, timestamp);
            }
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", "DELETE PRODUCT", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                // System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                String name = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
                
                String desc = "";
                if (role == 3) {
                    desc += "Staff";
                } else if (role == 4) {
                    desc += "Manager";
                }
                desc += " [" + this.currUsername + "] deleted [" + name + "] from products";
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                String timestamp = df.format(new Date());
                
                this.sqlite.deleteProduct(name);
                this.sqlite.addLogs("NOTICE", this.currUsername, desc, timestamp);
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton purchaseBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
