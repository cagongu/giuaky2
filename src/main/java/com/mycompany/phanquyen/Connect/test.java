/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanquyen.Connect;

/**
 *
 * @author hophu
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

    public static void main(String[] args) throws SQLException {
        try (Connection conn = JBDCConnection.getConnection(); Statement stmt = conn.createStatement()) {
//              Duyệt qua chương trình
//            String SQL = "SELECT TOP 10 * FROM products";
//            ResultSet rs = stmt.executeQuery(SQL);
//            while (rs.next()) {
//                System.out.println(rs.getString("productID") + " " + rs.getString("productName") + " " + rs.getString("price"));
//            }
//            String SQL ="CREATE TABLE employees (id INTEGER PRIMARY KEY, first_name CHAR(50),last_name CHAR(75))" ;
//            stmt.execute(SQL);
//            System.out.println("Employees table created");
//            String query1 = "ALTER TABLE employees ADD address NVARCHAR(100)";
//            stmt.execute(query1);
//            String query2 = "ALTER TABLE employees DROP COLUMN LAST_NAME";
//            stmt.execute(query2);
//            System.out.println("Address column added to the table & LAST_NAME column removed from the table");
//            stmt.execute("insert into employees (id, FIRST_NAME, LAST_NAME, address) values (1, 'Ho', 'Phuc Thai', 'Gia lai'), (2, 'Ho', 'Phuc Thien', 'Gia lai'); ");
//            ResultSet rs = stmt.executeQuery("SELECT TOP 3 * FROM employees");
//            while (rs.next()){
//                System.out.println(rs.getString("id") + " " + rs.getString("FIRST_NAME") + " " + rs.getString("LAST_NAME") + " " + rs.getString("address"));
//            }
//            String query3 = "DROP TABLE employess";
//            stmt.execute(query3);
//            System.out.println("Employess table removed");
            String SQL = "SELECT TOP 3 * FROM customers";
            ResultSet rs = stmt.executeQuery(SQL);
            while ((rs.next())) {
                System.out.println(rs.getString("ID") + " " + rs.getString("name") + " " + rs.getString("address") + " " + rs.getString("productID"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
