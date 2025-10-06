/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Zzz
 */
public class Ej04 {
    static void InitMatriz(int e[][]){
        for(int i = 0; i < 8; i++){
            for(int j = 0;j < 4; j++){
                e[i][j] = 0;
            }
        }
    }
    static void LeerConcurrencia(int e[][]){
        int p,o;
        p = GeneradorAleatorio.generarInt(9) + 1;
        while(p != 9){
            o = GeneradorAleatorio.generarInt(4) + 1;
            e[p - 1][o - 1] ++;
            p = GeneradorAleatorio.generarInt(9) + 1;
        }
    }
    
    static void ImpConcurrencia(int e[][]){
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 4; j++){
                System.out.printf("Piso N°: %d. Oficina N°: %d\n", i+1,j+1);
                System.out.println(e[i][j]);
            }
          
        }
    }
    
    public static void main(String[] args){
        int edificio[][] = new int[8][4];
        GeneradorAleatorio.iniciar();
        InitMatriz(edificio);
        LeerConcurrencia(edificio);
        ImpConcurrencia(edificio);
        
    }
    
}
