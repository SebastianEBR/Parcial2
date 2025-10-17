package org.uniquindio.edu.co.pdc.parcialinmobiliaria.model;

// aca se utiliza el constructor abstracto de Inmueble
public class Finca extends Inmueble {

    public Finca(Builder builder) {
        super(builder);
    }

    public static class Builder extends Inmueble.Builder<Builder>{
        @Override
        public Finca build() {
            return new Finca(this);
        }

        @Override
        public Builder self() {
            return this;
        }
    }
}
