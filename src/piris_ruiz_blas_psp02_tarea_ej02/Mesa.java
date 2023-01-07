/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package piris_ruiz_blas_psp02_tarea_ej02;

import java.util.concurrent.Semaphore;
import static piris_ruiz_blas_psp02_tarea_ej02.Piris_ruiz_blas_PSP02_Tarea_Ej02.NUM_FILOSOFOS;

/**
 *
 * @author bpiris
 * CLASE MESA QUE GESTIONARÁ EL USO DE LOS PALILLOS
 */
public class Mesa {
    
    Semaphore[] palillos;
    int nPalillos;
    
    //CREAMOS UN CONTRUCTOR PARA GENERAR UN SEMAFORO DE PALILLOS DEL MISMO 
    //TAMAÑO QUE FILOSOFOS TENEMOS EN LA MESA
    Mesa (int nFilosofos) throws InterruptedException{
        this.palillos=new Semaphore[nFilosofos];
        this.nPalillos=nFilosofos;
        
        //GENERAR PALILLOS
        for(int i=0;i<nPalillos;i++){
            this.palillos[i]=new Semaphore(1);
        }
        
        //GENERAR FILOSOFOS
        for(int i=1;i<=nFilosofos;i++){
       Filosofo f=new Filosofo(this,i);
       f.start();
       Thread.sleep(5000);
        }
        
    }
    
    
    //METODO QUE DEVUELVE EL PALILLO IZQUIERDO
    public int palilloIzq(int i){
        return i;
    }
    
    //METODO QUE DEVUELVE EL PALILLO DERECHO
      public int palilloDer(int i){
          
          //SI EL PALILLO ES 0, DEVOLVEMOS EL NUMERO DE PALILLOS -1
          if(i==0){
          return nPalillos-1;
          }else{
          return i-1;
          }
    }
     
     //METODO QUE COGE LOS PALILLOS DE UN FILOSOFO
    public void usarPalillos(int idFilosofo,int filosofo) throws InterruptedException{
        //SI LOS PALILLOS ESTAN DISPONIBLES, SE PROCEDERAN A COGER, SI YA ESTAN COGIDOS,EL HILO FINALIZARÁ
        this.palillos[this.palilloIzq(idFilosofo)].acquire();
        this.palillos[this.palilloDer(idFilosofo)].acquire(); 
    }
    
    //METODO QUE SUELTA LOS PALILLOS DE UN FILOSOFO
     public void soltarPalillos(int idFilosofo,int filosofo){
         
         //MOSTRAMOS POR PANTALLA LOS PALILLOS QUE SE SUELTAN
          System.out.println("FILOSOFO "+filosofo+" SUELTA PALILLOS \n"
               +"IZQUIERDO: "+(this.palilloIzq(idFilosofo)+1)+" "
               +"DERECHO: "+(this.palilloDer(idFilosofo)+1)+"\n-------------------------------");
          
          
         //LIBERAMOS LOS PALILLOS
        this.palillos[this.palilloIzq(idFilosofo)].release();
        this.palillos[this.palilloDer(idFilosofo)].release();
    }
     
   //METODO QUE COMPRUEBA SI LOS PALILLOS ESTAN LIBRES O EN USO 
     public void comprobarPalillos(){
         String str="";
         for(int i=0;i<this.nPalillos;i++){
         int used = palillos[i].availablePermits();
            if (used==0) {
               str+=" PALILLO "+(i+1)+ " USO \n ";
            } 
            else 
                if(used==1) {
               str+=" PALILLO "+(i+1)+ " LIBRE \n";
            }else 
                    if(used>1) {
                        str+=" PALILLO "+(i+1)+ " ERROR \n";
                    }
         }
          System.out.println(str+"\n-------------------------------");
     }
     
     
       
    
    
}
