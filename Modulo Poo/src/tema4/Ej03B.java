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
public class Ej03B {
    public static void main(String[] coso){
        Persona p1 = new Trabajador("Fulano",99999999,99,"Peón Orco");
        Persona p2 = new Persona("Cosme",99999998,99);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        
    }
}
