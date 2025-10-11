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
public abstract class Registro extends EstacionMeteorologica{
    private final int meses = 12;
    private int anio;
    private int cantAnio;
    private double[][] temperatura;
    
    public Registro(int anio, int cantAnio,String nombre, double latitud, double longitud) {
        super(nombre, latitud, longitud);
        //int meses = 12;
        this.anio = anio;
        this.cantAnio = cantAnio;
        
        this.temperatura = new double[cantAnio][this.meses];
        //Inicializa las temperaturas a un valor promedio en la plata(?
        for(int i = 0; i < cantAnio*this.meses; i++){
           this.temperatura[i/this.meses][i%this.meses] = 9999999;
        } 
    }
    //private double[this.]

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setCantAnio(int cantAnio) {
        this.cantAnio = cantAnio;
    }

    public int getAnio() {
        return anio;
    }

    public int getCantAnio() {
        return cantAnio;
    }

    public void setTemperatura(int mes,int anio, double temp){
        int i = anio -this.getAnio();
     
        this.temperatura[i][mes] = temp;
    
    }
    
        public double getTemperatura(int anio,int mes){
        int i = anio - this.getAnio();
        //Este valor se inicialica en caso de que no entre el if.
        double temp = 99999999;
        if(i < this.getCantAnio() && mes < this.meses){
               temp = this.temperatura[i][mes];
        }
        return temp;
    }
        
        public int getMeses(){
            return this.meses;
        }
        
        public String getMayorTemperatura(){
            String aux;
            double mayor = -1;
            int x,y;
            x = y = 0;
            for(int i = 0; i < this.getCantAnio()*this.meses; i++){
                if(this.temperatura[i/meses][i%meses] > mayor){
                    mayor = this.temperatura[i/meses][i%meses];
                    x = i/meses;
                    y = i%meses;
                }
            }
            aux = "Mes con mayor temperatura: "+ y + 1 + "Año con mayor temperatura: "
                    + this.getAnio() + x;
            return aux;
        }

public abstract double getPromedio(int n);

    public String toString(int n){
        return super.toString() + " " + this.getPromedio(n) + "\n";
    }

}
