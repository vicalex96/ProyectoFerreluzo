/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoferreteria;

import java.util.Calendar;

/**
 *
 * @author VícAlex
 */
public class Factura {
    private Calendar fechaHora;
    private float precioT, totalIVA ,subTotal;
    private int numFactura;

    public Factura(Calendar fechaHora, float precioT, float totalIVA, float subTotal, int numFactura) {
        this.fechaHora = fechaHora;
        this.precioT = precioT;
        this.totalIVA = totalIVA;
        this.subTotal = subTotal;
        this.numFactura = numFactura;
    }

    public Factura() {
        fechaHora = Calendar.getInstance();
        precioT = 0;
        totalIVA = 0;
        subTotal = 0;
        numFactura = 0;
    }


    public Calendar getFecha() {
        return fechaHora;
    }


    public float getPrecioT() {
        return precioT;
    }

    public float getTotalIVA() {
        return totalIVA;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setfechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setPrecioT(float precioT) {
        this.precioT = precioT;
    }

    public void setTotalIVA(float totalIVA) {
        this.totalIVA = totalIVA;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }
    
    
    
}
