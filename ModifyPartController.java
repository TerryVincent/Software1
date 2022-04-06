/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.event.ActionEvent;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
/**
 *
 * @author Vishnu
 */
public class ModifyPartController {
    @FXML private TextField vName;
    @FXML private TextField ID;
    @FXML private TextField Min;
    @FXML private TextField Max;
    @FXML private TextField Name;
    @FXML private TextField Inv;
    @FXML private TextField Price;  
    @FXML private RadioButton InHouse;
    @FXML private Button cancelPart;
    @FXML private ToggleGroup group1;
    @FXML private RadioButton outSourced;
    @FXML private Label Vtext;
    @FXML private Button save;
    @FXML private ObservableList <Part> transfer;
    @FXML
    public void handleCancelPart() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Cancel ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult()==ButtonType.YES)
        {
            Stage stage = (Stage) cancelPart.getScene().getWindow();
            stage.close();
        }
    }
    
    public ModifyPartController(ObservableList<Part> transfer2)
    {   
        transfer = transfer2;
    }
    
    @FXML
    public void initialize()
    {
        ObservableList<Part> parts = Inventory.getAllParts();
        ID.setText(Integer.toString(transfer.get(0).getId()));
        Name.setText(transfer.get(0).getName());
        Min.setText(Integer.toString(transfer.get(0).getMin()));
        Max.setText(Integer.toString(transfer.get(0).getMax()));
        Price.setText(Double.toString(transfer.get(0).getPrice()));
        Inv.setText(Integer.toString(transfer.get(0).getStock()));
        
        if (transfer.get(0) instanceof inHouse) 
        {
	                vName.setText(Integer.toString(((inHouse) transfer.get(0)).getMachineid()));
                        
	}
        
        else if (transfer.get(0) instanceof OutSourced) 
        {
                        outSourced.setSelected(true);
	                vName.setText(((OutSourced) transfer.get(0)).getCompanyName());
                        
	}
        
        ID.setEditable(false);
        ID.setText("Auto-Gen Disabled");
        group1.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ov,
            Toggle old_toggle, Toggle new_toggle) 
             {  
                 if (InHouse.isSelected() ==true) {Vtext.setText("Machine ID");} 
                 if (outSourced.isSelected() ==true) {Vtext.setText("Company Name");}   
             }
        }
        );
    }
    
    @FXML
    public void onActionSavePart(){
        int id = transfer.get(0).getId();
        double price = Double.parseDouble(Price.getText());
        int min = Integer.parseInt(Min.getText());
        int max = Integer.parseInt(Max.getText());
        int inventory = Integer.parseInt(Inv.getText());
        String name = Name.getText();
        if (transfer.get(0) instanceof inHouse) 
        {   
                        
	                int machineId = Integer.parseInt(vName.getText());                      
                        Inventory.updatePart(id-1,new inHouse(id,name,price,inventory,max,min,machineId));
                        Stage stage = (Stage) save.getScene().getWindow();
                        stage.close();
        }
        
        else if (transfer.get(0) instanceof OutSourced) 
        {
                       
                        String cname = vName.getText();            
                        Inventory.updatePart(id-1,new OutSourced(id,name,price,inventory,max,min,cname));
                        Stage stage = (Stage) save.getScene().getWindow();
                        stage.close();
	}
    }
    
}
