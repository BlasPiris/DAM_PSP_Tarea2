/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package piris_ruiz_blas_psp02_tarea_ej02;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bpiris
 */
public class Filosofo extends Thread {
    
    Mesa mesa;
    int filosofo;
    int idFilosofo;
    
   Filosofo(Mesa m,int filosofo){
       this.mesa=m;
       this.filosofo=filosofo;
       this.idFilosofo=filosofo-1;
   }
   
   //METODO RUN QUE EJECUTARÁ LAS ACCIONES DEL FILÓSOFO
   public void run(){
       while(true){
           try {
               
                
               //LLAMAMOS AL METODO HAMBRE E INTENTAMOS COGER LOS PALILLOS
               this.hambre();            
               mesa.usarPalillos(this.idFilosofo,this.filosofo); 
               
               //LLAMAMOS AL METODO COMER Y SOLTAMOS LOS PALILLOS
               this.comer();
               mesa.soltarPalillos(this.idFilosofo,this.filosofo);
                
               
           } catch (InterruptedException ex) {
               Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }
   
   
   //METODO HAMBRE QUE INDICARÁ QUE EL FILOSOFO TIENE HAMBRE
   public void hambre() throws InterruptedException{  
       
        System.out.println("FILOSOFO "+this.filosofo+" TIENE HAMBRE\n-------------------------------");
         Thread.sleep(5000);
   }

    //METODO COMER QUE INDICARÁ QUE EL FILOSOFO ESTÁ COMIENDO Y SUS PALILLOS CORRESPONDIENTES
    private void comer() throws InterruptedException {
         System.out.println("FILOSOFO "+this.filosofo+" ESTA COMIENDO CON LOS PALILLOS \n"
               +"IZQUIERDO: "+(mesa.palilloIzq(this.idFilosofo)+1)+" "
               +"DERECHO: "+(mesa.palilloDer(this.idFilosofo)+1)+"\n-------------------------------");
         
         Thread.sleep(5000);
        
       
    }
}

 
              