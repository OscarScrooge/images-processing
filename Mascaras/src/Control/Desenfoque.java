/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import javafx.scene.input.DataFormat;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author LINK5
 */
public class Desenfoque {

    public Desenfoque() {
    }

    public Mat aplicaMascara(Mat originalImage) {
        
        int con=1;
        Mat newImage = new Mat();
        newImage=originalImage.clone();
                
        System.out.println("cols= " +originalImage.cols());
        System.out.println("rows= " +originalImage.rows());
        double[] rgb1, rgb2, rgb3, rgb4, rgb5, rgb6, rgb7, rgb8, rgb9;
        double r,g,b;
        for (int row = 1; row <= originalImage.rows()-1; row++) {
            for (int col = 1; col <= originalImage.cols()-1; col++) {                                     
                       rgb1 = originalImage.get(row - 1, col - 1); 
                       if(rgb1==null){
                         rgb1=rellenaNull(rgb1);
                       }
                       rgb2 = originalImage.get(row - 1, col);
                       if(rgb2==null){
                         rgb2=rellenaNull(rgb2);
                       }
                       rgb3 = originalImage.get(row - 1, col + 1);
                       if(rgb3==null){
                         rgb3=rellenaNull(rgb3);
                       }
                       rgb4 = originalImage.get(row, col - 1);
                       if(rgb4==null){
                         rgb4=rellenaNull(rgb4);
                       }
                       rgb5 = originalImage.get(row, col);
                       if(rgb5==null){
                         rgb5=rellenaNull(rgb5);
                       }
                       rgb6 = originalImage.get(row, col + 1);
                       if(rgb6==null){
                         rgb6=rellenaNull(rgb6);
                       }
                       rgb7 = originalImage.get(row + 1, col - 1);
                       if(rgb7==null){
                         rgb7=rellenaNull(rgb7);
                       }
                       rgb8 = originalImage.get(row + 1, col);
                       if(rgb8==null){
                         rgb8=rellenaNull(rgb8);
                       }
                       rgb9 = originalImage.get(row + 1, col + 1);
                       if(rgb9==null){
                         rgb9=rellenaNull(rgb9);
                       }
                     
                       
                       r=rgb1[0]/9+rgb2[0]/9+rgb3[0]/9+rgb4[0]/9+rgb5[0]/9+rgb6[0]/9+rgb7[0]/9+rgb8[0]/9+rgb9[0]/9;
                       g=rgb1[1]/9+rgb2[1]/9+rgb3[1]/9+rgb4[1]/9+rgb5[1]/9+rgb6[1]/9+rgb7[1]/9+rgb8[1]/9+rgb9[1]/9;
                       b=rgb1[2]/9+rgb2[2]/9+rgb3[2]/9+rgb4[2]/9+rgb5[2]/9+rgb6[2]/9+rgb7[2]/9+rgb8[2]/9+rgb9[2]/9;
//                       
//                       r=rgb1[0]*-2+rgb2[0]*-1+rgb3[0]*0+rgb4[0]*-1+rgb5[0]*1+rgb6[0]*1+rgb7[0]*0+rgb8[0]*1+rgb9[0]*2;
//                       g=rgb1[1]*-2+rgb2[1]*-1+rgb3[1]*-0+rgb4[1]*-1+rgb5[1]*1+rgb6[1]*1+rgb7[1]*0+rgb8[1]*1+rgb9[1]*2;
//                       b=rgb1[2]*-2+rgb2[2]*-1+rgb3[2]*0+rgb4[2]*-1+rgb5[2]*1+rgb6[2]*1+rgb7[2]*0+rgb8[2]*1+rgb9[2]*2;


      
//                       r=rgb1[0]*0+rgb2[0]*1+rgb3[0]*0+rgb4[0]*1+rgb5[0]*-4+rgb6[0]*1+rgb7[0]*0+rgb8[0]*1+rgb9[0]*0;
//                       g=rgb1[1]*0+rgb2[1]*1+rgb3[1]*0+rgb4[1]*1+rgb5[1]*-4+rgb6[1]*1+rgb7[1]*0+rgb8[1]*1+rgb9[1]*0;
//                       b=rgb1[2]*0+rgb2[2]*1+rgb3[2]*0+rgb4[2]*1+rgb5[2]*-4+rgb6[2]*1+rgb7[2]*0+rgb8[2]*1+rgb9[2]*0;
                       
                       newImage.put(row, col, new double[]{r,g,b});
            }
        }
        
//        Imgproc.Laplacian(originalImage,newImage,-1);
        return newImage;
    }
    
    
    private double[] rellenaNull(double[] vectorNull){
        
        vectorNull= new double[3];
        
          vectorNull[0]=-1;
          vectorNull[1]=-1;
          vectorNull[2]=-1;
          
          return vectorNull;
    }

    private void recorreMatriz(double matrixRBG) {
//               double[] kernel={1,1,1,1,1,1,1,1,1};
//               double r,g,b;
//               
//               for(int col=0;col<3;col++){
//                   for(int fila=0;fila<3;fila++){
//                       r=matrixRBG[0]*;
//                   }
//               }

    }

}
