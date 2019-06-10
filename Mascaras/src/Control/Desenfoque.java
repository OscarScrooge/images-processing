/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.scene.input.DataFormat;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author LINK5
 */
public class Desenfoque {

    private double mayorb,mayorg,mayorr;
    public Desenfoque() {
    }

    public Mat aplicaMascara(Mat originalImage) {

        int con = 1,row=0,col=0,x=0,y=0;
        Mat newImage = new Mat();
        Mat rotate=  new Mat(originalImage.rows(),originalImage.cols(), originalImage.type());
        double angulo=Math.PI/2;
        ArrayList colors = new ArrayList();
        newImage = originalImage.clone();
        DecimalFormat formato1 = new DecimalFormat("#.0");

        System.out.println("cols= " + originalImage.cols());
        System.out.println("rows= " + originalImage.rows());
        double[] rgb1, rgb2, rgb3, rgb4, rgb5, rgb6, rgb7, rgb8, rgb9;
        double r, g, b;
        for (row =0 ; row<=originalImage.rows() - 1; row++) {
            for ( col = 0; col <= originalImage.cols() - 1; col++) {
//                rgb1 = originalImage.get(row - 1, col - 1);
//                if (rgb1 == null) {
//                    rgb1 = rellenaNull(rgb1);
//                }
//                colors.add(rgb1);
//                rgb2 = originalImage.get(row - 1, col);
//                if (rgb2 == null) {
//                    rgb2 = rellenaNull(rgb2);
//                }
//                colors.add(rgb2);
//                rgb3 = originalImage.get(row - 1, col + 1);
//                if (rgb3 == null) {
//                    rgb3 = rellenaNull(rgb3);
//                }
//                colors.add(rgb3);
//                rgb4 = originalImage.get(row, col - 1);
//                if (rgb4 == null) {
//                    rgb4 = rellenaNull(rgb4);
//                }
//                colors.add(rgb4);
//                rgb5 = originalImage.get(row, col);
//                if (rgb5 == null) {
//                    rgb5 = rellenaNull(rgb5);
//                }
//                colors.add(rgb5);
//                rgb6 = originalImage.get(row, col + 1);
//                if (rgb6 == null) {
//                    rgb6 = rellenaNull(rgb6);
//                }
//                colors.add(rgb6);
//                rgb7 = originalImage.get(row + 1, col - 1);
//                if (rgb7 == null) {
//                    rgb7 = rellenaNull(rgb7);
//                }
//                colors.add(rgb7);
//                rgb8 = originalImage.get(row + 1, col);
//                if (rgb8 == null) {
//                    rgb8 = rellenaNull(rgb8);
//                }
//                colors.add(rgb8);
//                rgb9 = originalImage.get(row + 1, col + 1);
//                if (rgb9 == null) {
//                    rgb9 = rellenaNull(rgb9);
//                }
//                colors.add(rgb9);

                
//                x = (int) (row*.3);
//                y =(int) (col*.3); 
                
//                if(x<0){
//                  x= x*-1;                
//                }else if(y<0){
//                  y= y*-1;                
//                }  
                

                   
                  int xr=(int) (row);
                  int yc=(int) (col);
                                                
                 x = (int) Double.parseDouble(formato1.format(xr*Math.cos(angulo)-yc*Math.sin(angulo)));
                 y = (int) Double.parseDouble(formato1.format(xr*Math.sin(angulo)+yc*Math.cos(angulo)));

                  
                x=(int) (x*.5);
                y=(int) (y*.5);     
                                                            
                 x=(int) x+400;
                 y=(int) y+200;
                 
                if(x<0){
                  x= x*-1;                
                }
                if(y<0){
                  y= y*-1;                
                } 
                 
                
                 double[] bgr = originalImage.get(row, col);
                  rotate.put(x,y, bgr);
//                   System.out.println("("+x+","+y+")");                     
                                                                
//               
//                b = rgb1[0] / 9 + rgb2[0] / 9 + rgb3[0] / 9 + rgb4[0] / 9 + rgb5[0] / 9 + rgb6[0] / 9 + rgb7[0] / 9 + rgb8[0] / 9 + rgb9[0] / 9;
//                g = rgb1[1] / 9 + rgb2[1] / 9 + rgb3[1] / 9 + rgb4[1] / 9 + rgb5[1] / 9 + rgb6[1] / 9 + rgb7[1] / 9 + rgb8[1] / 9 + rgb9[1] / 9;
//                r = rgb1[2] / 9 + rgb2[2] / 9 + rgb3[2] / 9 + rgb4[2] / 9 + rgb5[2] / 9 + rgb6[2] / 9 + rgb7[2] / 9 + rgb8[2] / 9 + rgb9[2] / 9;
                
//                       b=rgb1[0]*-2+rgb2[0]*-1+rgb3[0]*0+rgb4[0]*-1+rgb5[0]*1+rgb6[0]*1+rgb7[0]*0+rgb8[0]*1+rgb9[0]*2;
//                       g=rgb1[1]*-2+rgb2[1]*-1+rgb3[1]*-0+rgb4[1]*-1+rgb5[1]*1+rgb6[1]*1+rgb7[1]*0+rgb8[1]*1+rgb9[1]*2;
//                       r=rgb1[2]*-2+rgb2[2]*-1+rgb3[2]*0+rgb4[2]*-1+rgb5[2]*1+rgb6[2]*1+rgb7[2]*0+rgb8[2]*1+rgb9[2]*2;

//                       r=rgb1[0]*0+rgb2[0]*1+rgb3[0]*0+rgb4[0]*1+rgb5[0]*-4+rgb6[0]*1+rgb7[0]*0+rgb8[0]*1+rgb9[0]*0;
//                       g=rgb1[1]*0+rgb2[1]*1+rgb3[1]*0+rgb4[1]*1+rgb5[1]*-4+rgb6[1]*1+rgb7[1]*0+rgb8[1]*1+rgb9[1]*0;
//                       b=rgb1[2]*0+rgb2[2]*1+rgb3[2]*0+rgb4[2]*1+rgb5[2]*-4+rgb6[2]*1+rgb7[2]*0+rgb8[2]*1+rgb9[2]*0;
//                newImage.put(row, col, new double[]{b, g, r});
//                 newImage.put(row, col, mayor(colors));
//                 QuickSort.parte(colors);
//                 newImage.put(row, col, new double[]{QuickSort.getMedianB(),QuickSort.getMedianG(), QuickSort.getMedianR()});
//                 colors.clear();

                   
            }
            
        }

       
        return rotate;
    }

