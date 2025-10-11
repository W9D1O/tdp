/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Zzz
 */
public class Ej04f {
    public  static void cargarTabla(Registro sis){
        double temp;
        
        for(int i = 0; i < sis.getCantAnio()*sis.getMeses(); i++){
            temp = GeneradorAleatorio.generarDouble(100);
            //System.out.println(temp);
            sis.setTemperatura(i%sis.getMeses(), i/sis.getMeses() + sis.getAnio(), temp);
        }
    }

    public static void main(String[] coso){
        GeneradorAleatorio.iniciar();
        Registro sisA = new SistemaA(2021,3,"La Plata",-34.921,-57.955);
        //Registro sisM = new SistemaM(2020,4,"Mar del Plata",-38.002,-57.556);
        cargarTabla(sisA);
        //cargarTabla(sisM);
        //impTabla(sisA);
        //impTabla(sisM);
        //impTabla(sisA);
        //sisA.setTemperatura(7, sisA.getAnio() + 1, 17);
        //System.out.println(sisM.toString(2022));
        //System.out.println(2022%12);
        for(int i = 0; i < sisA.getCantAnio(); i++)
        System.out.println(sisA.toString(i*sisA.getMeses()));
        
    }
}
