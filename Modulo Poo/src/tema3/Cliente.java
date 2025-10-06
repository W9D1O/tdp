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
public class Cliente {
    private String nombre;
    private int    dni;
    private int  edad;
    
    public Cliente(String nom,int dni,int edad){
        this.nombre = nom;
        this.dni = dni;
        this.edad = edad;
    }
    
    public Cliente(){
        
    }
    
    
    public int getDni(){
        return dni;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setDni(int dni){
        this.dni = dni;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public void setNombre(String nom){
        nombre = nom;
    }
    
    @Override
    public String toString(){
        return "El nombre del cliente es: " + nombre
                + ", su edad es: "+ edad + " , con DNI: " + dni;
    }
}
