/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package billing_app_fxml;

/**
 *
 * @author panka
 */
public class product {
    int id, purity, unit;
    String metal,note;
    Double rate, rate_gst;

    public product(int id, int purity, int unit, String metal, String note, Double rate, Double rate_gst) {
        this.id = id;
        this.purity = purity;
        this.unit = unit;
        this.metal = metal;
        this.note = note;
        this.rate = rate;
        this.rate_gst = rate_gst;
    }

    public int getId() {
        return id;
    }

    public int getPurity() {
        return purity;
    }

    public int getUnit() {
        return unit;
    }

    public String getMetal() {
        return metal;
    }

    public String getNote() {
        return note;
    }

    public Double getRate() {
        return rate;
    }

    public Double getRate_gst() {
        return rate_gst;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPurity(int purity) {
        this.purity = purity;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setRate_gst(Double rate_gst) {
        this.rate_gst = rate_gst;
    }
    
    
    
}
