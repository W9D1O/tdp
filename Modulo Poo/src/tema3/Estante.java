/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Zzz
 */
public class Estante {
    //private final int capacidad = 20;
    private int capacidad;
    private Libro[] lugares = null;
    private int dimL = 0;
    //private Libro lugares[] = null;
    
    public Estante(){
        
    }
    public Estante(int n){
       setCapacidad(n);     
    }
    
    //(i)
    public int getLibrosAlmacenados(){

        return this.dimL;
    }
    
    //(ii)
    public boolean getEstaLleno(){

        return this.dimL == capacidad;

    }
    
    private void setDimL(){
        this.dimL += 1;
    }

    //(iii)
    public void addLibro(Libro unLibro){
        //Get Libros almacenados me devuelve la cantidad de libros que tengo.
        //Esto es igual a la pocicion del libro + 1
    
        if(this.dimL < capacidad){
            lugares[this.dimL] = unLibro;
            setDimL();
        }

        else
            System.out.println("El estante está completo");
    }

    
    public void setCapacidad(int n){
        capacidad = n;
        lugares = new Libro[capacidad];
    }
    
    //Puede devolver null, para mi esto es un problema.
    //(iv)
    public Libro getLibro(String nomL){
        int cont = 0;
        Libro aux = null;
        if( lugares != null){
            while(cont < this.dimL && !lugares[cont].getTitulo().equals(nomL)){
                cont++;
            }
        }
        if(cont < capacidad && lugares[cont].getTitulo().equals(nomL))
            aux = lugares[cont];
        System.out.println("El libro no existe.");
        return aux;
    }
    
}
