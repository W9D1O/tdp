/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;


/**
 *
 * @author Zzz
 */
public class Triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;
    private String coloR; //Color de relleno.
    private String coloL; //Color linea.
    
    //Constructor de la clase.
    public Triangulo(double a, double b, double c, String cr,String cl){
        ladoA = a;
        ladoB = b;
        ladoC = c;
        coloR = cr;
        coloL = cl;
    }
    public Triangulo(){
        
    }
    
    public double getLadoA(){
        return ladoA;
    }
    public double getLadoB(){
        return ladoB;
    }
    public double getLadoC(){
        return ladoC;
    }
    public String getColoRelleno(){
        return coloR;
    }
    public String getColoLinea(){
        return coloL;
    }
    
    public double calcularPerimetro(){
        return ladoA+ladoB+ladoC;
    }
    
    public double calcularArea(){
        double area;
        double s = (ladoA + ladoB + ladoC) / 2;
        //double s = this.calcularPerimetro() / 2;
        double s2 = s*(s-ladoA)*(s-ladoB)*(s-ladoC);
        area = Math.sqrt(s2);
        return area;
    }
    
    public void setLadoA(double a){
        ladoA = a;
    }
    public void setLadoB(double b){
        ladoB = b;
    }
    public void setLadoC(double c){
        ladoC = c;
    }
    public void setColoRelleno(String cr){
        coloR = cr;
    }
    public void setColoLinea(String cl){
        coloL = cl;
    }
}
