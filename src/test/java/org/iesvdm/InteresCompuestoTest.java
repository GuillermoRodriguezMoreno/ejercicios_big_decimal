package org.iesvdm;

import org.iesvdm.InteresCompuesto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InteresCompuestoTest {

    @Test
    public void cuandoPrincipal1000Interes5porcientoY10peridos() {

        String principal = "1000";
        int interes = 5;
        int periodos = 10;

        //TODO

        // Creo objeto con los paremetros dados
        InteresCompuesto interesCompuesto = new InteresCompuesto(new BigDecimal("1000"), BigDecimal.valueOf((long)5), 10);

        // Calculo cantidad final y redondeo a 2 decimales
        BigDecimal cantidadFinal = interesCompuesto.calculaMontoFinal().setScale(2, RoundingMode.HALF_EVEN);

        Assertions.assertEquals(new BigDecimal("1628.89"), cantidadFinal);
    }

}
