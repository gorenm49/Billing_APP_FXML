/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author panka
 */
public class SellProduct {
     private SimpleIntegerProperty id;
    private StringProperty customerName;
    private StringProperty attributes; // JSON stored as a String

    // Default constructor
    public SellProduct() {
        this.id = new SimpleIntegerProperty();
        this.customerName = new SimpleStringProperty();
        this.attributes = new SimpleStringProperty();
    }

    // Parameterized constructor
    public SellProduct(int id, String customerName, String attributes) {
        this.id = new SimpleIntegerProperty(id);
        this.customerName = new SimpleStringProperty(customerName);
        this.attributes = new SimpleStringProperty(attributes);
    }

    // Getters and setters
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public StringProperty customerNameProperty() {
        return customerName;
    }

    public String getAttributes() {
        return attributes.get();
    }

    public void setAttributes(String attributes) {
        this.attributes.set(attributes);
    }

    public StringProperty attributesProperty() {
        return attributes;
    }

}
