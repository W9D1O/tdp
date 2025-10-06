/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Zzz
 */
public class Ej02 {
    
    static void initDni(Persona vp[],int max){
        int edad = -1;
        for(int i = 0; i < max; ++i){
            //Es necesario inicializar cada Objeto Persona del array
            //Como si fueran punteros.
            vp[i] = new Persona(); 
            vp[i].setEdad(edad);
        }
    }
    static void cargarDatos(Persona p,int dni,int edad,String nom){
        p.setDNI(dni);
        p.setEdad(edad);
        p.setNombre(nom);
    }
    static void cargarVector(Persona vp[],int max){
        String nom;
        int dni,edad;
        int cont = 0;
        dni = GeneradorAleatorio.generarInt(100);
        nom = GeneradorAleatorio.generarString(6);
        edad = GeneradorAleatorio.generarInt(85);
        while(dni != 0 && cont < max ){
           cargarDatos(vp[cont],dni,edad,nom);
           cont ++;
           dni = GeneradorAleatorio.generarInt(100);
           nom = GeneradorAleatorio.generarString(6);
           edad = GeneradorAleatorio.generarInt(85);
            
        }
    }
    static void informar(Persona vp[],int max){
        int index,cantMayor,dniMenor,posDniMenor;
        int terceraEdad = 65;
        dniMenor = 100000;
        index = cantMayor = 0;
        posDniMenor = -1;
        while(index < max && vp[index].getEdad() != -1){
            if(vp[index].getEdad() > terceraEdad) cantMayor ++;
            if(dniMenor > vp[index].getDNI()){
                dniMenor = vp[index].getDNI();
                posDniMenor = index;
            }
            index ++;
        }
        System.out.printf("La cantidad de personas mayores a %d es de: %d\n",
                            terceraEdad,cantMayor);
        System.out.println(vp[posDniMenor].toString());
        
        
    }
    public static void main(String[] args){
        int max = 15;
        Persona vPersonas[] = new Persona[max];
        initDni(vPersonas,max); //Inicializa las edades del array en -1.
        cargarVector(vPersonas,max); //Carga del vector de tipo Persona.
        informar(vPersonas,max);
        
        
    }
}
