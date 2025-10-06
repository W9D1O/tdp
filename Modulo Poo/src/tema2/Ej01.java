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
public class Ej01 {
    static void leerDatos(Persona p1){
        String nom;
        int dni,edad;
        System.out.println("Ingrese un nmombre: ");
        nom = Lector.leerString();
        System.out.println("Ingrese número de DNI: ");
        dni = Lector.leerInt();
        System.out.println("Ingrese edad: ");
        edad = Lector.leerInt();
        p1.setNombre(nom);
        p1.setEdad(edad);
        p1.setDNI(dni);
    }
    public static void main(String[] args){
        Persona p1  = new Persona();
        leerDatos(p1);
        System.out.println(p1.toString());
    }
    
}
