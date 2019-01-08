package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import org.opencv.core.Core;
import static org.opencv.core.Core.BORDER_REFLECT_101;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import simplesample.ImageProcessor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class ImageViewer extends javax.swing.JFrame {

    /**
     * Creates new form ImageViewer
     */

    public ImageViewer(Mat image) {

        initComponents();

        this.image = image;
        
        Mat myImage= new Mat(1419,389, CvType.CV_8UC3);
        
//        for(int i=0;i<myImage.rows();i++){
//            for(int j=0;j<myImage.cols();j++){
//                int n1= (int) (Math.random()*255);
//                int n2= (int) (Math.random()*255);
//                int n3= (int) (Math.random()*255);
////                System.err.println("n1="+n1+" n2="+n2+" n3="+n3);
//                myImage.put(i, j, new double[]{n1,n2,n3});
//            }
//        }
        
        Image loadedImage = toBufferedImage(this.image);        
//        Image loadedImage = toBufferedImage(myImage);        
        showImage.setIcon(new ImageIcon(loadedImage));
        this.imageAux=this.image;
        ImageProcessor imageProcessor = new ImageProcessor();

    }

    public Image toBufferedImage(Mat matrix) {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (matrix.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
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

        showImage = new javax.swing.JLabel();
        sliderLabel = new javax.swing.JSlider();
        setupButton = new javax.swing.JButton();
        jRadioButton_Erode = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton_Dilate = new javax.swing.JRadioButton();
        jRadioButton_Open = new javax.swing.JRadioButton();
        jRadioButton_Close = new javax.swing.JRadioButton();
        jRadioButton_Add_Noise = new javax.swing.JRadioButton();
        jPanel_Image = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        showImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showImageMousePressed(evt);
            }
        });

        sliderLabel.setMajorTickSpacing(2);
        sliderLabel.setMaximum(20);
        sliderLabel.setMinorTickSpacing(1);
        sliderLabel.setPaintLabels(true);
        sliderLabel.setPaintTicks(true);
        sliderLabel.setValue(0);
        sliderLabel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderLabelStateChanged(evt);
            }
        });

        setupButton.setText("Clear");
        setupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setupButtonActionPerformed(evt);
            }
        });

        jRadioButton_Erode.setText("Erode");
        jRadioButton_Erode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_ErodeActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Rectangle");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Kernel Size");

        jLabel2.setText("Shape");

        jRadioButton2.setText("Elipse");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Cross");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton_Dilate.setText("Dilate");
        jRadioButton_Dilate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_DilateActionPerformed(evt);
            }
        });

        jRadioButton_Open.setText("Open");
        jRadioButton_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_OpenActionPerformed(evt);
            }
        });

        jRadioButton_Close.setText("Close");
        jRadioButton_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_CloseActionPerformed(evt);
            }
        });

        jRadioButton_Add_Noise.setText("Add Noise");
        jRadioButton_Add_Noise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_Add_NoiseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ImageLayout = new javax.swing.GroupLayout(jPanel_Image);
        jPanel_Image.setLayout(jPanel_ImageLayout);
        jPanel_ImageLayout.setHorizontalGroup(
            jPanel_ImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel_ImageLayout.setVerticalGroup(
            jPanel_ImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(showImage, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(setupButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton_Erode)
                .addGap(29, 29, 29)
                .addComponent(jRadioButton_Dilate)
                .addGap(54, 54, 54)
                .addComponent(jRadioButton_Open)
                .addGap(45, 45, 45)
                .addComponent(jRadioButton_Close)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton_Add_Noise)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(45, 45, 45)
                        .addComponent(jRadioButton2)
                        .addGap(30, 30, 30)
                        .addComponent(jRadioButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sliderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton_Close)
                        .addComponent(jRadioButton_Add_Noise))
                    .addComponent(jRadioButton_Open, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton_Dilate)
                        .addComponent(jRadioButton_Erode)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(sliderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(showImage, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(setupButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sliderLabelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderLabelStateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        this.kernelSize = (int) source.getValue();
        
//        this.repaint();
    }//GEN-LAST:event_sliderLabelStateChanged

    private void showImageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showImageMousePressed
        // TODO add your handling code here:

        Imgproc.circle(image, new Point(evt.getX(), evt.getY()), 20, new Scalar(0, 0, 255), 4);
        Image loadedImage = toBufferedImage(image);
        showImage.setIcon(new ImageIcon(loadedImage));
//        this.repaint();

    }//GEN-LAST:event_showImageMousePressed

    private void setupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setupButtonActionPerformed
        // TODO add your handling code here:
        this.image=this.imageAux;
        Image originalImage = toBufferedImage(this.image);
        showImage.setIcon(new ImageIcon(originalImage));
    }//GEN-LAST:event_setupButtonActionPerformed

    private void jRadioButton_ErodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_ErodeActionPerformed
        // TODO add your handling code here:
        Mat outputImage = new Mat();
        Mat element = getKernelFromShape(kernelSize, this.shape);
        Imgproc.erode(this.image, outputImage, element);
        Image newImage = toBufferedImage(outputImage);
            showImage.setIcon(new ImageIcon(newImage));
    }//GEN-LAST:event_jRadioButton_ErodeActionPerformed

    private Mat getKernelFromShape(int elementSize, int elementShape) {
        return Imgproc.getStructuringElement(elementShape, new Size(elementSize * 2 + 1, elementSize * 2 + 1), new Point(elementSize,
                elementSize));
    }
    
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        this.shape =Imgproc.CV_SHAPE_RECT;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
                this.shape =Imgproc.CV_SHAPE_ELLIPSE;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
                        this.shape =Imgproc.CV_SHAPE_CROSS;
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton_DilateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_DilateActionPerformed
        // TODO add your handling code here:
         Mat outputImage = new Mat();
        Mat element = getKernelFromShape(kernelSize, this.shape);
        Imgproc.dilate(this.image, outputImage, element);
        this.image=outputImage;
