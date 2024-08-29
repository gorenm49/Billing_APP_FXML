/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author panka
 */
public class Prod_List {
    int id;
    String prod_name;

    public Prod_List(int id, String prod_name) {
        this.id = id;
        this.prod_name = prod_name;
    }

    public int getId() {
        return id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

   
    
    
}
