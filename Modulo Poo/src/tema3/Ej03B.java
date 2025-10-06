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
public class Ej03B {
    static void cargarLibro(Libro lib){
        String aux;
        System.out.println("Ingrese atitulo del libro: ");
        aux = Lector.leerString();
        lib.setTitulo(aux);
        if(!lib.getTitulo().equals("ZZZ")){
        Autor autor1 = new Autor();
        System.out.println("Ingrese el nombre del autor: ");
        aux = Lector.leerString();
        autor1.setNombre(aux);
        System.out.println("Ingrese una breve biografia del autor: ");
        aux = Lector.leerString();
        autor1.setBiografia(aux);
        System.out.println("Ingrese origen del autor: ");
        aux = Lector.leerString();
        autor1.setOrigen(aux);
        lib.setPrimerAutor(autor1);
        System.out.println("Ingrese nombre de la Editoria: ");
        aux = Lector.leerString();
        lib.setEditorial(aux);
        System.out.println("Ingrese ISBN: ");
        aux = Lector.leerString();
        lib.setISBN(aux);
        }
    }
    public static void main(String[] coso){
    Estante primerEstante = new Estante();
    Libro lib = new Libro();
    //System.out.println(primerEstante.getEstaLleno());
    int num;
    System.out.println("Ingrese la capacidad maxima del estante: ");
    num = Lector.leerInt();
    primerEstante.setCapacidad(num);
    cargarLibro(lib);
    primerEstante.addLibro(lib);
    while(!primerEstante.getEstaLleno() && !lib.getTitulo().equals("ZZZ")){
        primerEstante.addLibro(lib);
        cargarLibro(lib);
    }
    System.out.println(primerEstante.getEstaLleno());
    
   lib = primerEstante.getLibro("Las mañanitas");
        System.out.println(lib);
    
    }
}