//        Image newImage = toBufferedImage(outputImage);
        Image newImage = toBufferedImage(this.image);
            showImage.setIcon(new ImageIcon(newImage));
    }//GEN-LAST:event_jRadioButton_DilateActionPerformed

    private void jRadioButton_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_OpenActionPerformed
        // TODO add your handling code here:
         Mat outputImage = new Mat();
        Mat element = getKernelFromShape(kernelSize, this.shape);
        Imgproc.morphologyEx(this.image,outputImage, Imgproc.MORPH_OPEN,element);
        Image newImage = toBufferedImage(outputImage);
            showImage.setIcon(new ImageIcon(newImage));
    }//GEN-LAST:event_jRadioButton_OpenActionPerformed

    private void jRadioButton_CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_CloseActionPerformed
        // TODO add your handling code here:
         Mat outputImage = new Mat();
        Mat element = getKernelFromShape(kernelSize, this.shape);
        Imgproc.morphologyEx(this.image,outputImage, Imgproc.MORPH_CLOSE,element);
        Image newImage = toBufferedImage(outputImage);
            showImage.setIcon(new ImageIcon(newImage));
    }//GEN-LAST:event_jRadioButton_CloseActionPerformed

    private void jRadioButton_Add_NoiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_Add_NoiseActionPerformed
        // TODO add your handling code here:
        this.addNoise();
    }//GEN-LAST:event_jRadioButton_Add_NoiseActionPerformed

    private void addNoise() {
        
        Mat grayRnd = new Mat(this.image.rows(),this.image.cols(),this.image.type());
        System.out.println(""+grayRnd);
        double noise = 128;
        grayRnd.setTo(new Scalar(noise / 2, noise / 2, noise / 2));
        Core.subtract(this.image, grayRnd,this.image);
        Core.randu(grayRnd, 10, noise);
        Core.add(this.image, grayRnd,this.image);  
        this.image=grayRnd;
//        Image newImage = toBufferedImage(grayRnd);                
//        Image newImage = toBufferedImage(this.image);
//        showImage.setIcon(new ImageIcon(newImage));

    }

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
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ImageViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel_Image;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton_Add_Noise;
    private javax.swing.JRadioButton jRadioButton_Close;
    private javax.swing.JRadioButton jRadioButton_Dilate;
    private javax.swing.JRadioButton jRadioButton_Erode;
    private javax.swing.JRadioButton jRadioButton_Open;
    private javax.swing.JButton setupButton;
    private javax.swing.JLabel showImage;
    private javax.swing.JSlider sliderLabel;
    // End of variables declaration//GEN-END:variables

   private int kernelSize=0;
   private int shape=0;
   private Mat image;
   private Mat imageAux;
}
