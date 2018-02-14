/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoferreteria;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author VícAlex
 */
public class Venta {
   private DefaultTableModel Articulos;
   private Cliente Comprador;
   //private int numArticulos;
   
        public Venta(DefaultTableModel Articulos, Cliente Comprador){
            this.Articulos=Articulos;
            this.Comprador=Comprador;
            //this.numArticulos=numArticulos;
        }

    public Cliente getComprador() {
        return Comprador;
    }

    public DefaultTableModel getArticulos() {
        return Articulos;
    }

    public void setArticulos(DefaultTableModel Articulos) {
        this.Articulos =  Articulos;
    }

    public void setComprador(Cliente Comprador) {
        this.Comprador = Comprador;
    }
        
        
   
}
