/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Zzz
 */
public class Ej01F {
    public static void main(String[] coso){
        Figura triangulo = new Triangulo(12,14,22,"rojo","azul");
        Figura circulo = new Circulo("violeta","verde",17);
        System.out.println(triangulo.toString());
        System.out.println(circulo.toString());
        triangulo.despintar();
        circulo.despintar();
        System.out.println(triangulo.toString());
        System.out.println(circulo.toString());
    }
}
