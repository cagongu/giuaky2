/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.entities.MatHang;
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
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<MatHang> getAll() {
        try {
            List<MatHang> products = new ArrayList<>();
            Connection conn = JBDCConnection.getConnection();
            Statement stmt = conn.createStatement();
            String SQL = "Select * from MATHANG";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                MatHang a = new MatHang(rs.getString("MAMH"), rs.getNString("TENMH"), Float.parseFloat(rs.getString("GIABAN")), rs.getNString("DVT"), rs.getString("MALOAI"), rs.getNString("MOTA"), rs.getString("VOHIEUHOA"));
                products.add(a);
            }
//            for (MatHang a : products) {
//                System.out.println(a.getMAMH() + " " + a.getTENMH() + " " + a.getGIABAN() + " " + a.getDVT() + " " + a.getMALOAI() + " " + a.getMOTA() + " " + a.getVOHIEUHOA());
//            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
//        return productRepository.findAll();
    }

    public MatHang getProductById(String id) {
        try {
            List<MatHang> products = new ArrayList<>();
            Connection conn = JBDCConnection.getConnection();
            Statement stmt = conn.createStatement();
            String SQL = "Select * from MATHANG";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                MatHang a = new MatHang(rs.getString("MAMH"), rs.getNString("TENMH"), Float.parseFloat(rs.getString("GIABAN")), rs.getNString("DVT"), rs.getString("MALOAI"), rs.getNString("MOTA"), rs.getString("VOHIEUHOA"));
                products.add(a);
            }

            MatHang item = products.stream()
                    .filter(product -> product.getMAMH().equals(id))
                    .findFirst()
                    .orElse(null);
            return item;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addProduct(MatHang mathang) {
        try (Connection conn = JBDCConnection.getConnection()) {
            List<MatHang> products = new ArrayList<>();
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM MATHANG";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                MatHang a = new MatHang(rs.getString("MAMH"), rs.getNString("TENMH"), Float.parseFloat(rs.getString("GIABAN")), rs.getNString("DVT"), rs.getString("MALOAI"), rs.getNString("MOTA"), rs.getString("VOHIEUHOA"));
                products.add(a);
            }

            try {
                if (getProductById(mathang.getMAMH()) == null) {
                    products.add(mathang);
                    String queryAdd = "INSERT INTO MATHANG (MAMH, TENMH, GIABAN, DVT, MALOAI, MOTA, VOHIEUHOA) VALUES (?, ?, ?, ?, ?, ?, ?)";

                    try (PreparedStatement preparedStatement = conn.prepareStatement(queryAdd)) {
                        preparedStatement.setString(1, mathang.getMAMH());
                        preparedStatement.setString(2, mathang.getTENMH());
                        preparedStatement.setFloat(3, mathang.getGIABAN());
                        preparedStatement.setString(4, mathang.getDVT());
                        preparedStatement.setString(5, mathang.getMALOAI());
                        preparedStatement.setString(6, mathang.getMOTA());
                        preparedStatement.setString(7, mathang.getVOHIEUHOA());
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

    public void updateProduct(MatHang mathang, String id) {
        try (Connection conn = JBDCConnection.getConnection()) {
            try {
                String query = "UPDATE MATHANG SET MAMH=?, TENMH=?, GIABAN=?, DVT=?, MALOAI=?, MOTA=?, VOHIEUHOA=? WHERE MAMH=?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                    preparedStatement.setString(1, mathang.getMAMH());
                    preparedStatement.setNString(2, mathang.getTENMH());
                    preparedStatement.setFloat(3, mathang.getGIABAN());
                    preparedStatement.setNString(4, mathang.getDVT());
                    preparedStatement.setString(5, mathang.getMALOAI());
                    preparedStatement.setNString(6, mathang.getMOTA());
                    preparedStatement.setString(7, mathang.getVOHIEUHOA());
                    preparedStatement.setString(8, id);
                    preparedStatement.executeUpdate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Update thất bại: " + e.getMessage(), "failed",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Update thất bại: " + e.getMessage(), "failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối: " + e.getMessage(), "failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteProduct(String Id) {
        try (Connection conn = JBDCConnection.getConnection()) {
            String query = "DELETE FROM MATHANG WHERE MAMH = ?";
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
