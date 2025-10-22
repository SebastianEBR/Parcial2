package org.uniquindio.edu.co.pdc.parcialinmobiliaria.app;

import org.uniquindio.edu.co.pdc.parcialinmobiliaria.database.InmobiliariaDatabase;
import org.uniquindio.edu.co.pdc.parcialinmobiliaria.model.FactoryInmueble;
import org.uniquindio.edu.co.pdc.parcialinmobiliaria.model.Inmueble;

public class Main {
    public static void main(String[] args) {
        InmobiliariaDatabase inmobiliariaDb = InmobiliariaDatabase.getInstance();

        Inmueble casa1 = FactoryInmueble.createInmueble("casa"
                ,"001"
                ,"Quimbaya"
                ,6
                ,2
                ,500000000
        );

        Inmueble apartamento1 = FactoryInmueble.createInmueble("apartamento"
                ,"002"
                ,"Armenia"
                ,1
                ,1
                ,500000
        );

        Inmueble local1 = FactoryInmueble.createInmueble("local"
                ,"003"
                ,"Popayan"
                ,1
                ,1
                ,700000
        );

        Inmueble finca1 = FactoryInmueble.createInmueble("finca"
                ,"004"
                ,"Medellin"
                ,20
                ,3
                ,999999999
        );

        inmobiliariaDb.addInmueble(casa1);
        inmobiliariaDb.addInmueble(apartamento1);
        inmobiliariaDb.addInmueble(local1);
        inmobiliariaDb.addInmueble(finca1);

        System.out.println(inmobiliariaDb.getInmuebles());

        inmobiliariaDb.deleteInmueble(apartamento1);
        inmobiliariaDb.deleteInmueble(local1);
        System.out.println(inmobiliariaDb.getInmuebles());

    }
}
