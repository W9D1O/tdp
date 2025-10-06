/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
import PaqueteLectura.Lector;

/**
 *
 * @author Zzz
 */
public class Ej05 {
    //Devuelve un Partido, si el visitante es "ZZZ" devuelve null.
    static Partido LeerDatos(){
        String e = new String();
        String nomC = new String("ZZZ");
        int goles;
        Partido p = new Partido();
        System.out.println("Ingrese nombre del equipo local: ");
        e = Lector.leerString();
        p.setLocal(e);
        System.out.println("Ingrese la cantidad de goles del equilpo local: ");
        goles = Lector.leerInt();
        p.setGolesLocal(goles);
        System.out.println("Ingrese nombre del equipo visitante: ");
        e = Lector.leerString();
        if(!e.equals(nomC)){
        p.setVisitante(e);
        System.out.println("Ingrese la cantidad de goles del equilpo visitante: ");
        goles = Lector.leerInt();
        p.setGolesVisitante(goles);
            return p;
        }
        return null;
    }
    //Imprime los resultados de los partidos.
    static void informar(Partido c[],int dimL){
        for(int i = 0; i < dimL;i++){
            System.out.printf("%s: %d ", c[i].getLocal(),c[i].getGolesLocal());
            System.out.printf("VS %s: %d\n", c[i].getVisitante(),c[i].getGolesVisitante());
        }
    }
    //Aumenta en uno la variable ganados.
    static int ganoRiver(Partido p,int ganados){
        if(p.hayGanador() && p.getGanador().equals("river")){
            ganados++;
        }
        return ganados;
    }
    //Cantidad de goles de boca como local.
    static int addGoles(Partido p,int goles){
        if(p.getLocal().equals("boca"))
            goles += p.getGolesLocal();
        return goles;
    }
    public static void main(String[] coso){
        int max = 20;
        Partido campeonato[] = new Partido[max];
        int index = 0;
        int riverG,bocaCG;
        riverG = bocaCG = 0;
        Partido aux = LeerDatos();
        while(aux != null && index < max){  
             campeonato[index] = aux;
             riverG = ganoRiver(campeonato[index],riverG);
             bocaCG = addGoles(campeonato[index],bocaCG);
             index++;
             aux = LeerDatos();

        }
        informar(campeonato,index);
        System.out.printf("Partidos ganados por river: %d\n",riverG);
        System.out.printf("Cantidad de Goles de boca como local: %d\n", bocaCG);
    }
}


