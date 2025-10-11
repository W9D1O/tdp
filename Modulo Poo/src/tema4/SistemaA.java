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
public  class SistemaA extends Registro{

    public SistemaA(int anio, int cantAnio, String nombre, double latitud, double longitud) {
        super(anio, cantAnio, nombre, latitud, longitud);
    }
    
    @Override
    public double getPromedio(int n){
        double promedio = 0;
        
        for(int i = 0; i < this.getMeses(); i++){
            promedio += this.getTemperatura(n/this.getMeses() + this.getAnio(), i);
        }
        return promedio / this.getMeses();
    }
    

    
}
