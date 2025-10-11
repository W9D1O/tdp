package tema4;





public class Circulo extends Figura{
    private double radio;

    /*public Circulo(){
        
    }*/

    public Circulo(String cRelleno,String cLinea,double r){
        super(cRelleno,cLinea);
        this.radio = r;
       
    }
    public double getRadio(){
        return this.radio;
    }

    public void setRadio(double r){
        this.radio = r;
    }

    @Override
    public double calcularPerimetro(){
        return 2*Math.PI*this.radio;
    }
    @Override
    public double calcularArea(){
        return Math.PI*this.radio*this.radio;
    }
    
    @Override
    public String toString(){
        return super.toString() + " Su radio es: " + this.getRadio();
    }
}
