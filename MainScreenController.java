/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.*;
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
import javafx.scene.control.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 *
 * @author Vishnu
 */
public class MainScreenController  {
    
    @FXML private TableView<Part> tableView;
    @FXML private TableView<Product> tableView2;
    @FXML private TableColumn<Part, String> id;
    @FXML private TableColumn<Part, String> name;
    @FXML private TableColumn<Part, String> stock;
    @FXML private TableColumn<Part, String> price;
    @FXML private TableColumn<Part, String> id2;
    @FXML private TableColumn<Part, String> name2;
    @FXML private TableColumn<Part, String> stock2;
    @FXML private TableColumn<Part, String> price2;
    @FXML private javafx.scene.control.TextField searchParts;
    @FXML private javafx.scene.control.TextField searchProducts;
    @FXML private javafx.scene.control.Button cancelPart;
    @FXML private javafx.scene.control.ToggleButton delete2;
    @FXML private javafx.scene.control.RadioButton InHouse;
    @FXML private javafx.scene.control.TextField cName;
    @FXML private ObservableList <Part> selectedItems;
    @FXML private ObservableList <Product> selectedItems2;
    public MainScreenController(){}   
    
    
     public void initialize()
     { 
        TableViewSelectionModel <Part> selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        selectedItems = selectionModel.getSelectedItems();
       
        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        stock.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tableView.setItems(Inventory.getAllParts());
        FilteredList<Part> Searched = new FilteredList<>(Inventory.getAllParts(),p-> true);
        searchParts.textProperty().addListener((observable, oldValue, newValue) -> {
			Searched.setPredicate(Part -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Part.getName().toLowerCase().contains(lowerCaseFilter)) {
					return true; 
				} 
				return false; 
			});
		});
       SortedList<Part> sortedData = new SortedList<>(Searched);
       sortedData.comparatorProperty().bind(tableView.comparatorProperty());
       tableView.setItems(sortedData);
       ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       //Product Table////////////////////////////////////////////////////////////////////////////////////////////////////
       ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        TableViewSelectionModel <Product> selectionModel2 = tableView2.getSelectionModel();
        selectionModel2.setSelectionMode(SelectionMode.SINGLE);
        selectedItems2 = selectionModel2.getSelectedItems();
        id2.setCellValueFactory(new PropertyValueFactory<>("Id"));
        name2.setCellValueFactory(new PropertyValueFactory<>("Name"));
        stock2.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        price2.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tableView2.setItems(Inventory.getAllProducts());
        FilteredList<Product> SearchedProducts = new FilteredList<>(Inventory.getAllProducts(),p-> true);
        searchProducts.textProperty().addListener((observable, oldValue, newValue) -> {
			SearchedProducts.setPredicate(Product -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Product.getName().toLowerCase().contains(lowerCaseFilter)) {
					return true; 
				} 
				return false; 
			});
		});
       SortedList<Product> sortedData2 = new SortedList<>(SearchedProducts);
       sortedData2.comparatorProperty().bind(tableView2.comparatorProperty());
       tableView2.setItems(sortedData2);
       
 
     }
    
    public boolean search(int id)
    {
        for(Part parts: Inventory.getAllParts())
        {
            if(parts.getId()== id)
                return true;
        }
        return false;
    }
    
    public boolean update(int id, Part partsIn)
    {
        int index = -1;
        for(Part parts: Inventory.getAllParts())
        {
            index++;
            if(parts.getId()==id)
            {
                Inventory.getAllParts().set(index, partsIn);
                return true;
            }
        }
        return false;
    }
    
    public boolean delete(int id)
    {
        for(Part parts: Inventory.getAllParts())
        {
             if (parts.getId()== id )
                 return Inventory.getAllParts().remove(parts);
        }
      return false;
    }
    
    public boolean deleteP(int id)
    {
        for(Product products: Inventory.getAllProducts())
        {
             if (products.getId()== id )
                 return Inventory.getAllProducts().remove(products);
        }
      return false;
    }
    
    public void Exit(){System.exit(0);}
   
    public void addPart()throws Exception
    {
        Stage addStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        String fxmlsDocPath ="src\\Model\\AddPart.fxml";
        FileInputStream fxmlSstream = new FileInputStream(fxmlsDocPath);
        GridPane vbox = (GridPane) loader.load(fxmlSstream);         
        Scene scene = new Scene(vbox);
        addStage.setScene(scene);
        addStage.show();
    }
    
    public void ModifyPart()throws Exception
    {
        
        Stage addStages = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyPart.fxml"));
        ModifyPartController controller = new ModifyPartController(selectedItems);
        loader.setController(controller);
        GridPane vboxs = (GridPane) loader.load(); 
        Scene scenes = new Scene(vboxs);
        addStages.setScene(scenes);
        addStages.show();
    }    
    
    public void deletePart() throws Exception
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult()==ButtonType.YES)
        {delete(selectedItems.get(0).getId());}
        
    }
   
    public void addProduct()throws Exception
    {
        Stage addStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        String fxmlsDocPath ="src\\Model\\AddProduct.fxml";
        FileInputStream fxmlSstream = new FileInputStream(fxmlsDocPath);
        GridPane vbox = (GridPane) loader.load(fxmlSstream);         
        Scene scene = new Scene(vbox);
        addStage.setScene(scene);
        addStage.show();
    }
   
   public void ModifyProduct()throws Exception
    {
        
        Stage addStages = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyProduct.fxml"));
        ModifyProductController controller = new ModifyProductController (selectedItems2);
        loader.setController(controller);
        GridPane vboxs = (GridPane) loader.load(); 
        Scene scenes = new Scene(vboxs);
        addStages.setScene(scenes);
        addStages.show();
    }
    public void deleteProduct() throws Exception
    {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult()==ButtonType.YES){deleteP(selectedItems2.get(0).getId());}
        
    }
}
