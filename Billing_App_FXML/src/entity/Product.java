/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author panka
 */


public class Product {
    int id, purity, unit;
    String metal,note;
    Double rate, rate_gst;

    public Product(int id, int purity, int unit, String metal, String note, Double rate, Double rate_gst) {
        this.id = id;
        this.purity = purity;
        this.unit = unit;
        this.metal = metal;
        this.note = note;
        this.rate = rate;
        this.rate_gst = rate_gst;
    }

    private int getId() {
        return id;
    }

    private int getPurity() {
        return purity;
    }

    private int getUnit() {
        return unit;
    }

    public String getMetal() {
        return metal;
    }

    private String getNote() {
        return note;
    }

    private Double getRate() {
        return rate;
    }

    private Double getRate_gst() {
        return rate_gst;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setPurity(int purity) {
        this.purity = purity;
    }

    private void setUnit(int unit) {
        this.unit = unit;
    }

    private void setMetal(String metal) {
        this.metal = metal;
    }

    private void setNote(String note) {
        this.note = note;
    }

    private void setRate(Double rate) {
        this.rate = rate;
    }

    private void setRate_gst(Double rate_gst) {
        this.rate_gst = rate_gst;
    }
    
    
    
}
