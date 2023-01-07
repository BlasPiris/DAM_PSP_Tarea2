/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package piris_ruiz_blas_psp02_tarea_ej01;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bpiris
 * CLASE QUE VA A REALIZAR EL CONSUMO DE LOS ELEMENTOS ALMACENADOS
 */
public class Consumo extends Thread {
    
    Almacenamiento buffer;
    int cConsumidas;
    final int MAX=15;
    
    public Consumo(Almacenamiento buffer){
    this.buffer=buffer;
    this.cConsumidas=0;
    }
    
    //METODO RUN QUE CONSUMIRÁ ELEMENTOS DEL ALMACENAMIENTO HASTA UN MAXIMO DE 15 VECES
    public void run(){
        //REALIZAREMOS UN CONSUMO SIEMPRE QUE NO SE HAYA LLEGADO AL MAXIMO
    while(cConsumidas<MAX){
        try {
            //RECOGEMOS EL STRING DEL CARACTER CONSUMIDO, SUMAMOS UNO EN EL CONTADOR DE CARACTERES Y LO SACAMOS POR PANTALLA
            String cConsumido = buffer.consumir();
            cConsumidas++;
            System.out.println("Consumido caracter "+cConsumido);
            System.out.println("Caracteres consumidos "+cConsumidas);
            System.out.println(buffer.toString());
            System.out.println("--------------------");
            
            //DORMIMOS EL PROCESO POR UN TIEMPO ALEATORIO ENTRE 0 Y 5 SEGUNDOS
            sleep((long) (Math.random()*5000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
}
