/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoferreteria;

/**
 *
 * @author VícAlex
 */
public class Articulo {
    private String nombre;
    private int ID;
    private String familia;
    private String codigoBarras;
    private String descripcion; 
    private float costo;
    private float impuesto;
    private float precio;
    private int unidades;
    private int nroVendido;
    
    public Articulo(){
        nombre = "";
        ID = 0;
        familia = "";
        codigoBarras = "";
        descripcion = "";
        costo = 0;
        impuesto = 0;
        precio = 0;
        unidades = 0;
        nroVendido = 0;
    }

    public int getNroVendido() {
        return nroVendido;
    }

    public Articulo(String nombre, int codigoSistema, String familia, String codigoBarras, 
            int unidades, String descripcion, float costo, float impuesto, float precio) {
        this.nombre = nombre;
        this.ID = codigoSistema;
        this.familia = familia;
        this.codigoBarras = codigoBarras;
        this.descripcion = descripcion;
        this.costo = costo;
        this.impuesto = impuesto;
        this.precio = precio;
        this.unidades = unidades;
        nroVendido = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getID() {
        return ID;
    }

    public String getFamilia() {
        return familia;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public float getPrecio() {
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNroVendido(int nroVendido) {
        this.nroVendido = nroVendido;
    }
    
    public void setID(int codigoSistema) {
        this.ID = codigoSistema;
    }

    public void setCodigoSistema(int codigoSistema) {
        this.ID = codigoSistema;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    
}
