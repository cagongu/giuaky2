/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.phanquyen;

import com.mycompany.entities.NhanVien;
import com.mycompany.repository.NhanVienService;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hophu
 */
public class PhanQuyenUser extends javax.swing.JFrame {

    /**
     * Creates new form PhanQuyenUser
     */
    private NhanVienService nhanVienService;

    public PhanQuyenUser() {
        initComponents();
        renderViewAdmin();
        renderViewNv();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPane_admin = new javax.swing.JScrollPane();
        TABLE_ADMIN = new javax.swing.JTable();
        ScrollPane_nhanVien = new javax.swing.JScrollPane();
        TABLE_NHANVIEN = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ScrollPane_admin.setName("Nhân Viên Quản Lý"); // NOI18N

        TABLE_ADMIN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên Đăng Nhập", "Tên Nhân Viên", "Số Điện Thoại", "Giới Tính", "Ngày Sinh"
            }
        ));
        ScrollPane_admin.setViewportView(TABLE_ADMIN);
        if (TABLE_ADMIN.getColumnModel().getColumnCount() > 0) {
            TABLE_ADMIN.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        ScrollPane_nhanVien.setName("Nhân Viên Quản Lý"); // NOI18N

        TABLE_NHANVIEN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Thay Đổi", "Tên Đăng Nhập", "Tên Nhân Viên", "Số Điện Thoại", "Giới Tính", "Ngày Sinh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TABLE_NHANVIEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLE_NHANVIENMouseClicked(evt);
            }
        });
        ScrollPane_nhanVien.setViewportView(TABLE_NHANVIEN);
        if (TABLE_NHANVIEN.getColumnModel().getColumnCount() > 0) {
            TABLE_NHANVIEN.getColumnModel().getColumn(0).setMaxWidth(100);
            TABLE_NHANVIEN.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane_admin)
            .addComponent(ScrollPane_nhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ScrollPane_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ScrollPane_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TABLE_NHANVIENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLE_NHANVIENMouseClicked
        int row = TABLE_NHANVIEN.getSelectedRow();

        if (row > 0) {
            int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn tiếp tục?", "Xác nhận",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                // Thực hiện các hành động khi người dùng chọn Yes ở đây
                nhanVienService = new NhanVienService();
                List<NhanVien> listNV = nhanVienService.getAll();
                NhanVien nhanVien = new NhanVien();
                String id = "";

                for (var item : listNV) {
                    if (item.getTENDANGNHAP().equals(TABLE_NHANVIEN.getValueAt(row, 1))) {
                        id = item.getMANHANVIEN();
                        nhanVien.setMANHANVIEN(item.getMANHANVIEN());
                        nhanVien.setTENNHANVIEN(item.getTENNHANVIEN());
                        nhanVien.setDIACHI(item.getDIACHI());
                        nhanVien.setSDT(item.getSDT());
                        nhanVien.setGIOITINH(item.getGIOITINH());
                        nhanVien.setNGAYSINH(item.getNGAYSINH());
                        nhanVien.setCMND_CCCD(item.getCMND_CCCD());
                        nhanVien.setTENDANGNHAP(item.getTENDANGNHAP());
                        nhanVien.setMATKHAU(item.getMATKHAU());
                        nhanVien.setVOHIEUHOA(item.getVOHIEUHOA());
                        nhanVien.setLAQUANLY("true");
                    }
                }
                nhanVienService.updateNhanVien(nhanVien, id);
                Admin_login a = new Admin_login();
                a.setTitle(this.getTitle());
                a.show();
            } else {
                JOptionPane.showMessageDialog(null, "Bạn không có quyền admin?", "error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }    }//GEN-LAST:event_TABLE_NHANVIENMouseClicked

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
            java.util.logging.Logger.getLogger(PhanQuyenUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhanQuyenUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhanQuyenUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhanQuyenUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PhanQuyenUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane_admin;
    private javax.swing.JScrollPane ScrollPane_nhanVien;
    private javax.swing.JTable TABLE_ADMIN;
    private javax.swing.JTable TABLE_NHANVIEN;
    // End of variables declaration//GEN-END:variables

    private void renderViewNv() {
        nhanVienService = new NhanVienService();
        List<NhanVien> listNV = nhanVienService.getAll();
        DefaultTableModel model = (DefaultTableModel) TABLE_NHANVIEN.getModel();
        model.setRowCount(0);
        for (var nhanVien : listNV) {
            if (nhanVien.getLAQUANLY().contains("false")) {
                Object[] row = {false, nhanVien.getTENDANGNHAP(), nhanVien.getTENNHANVIEN(), nhanVien.getSDT(), nhanVien.getGIOITINH(), nhanVien.getNGAYSINH()};
                model.addRow(row);
            }
        }
    }

    private void renderViewAdmin() {
        nhanVienService = new NhanVienService();
        List<NhanVien> listNV = nhanVienService.getAll();
        DefaultTableModel model = (DefaultTableModel) TABLE_ADMIN.getModel();
        model.setRowCount(0);
        for (var nhanVien : listNV) {
            if (nhanVien.getLAQUANLY().contains("true")) {
                Object[] row = {nhanVien.getTENDANGNHAP(), nhanVien.getTENNHANVIEN(), nhanVien.getSDT(), nhanVien.getGIOITINH(), nhanVien.getNGAYSINH()};
                model.addRow(row);
            }
        }
    }

}
