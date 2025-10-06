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
public class Autor {
    private String nombre;
    private String biografia;
    private String origen;
    
    
    public Autor(String nom, String bio, String orig){
    nombre = nom;
    biografia = bio;
    origen = orig;
    }
    
    public Autor(){
        
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getBiografia(){
        return biografia;
    }
    public String getOrigen(){
        return origen;
    }
    public void setNombre(String nom){
        nombre = nom;
    }
    public void setBiografia(String bio){
        biografia = bio;
    }
    public void setOrigen(String orig){
        origen = orig;
    }
    
    @Override
    public String toString(){
        String aux;
        aux = nombre + ", " + biografia +". "+ origen;
        return aux;
    }
}

