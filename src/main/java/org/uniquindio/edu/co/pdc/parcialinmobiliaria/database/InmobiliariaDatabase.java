package org.uniquindio.edu.co.pdc.parcialinmobiliaria.database;

import org.uniquindio.edu.co.pdc.parcialinmobiliaria.model.Inmueble;

import java.util.ArrayList;
import java.util.Optional;

// en esta clase se usa Singleton
public class InmobiliariaDatabase {

    private static InmobiliariaDatabase instance;

    private ArrayList<Inmueble> inmuebles;

    private InmobiliariaDatabase() {
        this.inmuebles = new ArrayList<>();
    }

    public static InmobiliariaDatabase getInstance() {
        if  (instance == null) {
            instance = new InmobiliariaDatabase();
        }
        return instance;
    }

    public void addInmueble(Inmueble inmueble) {
        this.inmuebles.add(inmueble);
    }

    public void deleteInmueble(Inmueble inmueble) {
        this.inmuebles.remove(inmueble);
    }

    public ArrayList<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public Optional<Inmueble> findInmuebleByCode(String code){
        return this.getInmuebles()
                .stream()
                .filter(i -> i.getCode().equals(code))
                .findFirst();
    }
}
