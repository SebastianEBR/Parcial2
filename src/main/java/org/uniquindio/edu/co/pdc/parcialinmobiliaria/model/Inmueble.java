package org.uniquindio.edu.co.pdc.parcialinmobiliaria.model;

// en esta se utiliza Builder abstracto
public abstract class Inmueble {
    protected String ciudad;
    protected int numHabitaciones;
    protected int numPisos;
    protected double precio;

    protected Inmueble(Builder<?> builder) {
        this.ciudad = builder.ciudad;
        this.numHabitaciones = builder.numHabitaciones;
        this.numPisos = builder.numPisos;
        this.precio = builder.precio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumPisos() {
        return numPisos;
    }

    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "ciudad='" + ciudad + '\'' +
                ", numHabitaciones=" + numHabitaciones +
                ", numPisos=" + numPisos +
                ", precio=" + precio +
                '}';
    }

    public static abstract class Builder<T extends Builder<T>> {
        protected String ciudad;
        protected int numHabitaciones;
        protected int numPisos;
        protected double precio;

        public T ciudad(String ciudad) {
            this.ciudad = ciudad;
            return self();
        }

        public T numHabitaciones(int numHabitaciones) {
            this.numHabitaciones = numHabitaciones;
            return self();
        }

        public T numPisos(int numPisos) {
            this.numPisos = numPisos;
            return self();
        }

        public T precio(double precio) {
            this.precio = precio;
            return self();
        }

        protected abstract T self();
        public abstract Inmueble build();
    }
}
