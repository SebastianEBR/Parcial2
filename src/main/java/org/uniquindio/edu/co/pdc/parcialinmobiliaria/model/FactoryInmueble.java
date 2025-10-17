package org.uniquindio.edu.co.pdc.parcialinmobiliaria.model;

// este es el factory method
public class FactoryInmueble {
    public static Inmueble createInmueble(String type, String code, String ciudad, int numHabitaciones, int numPisos){
        switch (type.toUpperCase()){
            case "CASA":
                return new Casa.Builder()
                        .code(code)
                        .ciudad(ciudad)
                        .numHabitaciones(numHabitaciones)
                        .numPisos(numPisos)
                        .build();

            case "APARTAMENTO":
                return new Apartamento.Builder()
                        .code(code)
                        .ciudad(ciudad)
                        .numHabitaciones(numHabitaciones)
                        .numPisos(numPisos)
                        .build();
            case "FINCA":
                return new Finca.Builder()
                        .code(code)
                        .ciudad(ciudad)
                        .numHabitaciones(numHabitaciones)
                        .numPisos(numPisos)
                        .build();

            case "LOCAL":
                return new Local.Builder()
                        .code(code)
                        .ciudad(ciudad)
                        .numHabitaciones(numHabitaciones)
                        .numPisos(numPisos)
                        .build();
            default:
                throw new IllegalArgumentException("unknow Inmueble type " + type);
        }
    }
}
