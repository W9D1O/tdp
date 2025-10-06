package tema3;

import PaqueteLectura.Lector;

public class Ej05B {
    public static void main(String[] args) {
        Circulo circulo1 = new Circulo();
        double r;
        String cad;
        System.out.println("Ingrese radio del circulo: ");
        r = Lector.leerDouble();
        circulo1.setRadio(r);
        System.out.println("Ingrese color de relleno del circulo: ");
        cad = Lector.leerString();
        circulo1.setColorDeRelleno(cad);
        System.out.println("Ingrese color de linea del circulo: ");
        circulo1.setColorDeLinea(cad);
        System.out.println("El area del circulo es: " + circulo1.calcularArea());
        System.out.println("El perimetro del circulo es: " + circulo1.calcularPerimetro());
    }

}
