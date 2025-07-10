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
        int totalWidth = 50; // Total receipt width

        // Calculate maximum lengths for each column
        int maxItemLength = "ITEM".length();
        int maxPriceLength = "PRICE".length();
        int maxQtyLength = "QTY".length();
        int maxTotalLength = "TOTAL".length();

        int totalItems = 0;
        double subtotalValue = 0;

        // Scan table to determine maximum column widths
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String product = String.valueOf(tableModel.getValueAt(i, 1));
            String price = formatCurrency(String.valueOf(tableModel.getValueAt(i, 2)));
            String qty = String.valueOf(tableModel.getValueAt(i, 3));
            int total = (int) tableModel.getValueAt(i, 4);
            String totalStr = formatCurrency(String.valueOf(total));

            maxItemLength = Math.max(maxItemLength, product.length() > 20 ? 20 : product.length());
            maxPriceLength = Math.max(maxPriceLength, price.length());
            maxQtyLength = Math.max(maxQtyLength, qty.length());
            maxTotalLength = Math.max(maxTotalLength, totalStr.length());

            totalItems += Integer.parseInt(qty);
            subtotalValue += total;
        }

        // Ensure minimum widths for headers
        maxItemLength = Math.max(maxItemLength, "ITEM".length());
        maxPriceLength = Math.max(maxPriceLength, "PRICE".length());
        maxQtyLength = Math.max(maxQtyLength, "QTY".length());
        maxTotalLength = Math.max(maxTotalLength, "TOTAL".length());

        // Header section
        receipt.append("=".repeat(totalWidth)).append("\n");
        receipt.append(centerText("CMart Store", totalWidth)).append("\n");
        receipt.append(centerText("123 Main Street, City", totalWidth)).append("\n");
        receipt.append(centerText("Phone: (123) 456-7890", totalWidth)).append("\n\n");
        receipt.append(centerText(dateTime, totalWidth)).append("\n");
        receipt.append(String.format("%10s %s", "Transaction ID:", transactionId)).append("\n");
        receipt.append(String.format("%10s %s", "Cashier:", cashierName)).append("\n");
        receipt.append("-".repeat(totalWidth)).append("\n");

        // Column headers with dynamic spacing
        String headerFormat = "%-" + maxItemLength + "s %-" + maxPriceLength + "s %" + maxQtyLength + "s %" + maxTotalLength + "s";
        receipt.append(String.format(headerFormat, "ITEM", "PRICE", "QTY", "TOTAL")).append("\n");
        receipt.append("-".repeat(totalWidth)).append("\n");

        // Item rows
        String rowFormat = "%-" + maxItemLength + "s %-" + maxPriceLength + "s %" + maxQtyLength + "s %" + maxTotalLength + "s";
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String product = String.valueOf(tableModel.getValueAt(i, 1));
            if (product.length() > maxItemLength) {
                product = product.substring(0, maxItemLength - 3) + "...";
            }
            String price = formatCurrency(String.valueOf(tableModel.getValueAt(i, 2)));
            String qty = String.valueOf(tableModel.getValueAt(i, 3));
            int total = (int) tableModel.getValueAt(i, 4);
            String totalStr = formatCurrency(String.valueOf(total));

            receipt.append(String.format(rowFormat, product, price, qty, totalStr)).append("\n");
        }

        // Footer section
        receipt.append("-".repeat(totalWidth)).append("\n");
        receipt.append(String.format("%20s %10d", "TOTAL ITEMS:", totalItems)).append("\n");
        receipt.append(String.format("%20s %s", "SUBTOTAL:", formatCurrency(sub))).append("\n");
        receipt.append(String.format("%20s %s", "PAYMENT:", formatCurrency(pay))).append("\n");
        receipt.append(String.format("%20s %s", "BALANCE:", formatCurrency(bal))).append("\n");
        receipt.append("=".repeat(totalWidth)).append("\n");
        receipt.append(centerText("Thank you for shopping with us!", totalWidth)).append("\n");
        receipt.append(centerText("Returns accepted within 7 days with receipt", totalWidth)).append("\n");
        receipt.append(centerText("Visit us online: www.cmart.com", totalWidth)).append("\n");
        receipt.append("=".repeat(totalWidth)).append("\n");

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
