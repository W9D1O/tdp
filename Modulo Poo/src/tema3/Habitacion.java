/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
import PaqueteLectura.GeneradorAleatorio;

public class Habitacion {
    private short limInf = 2000;
    private short limSup = 8000;
    private double costo;

    private boolean ocupada;
    private Cliente cliente;
    
    public Habitacion(){
        this.ocupada = false;
        this.costo = GeneradorAleatorio.generarDouble(limSup + 1) + limInf;

}
    public Habitacion(Cliente reservo){
        this.ocupada = true;
        this.cliente = reservo;
        this.costo = GeneradorAleatorio.generarDouble(limSup + 1) + limInf ;

    }
    
    public void setAumento(double aum){
        this.costo += aum;
    }

    public boolean isOcupada() {
        return ocupada;
    }
    public double getCosto(){
        return this.costo;
    }

    public Cliente getCliente() {
        
        if(!this.ocupada){
            System.out.println("La habitacion se encuentra libre.");
            this.cliente = null;
        }
        return this.cliente;
    }


    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setCliente(Cliente ocupante) {
        this.cliente = ocupante;
    }
    
    @Override
    public String toString(){
        String aux = "Libre";
        if(this.ocupada){
            aux = "ocupada";
        }
        return "La habitacion se encuentra " + aux + "Los datos del cliente son: " + this.cliente;
    }
    }

