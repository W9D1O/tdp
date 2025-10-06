/*
Demo que crea objetos Libro invocando a los constructores definidos. 
 */
package tema3;

/**
 *
 * @author vsanz
 */
public class Demo01ConstructoresLibro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Autor aux = new Autor("Herbert Schildt","Schildt posee títulos de posgrado...","Estados Unidos");
        Libro libro1= new  Libro( "Java: A Beginner's Guide",   
                                 "Mcgraw-Hill", 2014,   
                                 aux, "978-0071809252", 21.72);
        aux = new Autor("John Horton","John Horton is a coding and"
                + " gaming enthusiast based in the UK","UK");
        Libro libro2= new Libro("Learning Java by Building Android Games",  
                              "CreateSpace Independent Publishing", 
                               aux, "978-1512108347");
        //System.out.println(libro1.toString());
        //System.out.println(libro2.toString());
        //System.out.println("Precio del libro2: " +libro2.getPrecio());
        //System.out.println("Año edición del libro2: " +libro2.getAñoEdicion());
        System.out.println(libro2.getPrimerAutor().toString());
        //Libro libro3= new Libro();
        System.out.println(libro2.getPrimerAutor());
        //System.out.println(libro3.getPrimerAutor().getNombre());
    }
    
}
