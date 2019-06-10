/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.ArrayList;
import java.util.ArrayList;

/**
 *
 * @author LINK5
 */
public class QuickSort {

    private static double medianB=0,medianG=0,medianR=0;
    
    public QuickSort() {
    }

   public static double[] quickSort(double[] arr, int start, int end){
 
        int partition = partition(arr, start, end);
 
        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
        
        return arr;
    }
     public static int partition(double[] arr, int start, int end){
        double pivot = arr[end];
 
        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                double temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }
 
        double temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
 
        return start;
    }
   

    public static void parte(ArrayList colores) {
        double[] b = new double[9];
        double[] g = new double[9];
        double[] r = new double[9];
        double[] aux = new double[3];
        for (int i = 0; i < colores.size(); i++) {
            aux = (double[]) colores.get(i);
            b[i] = aux[0];
            g[i] = aux[1];
            r[i] = aux[2];
        }
        b=quickSort(b, 0, b.length-1);
        medianB = b[((b.length+1)/2)-1];
        g=quickSort(g, 0, g.length-1);
        medianG = g[((g.length+1)/2)-1];
        r=quickSort(r, 0, r.length-1);
        medianR = r[((r.length+1)/2)-1];
        
    }

    public static double getMedianB() {
        return medianB;
    }

    public static double getMedianG() {
        return medianG;
    }

    public static double getMedianR() {
        return medianR;
    }
    
    
}
