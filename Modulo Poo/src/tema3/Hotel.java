package tema3;

public class  Hotel {
    private int cantidad;
    //int dimL = 0;
    private Habitacion[] habitaciones = null;

    //Preguntar si es válido
    public Hotel(int n){
        this.cantidad = n; 
        this.habitaciones = new Habitacion[this.cantidad];
        for(int i = 0; i < this.cantidad; i++){
            this.habitaciones[i] = new Habitacion();
        }

    }

    //Preguntar si es válido
    public void setAumentos(double aum){
        for(int i = 0; i < cantidad; i ++){
            this.habitaciones[i].setAumento(aum);
        }
    }

    public void setHabitacion(Cliente c, int n){
        this.habitaciones[n].setOcupada(true);
        this.habitaciones[n].setCliente(c);
    }
    public Habitacion getHabitacion(int n){
        Habitacion aux = null;
        if(this.habitaciones[n] != null) aux = this.habitaciones[n];
        return aux;
    }

    
    public String toString(int n){
        String aux;
        if(this.habitaciones[n].isOcupada())
        aux = "Habitacion N° " + n +": " + this.habitaciones[n].getCosto() + this.habitaciones[n].getCliente();
        else
            aux = "Habitacion N° " + n +": " + this.habitaciones[n].getCosto() + "se encuentra libre.";

        return aux;
    }
}

