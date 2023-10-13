/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.phanquyen;

import com.mycompany.entities.NhanVien;
import com.mycompany.repository.NhanVienService;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hophu
 */
public class Admin_login extends javax.swing.JFrame {

    /**
     * Creates new form Admin_login
     */
    private NhanVienService nhanVienService;

    public Admin_login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordAdmin = new javax.swing.JPasswordField();
        btn_accept = new javax.swing.JButton();
        btn_refuser = new javax.swing.JButton();
        lb_title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_accept.setText("YES");
        btn_accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acceptActionPerformed(evt);
            }
        });

        btn_refuser.setText("NO");

        lb_title.setText("Nhập mặt khẩu để xác nhận");
        lb_title.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPasswordAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_accept)
                .addGap(12, 12, 12)
                .addComponent(btn_refuser)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_title)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_refuser)
                    .addComponent(btn_accept))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acceptActionPerformed
        // TODO add your handling code here:
        nhanVienService = new NhanVienService();
        List<NhanVien> listNV = nhanVienService.getAll();
        var user = listNV.stream()
                .filter(nhanVien -> nhanVien.getTENDANGNHAP().equals(this.getTitle()))
                .findFirst().orElse(null);
        if (user == null) {
            JOptionPane.showMessageDialog(this, "Password bạn vừa nhập không chính xác ", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        } else {
//            code thêm đoạn đổi mã nhan viên và addmin;
            JOptionPane.showMessageDialog(this, "Login Thành Công! ", "successful",
                    JOptionPane.INFORMATION_MESSAGE);
            PhanQuyenUser a = new PhanQuyenUser();
            this.setVisible(false);
            a.show();

        }
    }//GEN-LAST:event_btn_acceptActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_accept;
    private javax.swing.JButton btn_refuser;
    private javax.swing.JPasswordField jPasswordAdmin;
    private javax.swing.JLabel lb_title;
    // End of variables declaration//GEN-END:variables
}
