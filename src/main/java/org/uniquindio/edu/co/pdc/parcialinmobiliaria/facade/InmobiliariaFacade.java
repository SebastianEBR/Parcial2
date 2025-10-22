package org.uniquindio.edu.co.pdc.parcialinmobiliaria.facade;

import org.uniquindio.edu.co.pdc.parcialinmobiliaria.database.InmobiliariaDatabase;
import org.uniquindio.edu.co.pdc.parcialinmobiliaria.model.FactoryInmueble;
import org.uniquindio.edu.co.pdc.parcialinmobiliaria.model.Inmueble;

import java.util.ArrayList;

public class InmobiliariaFacade {
    private static InmobiliariaDatabase database;

    public InmobiliariaFacade() {
        database = InmobiliariaDatabase.getInstance();
    }

    public Inmueble registrarInmueble(String tipo, String code, String ciudad, int habitaciones, int pisos, double precio) {
        Inmueble nuevo = FactoryInmueble.createInmueble(tipo, code, ciudad, habitaciones, pisos, precio);
        database.addInmueble(nuevo);
        return nuevo;
    }

    public ArrayList<Inmueble> listarInmuebles() {
        return database.getInmuebles();
    }

    public void eliminarInmueble(Inmueble inmueble) {
        database.deleteInmueble(inmueble);
    }
}
