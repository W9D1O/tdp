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
public class SistemaM extends Registro{

    public SistemaM(int anio, int cantAnio, String nombre, double latitud, double longitud) {
        super(anio, cantAnio,nombre, latitud, longitud);
    }
    
    @Override
    public double getPromedio(int n){
        double promedio = 0;
        for(int i = 0;i < this.getCantAnio(); i++){
            promedio += this.getTemperatura(i, n%this.getMeses());
    }
        return promedio / this.getCantAnio();
    }
    

}
