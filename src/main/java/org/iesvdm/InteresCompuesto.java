package org.iesvdm;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InteresCompuesto {

    // Monto inicial
    private BigDecimal p;

    // Tasa de interes
    private BigDecimal r;

    // Numero años
    private int n;

    // Cantidad final
    private BigDecimal c;

    public InteresCompuesto(BigDecimal p, BigDecimal r, int n) {

        this.p = p;
        this.r = r;
        this.n = n;

    }

    public BigDecimal getP() {
        return p;
    }

    public void setP(BigDecimal p) {
        this.p = p;
    }

    public BigDecimal getR() {
        return r;
    }

    public void setR(BigDecimal r) {
        this.r = r;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public BigDecimal getC() {
        return c;
    }

    public void setC(BigDecimal c) {
        this.c = c;
    }

    public BigDecimal calculaMontoFinal() {
        //TODO

        // c = p * (1 + r) ^ n

        this.c = this.p.multiply(BigDecimal.ONE.add(this.r.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)).pow(this.n));

        return this.c;

    }



}
