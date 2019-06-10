/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelmanipulation_refactor;

import org.opencv.core.Mat;

/**
 *
 * @author LINK5
 */
public class Filters {
    
    private static double[] newSpec;
    
    public static Mat addBrightness(Mat image,int level){
      
            
             for (int i = 0; i < image.rows(); i++) {
                for (int j = 0; j < image.cols(); j++) {
                    newSpec = image.get(i, j);
                    newSpec[0] = newSpec[0] + level;
                    newSpec[1] = newSpec[1] + level;
                    newSpec[2] = newSpec[2] + level;
                    image.put(i, j, newSpec);
                }
            }
         newSpec=null;
         return image;        
    }
    
    public static Mat addContrast(Mat image,int level){
        
         for (int i = 0; i < image.rows(); i++) {
                for (int j = 0; j < image.cols(); j++) {
                    newSpec = image.get(i, j);
                    newSpec[0] = lookRange(newSpec[0], level);
                    newSpec[1] = lookRange(newSpec[1], level);
                    newSpec[2] = lookRange(newSpec[2], level);
                    image.put(i, j, newSpec);
                }
            }
         newSpec=null;
         return image;     
    }
    
    private static double lookRange(double color, int level){
    
         double val=0.0;
         if (color>=0 && color <=120){
            return (color-level);
         }else{
            return (color+level);
         }
         
         
    }
    
    public static Mat negative(Mat image){
    
         for (int i = 0; i < image.rows(); i++) {
                for (int j = 0; j < image.cols(); j++) {
                    newSpec = image.get(i, j);
                    newSpec[0] = changeColor(newSpec[0]);
                    newSpec[1] = changeColor(newSpec[1]);
                    newSpec[2] = changeColor(newSpec[2]);
                    image.put(i, j, newSpec);
                }
            }
         newSpec=null;
         return image;                
    }
       
    private static double changeColor(double color){    
        return 255-color;   
    }
    
     public static Mat correctLight(Mat image, int level){
    
         for (int i = 0; i < image.rows(); i++) {
                for (int j = 0; j < image.cols(); j++) {
                    newSpec = image.get(i, j);
                    newSpec[0] =newSpec[0]+ changeLight(newSpec[0],level);
                    newSpec[1] =newSpec[1]+ changeLight(newSpec[1],level);
                    newSpec[2] = newSpec[2]+ changeLight(newSpec[2],level);
                    image.put(i, j, newSpec);
                }
            }
         newSpec=null;
         return image;                
    }
     
     private static double changeLight(double color,double level){   
         double pow = level/10.0;
         double newColor = Math.pow(color, pow);   
        return (int) newColor;
    }
     
     public static Mat toBynary(Mat image,int umbral){
         double[] change;
         for (int i = 0; i < image.rows(); i++) {
                for (int j = 0; j < image.cols(); j++) {
                    newSpec = image.get(i, j);
                    change = changeColor(newSpec, umbral);                   
                    image.put(i, j, change);
                }
            }
         newSpec=null;
         return image;     
    }
     
       private static double[] changeColor(double[] color, int umbral){
         
           double min,max;
                   min=max=color[0];
 
		for(int i = 0; i < color.length; i++)
		{
			if(min>color[i])
			{
				min=color[i];
			}
			if(max<color[i])
			{
				max=color[i];
			}
		}
           
         if (max <=umbral){
            color[0]= color[1]=color[2]=0;
            return color;
         }else{
            color[0]=color[1]= color[2]=255;
            return color;
         }
         
         
    }
     
}
