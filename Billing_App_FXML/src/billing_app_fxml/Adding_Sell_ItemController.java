/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package billing_app_fxml;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author panka
 */
public class Adding_Sell_ItemController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private product p;

    public Adding_Sell_ItemController() {
        this.p = StoreService.getProduct();
    }

    @FXML
    private ComboBox<String> combo_select_metal;

    @FXML
    private ComboBox<String> combo_select_product;

    @FXML
    private Button sell_btn_save;

    @FXML
    private TextField sell_txt_Unit;

    @FXML
    private TextField sell_txt_charges;

    /* ObservableList<String> metalOption = FXCollections.observableArrayList(
            "Gold",
            "Silver",
            "platinum"
    );

     */
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    @FXML
    void adding_Sell_Poduct(ActionEvent event) {
        conn = mysqlconnect.connectDb();

        // String attributes = "{\"metal\": \"Alice\", \"age\": 30}";
        //  String attributes = "{\"metal\": \"combo_select_metal.getValue()\", \"product\": \"metal Ring\", \"unit\": \"45\", \"charges\": \"35\"}";
//        String addingProductQuery = "insert into sellproducts (customerName, attributes) values (?, '{metal: ?, product: ?,unit: ?,charges: ?}')";
        String getMetal = combo_select_metal.getValue();
        String getProduct = combo_select_product.getValue();
        String getUnit = sell_txt_Unit.getText();
        String getCharges = sell_txt_charges.getText();

        String attributes = String.format("{\"metal\": \"%s\", \"product\": \"%s\", \"unit\": \"%s\", \"charges\": \"%s\"}", getMetal, getProduct, getUnit, getCharges);
        String addingProductQuery = "insert into sellproducts (customerName, attributes) values (?, ?)";

        try {

            if (combo_select_metal.getValue() != null && combo_select_product.getValue() != null && !sell_txt_Unit.getText().equals("") && !sell_txt_charges.getText().equals("")) {
                ps = conn.prepareStatement(addingProductQuery);

                ps.setString(1, "Umesh");
                ps.setString(2, attributes);

                /*    ps.setString(2, combo_select_metal.getValue());
                ps.setString(3, combo_select_metal.getValue());
                ps.setString(4, sell_txt_Unit.getText());
                ps.setString(5, sell_txt_charges.getText());
                 */
                ps.execute();

                JOptionPane.showMessageDialog(null, "Product added" + sell_txt_Unit.getText());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    ObservableList<String> ProductOption = FXCollections.observableArrayList(
            "Finger Ring",
            "neck-lace",
            "Ear-Ring"
    );

    ObservableList<String> MetalNameList = StoreService.getAllMetalNames();
    ListView<String> listView = new ListView<>(MetalNameList);
    
    ObservableList<String> productNameList = StoreService.getAllProductsNames();
    ListView<String> productlistView = new ListView<>(productNameList);

    @FXML
    void chooseMetalfromCombobox() {
        combo_select_metal.setItems(MetalNameList);
    }

    @FXML
    void chooseProductfromCombobox() {
        combo_select_product.setItems(productNameList);
    }

    @FXML
    void ClearAllFromSellPane(ActionEvent event) {
        combo_select_metal.setValue(null);
        combo_select_product.setValue(null);
        sell_txt_Unit.clear();
        sell_txt_charges.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        chooseMetalfromCombobox();
        chooseProductfromCombobox();
    }

}
