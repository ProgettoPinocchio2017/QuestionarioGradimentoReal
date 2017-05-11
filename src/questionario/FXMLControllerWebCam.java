/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionario;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.resize;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import static org.opencv.imgproc.Imgproc.resize;

/**
 *
 * @author Michele
 */
public class FXMLControllerWebCam implements Initializable {

    VideoCapture webSource = null;
    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    CascadeClassifier faceDetector = new CascadeClassifier(FXMLControllerWebCam.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));
    MatOfRect faceDetections = new MatOfRect();
    Task tk;
    Image im;

    @FXML
    private ImageView imvCam;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnDetection;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnStop;

    @FXML
    private ImageView imvCam2;

    @FXML
    void doAdd(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("SceltaSiNo.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void doDetetection(ActionEvent event) {

    }

    @FXML
    void doStart(ActionEvent event) {
        tk = new Task() {
            @Override
            protected Integer call() throws Exception {
                System.out.println("Questo task acquisirà immagini dalla fotocamera");
                Integer iterations = 0;
                /*if (faceDetector.load(FXMLDocumentController.class.getResource("C:\\Users\\Michele\\Documents\\NetBeansProjects\\JavaFXOpenCvTask\\src\\javafxopencvtask\\haarcascade_frontalface_alt.xml").getPath().substring(1))) {
                    System.out.println("Caricamento andato a buon fine");
                } else {
                    System.out.println("Caricamento non andato a buon fine");
                }*/
                webSource = new VideoCapture(0);
                while (true) {
                    if (webSource.grab()) {
                        try {
                            webSource.retrieve(frame);
                        } catch (Exception ex) {
                            System.out.println("Error");
                        }
                    }
                    Imgcodecs.imencode(".bmp", frame, mem);
                    im = new Image(new ByteArrayInputStream(mem.toArray()));
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            imvCam.setImage(im);
                        }
                    });

                    if (isCancelled()) {
                        webSource.release();
                        break;
                    }
                }
                return iterations;
            }
        };
        tk.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                System.out.println("Task terminato " + tk.getValue());
            }
        });
        Thread t = new Thread(tk);
        t.setDaemon(true);
        t.start();

    }

    @FXML
    void doStop(ActionEvent event) {
        tk.cancel();
    }
//C:\\Users\\4D_2016-17\\Desktop\\JavaFXOpenCvTask\\src\\javafxopencvtask\\

    @FXML
    void doDetection(ActionEvent event) throws IOException {
        int i = 1;
        Mat matAdd = Imgcodecs.imread("C:\\Users\\4D_2016-17\\Desktop\\prova.jpg", Imgcodecs.CV_LOAD_IMAGE_ANYCOLOR);
        Mat shrek = Imgcodecs.imread("C:\\Users\\4D_2016-17\\Desktop\\index2.jpg", Imgcodecs.CV_LOAD_IMAGE_ANYCOLOR);
        faceDetector = new CascadeClassifier("C:\\Users\\4D_2016-17\\Desktop\\SIMONECOGLIONE\\src\\javafxopencvtask\\haarcascade_frontalface_alt.xml");
       
         Rect shrekroi= new Rect(150,30,60,75);
         Mat faccia=new Mat();
         Mat destinationROI=matAdd.submat(shrekroi);
         Size s = new Size(60, 75);
         faceDetector.detectMultiScale(frame, faceDetections);
       
     
        Imgproc.line(frame, new Point(20, 20), new Point(400, 400), new Scalar(0, 0, 255));
        Rect rect2=new Rect();
        Mat newMat= new Mat();
       
        for ( Rect rect1 : faceDetections.toArray()) {
               
           
            //Imgproc.circle(frame, new Point(rect1.x+rect1.width/2,rect1.y+rect1.height/2),rect1.width/2, new Scalar(0, 0, 255), 5);
            //Imgproc.rectangle(frame, new Point(rect1.x, rect1.y), new Point(rect1.x + rect1.width, rect1.y + rect1.height+((rect1.height*15)/100)), new Scalar(0, 0, 255), 5);
            Rect roi= new Rect(rect1.x,rect1.y,rect1.width,rect1.height+((rect1.height*15)/100));
            Mat crop=new Mat();
            crop=frame.submat(roi);
            Imgproc.resize(crop, newMat, s);
           
            
           newMat.copyTo( destinationROI); 
           shrek.copyTo( matAdd, shrek ); 
          
        }
           
           
    
        
        

       
        Imgcodecs.imencode(".bmp", matAdd, mem);
        Image im2 = new Image(new ByteArrayInputStream(mem.toArray()));
          //Mat destinationROI = im2.submat();
        imvCam2.setImage(im2);
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
