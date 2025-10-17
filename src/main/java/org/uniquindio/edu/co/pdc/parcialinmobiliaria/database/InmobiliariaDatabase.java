package org.uniquindio.edu.co.pdc.parcialinmobiliaria.database;

import org.uniquindio.edu.co.pdc.parcialinmobiliaria.model.Inmueble;

import java.util.ArrayList;

// en esta clase se usa Singleton
public class InmobiliariaDatabase {
    private ArrayList<Inmueble> inmuebles;

    private InmobiliariaDatabase() {
        this.inmuebles = new ArrayList<>();
    }

    public static InmobiliariaDatabase getInstance() {
        return new InmobiliariaDatabase();
    }

    public ArrayList<Inmueble> getInmuebles() {
        return inmuebles;
    }
}
