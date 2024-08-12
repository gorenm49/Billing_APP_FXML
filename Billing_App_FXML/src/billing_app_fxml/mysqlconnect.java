/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package billing_app_fxml;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author panka
 */
public class mysqlconnect {

    Connection conn = null;

    public static Connection connectDb() {
        try {
           // Class.forName("com.mysql.jdbc.Driver");
             Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/producttest";
            Connection conn = DriverManager.getConnection(url, "root", "Nits@1006");
            JOptionPane.showMessageDialog(null, "Connected");
            return conn;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            return null;
        }
    }

    public static ObservableList<product> getDataProducts() {
        Connection conn = connectDb();

        if (conn == null) {
            return FXCollections.observableArrayList(); // Return empty list if connection is null
        }
        ObservableList<product> list = FXCollections.observableArrayList();
        try {
            String query = "select * from product";
            PreparedStatement ps;
            ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // list.add(new product(Integer.parseInt(rs.getString("id")), (Integer.parseInt(rs.getString("purity"))), (Integer.parseInt(rs.getString("unit"))), rs.getString("metal"), rs.getString("note"), (Double.parseDouble(rs.getString("rate"))), (Double.parseDouble(rs.getString("rate_gst")))));
                list.add(new product(
                        rs.getInt("id"),
                        rs.getInt("purity"),
                        rs.getInt("unit"),
                        rs.getString("metal"),
                        rs.getString("note"),
                        rs.getDouble("rate"),
                        rs.getDouble("rate_gst")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
