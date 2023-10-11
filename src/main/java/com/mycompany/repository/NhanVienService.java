/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.entities.NhanVien;
import com.mycompany.phanquyen.Connect.JBDCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hophu
 */
@Service
@RequiredArgsConstructor
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAll() {
        try {
            List<NhanVien> listNV = new ArrayList<>();
            Connection conn = JBDCConnection.getConnection();
            Statement stmt = conn.createStatement();
            String SQL = "Select * from NHANVIEN";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                NhanVien a = new NhanVien(rs.getString("MANHANVIEN"), rs.getNString("TENNHANVIEN"), rs.getNString("DIACHI"), rs.getString("SDT"), rs.getNString("GIOITINH"), rs.getString("NGAYSINH"), rs.getString("CMND_CCCD"), rs.getString("TENDANGNHAP"), rs.getString("MATKHAU"), rs.getString("VOHIEUHOA"), rs.getString("LAQUANLY"));
                listNV.add(a);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public NhanVien getNhanVienById(String id) {
        try {
            List<NhanVien> listNV = new ArrayList<>();
            Connection conn = JBDCConnection.getConnection();
            Statement stmt = conn.createStatement();
            String SQL = "Select * from NHANVIEN";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                NhanVien a = new NhanVien(rs.getString("MANHANVIEN"), rs.getNString("TENNHANVIEN"), rs.getNString("DIACHI"), rs.getString("SDT"), rs.getNString("GIOITINH"), rs.getString("NGAYSINH"), rs.getString("CMND_CCCD"), rs.getString("TENDANGNHAP"), rs.getString("MATKHAU"), rs.getString("VOHIEUHOA"), rs.getString("LAQUANLY"));
                listNV.add(a);
            }

            NhanVien item = listNV.stream()
                    .filter(nhanVien -> nhanVien.getMANHANVIEN().equals(id))
                    .findFirst()
                    .orElse(null);
            return item;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addNhanVien(NhanVien nhanVien) {
        try (Connection conn = JBDCConnection.getConnection()) {
            List<NhanVien> listNV = new ArrayList<>();
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM MATHANG";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                NhanVien a = new NhanVien(rs.getString("MANHANVIEN"), rs.getNString("TENNHANVIEN"), rs.getNString("DIACHI"), rs.getString("SDT"), rs.getNString("GIOITINH"), rs.getString("NGAYSINH"), rs.getString("CMND_CCCD"), rs.getString("TENDANGNHAP"), rs.getString("MATKHAU"), rs.getString("VOHIEUHOA"), rs.getString("LAQUANLY"));
                listNV.add(a);
            }

            try {
                if (getNhanVienById(nhanVien.getMANHANVIEN()) == null) {
                    listNV.add(nhanVien);
                    String queryAdd = "INSERT INTO MATHANG (MANHANVIEN, TENNHANVIEN, DIACHI, SDT, GIOITINH, NGAYSINH, CMND_CCCD, TENDANGNHAP, MATKHAU, VOHIEUHOA, LAQUANLY) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    try (PreparedStatement preparedStatement = conn.prepareStatement(queryAdd)) {
                        preparedStatement.setString(1, nhanVien.getMANHANVIEN());
                        preparedStatement.setString(2, nhanVien.getTENNHANVIEN());
                        preparedStatement.setString(3, nhanVien.getDIACHI());
                        preparedStatement.setString(4, nhanVien.getSDT());
                        preparedStatement.setString(5, nhanVien.getGIOITINH());
                        preparedStatement.setString(6, nhanVien.getNGAYSINH());
                        preparedStatement.setString(7, nhanVien.getCMND_CCCD());
                        preparedStatement.setString(8, nhanVien.getTENDANGNHAP());
                        preparedStatement.setString(9, nhanVien.getMATKHAU());
                        preparedStatement.setString(10, nhanVien.getVOHIEUHOA());
                        preparedStatement.setString(11, nhanVien.getLAQUANLY());

                        preparedStatement.executeUpdate();
                        System.out.println("Dữ liệu đã được chèn thành công.");
                    }
                    JOptionPane.showMessageDialog(null, "Thêm thành công! ", "successfull",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại!!! ", "failed",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Thêm thất bại: " + e.getMessage(), "failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateNhanVien(NhanVien nhanVien) {
        String id = nhanVien.getMANHANVIEN();
        deleteNhanVien(id);
        addNhanVien(nhanVien);
    }

    public void deleteNhanVien(String Id) {
        try (Connection conn = JBDCConnection.getConnection()) {
            String query = "DELETE FROM NHANVIEN WHERE MANHANVIEN = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                // Thiết lập giá trị cho tham số trong câu lệnh SQL (điều kiện xóa)
                preparedStatement.setString(1, Id);
                // Thực hiện câu lệnh SQL
                int rowsAffected = preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Xóa thất bại: " + e.getMessage(), "failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
