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

        final long radioTierra = 6378;
        BigDecimal a = null;
        BigDecimal b = null;
        BigDecimal distanciaKm = null;

        // Resta
        BigDecimal difLatitud = enRadianes(destino.latitud.subtract(this.latitud));
        BigDecimal difLong = enRadianes(destino.longitud.subtract(this.longitud));

        // Calculos variable a

        // Calculo seno²(difLat/2)
        BigDecimal seno2Lat = difLatitud.divide(BigDecimal.TWO, MathContext.DECIMAL128);
        seno2Lat = new BigDecimal(Double.toString(Math.sin(seno2Lat.doubleValue())));
        seno2Lat = seno2Lat.pow(2);

        // Calculo cos(latOrigen)
        BigDecimal cosLatOr = enRadianes(this.latitud);
        cosLatOr = new BigDecimal(Double.toString(Math.cos(cosLatOr.doubleValue())));

        // Calculo cos(latDest)
        BigDecimal cosLatDest = enRadianes(destino.latitud);
        cosLatDest = new BigDecimal(Double.toString(Math.cos(cosLatDest.doubleValue())));

        // Calculos seno²(difLong/2)
        BigDecimal seno2Long = difLong.divide(BigDecimal.TWO, MathContext.DECIMAL128);
        seno2Long = new BigDecimal(Double.toString(Math.sin(seno2Long.doubleValue())));
        seno2Long = seno2Long.pow(2);

        // Calculo final a

        a = cosLatOr.multiply(cosLatDest);
        a = a.multiply(seno2Long);
        a = a.add(seno2Lat);

        // Calculos variable b
        BigDecimal raizA = a.sqrt(MathContext.DECIMAL128);
        BigDecimal raizB = BigDecimal.ONE.subtract(a);
        raizB = raizB.sqrt(MathContext.DECIMAL128);
        b = new BigDecimal(Double.toString(Math.atan2(raizA.doubleValue(), raizB.doubleValue())));
        b = b.multiply(BigDecimal.TWO);

        // Calculo distancia en km
        distanciaKm = b.multiply(new BigDecimal(radioTierra), MathContext.DECIMAL128);

        return distanciaKm;
    }

    public BigDecimal enRadianes(BigDecimal numero){

        BigDecimal rad = null;

        // Convierto pi a string
        BigDecimal pi = new BigDecimal(Double.toString(Math.PI));

        rad = pi.divide(BigDecimal.valueOf(180), MathContext.DECIMAL128).multiply(numero);

        return  rad;
    }

}
