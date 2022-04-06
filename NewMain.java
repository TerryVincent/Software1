/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.URL;
import java.util.*;
/**
 *
 * @author Vishnu
 */
public class NewMain extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
     @Override
    public void start(Stage primaryStage) throws Exception {
        Inventory inv = new Inventory();
        inHouse a1 = new inHouse(1,"part a1",2.99,10,5,100,101);
        inHouse a2 = new inHouse(1,"part a2",2.99,10,5,100,101);
        addTestData(inv);
        inv.lookupPart(1);
        GridPane vbox = (GridPane) FXMLLoader.load(getClass().getResource("FXMLsss.fxml")); 
        Model.MainScreenController controller = new Model.MainScreenController();
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    
    }
    public static void addTestData(Inventory inv){
        OutSourced a1 = new OutSourced(1,"part a1",2.99,10,5,100,"Happy");
        inHouse a2 = new inHouse(2,"part a2",3.99,11,6,101,102);
        inHouse a3 = new inHouse(3,"part a3",4.99,12,7,102,103);
        inHouse a4 = new inHouse(4,"part a4",5.99,13,8,103,1014);   
        Product a5 = new Product(1,"a5",2.99,10,5,100);
        Product a6 = new Product(2,"a6",4.99,12,7,102);
        Product a7 = new Product(3,"a7",3.99,11,6,101);
        Product a8 = new Product(4,"a8",5.99,13,8,103); 
        inv.addPart(a1);
        inv.addPart(a2);
        inv.addPart(a3);
        inv.addPart(a4);
        inv.addProduct(a5);
        inv.addProduct(a6);
        inv.addProduct(a7);
        inv.addProduct(a8);
        
    }
}
