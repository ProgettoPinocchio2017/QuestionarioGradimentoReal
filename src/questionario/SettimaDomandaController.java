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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cipri
 */
public class SettimaDomandaController implements Initializable {

    @FXML
    private Label idDomanda;

    @FXML
    private Button idBack;

    @FXML
    private RadioButton idUno;

    @FXML
    private ToggleGroup parco;

    @FXML
    private RadioButton idDue;

    @FXML
    private RadioButton idTre;

    @FXML
    private RadioButton idQuattro;

    @FXML
    private RadioButton idCinque;

    @FXML
    private RadioButton idSei;

    @FXML
    private RadioButton idSette;

    @FXML
    private RadioButton idOtto;

    @FXML
    private RadioButton idNove;

    @FXML
    private RadioButton idDieci;

    @FXML
    private Button idNext;

    @FXML
    private MediaView idVideo;

    @FXML
    void doBack(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("SestaDomanda.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void doCinque(ActionEvent event) {
        Questionario.vettore[6] = 5;
    }

    @FXML
    void doDieci(ActionEvent event) {
        Questionario.vettore[6] = 10;
    }

    @FXML
    void doDue(ActionEvent event) {
        Questionario.vettore[6] = 2;
    }

    @FXML
    void doNext(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("OttavaDomanda.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void doNove(ActionEvent event) {
        Questionario.vettore[6] = 9;
    }

    @FXML
    void doOtto(ActionEvent event) {
        Questionario.vettore[6] = 8;
    }

    @FXML
    void doQuattro(ActionEvent event) {
        Questionario.vettore[6] = 4;
    }

    @FXML
    void doSei(ActionEvent event) {
        Questionario.vettore[6] = 6;
    }

    @FXML
    void doSette(ActionEvent event) {
        Questionario.vettore[6] = 7;
    }

    @FXML
    void doTre(ActionEvent event) {
        Questionario.vettore[6] = 3;
    }

    @FXML
    void doUno(ActionEvent event) {
        Questionario.vettore[6] = 1;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       switch ( Questionario.vettore[6]){
            case 1: idUno.setSelected(true);break;
            case 2: idDue.setSelected(true);break;
            case 3: idTre.setSelected(true);break;
            case 4: idQuattro.setSelected(true);break;
            case 5: idCinque.setSelected(true);break;
            case 6: idSei.setSelected(true);break;
            case 7: idSette.setSelected(true);break;
            case 8: idOtto.setSelected(true);break;
            
            
        }
    }

}
