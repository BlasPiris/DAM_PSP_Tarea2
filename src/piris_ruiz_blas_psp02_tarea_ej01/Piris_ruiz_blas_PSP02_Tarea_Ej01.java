/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package piris_ruiz_blas_psp02_tarea_ej01;

/**
 *
 * @author bpiris
 */
public class Piris_ruiz_blas_PSP02_Tarea_Ej01 {
    
    //VARIABLE DEL NUMERO DE VALORES QUE TENDRÁ EL ALMACENAMIENTO
    final static int NUM_CAR_ALM=6;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
       
        //INSTANCIAMOS EL ALMACENAMIENTO, LA PRODUCCION Y EL CONSUMO
       Almacenamiento b=new Almacenamiento(NUM_CAR_ALM);
       Produccion p=new Produccion(b);
       Consumo c=new Consumo(b);
       
       //INICIAMOS LA PRODUCCION Y 5 SEGUNDOS DESPUES, EL CONSUMO
       p.start();
       Thread.sleep(5000);
       c.start();
       
    }
    
}
