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
public class Triangulo extends Figura{
    private double ladoA;
    private double ladoB;
    private double ladoC;
     
    //Si la clara padre no tiene iun coanstructor vacio la clase hija tampoco la puede tener
    /*public Triangulo(){
        
    }*/
    
    
    //Constructor de la clase.
    public Triangulo(double a, double b, double c, String cr,String cl){
        super(cr,cl);
        this.ladoA = a;
        this.ladoB = b;
        this.ladoC = c;

    }
 
    public double getLadoA(){
        return this.ladoA;
    }
    public double getLadoB(){
        return ladoB;
    }
    public double getLadoC(){
        return this.ladoC;
    }


    @Override
    public double calcularPerimetro(){
        return this.ladoA+this.ladoB+this.ladoC;
    }
    
    @Override
    public double calcularArea(){
        double area;
        double s = (this.ladoA + this.ladoB + this.ladoC) / 2;
        //double s = this.calcularPerimetro() / 2;
        double s2 = s*(s-this.ladoA)*(s-this.ladoB)*(s-this.ladoC);
        area = Math.sqrt(s2);
        return area;
    }
    
    public void setLadoA(double a){
        this.ladoA = a;
    }
    public void setLadoB(double b){
        this.ladoB = b;
    }
    public void setLadoC(double c){
        this.ladoC = c;
    }

    @Override
    public String toString(){
        return super.toString() + ". Lados: " + this.getLadoA() + " "
        + this.getLadoB() + " " + this.getLadoC();
    } 
}
