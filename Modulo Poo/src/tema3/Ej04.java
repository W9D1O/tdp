package tema3;

import PaqueteLectura.GeneradorAleatorio;

public class Ej04 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int maxHotel = 3;
        Hotel losAromos = new Hotel(maxHotel);
        //Habitacion habitacion1 = new Habitacion();
        Cliente cli1 = new Cliente("damian",203432,55);
        losAromos.setHabitacion(cli1, 2);
        //losAromos.getHabitacion(0)
        System.out.println("Antes del aumento.");

        for(int i = 0; i < maxHotel; i++){
        System.out.println(losAromos.toString(i));
        }

        System.out.println("Después del aumento.");
        losAromos.setAumentos(12000);
        losAromos.getHabitacion(0).setAumento(10000);
        for(int j = 0; j < maxHotel; j++){
            System.out.println(losAromos.toString(j));
        }
        
    }

}
