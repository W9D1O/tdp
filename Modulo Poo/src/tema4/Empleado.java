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
public abstract class Empleado {
    private String nombre;
    private double sueldoBasico;
    private int antiguedad;

    public Empleado(String nombre, double sueldoBasico, int antiguedad) {
        //Preguntar si es válido
        this.setNombre(nombre);
        //this.nombre = nombre;
        this.setSueldoBasico(sueldoBasico);
        //this.sueldoBasico = sueldoBasico;
        this.setAntiguedad(antiguedad);
        //this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    @Override
    public String toString(){
        return "Nombre: " + this.getNombre() + ". Sueldo basico: " +
                this.getSueldoBasico() +
                " Antiguedad: " + this.getAntiguedad() + 
                " Efectividad: " + this.calcularEfectividad();
    }
    
    public abstract double calcularEfectividad();
    
    public abstract double calcularSueldoACobrar();
    

}
