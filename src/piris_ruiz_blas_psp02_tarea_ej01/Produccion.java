/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package piris_ruiz_blas_psp02_tarea_ej01;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bpiris
 * CLASE QUE GENERA UN STRING AL ALMACENAMIENTO
 */
public class Produccion extends Thread {
    
    Almacenamiento buffer;
   final String[] caracteres={"Q","W","E","R","T","Y","U","I","O","P","A",
    "S","D","F","G","H","J","K","L","Ñ","Z","X","C","V","B","N","M"};
    int cProducidas;
    final int MAX=15;
    
    public Produccion(Almacenamiento buffer){
    this.buffer=buffer;
    this.cProducidas=0;
    }
    
    
    //METODO RUN QUE GENERARÁ UN STRING PARA EL ALMACENAMIENTO UN MAXIMO DE 15 VECES
    public void run(){
        //REALIZAREMOS LA PRODUCCION SUEMPRE Y CUANDO NO SE HAYAN PRODUCIDO MAS CARACTERES QUE EL MAXIMO
    while(cProducidas<MAX){
        try {
            //GENERAMOS UN CARACTER RANDOM, LO AÑADIMOS AL ALMACENAMIENTO Y SUMAMOS UNO EN EL CONTADOR. MOSTRAMOS EL CARACTER
            int ran = new Random().nextInt(caracteres.length);
            String cProducido=caracteres[ran];
            buffer.generar(cProducido);
            cProducidas++;
            System.out.println("Producido caracter "+cProducido);
            System.out.println("Caracteres producidos "+cProducidas);
            System.out.println(buffer.toString());
            System.out.println("--------------------");
            
            //DORMIMOS EL PROCESO POR UN TIEMPO ALEATORIO ENTRE 0 Y 5 SEGUNDOS
            sleep((long) (Math.random()*5000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Produccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    
}
