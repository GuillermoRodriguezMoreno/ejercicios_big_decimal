package org.iesvdm.haversine;

import java.math.BigDecimal;
import java.math.MathContext;

public class Posicion {

    // Atributos

    BigDecimal latitud;
    BigDecimal longitud;

    // Constructores
    public Posicion(BigDecimal latitud, BigDecimal longitud){

        this.latitud = latitud;
        this.longitud = longitud;

    }

    // Getters y Setters

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    // Metodos

    public BigDecimal distanciaKm(Posicion destino){

        BigDecimal distancia = null;

        // Resta
        BigDecimal difLatitud = enRadianes(destino.latitud.subtract(this.latitud));
        BigDecimal difLong = enRadianes(destino.longitud.subtract(this.longitud));

        // Calculos
        distancia = (difLatitud.divide(new BigDecimal(2), MathContext.DECIMAL128)).


        return distancia;
    }

    public BigDecimal enRadianes(BigDecimal numero){

        BigDecimal rad = null;

        // Convierto pi a string
        BigDecimal pi = new BigDecimal(Double.toString(Math.PI));

        rad = pi.divide(BigDecimal.valueOf(180), MathContext.DECIMAL128).multiply(numero);

        return  rad;
    }
}
