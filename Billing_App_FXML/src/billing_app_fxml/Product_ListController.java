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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author panka
 */
public class Product_ListController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<product> product;

    @FXML
    private TableView<prod_list> prod_list;

    @FXML
    private Button add_metal;

    @FXML
    private Button delete_metal;

    @FXML
    private TextField pl_txt_add_prod;

    @FXML
    private Button refresh_metal;

    @FXML
    private HBox sell_Button;

    @FXML
    private Button update_metal;

    @FXML
    private TableColumn<prod_list, Integer> id;

    @FXML
    private TableColumn<prod_list, String> prod_name;

    ObservableList<prod_list> listP;
    //ObservableList<product> ;

    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    @FXML
    void handleButtonAddProduct(ActionEvent event) {

        String add_prod_query = "INSERT INTO prod_list (prod_name) VALUES (?)";
        conn = mysqlconnect.connectDb();
        if (!pl_txt_add_prod.getText().equals("")) {
            try {
                ps = conn.prepareStatement(add_prod_query);
                ps.setString(1, pl_txt_add_prod.getText());

                ps.execute();
                refreshTable();
                JOptionPane.showMessageDialog(null, "Product Listed");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void getSelected(MouseEvent event) {
        index = prod_list.getSelectionModel().getSelectedIndex();

        if (index <= -1) {
            return;
        }

        pl_txt_add_prod.setText(prod_name.getCellData(index).toString());
    }

    @FXML
    void handleButtonUpdateProduct(ActionEvent event) {
        // conn = mysqlconnect.connectDb();
        //  String deleteQuery = "delete from product where id = ?";

        try {
            conn = mysqlconnect.connectDb();

            int getID = prod_list.getSelectionModel().getSelectedItem().getId();
            String getProdName = pl_txt_add_prod.getText();

            String updateQuery = "update prod_list set prod_name = '" + getProdName + "' where id = '" + getID + "'";

            ps = conn.prepareStatement(updateQuery);
            ps.execute();
            refreshTable();
            JOptionPane.showMessageDialog(null, "prod list updated");
        } catch (Exception e) {

        }

        /* if (id != null && !id.getText().equals("")) {
            try {

                ps = conn.prepareStatement(deleteQuery);

                ps.setInt(1, Integer.parseInt(id.getText()));

                ps.execute();
                JOptionPane.showMessageDialog(null, "prod Deleted from list");
                //  refreshTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }

        try {

            if (id != null && !id.getText().equals("")) {
                String add_prod_query = "INSERT INTO prod_list (prod_name) VALUES (?)";
                ps = conn.prepareStatement(add_prod_query);
                ps.setString(1, pl_txt_add_prod.getText());
            }

            ps.execute();

            JOptionPane.showMessageDialog(null, "Prod updated");
        } catch (Exception e) {
        }*/
    }

    public void handleButtonDeleteProduct() {
        conn = mysqlconnect.connectDb();

        String sql = "delete from prod_list where id = ?";

        try {
            ps = conn.prepareStatement(sql);
            int getIdFromTable = prod_list.getSelectionModel().getSelectedItem().getId();

            ps.setInt(1, getIdFromTable);
            ps.execute();
            refreshTable();
            JOptionPane.showMessageDialog(null, "prod Item Deleted");
            // refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @FXML
    void openSellModel(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SellModel.fxml"));
            //FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Sell window");
            stage.setScene(new Scene(root1));
            stage.show();
            /*  stage.setOnCloseRequest(e -> {

              //  StoreService.clearProduct();
                refreshTable();
            });*/

            //  refreshTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void refreshTable() {
        id.setCellValueFactory(new PropertyValueFactory<prod_list, Integer>("id"));
        prod_name.setCellValueFactory(new PropertyValueFactory<prod_list, String>("prod_name"));

        listP = mysqlconnect.getProductList();
        prod_list.setItems(listP);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        refreshTable();

    }

}
