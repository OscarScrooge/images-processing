/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelmanipulation_refactor;

/**
 *
 * @author LINK5
 */
public class SingletonColors {
    
    private static double[] colorsInstance;
    
    private  SingletonColors(){}
    
    
    public static double[] getColorsInstance(int lenght){
         if(colorsInstance==null){
             colorsInstance = new double[lenght];
             return colorsInstance;
         }
          return colorsInstance;    
    }
}
