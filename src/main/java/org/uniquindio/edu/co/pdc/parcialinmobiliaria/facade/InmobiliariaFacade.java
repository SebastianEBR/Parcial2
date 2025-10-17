package org.uniquindio.edu.co.pdc.parcialinmobiliaria.facade;

import org.uniquindio.edu.co.pdc.parcialinmobiliaria.database.InmobiliariaDatabase;
import org.uniquindio.edu.co.pdc.parcialinmobiliaria.model.FactoryInmueble;
import org.uniquindio.edu.co.pdc.parcialinmobiliaria.model.Inmueble;

import java.util.ArrayList;

public class InmobiliariaFacade {
    private InmobiliariaDatabase database;

    public InmobiliariaFacade() {
        this.database = InmobiliariaDatabase.getInstance();
    }

    public Inmueble registrarInmueble(String tipo, String ciudad, int habitaciones, int pisos) {
        Inmueble nuevo = FactoryInmueble.createInmueble(tipo, ciudad, habitaciones, pisos);
        database.addInmueble(nuevo);
        return nuevo;
    }

    public ArrayList<Inmueble> listarInmuebles() {
        return database.getInmuebles();
    }

    public void eliminarInmueble(String id) {
        //database.deleteInmueble(id);
    }
}
