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
public class Double {
    private int grados;
    private int minutos;
    private int segundos;
    
    public Double(int grados,int minutos,int segundos){
        this.setGrados(grados);
        this.setMinutos(minutos);
        this.setSegundos(segundos);
    }

    public void setGrados(int grados) {
        this.grados = grados;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getGrados() {
        return grados;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }
    
    
    
}
