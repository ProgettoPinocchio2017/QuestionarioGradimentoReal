/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testvideo4;

import Model.Video;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *

 * La classe controller  si occupa della  gestione grafica permettendo la visualizzazione del video.
 * @author Manuel 
 */
public class FXMLDocumentController implements Initializable {

    /**
     * @param mioPane,oggetto di tipo StackPane,la scena passata dalla classe TestVideo4.
     * @param mioVideo,oggetto di tipo Video,che verrà visualizzato a schermo intero.
     * @author Manuel.
     */
    private StackPane mioPane;
    private Video mioVideo;
    /**
     * Il metodo setMiaScena() permette di settare la scena della finestra,accetta come parametro un
     * oggetto di tipo StackPane.
     *
     * @param mioPane
     * @author Manuel
     */
    public void setMiaScena(StackPane mioPane) {
        this.mioPane = mioPane;
    }
        /**
     * Il metodo setMioVideo() permette di settare il video,accetta come parametro un
     * oggetto di tipo Video.
     * @param mioVideo
     * @author Manuel

     */
     public void setMioVideo(Video mioVideo) {
        this.mioVideo = mioVideo;
    }
    @FXML
    private Button btnPlay;
    @FXML
    private MediaView mwvideo;
            /**
     * Il metodo doPlay() permette di visualizzare il video,se si preme sul pulsante play.
     * @param mioVideo
     * @author Manuel

     */
    @FXML
    void doPlay(ActionEvent event) throws IOException {
        Task tk = new Task() {
            @Override
            protected Integer call() throws Exception {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Media media = mioVideo.getM();
                        MediaPlayer mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.setAutoPlay(true);
                        mwvideo.setMediaPlayer(mediaPlayer);
                        mwvideo.fitWidthProperty().bind(mioPane.widthProperty());
                        mwvideo.fitHeightProperty().bind(mioPane.heightProperty());
                    }
                });
                return 0;
            }
        };
        tk.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
            }
        });
        Thread t = new Thread(tk);
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
