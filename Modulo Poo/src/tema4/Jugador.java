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
public class Jugador extends Empleado{
    private int partidosJugados;
    private int golesAnotados;

    public Jugador(int partidosJugados, int golesAnotados, String nombre, double sueldoBasico, int antiguedad) {
        super(nombre, sueldoBasico, antiguedad);
        this.setGolesAnotados(golesAnotados);
        this.setPartidosJugados(partidosJugados);
    }
    
    /*public Jugador(){
        this.setGolesAnotados(0);
        this.setPartidosJugados(0);
    }*/
    
    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }
    
    
    @Override
    public double calcularEfectividad(){
        return (double)this.getGolesAnotados() / this.getPartidosJugados();
    }
    
    @Override
    public double calcularSueldoACobrar(){
        double plus = (this.getSueldoBasico()*0.10) * this.getAntiguedad();
        double aCobrar = this.getSueldoBasico() + plus;
        if(this.calcularEfectividad() > 0.5) aCobrar += plus;
        return aCobrar;
    }
    
    @Override
    public String toString(){
        return super.toString() + " Sueldo a cobrar: "
               + this.calcularSueldoACobrar();
    }
}
