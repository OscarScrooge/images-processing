/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author LINK5
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        initComponents();
        selectImage();
       // createImagePixelsOriginal();
    }

    private void selectImage() {
        JFileChooser chooser = new JFileChooser();
        chooser.showDialog(null, null);

        File selectedFile = chooser.getSelectedFile();

        try {
            Mat newImage = Imgcodecs.imread(selectedFile.getPath());
            setImage1(newImage);
            imageAux = newImage;
        } catch (Exception ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    private void createImagePixelsOriginal() {
//
//        Mat myImage = new Mat(1419, 389, CvType.CV_8UC3);
//
//        for (int i = 0; i < myImage.rows(); i++) {
//            for (int j = 0; j < myImage.cols(); j++) {
//                int n1 = (int) (Math.random() * 255);
//                int n2 = (int) (Math.random() * 255);
//                int n3 = (int) (Math.random() * 255);
////                System.err.println("n1="+n1+" n2="+n2+" n3="+n3);
//                myImage.put(i, j, new double[]{n1, n2, n3});
//            }
//        }
//
//        setImage1(myImage);
//        imageAux = myImage;
//    }

    private void createImagePixelsOriginal() {

        Mat myImage = new Mat(1419, 389, CvType.CV_8UC3);
        double bit=0.0;
        for (int i = 0; i < myImage.rows(); i++) {
            for (int j = 0; j < myImage.cols(); j++) {
                int n1 = (int) (Math.random() * 255);
                int n2 = (int) (Math.random() * 255);
                int n3 = (int) (Math.random() * 255);
//                System.err.println("n1="+n1+" n2="+n2+" n3="+n3);
                myImage.put(i, j, new double[]{n1,n2,n3});                
//                myImage.put(i, j, new double[]{bit,bit,bit});
//                if(bit==0.0){
//                   bit=255.0;
//                }else{
//                   bit=0.0;
//                }
            }
        }

        setImage1(myImage);
        imageAux = myImage;
    }
    private void setImage1(Mat image) {
        Image loadedImage = toBufferedImage(image);
        jLabel_showImage1.setIcon(new ImageIcon(loadedImage.getScaledInstance(this.jLabel_showImage1.getWidth(), this.jLabel_showImage1.getHeight(), Image.SCALE_DEFAULT)));
    }

    private void setImage2(Mat image) {
        Image loadedImage = toBufferedImage(image);
        jLabel_showImage2.setIcon(new ImageIcon(loadedImage.getScaledInstance(this.jLabel_showImage2.getWidth(), this.jLabel_showImage2.getHeight(), Image.SCALE_DEFAULT)));
    }

    private void sumaPixeles(Mat image, int specValue) {

       
            for (int i = 0; i < image.rows(); i++) {
                for (int j = 0; j < image.cols(); j++) {
                    double[] newSpec = image.get(i, j);
                    newSpec[0] = newSpec[0] + specValue;
                    newSpec[1] = newSpec[1] + specValue;
                    newSpec[2] = newSpec[2] + specValue;
                    image.put(i, j, newSpec);
                    System.err.println("n1="+newSpec[0]+" n2="+newSpec[1]+" n3="+newSpec[2]);
                }
            }
      
        setImage2(image);
    }

    private void restaPixeles(Mat image, int specValue) {

        for (int i = 0; i < image.rows(); i++) {
            for (int j = 0; j < image.cols(); j++) {
                double[] newSpec = image.get(i, j);
                newSpec[0] = newSpec[0] - specValue;
                newSpec[1] = newSpec[1] - specValue;
                newSpec[2] = newSpec[2] - specValue;
                image.put(i, j, newSpec);
            }
        }
        setImage2(image);
    }

    private void multiplicaPixeles(Mat image, int specValue) {
        
        if(specValue!=0){
           for (int i = 0; i < image.rows(); i++) {
            for (int j = 0; j < image.cols(); j++) {
                double[] newSpec = image.get(i, j);
                newSpec[0] = newSpec[0] * specValue;
                newSpec[1] = newSpec[1] * specValue;
                newSpec[2] = newSpec[2] * specValue;
                image.put(i, j, newSpec);
            }
        }
        setImage2(image);
        }

        
    }

    private void dividePixeles(Mat image, int specValue) {
        
        if(specValue!=0){
            
            for (int i = 0; i < image.rows(); i++) {
            for (int j = 0; j < image.cols(); j++) {
                double[] newSpec = image.get(i, j);
                newSpec[0] = newSpec[0] * 1 / specValue;
                newSpec[1] = newSpec[1] * 1 / specValue;
                newSpec[2] = newSpec[2] * 1 / specValue;
                image.put(i, j, newSpec);
            }
        }
        setImage2(image);
        }

        
    }
    
    private void transformacionLinealGenerica(Mat image, int specValue) {
        
        if(specValue!=0){
            
            for (int i = 0; i < image.rows(); i++) {
            for (int j = 0; j < image.cols(); j++) {
                double[] newSpec = image.get(i, j);
                newSpec[0] = Math.pow(newSpec[0],specValue);
                newSpec[1] = Math.pow(newSpec[1],specValue);
                newSpec[2] = Math.pow(newSpec[2],specValue);
                image.put(i, j, newSpec);
            }
        }
        setImage2(image);
        }

        
    }
    
     private void transformacionLGama(Mat image, int specValue) {
        
        if(specValue!=0){
            
            for (int i = 0; i < image.rows(); i++) {
            for (int j = 0; j < image.cols(); j++) {
                double[] newSpec = image.get(i, j);
                newSpec[0] = newSpec[0] * specValue+(specValue-1) ;
                newSpec[1] = newSpec[1] * specValue+(specValue-1);
                newSpec[2] = newSpec[2] * specValue+(specValue-1);
                image.put(i, j, newSpec);
            }
        }
        setImage2(image);
        }

        
    }

    private Image toBufferedImage(Mat matrix) {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (matrix.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        if (matrix.channels() > 3) {
            type = BufferedImage.TYPE_4BYTE_ABGR;
        }
        int bufferSize = matrix.channels() * matrix.cols() * matrix.rows();
        byte[] buffer = new byte[bufferSize];
        matrix.get(0, 0, buffer); // get all the pixels
        BufferedImage image = new BufferedImage(matrix.cols(), matrix.
                rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().
                getDataBuffer()).getData();
        System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
        return image;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_showImage1 = new javax.swing.JLabel();
        jLabel_showImage2 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        jSlider3 = new javax.swing.JSlider();
        jSlider4 = new javax.swing.JSlider();
        jSlider5 = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSlider1.setMajorTickSpacing(2);
        jSlider1.setMaximum(20);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jSlider2.setMajorTickSpacing(2);
        jSlider2.setPaintLabels(true);
        jSlider2.setPaintTicks(true);
        jSlider2.setSnapToTicks(true);
        jSlider2.setValue(0);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });

        jSlider3.setMajorTickSpacing(1);
        jSlider3.setMaximum(5);
        jSlider3.setPaintLabels(true);
        jSlider3.setPaintTicks(true);
        jSlider3.setSnapToTicks(true);
        jSlider3.setValue(0);
        jSlider3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider3StateChanged(evt);
            }
        });

        jSlider4.setMajorTickSpacing(2);
        jSlider4.setMaximum(20);
        jSlider4.setPaintLabels(true);
        jSlider4.setPaintTicks(true);
        jSlider4.setSnapToTicks(true);
        jSlider4.setValue(0);
        jSlider4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider4StateChanged(evt);
            }
        });

        jSlider5.setMajorTickSpacing(2);
        jSlider5.setMaximum(20);
        jSlider5.setPaintLabels(true);
        jSlider5.setPaintTicks(true);
        jSlider5.setSnapToTicks(true);
        jSlider5.setValue(0);
        jSlider5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider5StateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSlider4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                                .addComponent(jSlider3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSlider2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSlider5, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_showImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_showImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jSlider5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_showImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_showImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        int level = (int) source.getValue();
        sumaPixeles(imageAux, level);

    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        int level = (int) source.getValue();
        restaPixeles(imageAux, level);
    }//GEN-LAST:event_jSlider2StateChanged

    private void jSlider3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider3StateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        int level = (int) source.getValue();
        multiplicaPixeles(imageAux, level);
    }//GEN-LAST:event_jSlider3StateChanged

    private void jSlider4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider4StateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        int level = (int) source.getValue();
        dividePixeles(imageAux, level);
    }//GEN-LAST:event_jSlider4StateChanged

    private void jSlider5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider5StateChanged
        // TODO add your handling code here:
          JSlider source = (JSlider) evt.getSource();
        int level = (int) source.getValue();
        transformacionLGama(imageAux, level);
    }//GEN-LAST:event_jSlider5StateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_showImage1;
    private javax.swing.JLabel jLabel_showImage2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider3;
    private javax.swing.JSlider jSlider4;
    private javax.swing.JSlider jSlider5;
    // End of variables declaration//GEN-END:variables
   private Mat imageAux;
}
