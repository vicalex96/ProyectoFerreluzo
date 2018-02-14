 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ClasesDocumentos.Documento;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jdom2.Element;
import proyectoferreteria.*;
import java.lang.String;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author VícAlex
 */
public class Controladora {
    
    private Inventario listado;
    
    public Controladora() {
        listado = new Inventario();
    }
    
    /**
     * Limpia un String numerico, de todo que no sea un numero.
     * @param palabra
     * @return String
     */
    public String limpiarPalabra(String palabra){
            palabra=palabra.replaceAll("//W","");
            palabra=palabra.replaceAll("-", "");
            palabra=palabra.replaceAll("V", "");
            palabra=palabra.replaceAll("E", "");
            palabra=palabra.replaceAll("J", "");
            return palabra;
    }
    
    public Venta filtrarClientes(String cedula, ArrayList<Venta> Compradores){
        ArrayList<Venta> lista=Compradores;
        String palabra;
        Venta found=null;
        if (lista.isEmpty()){ 
            return null;
        }
        for (Venta e:lista){
            palabra=e.getComprador().getDocumento();
            if (limpiarPalabra(palabra).equals(limpiarPalabra(cedula))){
                found=e;
            }    
        }
        
     return found;
    }
    
    public void camposCompletos(JTextField cedula, JTextField nombre, JTextField direccion, JTextField telefono ){
        boolean respuesta=false;
        
        try {
            int num=Integer.parseInt(cedula.getText());
               }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Error algun valor numerico no es valido",
                "Advertencia",JOptionPane.WARNING_MESSAGE);
            return;
        } 
    }

    public void validarEntero (String numero, String mensaje){
        try{
         int numero1 = Integer.parseInt(numero);
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,mensaje,"Debe indicar un numero entero", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void validaLetra(java.awt.event.KeyEvent evt){
    int k=(int)evt.getKeyChar();
       if ((k < 97 || k > 122) && (k<65 || k>90) && k!=20 && k!=8 && k!=32 && k!=127)
       {
          evt.setKeyChar((char)KeyEvent.VK_CLEAR); 
          //JOptionPane.showMessageDialog(null,"Sólo debe ingresar letras","Error Datos",JOptionPane.ERROR_MESSAGE);
       }
    }
    
    
    public void validaNumero(java.awt.event.KeyEvent evt) {                                         
        char car = evt.getKeyChar();
        if(car<'0' || car>'9') evt.consume();
        
    }
    
    public void validaNumeroSigno(java.awt.event.KeyEvent evt) {                                         
        char car = evt.getKeyChar();
        if((car<'0' || car>'9') && (car<',' || car>='.')) evt.consume();
    }
 
  
    
    public boolean guardarCliente(ArrayList<Cliente> Clientes,JTextField cedula,JTextField nombre,
            JTextField direccion, JTextField telefono, JComboBox nacionalidad){
        
        
        if (nacionalidad.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null,"Seleccion la nacionalidad",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
                return false;
            }
        
        if((cedula.getText().isEmpty())||(nombre.getText().isEmpty())||(direccion.getText().isEmpty())||
                    (telefono.getText().isEmpty())){
            JOptionPane.showMessageDialog(null,"Exiten campos vacios",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            return false;
            
            
        }
        else{
            Cliente persona= new Cliente(nombre.getText(),nacionalidad.getSelectedItem()+"-"+cedula.getText(),direccion.getText(),telefono.getText());
            Clientes.add(persona);
            JOptionPane.showMessageDialog(null,"El cliente se guardo con exito");
            return true;
        }
    }

    public void llenarTabla(ArrayList<Cliente> Clientes,JTable tabla){

        String[] columna = { "Nombre", "CI/RIF", "Direccion", "Telefono" };
            DefaultTableModel dtm = new DefaultTableModel(null,columna){
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
                //se puede indicar por comlunas o finlas editables
            }
        };
            ArrayList<Cliente> Lista=Clientes;
            for (Cliente e: Lista)
            {
                String[] row = {e.getNombre(),e.getDocumento(),e.getDireccion(),e.getTelefono()};
                dtm.addRow(row);
            }
            tabla.setModel(dtm);
    }
    
    
    
    
    public void filtrarTablaCliente(ArrayList<Cliente> data,JTextField ClienteBuscar,
                                JTable tablaCliente,int criterioBuscar){
        String palabra = ClienteBuscar.getText();
        int length= palabra.length();
        palabra.toCharArray();
        palabra.toLowerCase();
        ArrayList<Cliente> listado = data;
        String[] columna = { "Nombre", "CI/RIF", "Direccion","Telefono"};
        DefaultTableModel modeloTabla = new DefaultTableModel(null,columna){
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
                //se puede indicar por comlunas o finlas editables
            }
        };
        //buscar cliente por nombre
        if(criterioBuscar == 0){
            for(Cliente e:listado){
                e.getNombre().toLowerCase();
                int agregar = 0;
                if(palabra.length() > e.getNombre().length() )
                    agregar = 1; 
                else 
                    for(int i=0;i< length && i < e.getNombre().length();i++){
                        char char1 = palabra.toLowerCase().charAt(i);
                        char char2 = e.getNombre().toLowerCase().charAt(i);
                        //char char3 = e.getNombre().substring(e.getNombre().indexOf(" ")+1,e.getNombre().length()).toLowerCase().charAt(i);
                       // System.out.println(char3);
                        if((char1 != char2 ))//&&(char1!=char3))
                            agregar = 1;       
                }
                if(agregar == 0){
                    String[] row = {e.getNombre(), e.getDocumento(),e.getDireccion(),e.getTelefono()};
                    modeloTabla.addRow(row);  
                }      
            }
        tablaCliente.setModel(modeloTabla);      
        }
        //buscar cliente por cedula
        if(criterioBuscar == 1){
            for(Cliente e:listado){
                String[] parte = e.getDocumento().split("-");
                int agregar = 0;
                if(palabra.length() > parte[1].length() )
                    agregar = 1; 
                else
                    for(int i=0;i< length && i < parte[1].length();i++){
                        char char1 = palabra.toLowerCase().charAt(i);
                        char char2 = parte[1].toLowerCase().charAt(i);
                        if(char1 != char2 )
                            agregar = 1;       
                    }
                if(agregar == 0){
                    String[] row = {e.getNombre(), e.getDocumento(),e.getDireccion(),e.getTelefono()};
                    modeloTabla.addRow(row);  
                }      
            }
        tablaCliente.setModel(modeloTabla);
        }
    }
    
    public void filtrarTablaCliente(JTextField ClienteBuscar,
                                JTable tablaCliente,int criterioBuscar){
        String palabra = ClienteBuscar.getText();
        int length= palabra.length();
        palabra.toCharArray();
        palabra.toLowerCase();
        ArrayList<Articulo> lista = listado.getListado();
        JTable tabla = tablaCliente;
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        int i=0;
        int Count = tabla.getRowCount();
        System.out.println(criterioBuscar);
        while (i!=Count){
                dtm.removeRow(0);
                i++;
                }
        //buscar cliente por nombre
        if(criterioBuscar == 0){
            for(Articulo e:lista){
                e.getNombre().toLowerCase();
                int agregar = 0;
                if(palabra.length() > e.getNombre().length() )
                    agregar = 1; 
                else 
                    for(i=0;i< length && i < e.getNombre().length();i++){
                        char char1 = palabra.toLowerCase().charAt(i);
                        char char2 = e.getNombre().toLowerCase().charAt(i);
                        //char char3 = e.getNombre().substring(e.getNombre().indexOf(" ")+1,e.getNombre().length()).toLowerCase().charAt(i);
                       // System.out.println(char3);
                        if((char1 != char2 ))//&&(char1!=char3))
                            agregar = 1;       
                }
                if(agregar == 0){
                    String[] row = {e.getNombre(), Integer.toString(e.getID()),e.getFamilia(),e.getDescripcion()};
                    dtm.addRow(row);  
                }      
            }
        tablaCliente.setModel(dtm);      
        }
        //buscar cliente por cedula
        if(criterioBuscar == 2){
            for(Articulo e:lista){
                String parte = Integer.toString(e.getID());
                int agregar = 0;
                if(palabra.length() > parte.length() )
                    agregar = 1; 
                else
                    for(i=0;i< length && i < parte.length();i++){
                        char char1 = palabra.toLowerCase().charAt(i);
                        char char2 = parte.toLowerCase().charAt(i);
                        if(char1 != char2 )
                            agregar = 1;       
                    }
                if(agregar == 0){
                    String[] row = {e.getNombre(), Integer.toString(e.getID()),e.getFamilia(),e.getDescripcion()};
                    dtm.addRow(row);  
                }      
            }
        tablaCliente.setModel(dtm);
        }
    }
    
    /**
     * Bloquea o desbloquea los diferentes campos de JTextField y JComboBox
     * @param enabled - true para desbloquear y false para bloquear
     * @param fieldNombre - JTextField del campo Nombre
     * @param fieldCI - JTextField del campo Cedula
     * @param fieldDireccion - JTextField del campo Direccion
     * @param fieldTelefono - JTextField del campo Telefono
     * @param comboNacional - JComboBox de la seleccion de Nacionalidad
     */
    public void enableFields(boolean enabled,JTextField fieldNombre, JTextField fieldCI, JTextField fieldDireccion, JTextField fieldTelefono, JComboBox comboNacional){
        if (enabled){
            fieldNombre.setEnabled(true);
            fieldDireccion.setEnabled(true);
            fieldTelefono.setEnabled(true); 
            comboNacional.setEnabled(true);
        }
        else{
            fieldNombre.setEnabled(false);
            fieldDireccion.setEnabled(false);
            fieldTelefono.setEnabled(false);
            comboNacional.setEnabled(false);
        }
    }
    
    /**
     * Llena los diferentes campos JTextField y JComboBox con los datos dados.
     * Tiene la funcion de bloquear o no los campos.
     * @param nombre - String para llenar en el campo Nombre
     * @param cedula - String para llenar en el campo cedula
     * @param direccion -String para llenar en el campo direccion
     * @param telefono - String para llenar en el campo telefono
     * @param fieldNombre - JTextField del campo Nombre
     * @param fieldCI - JTextField del campo Cedula
     * @param fieldDireccion - JTextField del campo Direccion
     * @param fieldTelefono - JTextField del campo Telefono
     * @param comboNacional  - JComboBox de la seleccion de Nacionalidad
     * @param bloq - Boolean para bloquear o no los campos (false para bloquear y true para desbloquear)
     */
    public void setFields(String nombre, String cedula, String direccion, String telefono, 
            JTextField fieldNombre, JTextField fieldCI, JTextField fieldDireccion, JTextField fieldTelefono, JComboBox comboNacional,boolean bloq){
        fieldNombre.setText(nombre);
        if (cedula.startsWith("")){
            comboNacional.setSelectedIndex(0);
        }
        if (cedula.startsWith("V")){
            comboNacional.setSelectedIndex(1);
        }
        if (cedula.startsWith("E")){
            comboNacional.setSelectedIndex(2);
        }
        if (cedula.startsWith("J")){
            comboNacional.setSelectedIndex(3);
        }
        fieldCI.setText(limpiarPalabra(cedula));
        fieldDireccion.setText(direccion);
        fieldTelefono.setText(telefono);
        enableFields(bloq,fieldNombre,fieldCI,fieldDireccion,fieldTelefono,comboNacional);
        
        
    }
 
        public int getID(){
        if(listado.getListado() != null)
            return listado.getListado().size();
        else
            return 0;   
    }
    
    //revisar errores al agregar o editar Articulos
    public String validaciones(JTextField Fnombre,JTextField FcodigoBarras,
            JTextField Funidades, JTextField Fcosto,
            JTextField  Fimpuesto,JTextField Fprecio) throws ParseException{
        String Error = "";
            //valida nombre
        try{    
            if( Fnombre.getText().matches("^[ ]*"))
                Error = Error + "- El Articulo tiene que tener un nombre \n";
            
            long validar;
            String codigoBarras = "";
            if(!"".equals(FcodigoBarras.getText())){
                try{
                    validar = Long.parseLong(FcodigoBarras.getText());
                    codigoBarras = String.valueOf(validar);
                }
                catch(NumberFormatException e){
                    Error = Error + "- Codigo de barras presenta digitos invalidos \n"; 
                }
            }
        
            //Revisa si las unidades son un numero valido
            int unidades = 0;
            if(!"".equals(Funidades.getText())){
                try{
                    unidades = Integer.parseInt(Funidades.getText());
                }  
                catch(NumberFormatException e){
                    Error = Error + "- valor de exitencias invalido \n"; 
                    }    
                }
        
            //revisa que se haya ingresado valor numerico en costo
            float costo = 0;
            try{
                costo= parseToFloat(Fcosto.getText());
            }
            catch(NumberFormatException e){
                Error = Error + "- El costo no valido \n";
            }
            
            //revisa que impuesto este dentro de rango
            try{
                float impuesto = parseToFloat(Fimpuesto.getText()); 
                if(impuesto > 100 || impuesto < 0)
                Error = Error + "- Impuesto Fuera de rango( 0% - 100% ) \n";
            }catch(NumberFormatException e){
                Error = Error + "- Valor de impuesto no es vlido \n";
            }
  
            float precio = 0;
            try{ 
                precio= parseToFloat(Fprecio.getText());
            }
            catch(NumberFormatException e){
                Error = Error + "- El precio de venta no es valido \n";
            }
        }
        catch(NumberFormatException e){
            Error = "- no se han llenado todos los campos obligatorios (*) \n";
        }
        return Error;
    }
    
    //agrega los datos de los jFields a un Articulo
    public void crearArticulo(JTextField Fnombre,JTextField FcodigoBarras, JTextField Ffamilia,
            JTextField Funidades, JTextArea Fdescripcion, JTextField Fcosto,
            JTextField  Fimpuesto,JTextField Fprecio,Documento doc) throws ParseException{
        String Error = "";
        //busca si hay errores de compatibildidad con los datos Jfield
        Error = validaciones(Fnombre,FcodigoBarras,
             Funidades, Fcosto, Fimpuesto, Fprecio);
        if(Error == ""){
            //guarda los field en variables
            String nombre  = Fnombre.getText();
            String familia = Ffamilia.getText();
            String  codigoBarras = "";
            if(!"".equals(FcodigoBarras.getText())){
                long validar = Long.parseLong(FcodigoBarras.getText());
                codigoBarras = String.valueOf(validar);
            }
            int unidades = 0;
            if(!"".equals(Funidades.getText()))
                unidades = Integer.parseInt(Funidades.getText());  
            String descripcion = Fdescripcion.getText();
            float impuesto = parseToFloat(Fimpuesto.getText()); 
            float costo= parseToFloat(Fcosto.getText());
            float precio= parseToFloat(Fprecio.getText());
            
            //guarda las variables en el objeto 
            listado.nuevoArticulo(nombre,codigoBarras, familia,
                            unidades, descripcion, 
                            costo,impuesto, precio,doc);
            JOptionPane.showMessageDialog(null, "Articulo agregado correctamente");
        }else
            JOptionPane.showMessageDialog(null,"Error: \n" + Error,"Error",2);  
    }
    
    //editar articulo seleccionado
    public boolean editarArticulo(String ID, JTextField Fnombre,JTextField FcodigoBarras, JTextField Ffamilia,
            JTextField Funidades, JTextArea Fdescripcion, JTextField Fcosto,
            JTextField  Fimpuesto,JTextField Fprecio,Documento xml) throws ParseException{
        
        String Error = "";
        //busca si hay errores de compatibildidad con los datos Jfield
         Error = validaciones(Fnombre,FcodigoBarras,
             Funidades, Fcosto, Fimpuesto, Fprecio);
        if(Error == ""){
            //guarda los field en variables
            String nombre  = Fnombre.getText();
            String familia = Ffamilia.getText();
            String  codigoBarras = "";
            if(!"".equals(FcodigoBarras.getText())){
                long validar = Long.parseLong(FcodigoBarras.getText());
                codigoBarras = String.valueOf(validar);
            }
            String unidades = Funidades.getText();
            String descripcion = Fdescripcion.getText();
            String impuesto = Fimpuesto.getText(); 
            String costo= Fcosto.getText();
            String precio= Fprecio.getText();
            
            //guarda las variables en el objeto      
            xml.editarArticulo( ID,  nombre, codigoBarras,  familia,
                unidades,  descripcion,  costo, impuesto, precio);
            JOptionPane.showMessageDialog(null, "Articulo editado correctamente");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Error: \n" + Error,"Error",2);
             return false;
        }
        
    }
    
    /**
     *Busca un objeto de tipo Inventario, con la tabla de la seleccion y el xml.
     * @param tablaArticulo JTable con la seccion.
     * @param doc Objeto de tipo Documento, que contiene el Inventario
     * @return El objeto de tipo Articulo encontrado
     * @throws java.text.ParseException
     */
        public Articulo agregarArticulo(JTable tablaArticulo, Documento doc) throws ParseException{
        int tableSelection = tablaArticulo.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel) tablaArticulo.getModel();
        String ID = dtm.getValueAt(tableSelection,1).toString();   
        Articulo e = doc.cargarDatosArticulo(ID);
        return e;
    }
   
    /**
     *
     * @param tablaArticulo
     * @param producto
     * @return
     */
    public void agregarArticulo(JTable tablaArticuloCaja, String nombre, String ID,
                                String descripcion,String IVA, String precio, String unidades){
        
        DefaultTableModel dtm = (DefaultTableModel) tablaArticuloCaja.getModel();
        String[] row = {nombre,ID,descripcion,unidades,IVA,precio};
        dtm.addRow(row);
        tablaArticuloCaja.setModel(dtm);     
    }
    
    public DefaultTableModel filtrarTablaArticulo(JTable Tabla, String busqueda, int Criterio,int tipoTabla){
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
                if(tipoTabla == 2  && columnas >= 2) 
                    return  true;
                else 
                return  false;
                //se puede indicar por comlunas o finlas editables
            }
        }; 
        //determina que valor se va a leer del articulo en el XML
        int dato = 0;
        switch(Criterio){
            case 0: dato = 0;
                break;
            case 1: dato = 1;
                break;
            case 2: dato = 2;
                break;
        }
        for(int i=0; i < Tabla.getRowCount(); i++){
        int length = busqueda.length();
            int agregar = 0;
            if(busqueda.length() > ((String) Tabla.getValueAt(i,dato)).length() )
                agregar = 1; 
            else
            for(int h = 0; h < length && h < ((String) Tabla.getValueAt(i,dato)).length(); h++){
                char char1 = busqueda.toLowerCase().charAt(h);
                char char2 = ((String) Tabla.getValueAt(i,dato)).toLowerCase().charAt(h);
                if(char1 != char2)
                    agregar = 1;
                }
            if(agregar == 0){
                String[] edit = {((String) Tabla.getValueAt(i,0)), 
                                 ((String) Tabla.getValueAt(i,1)),
                                 ((String) Tabla.getValueAt(i,2)), 
                                 ((String) Tabla.getValueAt(i,3))};
                            modeloTabla.addRow(edit);
                }    
        
        } 
    return modeloTabla;
    }
    
    public DefaultTableModel filtrarTablaArticuloCaja(JTable Tabla, String busqueda, int Criterio){
         DefaultTableModel dtm=copyTableModel((DefaultTableModel)Tabla.getModel());
         dtm=removeRows(dtm);
        //determina que valor se va a leer del articulo en el XML
        int dato = 0;
        switch(Criterio){
            case 0: dato = 0;
                break;
            case 1: dato = 1;
                break;
            case 2: dato = 2;
                break;
        }
        for(int i=0; i < Tabla.getRowCount(); i++){
        int length = busqueda.length();
            int agregar = 0;
            if(busqueda.length() > ((String) Tabla.getValueAt(i,dato)).length() )
                agregar = 1; 
            else
            for(int h = 0; h < length && h < ((String) Tabla.getValueAt(i,dato)).length(); h++){
                char char1 = busqueda.toLowerCase().charAt(h);
                char char2 = ((String) Tabla.getValueAt(i,dato)).toLowerCase().charAt(h);
                if(char1 != char2)
                    agregar = 1;
                }
            if(agregar == 0){
                String[] edit = {((String) Tabla.getValueAt(i,0)), 
                                 ((String) Tabla.getValueAt(i,1)),
                                 ((String) Tabla.getValueAt(i,2)), 
                                 ((String) Tabla.getValueAt(i,3))};
                            dtm.addRow(edit);
                }    
        
        } 
    return dtm;
    }
    
    //revisa que las tablas  (tabla de uso y el comparador)de Editar rapido sean o no iguales
    public boolean revisarIgualdadTabla(JTable tabla1, JTable tabla2){
        String Ta;
        String Tb; 
        for(int i = 0; i<tabla1.getRowCount();i++){
            Ta =(String)tabla1.getValueAt(i, 2);
            Tb =(String)tabla2.getValueAt(i, 2);
            if( !Ta.equals(Tb) )
                return false;
            Ta =(String)tabla1.getValueAt(i, 3);
            Tb =(String)tabla2.getValueAt(i, 3);
            if(!Ta.equals(Tb))
                return false;      
        }
        return true;
    }
    
    //busca a traves del documento de identidad los posibles datos de un cliente en el sistema
    public Cliente buscarCliente(String CI_RIF, String inicial, ArrayList<Cliente> personas){
    int length = CI_RIF.length();
    
    for(Cliente e : personas){
        boolean iguales = true;
        String[] parte = e.getDocumento().split("-");
        if(!parte[0].equals(inicial))
            iguales = false;
        if(!CI_RIF.equals(parte[1]))
            iguales = false;        
        if(iguales == true){
        return e;
        }
    }
    
    return null;
    }
    
    public DefaultTableModel cargarTablaVenta(ArrayList<Venta> ventas){
        String[] columna= {"Cliente", "CI/RIF", "Telefono"};
        ArrayList<Venta> lista=ventas;
        DefaultTableModel tabla=new DefaultTableModel(null,columna){
            @Override
            public boolean isCellEditable(int filas, int columnas) {             
                    return  false;
                //se puede indicar por comlunas o finlas editables
            }
        }; 
        for (Venta e:lista){
            String[] row={  e.getComprador().getNombre(),
                            e.getComprador().getDocumento(),
                            e.getComprador().getTelefono(),
                            };
            tabla.addRow(row);
        }
        return tabla;
    }



    public DefaultTableModel copyTableModel (DefaultTableModel tabla){
        final DefaultTableModel copy = new DefaultTableModel(tabla.getRowCount(), 0);
            for (int column = 0; column < tabla.getColumnCount(); column++) {
                copy.addColumn(tabla.getColumnName(column));
                for (int row = 0; row < tabla.getRowCount(); row++)
                    copy.setValueAt(tabla.getValueAt(row, column), row, column);
        }      
        return copy;
    }

    /**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
     */
    
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    public String parseToString(Calendar fecha){
        DateFormat nuevaFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date today;
        // Get the date today using Calendar object.
        if (fecha == null)
            today = Calendar.getInstance().getTime(); 
        else 
            today = fecha.getTime();
        // Using DateFormat format method we can create a string 
        // representation of a date with the defined format.
        String reportDate = nuevaFecha.format(today);

        // Print what date is today!
        //System.out.println("Report Date: " + reportDate);
        return reportDate;
    }
    
    public String parseToString (float valor) throws ParseException{
        long valorGrande;
        /*if(valor >= 10000000){       
        valorGrande = (long) valor; 
        return Long.toString(valorGrande);
        }*/
        
        DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.');
        DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
        String f=formateador.format(valor);
        if (!f.contains(","))
            f=f+",00";
        
        if (f.substring(f.indexOf(",")).length()==2)
           f=f+"0";
        
        return f;
                //Float.toString(valor);
    }
    
    public DefaultTableModel cargarTablaFacturas(ArrayList<Factura> facturas) throws ParseException{
        String[] columna={"Fecha","Numero de Factura","Sub-Total", "IVA", "Total"};
        ArrayList<Factura> lista=facturas;
        DefaultTableModel dtm=new  DefaultTableModel (null,columna){
            @Override
            public boolean isCellEditable(int filas, int columnas) {             
                    return  false;
                //se puede indicar por comlunas o finlas editables
            }
        };
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        
        for (Factura e:lista){
            String[] row = {parseToString(e.getFecha()),
                            Integer.toString(e.getNumFactura()),
                            parseToString(e.getSubTotal()),
                            parseToString(e.getTotalIVA()),
                            parseToString(e.getPrecioT())
                            };
            dtm.addRow(row);
        }
        return dtm;
    }
    
    public float parseToFloat(String valor) throws ParseException {
        DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.'); 
        DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
        if (valor.contains(",00"))
            valor=valor.replace(",00", "");
        if (!valor.contains(".")){
            valor=valor.replace(",",".");
            return Float.parseFloat(valor);
        }    
        try{
        double a =(double) formateador.parseObject(valor);
        float b= (float) a;
        return b;
        }
        catch(ClassCastException e){
        long a =(long) formateador.parseObject(valor);
        float b= (float) a;
        return b;
        }
        
    }
    
    public boolean checkTable(JTable tabla,String ID,String num){
        int i=0;
        int b= Integer.parseInt(num);
        while(i<tabla.getRowCount()){
            if (ID.equals(tabla.getValueAt(i, 1).toString())){
                int a=Integer.parseInt(tabla.getValueAt(i,3 ).toString());
                tabla.setValueAt(a+b, i, 3);
                return true;
               
            }
            i++;
        }
        return false;
    }

    public DefaultTableModel removeRows(DefaultTableModel dtm){
        
        while(dtm.getRowCount()>0){
            int a=dtm.getRowCount()-1;
            dtm.removeRow(a);
        }
        return dtm;
    }
}