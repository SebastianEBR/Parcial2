package org.uniquindio.edu.co.pdc.parcialinmobiliaria.model;

// aca se utiliza el Builder abstracto de Inmueble
public class Apartamento extends Inmueble {

    private Apartamento(Builder builder) {
        super(builder);
    }

    public static class Builder extends Inmueble.Builder<Builder>{
        @Override
        public Apartamento build() {
            return new Apartamento(this);
        }

        @Override
        public Builder self() {
            return this;
        }
    }
}
