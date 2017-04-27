/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 4D 2016-17
 */
public class SceltaSiNoController implements Initializable {

    @FXML
    private Button btnFine;

    @FXML
    private RadioButton rdbSi;

    @FXML
    private ToggleGroup Scelta;

    @FXML
    private RadioButton rbdNo;

    @FXML
    void doFine(ActionEvent event) throws IOException{
    if(rdbSi.isSelected()){
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("PaginaFinale.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
    else{
       Parent tableViewParent = FXMLLoader.load(getClass().getResource("PrimaDomanda.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show(); 
    }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
