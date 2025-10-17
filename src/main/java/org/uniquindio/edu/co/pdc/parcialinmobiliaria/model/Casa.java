package org.uniquindio.edu.co.pdc.parcialinmobiliaria.model;

// aca se utiliza el constructor abstracto de Inmueble
public class Casa extends Inmueble{

    private Casa(Builder builder) {
        super(builder);
    }

    public static class Builder extends Inmueble.Builder<Builder>{
        @Override
        public Casa build() {
            return new Casa(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
