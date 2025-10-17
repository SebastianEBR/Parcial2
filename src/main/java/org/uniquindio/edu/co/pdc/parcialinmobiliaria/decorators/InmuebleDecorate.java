//package org.uniquindio.edu.co.pdc.parcialinmobiliaria.decorators;
//
//import org.uniquindio.edu.co.pdc.parcialinmobiliaria.model.Inmueble;
//
//public abstract class InmuebleDecorate extends Inmueble {
//    protected Inmueble inmueble;
//
//    protected InmuebleDecorator(Inmueble inmueble) {
//        super(new Builder<Inmueble>() {
//            @Override
//            public Inmueble build() { return inmueble; }
//            @Override
//            protected Inmueble self() { return this; }
//        });
//        this.inmueble = inmueble;
//    }
//
//    protected InmuebleDecorate(Builder<?> builder) {
//        super(builder);
//    }
//
//    @Override
//    public String toString() {
//        return inmueble.toString();
//    }
//}
