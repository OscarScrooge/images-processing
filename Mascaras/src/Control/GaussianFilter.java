/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author LINK5
 */
public class GaussianFilter {
    
    
    
    public GaussianFilter( ){
                     
    }
  
    public double GaussianFunction(  ArrayList colors, int position, double targetPixel){
                 DecimalFormat df = new DecimalFormat("#.00");

         double gaussian;
        double standarDeviation = StandarDeviation(colors, position);
//        double exponent = Math.pow(targetPixel, 2)/(2*Math.pow(standarDeviation, 2));
//        exponent = -1*exponent;
       double exponent =(Math.pow(1, 2)+Math.pow(1, 2))/(2*Math.pow(1, 2));
        exponent = -1*exponent;
        gaussian = (1/Math.sqrt(2*Math.PI)*1)*Math.pow(Math.E,exponent);        
        return gaussian;
    }
    
    private double StandarDeviation(ArrayList colors, int position){
        
        double media = dataMedia( colors,  position);
        double[] distancias = distanceList(colors, position, media);
        double sumaDistancias = sumaDistancias(distancias);
        
        double stadarDeiation = Math.sqrt(sumaDistancias/colors.size());
        DecimalFormat df = new DecimalFormat("#.00");
        String deviation = df.format(stadarDeiation);
        
        return Double.parseDouble(deviation);
    }
    
    private double dataMedia(ArrayList colors, int position){
          double media=0;
          double[] temp;
          for(int i=0;i<colors.size();i++){
            temp=(double[]) colors.get(i);
//            System.out.println(temp[position]);
            media+=temp[position];
          } 
          media=media/colors.size();
             DecimalFormat df = new DecimalFormat("#.00");
       String mediaString = df.format(media);
       return Double.parseDouble(mediaString);
    }
    
    private double[] distanceList(ArrayList colors, int position,double media){
        
          double[] distancias = new double[colors.size()];
          double[] temp;
          for(int i=0;i<colors.size();i++){
              temp=(double[]) colors.get(i);
              distancias[i]=Math.pow(temp[position] - media,2);   
                DecimalFormat df = new DecimalFormat("#.00");
                String dist = df.format(distancias[i]);
               distancias[i]=Double.parseDouble(dist);
          }
          return distancias;
    }
    
    private double sumaDistancias(double[] distancias){
    
          double suma=0;
          for(int i=0;i<distancias.length;i++){
              suma+=distancias[i];
          }
          DecimalFormat df = new DecimalFormat("#.00");
          String sum = df.format(suma);
        
          return Double.parseDouble(sum);
    }
    
    
    
    
}
