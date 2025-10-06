/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
import PaqueteLectura.Lector;

/**
 *
 * @author Zzz
 */
public class Ej03vCompa {
     public static void main (String[] args){
       
     
        int MAXCUPOS = 20;
        int cantcupos = 0;
        int dias,entrevistas;
        String nombre;
        Persona matriz [][] = new Persona[5][8];
        
        
        Persona p1;
        p1=new Persona();
        System.out.println("Ingrese un nombre");
        nombre = Lector.leerString();
        dias = 0; 
        
         while ((dias < 5)&& (cantcupos <MAXCUPOS)&& !(nombre.equals("ZZZ"))){
            entrevistas = 0;
        
           while ((entrevistas < 8) && (cantcupos < MAXCUPOS)&& !(nombre.equals("ZZZ"))){
           new Persona();
         
         System.out.println("Ingrese un DNI");
         p1.setDNI(Lector.leerInt());
        
         System.out.println("Ingrese una edad");
         p1.setEdad(Lector.leerInt());
         
          System.out.println("Ingrese el nombre: ");
          p1.setNombre(Lector.leerString());
   
         
          matriz[dias][entrevistas] = p1;
          entrevistas++;
          cantcupos++;
        
    
        }
           dias++;
      
     }
          for (dias = 0 ;dias < 5 ; dias++){
               System.out.println("Dia: "+( dias+1));
            for (entrevistas = 0; entrevistas <8; entrevistas++){
                if( matriz[dias][entrevistas]!=null)
                  System.out.println(" Entrevista: "+ (entrevistas+1)+": "+ matriz[dias][entrevistas].getNombre());
                
             
            }
          }
     }
}
