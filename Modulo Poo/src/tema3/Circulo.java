package tema3;



public class Circulo {
    private double radio;
    private String colorDeRelleno;
    private String colorDeLinea;

    public Circulo(){
        
    }

    public Circulo(double r,String cRelleno,String cLinea){
        this.radio = r;
        this.colorDeRelleno = cRelleno;
        this.colorDeLinea = cLinea;
    }
    public double getRadio(){
        return this.radio;
    }
    public String getColorDeRelleno(){
        return this.colorDeRelleno;
    }
    public String getColorDeLinea(){
        return this.colorDeLinea;
    }
    public void setRadio(double r){
        this.radio = r;
    }
    public void setColorDeRelleno(String cr){
        this.colorDeRelleno = cr;
    }
    public void setColorDeLinea(String cl){
        this.colorDeLinea = cl;
    }

    public double calcularPerimetro(){
        return 2*Math.PI*this.radio;
    }
    public double calcularArea(){
        return Math.PI*this.radio*this.radio;
    }
}
