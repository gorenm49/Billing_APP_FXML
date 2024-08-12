/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package billing_app_fxml;

/**
 *
 * @author panka
 */
public class StoreService {
    private static product pStore = null;
    
    static product getProduct(){
        return pStore;
    }
    
    static void setProduct(product store){
        pStore =store;
    }
    
    static void clearProduct(){
        pStore = null;
    }
    
}
