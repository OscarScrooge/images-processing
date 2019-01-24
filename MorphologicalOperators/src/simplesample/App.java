/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplesample;

import view.ImageViewer;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author Administrator
 */
public class App {

    /**
     * @param args the command line arguments
     */
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to OpenCV " + Core.VERSION);
//        Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));
//        System.out.println("OpenCV Mat: " + m);
//        Mat mr1 = m.row(1);
//        mr1.setTo(new Scalar(1));
//        Mat mc5 = m.col(5);
//        mc5.setTo(new Scalar(5));
//        System.out.println("OpenCV Mat data:\n" + m.dump());
        JFileChooser chooser = new JFileChooser();
        chooser.showDialog(null, null);

        File selectedFile = chooser.getSelectedFile();
        System.out.println(selectedFile.getPath());
        try {
            openFile(selectedFile.getPath());
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void openFile(String fileName) throws Exception {
        Mat newImage = Imgcodecs.imread(fileName);
        if (newImage.dataAddr() == 0) {
            throw new Exception("Couldn't open file " + fileName);
        }

        ImageViewer frame = new ImageViewer(newImage);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        System.out.println(""+newImage.dump());

//        return newImage;
    }

}
