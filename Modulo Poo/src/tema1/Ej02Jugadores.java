
package tema1;
import PaqueteLectura.Lector;
//Paso 1: Importar la funcionalidad para lectura de datos


public class Ej02Jugadores {

  static void CargarVector(double v[],int DF){
      double alt;
        for(int i = 0;i < DF; ++i){
            System.out.println("Ingrese altura: ");
            alt = Lector.leerDouble();
            v[i] = alt;

            
        }
  }
  static double TotalAltura(double v[],int df){
      double acu = 0;
      for(int i = 0; i < df; i++){
          acu += v[i];
      }
      return acu;
  }
  static int CantMayor(double v[],double prom,int df){
      int cant = 0;
      for(int i = 0; i < df; i++){
          if(v[i] > prom) cant += 1;
  }
      return cant;
  }
    public static void main(String[] args) {
        //Paso 2: Declarar la variable vector de double 
        double v[];
        //Paso 3: Crear el vector para 15 double
        int DF = 15;
        v = new double[DF];
        
        //Paso 4: Declarar indice y variables auxiliares a usar
         double prom;
         double acuAlt;
        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        CargarVector(v,DF);
        acuAlt = TotalAltura(v,DF);
        //Paso 7: Calcular el promedio de alturas, informarlo
        prom = acuAlt / DF;
        System.out.println(prom);
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
         int cantidad = CantMayor(v,prom,DF);
        //Paso 9: Informar la cantidad.
        System.out.println(cantidad);
    }
    
}
