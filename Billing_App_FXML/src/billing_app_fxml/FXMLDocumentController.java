/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package billing_app_fxml;

//import com.sun.jdi.connect.spi.Connection;
import entity.Product;
import javafx.scene.input.MouseEvent;
import java.sql.Connection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
//import static org.apache.logging.log4j.FormatterLoggerManualExample.logger;

/**
 *
 * @author panka
 */
public class FXMLDocumentController implements Initializable {

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
    private Button add_metal;

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

    @FXML
    private HBox sell_Button;

    // private Product prod;
    

    @FXML
    void handleButtonAction(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Update_Metal_View.fxml"));
            
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Update window");
            stage.setScene(new Scene(root1));
            stage.setOnCloseRequest(e -> {

                StoreService.clearProduct();
                refreshTable();
            });
            stage.show();
            //  refreshTable();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ObservableList<product> listP;
    //ObservableList<product> ;

    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    Update_Metal_ViewController uView = new Update_Metal_ViewController();

    @FXML
    void pickupData(MouseEvent event) {
        product getIdFromTable = product.getSelectionModel().getSelectedItem();
        StoreService.setProduct(getIdFromTable);
       // JOptionPane.showMessageDialog(null, getIdFromTable.metal);
    }

    public void deleteFromPTable() {
        conn = mysqlconnect.connectDb();

        String sql = "delete from product where id = ?";

        try {
            ps = conn.prepareStatement(sql);
            int getIdFromTable = product.getSelectionModel().getSelectedItem().getId();

            ps.setInt(1, getIdFromTable);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
            refreshTable();
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
        id.setCellValueFactory(new PropertyValueFactory<product, Integer>("id"));
        purity.setCellValueFactory(new PropertyValueFactory<product, Integer>("purity"));
        unit.setCellValueFactory(new PropertyValueFactory<product, Integer>("unit"));
        metal.setCellValueFactory(new PropertyValueFactory<product, String>("metal"));
        note.setCellValueFactory(new PropertyValueFactory<product, String>("note"));
        rate.setCellValueFactory(new PropertyValueFactory<product, Double>("rate"));
        rate_gst.setCellValueFactory(new PropertyValueFactory<product, Double>("rate_gst"));

        listP = mysqlconnect.getDataProducts();
        product.setItems(listP);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        refreshTable();
    }

}