    private double[] rellenaNull(double[] vectorNull) {

        vectorNull = new double[3];

        vectorNull[0] = 255;
        vectorNull[1] = 255;
        vectorNull[2] = 255;

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

    private ArrayList mayor(ArrayList colores) {
        double[] b = new double[9];
        double[] g = new double[9];
        double[] r = new double[9];
        double[] aux = new double[3];
        double ponderacion=0.0;
        ArrayList coloresAux = colores;
        DecimalFormat formato1 = new DecimalFormat("#.00");
        for (int i = 0; i < colores.size(); i++) {
            aux = (double[]) colores.get(i);
            b[i] = aux[0];
            g[i] = aux[1];
            r[i] = aux[2];
        }
        
//        aux[0]=encuentra(b);
//        aux[1]=encuentra(g);
//        aux[2]=encuentra(r);
//        
//        ponderacion = aux[0]/255;        
//        ponderacion= Double.parseDouble(formato1.format(ponderacion));
//        mayorb+=ponderacion;
//        for (int i = 0; i < 9; i++) {
//            if(b[i]!=aux[0]){
//                b[i] +=ponderacion ;
//            }                        
//        }
//        
//         ponderacion = aux[1]/255;
//          ponderacion= Double.parseDouble(formato1.format(ponderacion)); 
//          mayorg+=ponderacion;
//         for (int i = 0; i < 9; i++) {
//            if(g[i]!=aux[1]){
//                g[i] +=ponderacion ;
//            }                        
//        }
//          ponderacion = aux[2]/255;
//          ponderacion= Double.parseDouble(formato1.format(ponderacion));   
//          mayorr+=ponderacion;
//          for (int i = 0; i < 9; i++) {
//            if(r[i]!=aux[2]){
//                r[i] +=ponderacion ;
//            }                        
//        }
        coloresAux.clear();
        coloresAux.add(b);
        coloresAux.add(g);
        coloresAux.add(r);
        
        return coloresAux;
    }

    private double encuentra(double[] array) {
        
        
        
        double mayor =0;
        double ponderacion=0.0;
        
        for (int i = 0; i < array.length; i++) {
            // System.out.println(nombres[i] + " " + sueldos[i]);
            if (array[i]> mayor) { // 
                mayor = array[i];
            }
            
        }               
       return mayor;

    }
    
    
    
//     private double[] mayor(ArrayList colores) {
//        double[] b = new double[9];
//        double[] g = new double[9];
//        double[] r = new double[9];
//        double[] aux = new double[3];
//        for (int i = 0; i < colores.size(); i++) {
//            aux = (double[]) colores.get(i);
//            b[i] = aux[0];
//            g[i] = aux[1];
//            r[i] = aux[2];
//        }
//        
//        aux[0]=encuentra(b);
//        aux[1]=encuentra(g);
//        aux[2]=encuentra(r);
//        
//        return aux;
//    }

    
   
}
