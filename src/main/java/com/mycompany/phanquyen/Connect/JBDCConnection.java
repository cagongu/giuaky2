/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanquyen.Connect;

/**
 *
 * @author hophu
 */
import java.sql.*;

public class JBDCConnection {

    public static Connection getConnection() {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=123;databaseName=quanly_phanquyen;encrypt=false";
        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            return conn;
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection conn) {
        try {
            if (conn != null) {
                // Thực hiện các thao tác in thông tin về kết nối ở đây
                System.out.println("Database name: " + conn.getMetaData().getDatabaseProductName());
            } else {
                System.out.println("Connection is null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
