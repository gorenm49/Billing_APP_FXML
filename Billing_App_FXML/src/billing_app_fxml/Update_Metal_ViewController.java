/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package billing_app_fxml;

import entity.Product;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author panka
 */
public class Update_Metal_ViewController implements Initializable {

    private product p;

    public Update_Metal_ViewController() {
        this.p = StoreService.getProduct();
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<product> product;

    @FXML
    private TableColumn<product, Integer> id;

    @FXML
    private TableColumn<product, String> metal;

    @FXML
    private TableColumn<product, String> note;

    @FXML
    private TableColumn<product, Integer> purity;

    @FXML
    private TableColumn<product, Double> rate;

    @FXML
    private TableColumn<product, Double> rate_gst;

    @FXML
    private TableColumn<product, Integer> unit;

    @FXML
    private ToggleButton create_clear;

    @FXML
    private TextField create_metal;

    @FXML
    private TextField create_note;

    @FXML
    private TextField create_purity;

    @FXML
    private TextField create_rate;

    @FXML
    private TextField create_rate_gst;

    @FXML
    private ToggleButton create_submit;

    @FXML
    private TextField create_unit;

    @FXML
    private TextField create_id;

    ObservableList<product> listP;

    private Product prod;

    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    @FXML
    void createProduct(ActionEvent event) {
        String deleteQuery = "delete from product where id = ?";
        conn = mysqlconnect.connectDb();
        if (create_id != null && !create_id.getText().equals("")) {
            try {

                ps = conn.prepareStatement(deleteQuery);

                ps.setInt(1, Integer.parseInt(create_id.getText()));

                ps.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
                //  refreshTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }

        String sql = "insert into product(purity,unit,metal,note,rate,rate_gst)values(?,?,?,?,?,?)";

        try {

            if (create_id.getText() != null && !create_id.getText().equals("")) {
                sql = "insert into product(id,purity,unit,metal,note,rate,rate_gst)values(?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, create_id.getText());
                ps.setString(2, create_purity.getText());
                ps.setString(3, create_unit.getText());
                ps.setString(4, create_metal.getText());
                ps.setString(5, create_note.getText());
                ps.setString(6, create_rate.getText());
                ps.setString(7, create_rate_gst.getText());
            } else {
                sql = "insert into product(purity,unit,metal,note,rate,rate_gst)values(?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, create_purity.getText());
                ps.setString(2, create_unit.getText());
                ps.setString(3, create_metal.getText());
                ps.setString(4, create_note.getText());
                ps.setString(5, create_rate.getText());
                ps.setString(6, create_rate_gst.getText());
            }

            ps.execute();

            JOptionPane.showMessageDialog(null, "Product added");

            // refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        //JOptionPane.showMessageDialog(null, "Clickeddd");
    }

    public void populateDataToView(product p) {
        create_metal.setText(p.metal);
        create_purity.setText("" + p.purity);
        create_rate.setText("" + p.rate);
        create_rate_gst.setText("" + p.rate_gst);
        create_note.setText("" + p.note);
        create_id.setText("" + p.id);
        create_unit.setText("" + p.unit);
    }

    public void sendDataToUpdateView(product prod) {
        product.setOnMouseClicked(e -> {
            if (index <= -1) {
                return;
            }
        });
    }

    public void refreshTable() {
        listP = mysqlconnect.getDataProducts();
        product.setItems(listP);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //sendDataToUpdateView();
        // refreshTable();
        if (this.p != null) {
            populateDataToView(p);
        }

    }

}
