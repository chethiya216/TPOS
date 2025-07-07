/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TPOS;

import java.awt.Font;
import java.awt.print.PrinterException;
import javax.swing.table.TableModel;

/**
 *
 * @author Chethiya
 */
public class Print extends javax.swing.JFrame {

    /**
     * Creates new form Print
     */
    public Print() {
        initComponents();
    }
    
    
    String lsub;
    String lpay;
    String lbal;
    String qty;
    
    public Print(String sub, String pay, String bal, TableModel tableModel, 
             String cashierName, String transactionId, String dateTime) throws PrinterException {
        initComponents();

        // Set monospaced font for proper alignment
        jTFPrint.setFont(new Font("Monospaced", Font.PLAIN, 12));

        StringBuilder receipt = new StringBuilder();
        int totalWidth = 60;
        // Header section
        
        receipt.append("=======================================================\n");
//        receipt.append(("                   CMart Store\n"));
        receipt.append(centerText("CMart Store", totalWidth)).append("\n");
//        receipt.append("              123 Main Street, City\n");
        receipt.append(centerText("123 Main Street, City", totalWidth)).append("\n");
//        receipt.append("               Phone: (+94) 779872446\n");
        receipt.append(centerText("Phone: (123) 456-7890", totalWidth)).append("\n\n");
//        receipt.append("\n");
//        receipt.append("                 ").append(dateTime).append("\n");
        receipt.append(centerText(dateTime, totalWidth)).append("\n");
//        receipt.append("            Transaction ID: ").append(transactionId).append("\n");
//        receipt.append("                    Cashier: ").append(cashierName).append("\n");
//        receipt.append("-------------------------------------------------------\n");
        receipt.append(String.format("%s%18s", "Transaction ID:", transactionId)).append("\n");
        receipt.append(String.format("%s%22s", "Cashier:", cashierName)).append("\n");
        receipt.append("-".repeat(totalWidth)).append("\n");

        // Column headers with proper spacing
        receipt.append(String.format("%5s %20s %8s %18s", "ITEM", "PRICE", "QTY", "TOTAL")).append("\n");
        receipt.append("-------------------------------------------------------\n");

        // Item rows and total items calculation
        int totalItems = 0;
        double subtotalValue = 0;

//        for(int i = 0; i < tableModel.getRowCount(); i++) {
//            String product = (String) tableModel.getValueAt(i, 1);
//            // Truncate long product names
//            if(product.length() > 20) {
//                product = product.substring(0, 17) + "...";
//            }
//
//            String price = (String) tableModel.getValueAt(i, 2);
//            String qty = (String) tableModel.getValueAt(i, 3);
//            int total = (int) tableModel.getValueAt(i, 4);
//
//            totalItems += Integer.parseInt(qty);
//            subtotalValue += total;
//
//            receipt.append(String.format("%5s %20s %8s %18s", 
//                product, 
//                formatCurrency(price), 
//                qty, 
//                formatCurrency(String.valueOf(total)))).append("\n");
//        }
         for(int i = 0; i < tableModel.getRowCount(); i++) {
            String product = (String) tableModel.getValueAt(i, 1);
            // Truncate long product names
            if(product.length() > 20) {
                product = product.substring(0, 17) + "...";
            }

            String price = (String) tableModel.getValueAt(i, 2);
            String qty = (String) tableModel.getValueAt(i, 3);
            int total = (int) tableModel.getValueAt(i, 4);

            totalItems += Integer.parseInt(qty);
            subtotalValue += total;

            // Format row with fixed spacing
            receipt.append(String.format("%5s %20s %8s %18s", 
                product, 
                formatCurrency(price), 
                qty, 
                formatCurrency(String.valueOf(total)))).append("\n");
        }

            // Footer section
        receipt.append("-------------------------------------------------------\n");
        receipt.append(String.format("%20s %10s", "TOTAL ITEMS:", totalItems)).append("\n");
        receipt.append(String.format("%20s %10s", "SUBTOTAL:", formatCurrency(sub))).append("\n");
        receipt.append(String.format("%20s %10s", "PAYMENT:", formatCurrency(pay))).append("\n");
        receipt.append(String.format("%20s %10s", "BALANCE:", formatCurrency(bal))).append("\n");
        receipt.append("=======================================================\n");
        receipt.append("          Thank you for shopping with us!\n");
        receipt.append("     Returns accepted within 7 days with receipt\n");
        receipt.append("           Visit us online: www.cmart.com\n");
        receipt.append("=======================================================\n");

        jTFPrint.setText(receipt.toString());
        jTFPrint.print();
    }
    
    private String formatCurrency(String amount) {
        try {
            double value = Double.parseDouble(amount);
            return String.format("Rs: %,.2f", value);
        } catch (NumberFormatException e) {
            return amount; // Return original if formatting fails
        }
    }
    
    private String centerText(String text, int width) {
        if (text.length() >= width) {
            return text.substring(0, width);
        }
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(width - text.length() - padding);
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
        jTFPrint = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTFPrint.setColumns(20);
        jTFPrint.setRows(5);
        jScrollPane1.setViewportView(jTFPrint);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Print().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTFPrint;
    // End of variables declaration//GEN-END:variables
}
