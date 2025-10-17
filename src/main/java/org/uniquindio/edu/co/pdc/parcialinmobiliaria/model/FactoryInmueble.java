package org.uniquindio.edu.co.pdc.parcialinmobiliaria.model;

// este es el factory method
public class FactoryInmueble {
    public static Inmueble createInmueble(String type, String code, String ciudad, int numHabitaciones, int numPisos
            , double precio){
        switch (type.toUpperCase()){
            case "CASA":
                return new Casa.Builder()
                        .code(code)
                        .ciudad(ciudad)
                        .numHabitaciones(numHabitaciones)
                        .numPisos(numPisos)
                        .precio(precio)
                        .build();

            case "APARTAMENTO":
                return new Apartamento.Builder()
                        .code(code)
                        .ciudad(ciudad)
                        .numHabitaciones(numHabitaciones)
                        .numPisos(numPisos)
                        .precio(precio)
                        .build();
            case "FINCA":
                return new Finca.Builder()
                        .code(code)
                        .ciudad(ciudad)
                        .numHabitaciones(numHabitaciones)
                        .numPisos(numPisos)
                        .precio(precio)
                        .build();

            case "LOCAL":
                return new Local.Builder()
                        .code(code)
                        .ciudad(ciudad)
                        .numHabitaciones(numHabitaciones)
                        .numPisos(numPisos)
                        .precio(precio)
                        .build();
            default:
                throw new IllegalArgumentException("unknow Inmueble type " + type);
        }
    }
}
