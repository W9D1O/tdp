
package tema2;

import PaqueteLectura.GeneradorAleatorio;


public class Ej04 {
      static Persona cargarPersona(int edad,int dni,String nom){
        Persona per = new Persona();
        per.setDNI(dni);
        per.setEdad(edad);
        per.setNombre(nom);
        return per;
    }
     
      
      static void informarNombres(Persona c[][], int diaM,int turnoM){
          int dia,turno;
          dia = turno = 0;
          while(dia < diaM){
              while(turno < turnoM){
                  if(c[dia][turno] != null)
                      System.out.println(c[dia][turno].getNombre());
                  turno++;
              }
              turno = 0;
              dia++;
          }
      }
      
    public static void main(String[] coso){
        int maxD = 5;
        int maxT = 8;
        int cont = 0;
        Persona casting[][] = new Persona[maxD][maxT];
        GeneradorAleatorio.iniciar();
        int maxdni = 2000;
        int maxedad = 100;
        String nom;
        int dni,edad;
        int auxT = 0;
        nom = GeneradorAleatorio.generarString(3);
        dni = GeneradorAleatorio.generarInt(maxdni) + 1;
        edad = GeneradorAleatorio.generarInt(maxedad) + 1;
        int diaDes = GeneradorAleatorio.generarInt(maxD);
        //Carga el casting.
        while(!nom.equals("ZZZ") && maxD*maxT > cont){
            if(casting[diaDes][auxT] == null){
            casting[diaDes][auxT] = cargarPersona(edad,dni,nom);
            auxT = 0;
            } else {
                while(auxT < maxT && casting[diaDes][auxT] != null){
                    auxT++;
                }
                if(auxT < maxT){
                    casting[diaDes][auxT] = cargarPersona(edad,dni,nom);
                    auxT = 0;
                }else{
                    System.out.println("El día ingresado se encuentra completo.");
                    auxT = 0;
                    cont--;
                }
            }
            cont++;
            nom = GeneradorAleatorio.generarString(3);
            dni = GeneradorAleatorio.generarInt(maxdni) + 1;
            edad = GeneradorAleatorio.generarInt(maxedad) + 1;
            diaDes = GeneradorAleatorio.generarInt(maxD);
        }
        //Informar Nombres
       informarNombres(casting,maxD,maxT);
    }
    
}
