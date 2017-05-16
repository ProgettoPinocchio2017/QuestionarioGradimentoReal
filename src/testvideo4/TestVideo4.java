/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testvideo4;

import Model.Video;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * La classe TestVideo4 serve per istanziare un oggetto di tipo Video e gestire
 * anche la parte grafica permettendone la visualizzazione.
 *
 * @author Manuel
 */
public class TestVideo4 extends Application {

    /**
     * @param video,si istanzia un oggetto di tipo Video.
     * @author Manuel.
     */
    private Video video;

    /**
     * Il metodo setvideo() permette di settare il video,accetta come parametro un
     * oggetto di tipo video.
     *
     * @param video
     * @author Manuel
     */
    public void setvideo(Video video) {
        this.video = video;
    }

    /**
     * Il metodo getVideo() permette di reperire il video,restituisce un oggetto
     * di tipo video.
     *
     * @return video;
     * @author Manuel
     */
    public Video getVideo() {
        return video;
    }

    /**
     * Il metodo start() permette l'implementazione grafica del
     * programma,accetta come parametro un oggetto di tipo stage. Crea una
     * finestra e la inizializza a FullScreen.
     *
     * @param stage,rappresenta la finestra su cui verrà implementata
     * l'interfaccia grafica.
     * @throws Exception,che lancia un'eccezione generica.
     * @author Manuel
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader mioLoader1 = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = mioLoader1.load();
        StackPane pane = new StackPane();
        pane.getChildren().add(root);
        Scene scene = new Scene(pane);
        FXMLDocumentController f = (mioLoader1.getController());
        f.setMiaScena(pane);
        f.setMioVideo(video);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setFullScreen(true);
        stage.show();
    }

    /**
     * Il metodo avvio(),lancia il thread javafx
     *
     * @param args,eventuali parametri passati al programma principale(non utilizzati).
     * @author Manuel
     * @
     */
    public void avvio(String args) {
        System.out.println(this.getVideo().getName());

        launch(args);
    }
}
