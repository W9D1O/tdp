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
public class Ej03 {
    static Persona cargarPersona(int edad,int dni,String nom){
        Persona per = new Persona();
        per.setDNI(dni);
        per.setEdad(edad);
        per.setNombre(nom);
        return per;
    }
    public static void main(String[] coso){
        int maxD = 5;
        int maxT = 8;
        int cont = 0;
        Persona casting[][] = new Persona[maxD][maxT];
        GeneradorAleatorio.iniciar();
        int dimLD = 0;
        int dimLT = 0;
        int maxdni = 2000;
        int maxedad = 100;
        String nom;
        int dni,edad;
        nom = GeneradorAleatorio.generarString(3);
        dni = GeneradorAleatorio.generarInt(maxdni) + 1;
        edad = GeneradorAleatorio.generarInt(maxedad) + 1;
        //Carga el casting.
        while(!nom.equals("ZZZ") && maxD*maxT > cont){
            casting[dimLD][dimLT] = cargarPersona(edad,dni,nom);
            cont++;
            dimLT++;
            if(dimLT == maxT && maxD*maxT > cont){
                dimLT = 0;
                dimLD++;
            } else if(cont == maxD*maxT){
                dimLD++;
            }
        nom = GeneradorAleatorio.generarString(3);
        dni = GeneradorAleatorio.generarInt(maxdni) + 1;
        edad = GeneradorAleatorio.generarInt(maxedad) + 1;
        }
        //Informar Nombres
          for(int i = 0; i < dimLD;i++){
            for(int j = 0; j < dimLT;j++){
                System.out.println(casting[i][j].getNombre());
            }
        }
    }
}
