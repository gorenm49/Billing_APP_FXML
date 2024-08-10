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
                // int getIdFromTable = product.getSelectionModel().getSelectedItem().getId();

                ps.setInt(1, Integer.parseInt(create_id.getText()));

                ps.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
                //  refreshTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }

        String sql = "insert into product(purity,unit,metal,note,rate,rate_gst)values(?,?,?,?,?,?)";
        // String query = "select * from product";
        //  PreparedStatement ps;

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

            // ps = conn.prepareStatement(query);
            // ResultSet rs = ps.executeQuery();
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

        // int getIdFromTable = product.getSelectionModel().getSelectedItem().getId();
        // create_id.setText(id.getCellData(idfromtable).toString());
        // String query = "select * from product where id = idfromtable";
        product.setOnMouseClicked(e -> {
            /*     conn = mysqlconnect.connectDb();
             String sql = "select * from product where id = ?";

        try {
            ps = conn.prepareStatement(sql);
            int getIdFromTable = product.getSelectionModel().getSelectedItem().getId();
            //System.out.print("iddd from "+getIdFromTable);
                    JOptionPane.showMessageDialog(null, "ddddddddd"+getIdFromTable);

        }catch(Exception ex){}*/

            //  product prod = product.getSelectionModel().getSelectedItem();
            // prod.id
            // System.out.print(prod.metal+"pppppppppp");
            if (index <= -1) {
                return;
            }

            //  create_metal.setText(prod.metal);
            /*      create_purity.setText(""+purityVal);
                create_rate.setText("" + rateVal);
                create_rate_gst.setText("" + rateGstVal);
                create_note.setText("" + noteVal);
                create_id.setText("" + idVal);
                create_unit.setText("" + unitVal); */
 /*  create_metal.setText(metal.getCellData(prod.metal).toString());
            create_purity.setText(purity.getCellData(index).toString());
            create_rate.setText(rate.getCellData(index).toString());
            create_rate_gst.setText(rate_gst.getCellData(index).toString());
            create_note.setText(note.getCellData(index).toString());
            create_id.setText(id.getCellData(index).toString());   
            create_unit.setText(unit.getCellData(index).toString());*/
 /*   String metalVal = product.getSelectionModel().getSelectedItem().getMetal();
                int purityVal = product.getSelectionModel().getSelectedItem().getPurity();
                Double rateVal = product.getSelectionModel().getSelectedItem().getRate();
                Double rateGstVal = product.getSelectionModel().getSelectedItem().getRate_gst();
                String noteVal = product.getSelectionModel().getSelectedItem().getNote();
                int unitVal = product.getSelectionModel().getSelectedItem().getUnit();
                int idVal = product.getSelectionModel().getSelectedItem().getId();

                create_metal.setText(metalVal);
                create_purity.setText(""+purityVal);
                create_rate.setText("" + rateVal);
                create_rate_gst.setText("" + rateGstVal);
                create_note.setText("" + noteVal);
                create_id.setText("" + idVal);
                create_unit.setText("" + unitVal);  */
        });

        /*  if (indx <= -1) {
            return;
        }
      //  create_metal.setText(metal.getCellData(indx).toString());
        create_purity.setText(purity.getCellData(indx).toString());
        create_rate.setText(rate.getCellData(indx).toString());
        create_rate_gst.setText(rate_gst.getCellData(indx).toString());
        create_note.setText(note.getCellData(indx).toString());
         create_id.setText(id.getCellData(indx).toString());
         */
        // this.prod = prod;
        //  create_metal.setText(prod.getMetal());
        // metal.setText(create_metal.getCellData(indx).toString());
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
