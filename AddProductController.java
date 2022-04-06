/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vishnu
 */
public class AddProductController implements Initializable {
    @FXML private TableView<Part> tableView;
    @FXML private TableView<Part> tableView2;
    @FXML private TextField min;
    @FXML private TextField max;
    @FXML private TextField price;
    @FXML private TextField inventory;
    @FXML private TextField name;
    @FXML private TableColumn<Part, String> name2;
    @FXML private TableColumn<Part, String> stock2;
    @FXML private TableColumn<Part, String> price2;
    @FXML private TableColumn<Part, String> id2;
    @FXML private TableColumn<Part, String> name3;
    @FXML private TableColumn<Part, String> stock3;
    @FXML private TableColumn<Part, String> price3;
    @FXML private TableColumn<Part, String> id3;
    @FXML private Product add;
    @FXML private Button save;
    @FXML private Button cancelPart;
        
   // public AddProductController(ObservableList <Product> transfer2)
   // {
   //     transfer = transfer2;
   // }
    
    @FXML
    public void saveProduct()
    {
       try
       {
           int id = Inventory.getAllProducts().size()+1;
            double price2 = Double.parseDouble(price.getText());
            int min2 = Integer.parseInt(min.getText());
            int max2 = Integer.parseInt(max.getText());
            int inventory2 = Integer.parseInt(inventory.getText());
            String name2 = name.getText();
            Inventory.addProduct(new Product(id,name2,price2,inventory2,min2,max2));
            for(int i = 0;i <add.getAllAssociatedParts().size();i++ )
            {
               Inventory.getAllProducts().get(id-1).addAssociatedPart(add.getAllAssociatedParts().get(i));
             }
            add.getAllAssociatedParts().clear();
            Stage stage = (Stage) save.getScene().getWindow();
            stage.close(); }catch(NullPointerException e){System.out.println("You must add a product");}
    }
    
    @FXML
    public void addProduct()
    {
        TableView.TableViewSelectionModel <Part> selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        ObservableList <Part> selectedItems = selectionModel.getSelectedItems();
        ObservableList <Product> transfer = Inventory.getAllProducts();
        if(transfer.size()!=0) add = transfer.get(transfer.size()-1); 
        add.addAssociatedPart(selectedItems.get(0));
        id3.setCellValueFactory(new PropertyValueFactory<>("Id"));
        name3.setCellValueFactory(new PropertyValueFactory<>("Name"));
        stock3.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        price3.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tableView2.setItems(Inventory.getAllProducts().get(add.getId()-1).getAllAssociatedParts());
        
    }
     @FXML
    public void handleCancelPart() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Cancel?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult()==ButtonType.YES)
        {
            Stage stage = (Stage) cancelPart.getScene().getWindow();
            stage.close();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id2.setCellValueFactory(new PropertyValueFactory<>("Id"));
        name2.setCellValueFactory(new PropertyValueFactory<>("Name"));
        stock2.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        price2.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tableView.setItems(Inventory.getAllParts());
       
    }    
    
}
