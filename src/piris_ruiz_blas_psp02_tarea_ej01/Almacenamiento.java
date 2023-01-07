/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package piris_ruiz_blas_psp02_tarea_ej01;

import java.util.Arrays;

/**
 *
 * @author bpiris
 * CLASE QUE GENERA EL ALMACENAMIENTO DEL BUFFER 
 */
public class Almacenamiento {
    String[] almacenamiento;
    int valorSiguiente;
    String valAlm;

   Almacenamiento(int longitudAmacenamiento){
        this.almacenamiento=new String[longitudAmacenamiento];
        this.valorSiguiente = 0;
        this.valAlm = "vacia";
    }
   
      //METODO QUE GENERA UN STRING EN EL ALMACENAMIENTO
     public synchronized void generar(String c) throws InterruptedException{
         
         //MIENTRAS QUE ESTÉ LLENA, ESPERAMOS
         while(valAlm.equals("llena")){
             wait();
         }
         
         //ALMACENAMOS EL CARACTER GENERADO ,SUMAMOS UNO E INDICAMOS QUE NO ESTA VACIO
         this.almacenamiento[this.valorSiguiente]=c;
         this.valorSiguiente++;
         this.valAlm="disponible";
         
         //SI EL VALOR SIGUIENTE ES IGUAL AL TOPE DE ALMACENAMIENTO, INDICAMOS QUE ESTA LLENA
         if(this.valorSiguiente==this.almacenamiento.length){
         this.valAlm="llena";
         }
         
         //NOTIFICAMOS 
         notifyAll();
    }

    
    //METODO QUE CONSUME UN STRING DEL ALMACENAMIENTO 
    public synchronized String consumir() throws InterruptedException{
        
        //MIENTRAS QUE ESTÉ VACIA, ESPERAMOS
         while(valAlm.equals("vacia")){
             wait();
         }
         
         //RESTAMOS UNO E INDICAMOS QUE NO ESTA LLENA
         this.valorSiguiente--;
          this.valAlm="disponible";
         
         //SI EL VALOR SIGUIENTE ES IGUAL A 0, INDICAMOS QUE EL ALMACENAMIENTO ESTA VACIO
         if(this.valorSiguiente==0){
         this.valAlm.equals("vacia");
         }
     
        //NOTIFICAMOS 
         notifyAll();
         //RECOGEMOS EL STRING DEL CARACTER, PONEMOS ESA POSCION DEL ARRAY NULA Y DEVOLVEMOS EL STRING
        String c= this.almacenamiento[this.valorSiguiente];
        this.almacenamiento[this.valorSiguiente]=null;
         return c;
    }

     //METODO TOSTRING QUE NOS DEVUELVE LOS ELEMENTOS ALMACENADOS
       @Override
    public String toString() {
        return "Almacenamiento " + Arrays.toString(almacenamiento) ;
    }
    
    
    
    
    
}
