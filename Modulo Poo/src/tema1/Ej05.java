/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;
import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Zzz
 */
public class Ej05 {
    static void calificar(int c[][],short cli,short ele){
        for(int i = 0; i < cli;i ++){
            for(int j = 0;j < ele; j++){
                c[i][j] = GeneradorAleatorio.generarInt(10) + 1;
            }
        }
    }
        static void impCalificaciones(int c[][],short cli,short ele){
        for(int i = 0; i < cli;i ++){
            System.out.printf("Cliente N°: %d\n", i+1);
            for(int j = 0;j < ele; j++){
                System.out.printf("%d ",c[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        GeneradorAleatorio.iniciar();
        short clientes = 5;
        short elementos = 4; // Corresponde a las distintas partes de la atención del restaurante.
        int calificaciones[][] = new int[clientes][elementos];
        calificar(calificaciones,clientes,elementos);
        impCalificaciones(calificaciones,clientes,elementos);
        
    }
}
