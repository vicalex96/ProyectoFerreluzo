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
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import proyectoferreteria.Articulo;

public class Documento {
    private Element root=new Element("Inventario");
    private String fileLocation = "src//Archivos//XMLInventario.xml";
    private Controladora control;
    
     public Documento() {
         control=new Controladora();
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
     public Documento(int num) {
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
    
    //crea las pestañas de informacion y guarda en ellas los datos de cada Articulo
    public void guardarDatosArticulo(Articulo herramienta) throws ParseException{
        Element articulo = new Element("articulo");
            Element nombre =  new Element("nombre");
                nombre.setText(herramienta.getNombre());
            Element ID =  new Element("ID");
                ID.setText(String.valueOf(herramienta.getID()));
            Element codigoBarras =  new Element("codigoBarras");
                codigoBarras.setText(String.valueOf(herramienta.getCodigoBarras()));
            Element unidades =  new Element("unidades");
                unidades.setText(String.valueOf(herramienta.getUnidades()));
            Element descripcion =  new Element("descripcion");
                descripcion.setText(herramienta.getDescripcion());
            Element costo = new Element("costo");
                costo.setText(control.parseToString(herramienta.getCosto()));
            Element impuesto = new Element("impuesto");            
                impuesto.setText(control.parseToString(herramienta.getImpuesto()));                            
            Element precio = new Element("precio");
                precio.setText(control.parseToString(herramienta.getPrecio()));
            Element familia = new Element("familia");
                familia.setText(herramienta.getFamilia());
            Element vendido = new Element("vendido");
                vendido.setText(Integer.toString(herramienta.getNroVendido()));
        
        articulo.addContent(nombre);
        articulo.addContent(familia);
        articulo.addContent(ID);
        articulo.addContent(codigoBarras);
        articulo.addContent(unidades);
        articulo.addContent(descripcion);
        articulo.addContent(costo);
        articulo.addContent(impuesto);
        articulo.addContent(precio);
        articulo.addContent(vendido);
        root.addContent(articulo);
        actualizarDatosXML();
    }
    
    //carga la lista de Articulos en menu inventario  en un modelo tabla y lo retorna
    public DefaultTableModel cargarTablaArticulo() {

        Element aux = new Element("articulo");
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        Iterator inicio = articulo.iterator();
               
        String[] columna = { "Nombre", "ID","Familia","Decripcion"};
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
                                e.getChildText("ID"),
                                e.getChildText("familia"), 
                                e.getChildText("descripcion")};
                modeloTabla.addRow(row);
            }
            catch(Exception ex){ 
                System.out.println(" ha ocurrido un error");
            }
        }
        //actualizarDatosXML();
        return modeloTabla;
    }
    
    //filtra la tabla de Articulos con el criterio seleciconado Nombre, ID o familia
    public DefaultTableModel filtrarTablaArticulo(String busqueda, int Criterio,int tipoTabla){
        Element aux = new Element("articulo");
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        //para volver al inicio el iterador(puntero)
        //Iterator inicio = articulo.iterator();
               
        String[] columnaDefault = { "Nombre", "ID","Familia","Decripcion"};
        String[] columnaEdit = { "Nombre", "ID","costo","precio"};
        
        String[] columna;
        if(tipoTabla == 2)
            columna = columnaEdit;
        else
            columna = columnaDefault;   
        DefaultTableModel modeloTabla = new DefaultTableModel(null,columna){
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                if (columnas < 2) {
                return false;
            } else {
                return true;
            }
                //se puede indicar por comlunas o finlas editables
            }
        }; 
        //determina que valor se va a leer del articulo en el XML
        String dato = "";
        switch(Criterio){
            case 0: dato = "nombre";
                break;
            case 1: dato = "ID";
                break;
            case 2: dato = "familia";
                break;
        }
                
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next(); 
            try{
                int length = busqueda.length();
                e.getChildText(dato).toLowerCase();
                int agregar = 0;
                if(busqueda.length() > e.getChildText(dato).length() )
                    agregar = 1; 
                else
                    for(int h = 0; h < length && h < e.getChildText(dato).length(); h++){
                        char char1 = busqueda.toLowerCase().charAt(h);
                        char char2 = e.getChildText(dato).toLowerCase().charAt(h);
                        if(char1 != char2 )
                            agregar = 1;
                    }
                if(agregar == 0){
                    switch(tipoTabla){
                        case 2:
                            String[] edit = {e.getChildText("nombre"), 
                                    e.getChildText("ID"),
                                    e.getChildText("costo"), 
                                    e.getChildText("precio")};
                            modeloTabla.addRow(edit);
                            break;
                        default:
                            String[] row = {e.getChildText("nombre"), 
                                    e.getChildText("ID"),
                                    e.getChildText("familia"), 
                                    e.getChildText("descripcion")};
                            modeloTabla.addRow(row);
                            break;
                    }
                }
            }       
            catch(Exception ex){ 
                System.out.println(" ha ocurrido un error");
            }
        }
    return modeloTabla;
    }
    
    public DefaultTableModel cargarTablaArticuloEditar() {

        Element aux = new Element("articulo");
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        Iterator inicio = articulo.iterator();
               
        String[] columna = { "Nombre", "ID","Costo","Precio"};
        DefaultTableModel modeloTabla = new DefaultTableModel(null,columna){
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return  columnas==2 || columnas==3;
                //se puede indicar por comlunas o finlas editables
            }
        }; 
        
        
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();
            try{ 
                String[] row = {e.getChildText("nombre"), 
                                e.getChildText("ID"),
                                e.getChildText("costo"), 
                                e.getChildText("precio")};
                modeloTabla.addRow(row);
            }
            catch(Exception ex){ 
                System.out.println(" ha ocurrido un error");
            }
        }
        //actualizarDatosXML();
        return modeloTabla;
    }
    
    public DefaultTableModel cargarTablaArticuloCaja() {

        Element aux = new Element("articulo");
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        Iterator inicio = articulo.iterator();
               
        String[] columna = { "Nombre", "ID","Familia","Descripcion","Precio"};
        DefaultTableModel modeloTabla = new DefaultTableModel(null,columna){
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
                //se puede indicar por comlunas o finlas editables
            }
        };
        
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();
            try{
                String[] row = {e.getChildText("nombre"), 
                                e.getChildText("ID"),
                                e.getChildText("familia"),
                                e.getChildText("descripcion"), 
                                e.getChildText("precio")};
                modeloTabla.addRow(row);
            }
            catch(Exception ex){ 
                System.out.println(" ha ocurrido un error");
            }
        }
        //actualizarDatosXML();
        return modeloTabla;
    }
    
    //indica el numero de instancias en el XML
    public int getNumeroArticulos(){
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        int cantidad = 0;
        while(i.hasNext()){
            cantidad += 1;
            i.next();
        }
        actualizarDatosXML();
        return cantidad;
    }
    
    //cargar los datos de un String que se haya encontrado por su ID
    public Articulo cargarDatosArticulo(String ID) throws ParseException{
        Articulo herramienta = new Articulo();
        Element aux = new Element("articulo");
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();
            if(ID.equals(e.getChildText("ID"))){
                herramienta.setNombre(e.getChildText("nombre"));
                herramienta.setFamilia(e.getChildText("familia"));
                herramienta.setID(Integer.parseInt(e.getChildText("ID")));
                herramienta.setCodigoBarras(e.getChildText("codigoBarras"));
                herramienta.setUnidades(Integer.parseInt(e.getChildText("unidades")));
                herramienta.setDescripcion(e.getChildText("descripcion"));
                herramienta.setCosto(control.parseToFloat(e.getChildText("costo")));
                herramienta.setImpuesto(control.parseToFloat(e.getChildText("impuesto")));
                herramienta.setPrecio(control.parseToFloat(e.getChildText("precio")));
                herramienta.setNroVendido(0);
                return herramienta;
            }
        }
        return null;
    }
    
    public Articulo buscarPorNombre(String Nombre){
        Articulo herramienta = new Articulo();
        Element aux = new Element("articulo");
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();
            if(Nombre.equals(e.getChildText("nombre"))){
                herramienta.setNombre(e.getChildText("nombre"));
                herramienta.setFamilia(e.getChildText("familia"));
                herramienta.setID(Integer.parseInt(e.getChildText("ID")));
                herramienta.setCodigoBarras(e.getChildText("codigoBarras"));
                herramienta.setUnidades(Integer.parseInt(e.getChildText("unidades")));
                herramienta.setDescripcion(e.getChildText("descripcion"));
                herramienta.setCosto(Float.parseFloat(e.getChildText("costo")));
                herramienta.setImpuesto(Float.parseFloat(e.getChildText("impuesto")));
                herramienta.setPrecio(Float.parseFloat(e.getChildText("precio")));
                //actualizarDatosXML();
                return herramienta;
            }
        }
        // actualizarDatosXML();
        return null;
    }
     
    //elimina el Articulo con el mismo ID (para eliminar de la tabla inventario)
    public void eliminarArticulo(String ID){
        Articulo herramienta = new Articulo();
        Element aux = new Element("articulo");
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        boolean flag=false;
        Element Found = null;
        while (aux != null && i.hasNext() ) {
            Element e = (Element) i.next();
            if(ID.equals(e.getChildText("ID"))){
                //articulo.remove(e);
                //actualizarDatosXML();
                Found=e;
                flag=true;
                ID="";
                //i.next();
            }
            if (flag){
                int n=Integer.parseInt(e.getChildText("ID"));
                n=n-1;
                System.out.println(n);
                e.getChild("ID").setText(Integer.toString(n));
            }
        } 
        articulo.remove(Found);
        actualizarDatosXML();
    }
    
    //edita los datos de un Articulo en el XML
    public void editarArticulo(String ID, String nombre,String codigoBarras, String familia,
                               String unidades, String descripcion, String costo,
                               String  impuesto,String precio) throws ParseException{
        Element aux = new Element("articulo");
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();
            if(ID.equals(e.getChildText("ID"))){
                e.getChild("nombre").setText(nombre);
                e.getChild("familia").setText(familia);
                e.getChild("codigoBarras").setText(codigoBarras);
                e.getChild("unidades").setText(unidades);
                e.getChild("descripcion").setText(descripcion);
                e.getChild("costo").setText(control.parseToString(control.parseToFloat(costo)));
                e.getChild("impuesto").setText(control.parseToString(control.parseToFloat(impuesto)));
                e.getChild("precio").setText(control.parseToString(control.parseToFloat(precio)));
            }
        }
        actualizarDatosXML();
    }
    
    public void editarArticulo(String ID, String costo,String precio) throws ParseException{
        Element aux = new Element("articulo");
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();
            if(ID.equals(e.getChildText("ID"))){               
                e.getChild("costo").setText(control.parseToString(control.parseToFloat(costo)));
                e.getChild("precio").setText(control.parseToString(control.parseToFloat(precio)));
                actualizarDatosXML();
            }
        }
    }
    
    public void guardarTabla(JTable tabla) throws ParseException{
        
        for(int i = 0; i < tabla.getRowCount(); i++){
            
            editarArticulo((String)tabla.getValueAt(i, 1),
                            (String)tabla.getValueAt(i, 2),
                            (String)tabla.getValueAt(i, 3));
        }
        Element aux = new Element("articulo");
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        int j=0;
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();             
                e.getChild("costo").setText((String)tabla.getValueAt(j, 2));
                e.getChild("precio").setText((String)tabla.getValueAt(j, 3));
            j = j + 1;     
        }
        actualizarDatosXML();
    }
    
    //muestra la lista de todos los articulos que se hayan vendido varias veces
     public DefaultTableModel cantidadArticuloVendido() {

        Element aux = new Element("articulo");
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        Iterator inicio = articulo.iterator();
               
        String[] columna = { "Articulo", "ID", "Unidades vendidas"};
        DefaultTableModel modeloTabla = new DefaultTableModel(null,columna){
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
            }
        };
        
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();
            if(Integer.parseInt(e.getChildText("vendido")) != 0){
                try{
                    String[] row = {e.getChildText("nombre"), 
                                e.getChildText("ID"),
                                e.getChildText("vendido")
                                };
                    modeloTabla.addRow(row);
                }
                catch(Exception ex){ 
                    System.out.println(" ha ocurrido un error");
                }
            }
        }
        //actualizarDatosXML();
        return modeloTabla;
    }
     
