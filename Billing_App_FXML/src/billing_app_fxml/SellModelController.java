/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package billing_app_fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.swing.Icon;

/**
 * FXML Controller class
 *
 * @author panka
 */
public class SellModelController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private int viewCount = 0;

    @FXML
    private ComboBox<String> combo_select_metal;

    @FXML
    private Button refresh_metal;

    @FXML
    private Button sell_model_add_row;

    @FXML
    private Button sell_model_delete_row;

    @FXML
    private HBox sell_Button;

    @FXML
    private BorderPane anchorPane_for_add_details;

    @FXML
    private VBox vbox_container;

    /*   ObservableList<String> metalOption = FXCollections.observableArrayList(
            "Gold",
            "Silver",
            "platinum"
    );

    ObservableList<String> ProductOption = FXCollections.observableArrayList(
            "Finger Ring",
            "neck-lace",
            "Ear-Ring"
    );
    
     */
    @FXML
    void addNewsellProductPanel(ActionEvent event) {

        try {

            //  AnchorPane sell_view = FXMLLoader.load(getClass().getResource("Adding_Sell_item.fxml"));
            //  anchorPane_for_add_details.setCenter(sell_view);
            //anchorPane_for_add_details.setBottom(sell_view);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Adding_Sell_item.fxml"));
            Parent view = loader.load();

            vbox_container.getChildren().add(view);
            viewCount++;

            System.out.println("Loaded view count: " + viewCount);

        } catch (Exception e) {

        }

    }
    
    
    @FXML
    void deletePreviousSellProductPanel(ActionEvent event) {
        if (!vbox_container.getChildren().isEmpty()) {
            // Remove the last added view
            vbox_container.getChildren().remove(vbox_container.getChildren().size() - 1);

            // Optionally, update the count
            viewCount--;
            System.out.println("Loaded view count: " + viewCount);
        } else {
            System.out.println("No views to delete.");
        }
    }

    /* @FXML
    void chooseMetalfromCombobox() {
        combo_select_metal.setItems(metalOption);
    }

    @FXML
    void chooseProductfromCombobox() {
        combo_select_product.setItems(ProductOption);
    }

     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // chooseMetalfromCombobox();
        // chooseProductfromCombobox();
    }

}
