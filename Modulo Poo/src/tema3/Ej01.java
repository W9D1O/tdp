/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
import PaqueteLectura.Lector;

/**
 *
 * @author Zzz
 */
public class Ej01 {
    public static void main(String[] coso){
        Triangulo t = new Triangulo();
        double lado;
        System.out.println("Ingrese lado A del triangulo: ");
        lado = Lector.leerDouble();
        t.setLadoA(lado);
        System.out.println("Ingrese lado B del triangulo: ");
        lado = Lector.leerDouble();
        t.setLadoB(lado);
        System.out.println("Ingrese lado C del triangulo: ");
        lado = Lector.leerDouble();
        t.setLadoC(lado);
        System.out.println(t.calcularPerimetro());
        System.out.println(t.calcularArea());       
    }

    
   
}
