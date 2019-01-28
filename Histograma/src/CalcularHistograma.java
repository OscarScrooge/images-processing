
import org.opencv.core.Mat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LINK5
 */
public class CalcularHistograma {

    Mat image;
    int contRojos=0;
    double[][] frecuencias;
     double[] frecuencias2;
     double[] frecuencias3;
     double[] frecuencias4;
    public CalcularHistograma() {    
        
    }
    
    public CalcularHistograma(Mat image) {
        this.image=image;
        frecuencias2= new double[image.cols()*image.rows()];
         frecuencias3= new double[image.cols()*image.rows()];
          frecuencias4= new double[image.cols()*image.rows()];
        recorreImagen(image,llenaColores(image));
    }
    
    
    private void recorreImagen(Mat image,double[][] colores){
         
        int i,j,cont=0;
        
        for(i=0;i<image.rows();i++){
          for(j=0;j<image.cols();j++){
              frecuencias2[cont]=image.get(i, j)[0];
              frecuencias3[cont]=image.get(i, j)[1];
              frecuencias4[cont]=image.get(i, j)[2];
              cont++;              
              colores=cuentaColor(image.get(i, j),colores);              
          }
        }
        imprimeFrecuencias(colores);
    }
    
    private double[][] cuentaColor(double[] pixel,double[][] colores){
        
        for(int i=0;i<colores.length;i++){
            
           if(pixel[0]==colores[i][0]){
              colores[i][1]=colores[i][1]+1;
           }
        }
        
        return colores;
    }
    
    private double[][]  llenaColores(Mat image){
        
        double[][] colores;
        colores= new double[256][2];
        
        for(int i=0;i<=255;i++){
           colores[i][0]=i;
           colores[i][1]=0;
        }
        return colores;
    }
    
    public void imprimeFrecuencias(double[][] frecuencias){
            double sumaPixeles=0;
            
            System.out.println("ROJO");
          for(int i=0;i<=255;i++){
              System.out.println(frecuencias[i][0]+" = " +frecuencias[i][1]+" pixeles");
              sumaPixeles=sumaPixeles+frecuencias[i][1];
          }
          
          System.out.println("AZUL");
          for(int i=0;i<=255;i++){
              System.out.println(frecuencias[i][0]+" = " +frecuencias[i][1]+" pixeles");
              sumaPixeles=sumaPixeles+frecuencias[i][1];
          }
          
          System.out.println("ROJO");
          for(int i=0;i<=255;i++){
              System.out.println(frecuencias[i][0]+" = " +frecuencias[i][1]+" pixeles");
              sumaPixeles=sumaPixeles+frecuencias[i][1];
          }
          this.frecuencias=frecuencias;
    }
    
    public double[] getFrecuencias(){
       return this.frecuencias2;
    }
     public double[] getFrecuencias2(){
       return this.frecuencias3;
    }
      public double[] getFrecuencias3(){
       return this.frecuencias4;
    }
    
}
