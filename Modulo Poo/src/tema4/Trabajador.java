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
public class Trabajador extends Persona{
    private String ocupacion;
    public Trabajador(String unNombre, int unDNI, int unaEdad,String ocupacion) {
        super(unNombre, unDNI, unaEdad);
        this.ocupacion = ocupacion;
    }

    public Trabajador() {
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
    @Override
    public String toString(){
        return super.toString() + " Ocupacion: " + this.getOcupacion();
    }
}
