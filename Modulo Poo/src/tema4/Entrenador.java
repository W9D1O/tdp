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
public class Entrenador extends Empleado{
    private int campeonatosGanados;

    public Entrenador(int campeonatosGanados, String nombre, double sueldoBasico, int antiguedad) {
        super(nombre, sueldoBasico, antiguedad);
        this.setCampeonatosGanados(campeonatosGanados);
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }

    public int getCampeonatosGanados() {
        return this.campeonatosGanados;
    }
    
    @Override
    public double calcularEfectividad(){
        return (double)this.getCampeonatosGanados() / this.getAntiguedad();
    }
    
    @Override
    public double calcularSueldoACobrar(){
        double aCobrar = this.getSueldoBasico() + (this.getSueldoBasico()*0.10)
                                                * this.getAntiguedad();
        if(this.getCampeonatosGanados() > 0 && this.getCampeonatosGanados() < 5){
            aCobrar += 5000;
        }else if(this.getCampeonatosGanados() > 0 && this.getCampeonatosGanados() < 11)
            aCobrar += 30000;
        else if(this.getCampeonatosGanados() > 0 && this.getCampeonatosGanados() > 10)
            aCobrar +=5000;
        return aCobrar;
    }
    
    @Override
    public String toString(){
        return super.toString() + " Sueldo a cobrar: " + 
                this.calcularSueldoACobrar();
    }
}
