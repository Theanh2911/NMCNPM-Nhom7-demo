/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.PhatThuong;

import view.TamTruTamVang.*;
import controller.PhatThuong.PhatThuongController;
import javax.swing.JPanel;

/**
 *
 * @author apple
 */
public class PhatThuongJFrame extends javax.swing.JFrame {

    /**
     * Creates new form TamVangTamTruJFrame
     */
    public PhatThuongJFrame(JPanel root) {

        initComponents();
        PhatThuongController controller = new PhatThuongController(btnThongKePhatThuongHocTap, btnThongKePhatThuongLe);
        controller.setEvent(root);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnThongKePhatThuongHocTap = new javax.swing.JButton();
        btnThongKePhatThuongLe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(167, 199, 231));

        jPanel2.setBackground(new java.awt.Color(167, 199, 231));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lựa chọn thống kê", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 20), new java.awt.Color(59, 61, 161))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lựa chọn thống kê mong muốn");

        btnThongKePhatThuongHocTap.setBackground(new java.awt.Color(130, 180, 203));
        btnThongKePhatThuongHocTap.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        btnThongKePhatThuongHocTap.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKePhatThuongHocTap.setText("Thống kê phát thưởng học tập");
        btnThongKePhatThuongHocTap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKePhatThuongHocTapActionPerformed(evt);
            }
        });

        btnThongKePhatThuongLe.setBackground(new java.awt.Color(130, 180, 203));
        btnThongKePhatThuongLe.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        btnThongKePhatThuongLe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKePhatThuongLe.setText("Thống kê phát thưởng lễ");
        btnThongKePhatThuongLe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKePhatThuongLeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKePhatThuongLe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKePhatThuongHocTap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(283, 283, 283))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThongKePhatThuongHocTap)
                .addGap(13, 13, 13)
                .addComponent(btnThongKePhatThuongLe)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKePhatThuongLeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKePhatThuongLeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKePhatThuongLeActionPerformed

    private void btnThongKePhatThuongHocTapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKePhatThuongHocTapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKePhatThuongHocTapActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThongKePhatThuongHocTap;
    private javax.swing.JButton btnThongKePhatThuongLe;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
