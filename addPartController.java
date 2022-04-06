/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class addPartController {

    
    @FXML private TextField cName;
    @FXML private TextField Min;
    @FXML private TextField Max;
    @FXML private TextField Price;
    @FXML private TextField Inv;
    @FXML private TextField Name;
    @FXML private RadioButton InHouse;
    @FXML private Button cancelPart;
    @FXML private ToggleGroup group1;
    @FXML private RadioButton outSourced;
    @FXML private Button save;
    @FXML private Label CompanyN;
    @FXML
    public void onActionSavePart(){
        int id = Inventory.getAllParts().size()+1;
        double price = Double.parseDouble(Price.getText());
        int min = Integer.parseInt(Min.getText());
        int max = Integer.parseInt(Max.getText());
        int inventory = Integer.parseInt(Inv.getText());
        String name = Name.getText();
        if (InHouse.isSelected() ==true)
        {
            int machineID = Integer.parseInt(cName.getText());
            Inventory.addPart(new inHouse( id,name,price,inventory,max,min,machineID));
            Stage stage = (Stage) save.getScene().getWindow();
            stage.close(); 
        }  
        if (outSourced.isSelected() == true)
        {
            String CompanyName = cName.getText();
            Inventory.addPart(new OutSourced(id,name,price,inventory,max,min,CompanyName));
            Stage stage = (Stage) save.getScene().getWindow();
            stage.close(); 
        }
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
    public void initialize()
    {   
  
        if (InHouse.isSelected() ==true) {cName.setEditable(true);}
        group1.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ov,
            Toggle old_toggle, Toggle new_toggle) 
             {  
                 if (InHouse.isSelected() ==true) {CompanyN.setText("MachineID");} 
                 if (outSourced.isSelected() ==true) {CompanyN.setText("CompanyName");}   
             }
        }
        );
    }
 
}
