/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
//Paso 1. importar la funcionalidad para generar datos aleatorios



public class Ej03Matrices {
    static void CargarMatriz(int m[][],int max){
                 for(int i = 0; i < max; ++i){
             for(int j = 0; j < max; ++j){
                 m[i][j] = GeneradorAleatorio.generarInt(100);
             }
         }
    }
        static void ImpMatriz(int m[][],int max){
                 for(int i = 0; i < max; ++i){
             for(int j = 0; j < max; ++j){
                 if(m[i][j] > -10 && m[i][j] < 10){
                     System.out.print(" ");
                     System.out.print(m[i][j]);
                 }else{
                     System.out.print(m[i][j]);
                 }
                 
                 System.out.print(" ");
             }
             System.out.println();
         }
    }
     static int SumaVector(int v[],int max){
         int acu = 0;
         for(int i = 0; i < max; ++i){
             acu += v[i];
         }
         return acu;
     }
     
     /*Vamos a entender que lo que hjay que hacer es sumar las columnas
     y almacenarlas en las pocisiones del array.
     */
     static void SumaColumnas(int m[][],int v[],int max){
         for(int i = 0; i < max; ++i){
             for(int j = 0; j < max; j++){
                 v[i] += m[j][i];
             }
         }
     }
     static void InitVector(int v[],int max){
         for(int i = 0; i < max;i++){
             v[i] = 0;
         }
     }
     static void ImpVector(int v[],int m){
         for(int i = 0; i < m; i++){
             System.out.printf("%d ", v[i]);
         }
         System.out.println();
     }
     
     static void Buscar(int m[][],int max){
         int n;
         System.out.println("Ingrese un número: ");
         n = Lector.leerInt();
         int i = 0;
         int j = 0;
         while(i < max  && m[i][j] != n){
                j++;
             if(j == max-1 && m[i][j] != n){
                 j = 0;
                 i++;
             }
         
         
         }
         if(i == max)
            System.out.println("No se encontro el numero");
         else
             System .out.printf("%d %d\n", i,j);
             
     }
     
    public static void main(String[] args) {
	    //Paso 2. iniciar el generador aleatorio     
         GeneradorAleatorio.iniciar();
         int max = 5;   
	 int m[][] = new int[max][max];
         CargarMatriz(m,max);
         ImpMatriz(m,max);
         int sum = SumaVector(m[1],max);
         System.out.println(sum);
         int vs[] = new int[max];
         InitVector(vs,max);
         SumaColumnas(m,vs, max);
         ImpVector(vs,max);
         Buscar(m,max);
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        
        //Paso 4. mostrar el contenido de la matriz en consola
    
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
    
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.

        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".

    }
}
