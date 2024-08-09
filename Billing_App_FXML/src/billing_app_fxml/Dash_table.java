/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package billing_app_fxml;

/**
 *
 * @author panka
 */
public class Dash_table {
    int purity, unit;
    String metal,note;
    double rate, rate_gst;

    public Dash_table(int purity, int unit, String metal, String note, double rate, double rate_gst) {
        this.purity = purity;
        this.unit = unit;
        this.metal = metal;
        this.note = note;
        this.rate = rate;
        this.rate_gst = rate_gst;
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

    public double getRate() {
        return rate;
    }

    public double getRate_gst() {
        return rate_gst;
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

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setRate_gst(double rate_gst) {
        this.rate_gst = rate_gst;
    }
    
    
}
