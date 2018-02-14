/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoferreteria;

import ClasesDocumentos.Documento;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inventario {
    private ArrayList<Articulo> listado;
    private org.jdom2.Element root;

    
    public Inventario() {
        listado = new ArrayList<>();
    }
    
    public ArrayList<Articulo> getListado() {
        return listado;
    }

    public void setListado(ArrayList<Articulo> listado) {
        this.listado = listado;
    }
    
    public void nuevoArticulo(String nombre,String codigoBarras, String familia,
                            int unidades, String descripcion, float costo,
                            float impuesto, float precio,Documento doc){
       /* Documento xml = new Documento();
        int ID =  xml.getNumeroArticulos();*/
        
        Articulo objeto = new Articulo(nombre, doc.getNumeroArticulos(), familia, codigoBarras, 
            unidades, descripcion, costo, impuesto, precio);
        listado.add(objeto);  
        
        try {
            //Documento doc = new Documento();
            doc.guardarDatosArticulo(objeto);
        } catch (ParseException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
 
}
