/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDocumentos;


import Controlador.Controladora;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import proyectoferreteria.Articulo;
import proyectoferreteria.Cliente;

public class ClienteDoc {
    private Element root=new Element("Inventario");
    private String fileLocation = "src//Archivos//XMLClientes.xml";
    
     public ClienteDoc() {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            Document doc = null;
            doc = builder.build(fileLocation);
            root = doc.getRootElement();
        } catch (JDOMException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo iniciar la operacion por: " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo iniciar la operacion por: " + ex.getMessage());    
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Ocurrio un error ");
        }
        
    }
     public ClienteDoc(int num) {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            Document doc = null;
            doc = builder.build(fileLocation);
            root = doc.getRootElement();
        } catch (JDOMException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo iniciar la operacion por: " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo iniciar la operacion por: " + ex.getMessage());    
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Ocurrio un error ");
        }
        
    }
     
    //actualiza el archivo XML 
    private boolean actualizarDatosXML() {
        try {
            XMLOutputter out = new XMLOutputter(org.jdom2.output.Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(fileLocation);
            out.output(root, file);
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error inesperado");
            return false;
        }
    } 
    
    public void guardarDatosCliente(Cliente persona){

        Element principal = new Element("cliente");
        Element nombre =  new Element("nombre");
                nombre.setText(persona.getNombre());
        Element Cedula =  new Element("cedula");
                Cedula.setText(String.valueOf(persona.getDocumento()));
        Element direccion =  new Element("direccion");
                direccion.setText(String.valueOf(persona.getDireccion()));
        Element telefono =  new Element("telefono");
                telefono.setText(String.valueOf(persona.getTelefono()));
        principal.addContent(nombre);
        principal.addContent(Cedula);
        principal.addContent(direccion);
        principal.addContent(telefono);

        root.addContent(principal);
        actualizarDatosXML();
    }
    
    //carga la lista de Clientes en una tabla en un modelo tabla y lo retorna
    public DefaultTableModel cargarTablaCliente() {

        Element aux = new Element("cliente");
        List articulo = this.root.getChildren("cliente");
        Iterator i = articulo.iterator();
        Iterator inicio = articulo.iterator();
               
        String[] columna = { "Nombre", "CI o RIF","Direccion","Telefono"};
        DefaultTableModel modeloTabla = new DefaultTableModel(null,columna){
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return  false;
                //se puede indicar por comlunas o finlas editables
            }
        }; 
 
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();
            try{ 
                String[] row = {e.getChildText("nombre"), 
                                e.getChildText("cedula"),
                                e.getChildText("direccion"), 
                                e.getChildText("telefono")};
                modeloTabla.addRow(row);
            }
            catch(Exception ex){ 
                System.out.println(" ha ocurrido un error");
            }
        }
        return modeloTabla;
    }
    
    public Cliente buscarClienet(String CI_RIF, String Nacionalidad){
        Cliente persona = new Cliente();
        String identificacion = Nacionalidad+"-"+CI_RIF;

        Element aux = new Element("cliente");
        List articulo = this.root.getChildren("cliente");
        Iterator i = articulo.iterator();
        
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();
           
            if(identificacion.equals(e.getChildText("cedula"))){
                persona.setNombre(e.getChildText("nombre"));
                persona.setDireccion(e.getChildText("direccion"));
                persona.setDocumento(e.getChildText("cedula"));
                persona.setTelefono(e.getChildText("telefono"));
                return persona;
            }
        }
    return null;
    }
    
    public Cliente buscarCliente(String CI_RIF){
        Controladora control=new Controladora();
        Cliente persona = new Cliente();
        CI_RIF=control.limpiarPalabra(CI_RIF);
        Element aux = new Element("cliente");
        List articulo = this.root.getChildren("cliente");
        Iterator i = articulo.iterator();
        
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();
            
            if(CI_RIF.equals(control.limpiarPalabra(e.getChildText("cedula")))){
                persona.setNombre(e.getChildText("nombre"));
                persona.setDireccion(e.getChildText("direccion"));
                persona.setDocumento(e.getChildText("cedula"));
                persona.setTelefono(e.getChildText("telefono"));
                return persona; 
            }
        }
    return null;
    
    }
    
    public void eliminarCliente(String CI_RIF){
        Element aux = new Element("cliente");
        List articulo = this.root.getChildren("cliente");
        Iterator i = articulo.iterator();
        while (aux != null && i.hasNext() ) {
            Element e = (Element) i.next();
            if(CI_RIF.equals(e.getChildText("cedula"))){
                articulo.remove(e);
                actualizarDatosXML();
                break;
            }
        } 
    }
    
    public void editarCliente(String nombre, String nacionalidad,String CI_RIF, 
                              String direccion,String telefono){
        String identificacion = nacionalidad+"-"+CI_RIF;

        Element aux = new Element("cliente");
        List articulo = this.root.getChildren("cliente");
        Iterator i = articulo.iterator();
        
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();
            System.out.println(e.getChildText("cedula"));
            if(identificacion.equals(e.getChildText("cedula"))){
                e.getChild("nombre").setText(nombre);
                e.getChild("direccion").setText(direccion);
                e.getChild("cedula").setText(identificacion);
                e.getChild("telefono").setText(telefono);
            actualizarDatosXML();
            }
        }
    }
    
    //filtra la tabla de Articulos con el criterio seleciconado Nombre, ID o familia
    public DefaultTableModel filtrarTablaCliente(String busqueda, int Criterio){
        Element aux = new Element("cliente");
        List articulo = this.root.getChildren("cliente");
        Iterator i = articulo.iterator();
        //para volver al inicio el iterador(puntero)
        //Iterator inicio = articulo.iterator();
              
        String[] columna = { "Nombre", "CI o RIF","Direccion","Telefono"};
 
        DefaultTableModel modeloTabla = new DefaultTableModel(null,columna){
            @Override
            public boolean isCellEditable(int filas, int columnas) { 
                return  false;
                //se puede indicar por comlunas o finlas editables
            }
        }; 
        //determina que valor se va a leer del articulo en el XML
        String dato = "";
        switch(Criterio){
            case 0: dato = "nombre";
                break;
            case 1: dato = "cedula";
                break;
        }       
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next(); 
            try{
                
                String buscado = e.getChildText(dato);
                if(Criterio == 1){
                    String[] q = buscado.split("-");
                    buscado = q[1];
                }
                
                int length = busqueda.length();
                int agregar = 0;
                if(busqueda.length() > e.getChildText(dato).length() )
                    agregar = 1; 
                else
                    for(int h = 0; h < length && h < buscado.length(); h++){
                        char char1 = busqueda.toLowerCase().charAt(h);
                        char char2 = buscado.toLowerCase().charAt(h);
                        if(char1 != char2 )
                            agregar = 1;
                    }
                if(agregar == 0){

                    String[] edit = {e.getChildText("nombre"), 
                        e.getChildText("cedula"),
                        e.getChildText("direcicon"), 
                        e.getChildText("telefono")};
                     modeloTabla.addRow(edit);    
                }
            }       
            catch(Exception ex){ 
                JOptionPane.showMessageDialog(null, "A ocurrido un error");
            }
        
       }
    return modeloTabla;
    }
}
