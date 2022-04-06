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
public class Product {
    private ObservableList <Part> associatedParts = FXCollections.observableArrayList();;
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    public Product (int id2, String name2, double price2, int stock2, int min2, int max2)
    {
        id = id2;
        name = name2;
        price = price2;
        stock = stock2;
        min = min2;
        max = max2;
    }
    public void setid(int id3){id = id3;}
    public void setName(String name3){name = name3;}
    public void setPrice(double price3){price = price3;}
    public void setStock(int stock3){stock = stock3;}
    public void setMin(int min3){min = min3;}
    public void setMax(int max3){max = max3;}
    public int getId(){return id;}
    public String getName(){return name;}
    public double getPrice(){return price;}
    public int getStock(){return stock;}
    public int getMin(){return min;}
    public int getMax(){return max;}
    public void addAssociatedPart(Part part1){associatedParts.add(part1);}
    public boolean deleteAssociatedPart(Part SelectedAssociatedPart)
    {
     return associatedParts.remove(SelectedAssociatedPart);
    }
    
    public ObservableList<Part> getAllAssociatedParts(){return associatedParts;}
}