//muestra el articulo mas vendido
     public String articuloMasVendido(){
         Articulo herramienta = new Articulo();
        Element aux = new Element("articulo");
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        Element masVendido = null;
        int cantidad = 0;
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();
            if(Integer.parseInt(e.getChildText("vendido"))> cantidad){
                masVendido = e;
                cantidad = Integer.parseInt(e.getChildText("vendido"));
            }
        }  
        if(masVendido != null){
            String retornar;
            retornar = "Articulo: "+ masVendido.getChildText("nombre");
            retornar += "   ID: " + masVendido.getChildText("ID");
            retornar += "   Candidad: "+ masVendido.getChildText("vendido");
            return retornar;
        }else
            return "todavia no hay una articulo mas vendido";
     }
    
//guarda  la cantidad vendida de un articulo 
    public void guardarCantidadVendida(String ID, String vendidos){
        Element aux = new Element("articulo");
        int cantidad = 0;
        List articulo = this.root.getChildren("articulo");
        Iterator i = articulo.iterator();
        try{
        while (aux != null && i.hasNext()) {
            Element e = (Element) i.next();
            if(ID.equals(e.getChildText("ID"))){  
                cantidad = Integer.parseInt(vendidos) + Integer.parseInt(e.getChildText("vendido"));
                e.getChild("vendido").setText(String.valueOf(cantidad));
                //try{
                    int a= Integer.parseInt(e.getChild("unidades").getText());
                    a= a-Integer.parseInt(vendidos);
                    if (a<0)
                        e.getChild("unidades").setText("0");
                    else
                        e.getChild("unidades").setText(Integer.toString(a));
                /*}
                catch(NullPointerException ex){
                    System.out.println("Error Aca");
                    e.getChild("unidades").setText("0");
                }*/
             
                actualizarDatosXML();
            }
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
    }
}
