/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import org.opencv.core.Mat;
import pixelmanipulation_refactor.CustomImage;
import pixelmanipulation_refactor.Filters;
import pixelmanipulation_refactor.MyImage;
/**
 *
 * @author LINK5
 */
public class PixelManipulation extends javax.swing.JFrame {

    /**
     * Creates new form PixelManipulation
     */
    public PixelManipulation() {
        initComponents();
        img = new CustomImage();
        width = this.jLabel_Image2.getWidth();
        height = this.jLabel_Image2.getHeight();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_SelectImage = new javax.swing.JButton();
        jLabel_Image1 = new javax.swing.JLabel();
        jLabel_Image2 = new javax.swing.JLabel();
        jSlider_Bright = new javax.swing.JSlider();
        jButton_MyImage = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jCheckBox_Negative = new javax.swing.JCheckBox();
        jSlider3 = new javax.swing.JSlider();
        jCheckBox_Binary = new javax.swing.JCheckBox();
        jTextField_Umbral = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_MedianFilter = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_SelectImage.setText("Sleccionar imágen");
        jButton_SelectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SelectImageActionPerformed(evt);
            }
        });

        jLabel_Image1.setText("Image_1");

        jLabel_Image2.setText("Image_2");
        jLabel_Image2.setOpaque(true);
        jLabel_Image2.setPreferredSize(new java.awt.Dimension(696, 696));

        jSlider_Bright.setMajorTickSpacing(1);
        jSlider_Bright.setMaximum(10);
        jSlider_Bright.setPaintLabels(true);
        jSlider_Bright.setPaintTicks(true);
        jSlider_Bright.setSnapToTicks(true);
        jSlider_Bright.setValue(0);
        jSlider_Bright.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider_BrightStateChanged(evt);
            }
        });

        jButton_MyImage.setText("Crear Imágen");
        jButton_MyImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MyImageActionPerformed(evt);
            }
        });

        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(10);
        jSlider1.setMinimum(-10);
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

        jCheckBox_Negative.setText("Negative");
        jCheckBox_Negative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_NegativeActionPerformed(evt);
            }
        });

        jSlider3.setMajorTickSpacing(1);
        jSlider3.setMaximum(10);
        jSlider3.setMinimum(1);
        jSlider3.setPaintLabels(true);
        jSlider3.setPaintTicks(true);
        jSlider3.setSnapToTicks(true);
        jSlider3.setValue(0);
        jSlider3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider3StateChanged(evt);
            }
        });

        jCheckBox_Binary.setText("Binary");
        jCheckBox_Binary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_BinaryActionPerformed(evt);
            }
        });

        jTextField_Umbral.setText("umbral");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Smoothing");

        jMenuItem_MedianFilter.setText("Median Filter");
        jMenu2.add(jMenuItem_MedianFilter);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel_Image1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel_Image2, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jButton_MyImage)
                                .addGap(217, 217, 217)
                                .addComponent(jButton_SelectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)
                                .addComponent(jCheckBox_Binary)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Umbral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSlider_Bright, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(138, 138, 138)
                                        .addComponent(jCheckBox_Negative))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(130, 130, 130)
                                        .addComponent(jButton1)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_SelectImage)
                    .addComponent(jButton_MyImage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_Image1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jSlider_Bright, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_Image2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox_Negative)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox_Binary)
                                .addComponent(jTextField_Umbral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton1))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SelectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SelectImageActionPerformed
        // TODO add your handling code here:
        Image imageToShow;
       
        myImage = img.getImage();
       
        buffer = img.toBytes(myImage);       
        
        imageToShow = img.toImage(myImage, buffer);
        
        jLabel_Image1.setIcon(new ImageIcon(imageToShow.getScaledInstance(this.jLabel_Image1.getWidth(), this.jLabel_Image1.getHeight(), Image.SCALE_DEFAULT)));
        brightImage = myImage.clone();
    }//GEN-LAST:event_jButton_SelectImageActionPerformed

    private void jSlider_BrightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_BrightStateChanged
        // TODO add your handling code here:
        
        JSlider source = (JSlider) evt.getSource();
        int level=0;       
        level = (int) source.getValue(); 
        brightImage = myImage;
         byte[] buffer = img.toBytes(brightImage);
        
        brightImage = Filters.addBrightness(brightImage,level);
        
        Image image= img.toImage(brightImage, buffer);
        
        this.jLabel_Image2.setSize(width, height);
        
        jLabel_Image2.setIcon(new ImageIcon(image.getScaledInstance(this.jLabel_Image2.getWidth(), this.jLabel_Image2.getHeight(), Image.SCALE_SMOOTH)));
       
    }//GEN-LAST:event_jSlider_BrightStateChanged

    private void jButton_MyImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MyImageActionPerformed
        // TODO add your handling code here:
          Mat ownMat = MyImage.create();
        buffer = img.toBytes(ownMat);
        Image ownImage = img.toImage(ownMat, buffer);
        jLabel_Image1.setIcon(new ImageIcon(ownImage.getScaledInstance(this.jLabel_Image1.getWidth(), this.jLabel_Image1.getHeight(), Image.SCALE_DEFAULT)));
        brightImage = ownMat;
    }//GEN-LAST:event_jButton_MyImageActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        int level=0;       
        level = (int) source.getValue();              
         byte[] buffer = img.toBytes(brightImage);
        
        brightImage = Filters.addContrast(brightImage,level);
        
        Image image = img.toImage(brightImage, buffer);
        
        jLabel_Image2.setIcon(new ImageIcon(image.getScaledInstance(this.jLabel_Image2.getWidth(), this.jLabel_Image2.getHeight(), Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_jSlider1StateChanged

    private void jCheckBox_NegativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_NegativeActionPerformed
        // TODO add your handling code here:
         byte[] buffer = img.toBytes(brightImage);
        
        brightImage = Filters.negative(brightImage);
        
        Image image = img.toImage(brightImage, buffer);
        
        jLabel_Image2.setIcon(new ImageIcon(image.getScaledInstance(this.jLabel_Image2.getWidth(), this.jLabel_Image2.getHeight(), Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_jCheckBox_NegativeActionPerformed

    private void jSlider3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider3StateChanged
        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        int level=0;       
        level = (int) source.getValue();              
         byte[] buffer = img.toBytes(brightImage);
        
        brightImage = Filters.correctLight(brightImage,level);
        
        Image image = img.toImage(brightImage, buffer);
        
        jLabel_Image2.setIcon(new ImageIcon(image.getScaledInstance(this.jLabel_Image2.getWidth(), this.jLabel_Image2.getHeight(), Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_jSlider3StateChanged

    private void jCheckBox_BinaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_BinaryActionPerformed
        // TODO add your handling code here:
         byte[] buffer = img.toBytes(brightImage);
        
         brightImage = Filters.toBynary(brightImage,Integer.parseInt(jTextField_Umbral.getText()));
        
         Image image = img.toImage(brightImage, buffer);
        
         jLabel_Image2.setIcon(new ImageIcon(image.getScaledInstance(this.jLabel_Image2.getWidth(), this.jLabel_Image2.getHeight(), Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_jCheckBox_BinaryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        byte[] buffer = img.toBytes(myImage);
        
        
         Image image = img.toImage(myImage, buffer);
        
         jLabel_Image2.setIcon(new ImageIcon(image.getScaledInstance(this.jLabel_Image2.getWidth(), this.jLabel_Image2.getHeight(), Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_jButton1ActionPerformed

   
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
            java.util.logging.Logger.getLogger(PixelManipulation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PixelManipulation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PixelManipulation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PixelManipulation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PixelManipulation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_MyImage;
    private javax.swing.JButton jButton_SelectImage;
    private javax.swing.JCheckBox jCheckBox_Binary;
    private javax.swing.JCheckBox jCheckBox_Negative;
    private javax.swing.JLabel jLabel_Image1;
    private javax.swing.JLabel jLabel_Image2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_MedianFilter;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider3;
    private javax.swing.JSlider jSlider_Bright;
    private javax.swing.JTextField jTextField_Umbral;
    // End of variables declaration//GEN-END:variables
   private Mat myImage;
   private byte[] buffer;
   private CustomImage img;
   private  Mat brightImage;
   private int width=0,height=0;
}
