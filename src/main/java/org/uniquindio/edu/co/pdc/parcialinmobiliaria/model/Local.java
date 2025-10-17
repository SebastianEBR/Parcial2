package org.uniquindio.edu.co.pdc.parcialinmobiliaria.model;

// aca se utiliza el constructor abstracto de Inmueble
public class Local extends Inmueble {
    public Local(Builder builder) {
        super(builder);
    }

    public static class Builder extends Inmueble.Builder<Builder>{
        @Override
        public Local build() {
            return new Local(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
