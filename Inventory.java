/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;
/**
 *
 * @author Vishnu
 */
public class Inventory {
    private static ObservableList <Part> allParts = FXCollections.observableArrayList();
    private static ObservableList <Product> allProducts= FXCollections.observableArrayList();   
    
    public static void addPart(Part newPart){allParts.add(newPart);}
    
    public static void addProduct(Product newProduct){allProducts.add(newProduct);}
    
    public static Part lookupPart(int partId)
    {
        int found = -1;
        for (int i = 0 ; i < allParts.size();i++){
            if( allParts.get(i).getId()== partId ) found = i ;
        }
        return allParts.get(found);
    }
    
    public static Product lookupProduct(Product ProductId)
    {
        int found = -1;
        for (int i = 0 ; i < allProducts.size();i++){
            if( allProducts.get(i)== ProductId ) found = i ;
        }
        return allProducts.get(found);
    }
    
    public static Part lookupPart(String Name)
    {
        int found = -1;
        for (int i = 0 ; i < allParts.size();i++){
            if( allParts.get(i).getName().equals(Name)) found = i ;
        }
        return allParts.get(found);
    }    
    
    public static Product lookupProduct(String ProductName)
    {
        int found = -1;
        for (int i = 0 ; i < allProducts.size();i++){
            if( allProducts.get(i).getName().equals(ProductName)) found = i ;
        }
        return allProducts.get(found);
    }
    
    public static void updatePart(int index, Part selectedPart)
    {
        //allParts.remove(index);
        Inventory.deletePart(allParts.get(index));
        allParts.add(index,selectedPart);
        
    }
    
    public static void updateProduct(int index, Product selectedProduct)
    {
        System.out.println("index "+index);
        Inventory.deleteProduct(allProducts.get(index));
        allProducts.add(index, selectedProduct);   
    }
    
    public static boolean deletePart(Part selectedPart){return allParts.remove(selectedPart);}
    
    public static boolean deleteProduct(Product selectedProduct){ return allProducts.remove(selectedProduct);}
    
    public static ObservableList<Part> getAllParts(){return allParts;}
    
    public static ObservableList<Product> getAllProducts(){return allProducts;}
}
