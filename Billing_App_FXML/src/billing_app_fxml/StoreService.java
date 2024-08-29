/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package billing_app_fxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 *
 * @author panka
 */
public class StoreService {
    private static product pStore = null;
    
    static product getProduct(){
        return pStore;
    }
    
    static void setProduct(product store){
        pStore =store;
    }
    
    static void clearProduct(){
        pStore = null;
    }
    
    static public ObservableList<String> getAllMetalNames() {
        ObservableList<String> metalList = FXCollections.observableArrayList();
        
        String query = "SELECT metal FROM product";
        
        try (Connection connection = mysqlconnect.connectDb();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String metalName = resultSet.getString("metal");
                metalList.add(metalName);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception as needed
        }
        
        return metalList;
    }
    
    static public ObservableList<String> getAllProductsNames() {
        ObservableList<String> metalList = FXCollections.observableArrayList();
        
        String query = "SELECT prod_name FROM prod_list";
        
        try (Connection connection = mysqlconnect.connectDb();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String prodName = resultSet.getString("prod_name");
                metalList.add(prodName);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception as needed
        }
        
        return metalList;
    }
    
}
