/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionario;

import java.io.ByteArrayInputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
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
    void doAdd(ActionEvent event) {

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
    void doDetection(ActionEvent event) {
        int i = 1;

        faceDetector = new CascadeClassifier("C:\\Users\\4D_2016-17\\Desktop\\JavaFXOpenCvTask\\src\\javafxopencvtask\\haarcascade_frontalface_alt.xml");

        faceDetector.detectMultiScale(frame, faceDetections);
        int x = faceDetections.width();
        int y = faceDetections.height();
      /*  Mat matAdd = Imgcodecs.imread("C:\\Users\\4D_2016-17\\Desktop\\JavaFXOpenCvTask\\src\\javafxopencvtask\\Pinocchio.jpg", Imgcodecs.CV_LOAD_IMAGE_ANYCOLOR);
        Mat newMat = new Mat();
       // Size s = new Size(x, y);
        Size s = new Size(x, y);
        Imgproc.resize(matAdd, newMat, s);
        //Rect[] rect =faceDetections.toArray();
        Imgproc.line(frame, new Point(20, 20), new Point(400, 400), new Scalar(0, 0, 255));*/
        /* roi= new Rect(new Point(rect1.x, rect1.y), s);
             Mat destinationROI = frame.submat( roi );
             newMat.copyTo( destinationROI , newMat); 
            System.out.println(i++);*/
       
        //Rect[] rect =faceDetections.toArray();
        
     
       
        Imgproc.line(frame, new Point(20, 20), new Point(400, 400), new Scalar(0, 0, 255));
        Rect rect2=new Rect();
        //Point a=new Point(rect[0].x,rect[0].y);
        for ( Rect rect1 : faceDetections.toArray()) {
               
        //Rect[] rect =faceDetections.toArray();
            
            Imgproc.rectangle(frame, new Point(rect1.x, rect1.y), new Point(rect1.x + rect1.width, rect1.y + rect1.height), new Scalar(0, 0, 255), 5);
            rect2=rect1;
            //newMat.copyTo(frame);
            //
        }
           //Rect roi= new Rect(rect2.x, rect2.y,x,y);
            Mat matAdd = Imgcodecs.imread("C:\\Users\\4D_2016-17\\Desktop\\JavaFXOpenCvTask1\\src\\javafxopencvtask\\LAVORO_SCUOLA.jpg", Imgcodecs.CV_LOAD_IMAGE_ANYCOLOR);
             Mat newMat = new Mat();
             // Size s = new Size(x, y);
             Size s = new Size(rect2.width, rect2.height);
            Imgproc.resize(matAdd, newMat, s);
             Rect roi= new Rect(rect2.x,rect2.y,rect2.width,rect2.height);
             Mat destinationROI = frame.submat( roi );
             newMat.copyTo( destinationROI , newMat); 
        
       
        // Rect rectCrop = new Rect(rect[0].x,rect[0].y, x1, y1);
       
        
        

        //newMat.copyTo(frame.rowRange(rect[0].x+1, x1+1),frame.colRange(rect[0].y+1, y1+1));
        Imgcodecs.imencode(".bmp", frame, mem);
        Image im2 = new Image(new ByteArrayInputStream(mem.toArray()));
          //Mat destinationROI = im2.submat();
        imvCam2.setImage(im2);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
