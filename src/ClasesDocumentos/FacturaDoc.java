/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDocumentos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import proyectoferreteria.Factura;

/**
 *
 * @author Army
 */
public class FacturaDoc {
    
    private Element root = new Element("Clientes");
    private String fileLocation = "src//Archivos//XMLFacturas.xml";
    
    public FacturaDoc(){
    try {
            SAXBuilder builder = new SAXBuilder(false);
            Document doc;
            
            doc = builder.build(fileLocation);
            root = doc.getRootElement();
        } catch (JDOMException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
            updateDocument();
            
        } catch (IOException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        }
    
}
    private void updateDocument() {
        try {
            XMLOutputter out = new XMLOutputter(org.jdom2.output.Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(fileLocation);
            out.output(root, file);
            file.flush(); 
            file.close();
            
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            
        }
    }
    
    public int getsize(){
        return root.getContentSize();
    }
    
    public Element facturaToElement(Factura dato) throws ParseException{
        Element factura= new Element("factura");
        
        Element fecha= new Element("fecha");
        fecha.setText(parseToString(dato.getFecha()));
        
        Element total= new Element("total");
        total.setText(parseToString(dato.getPrecioT()));
        
        Element IVA= new Element("IVA");
        IVA.setText(parseToString(dato.getTotalIVA()));
        
        Element subTotal= new Element ("subTotal");
        subTotal.setText(parseToString(dato.getSubTotal()));
        
        Element numFactura= new Element("numero");
        numFactura.setText(Integer.toString(dato.getNumFactura()));
        
        factura.addContent(fecha);
        factura.addContent(total);
        factura.addContent(IVA); 
        factura.addContent(subTotal);
        factura.addContent(numFactura);
        
        return factura;
    }
    
    public void agregarFactura(Factura dato) throws ParseException{
        root.addContent(facturaToElement(dato));
        updateDocument();
    }
    
    public void eliminarFactura(String NumFactura){
        
        Element aux = new Element("factura");
        List numero = this.root.getChildren("factura");
        Iterator i = numero.iterator();
        boolean flag=false;
        Element Found = null;
        while (aux != null && i.hasNext() ) {
            Element e = (Element) i.next();
            if(NumFactura.equals(e.getChildText("numero"))){
                //articulo.remove(e);
                //actualizarDatosXML();
                Found=e;
                flag=true;
                NumFactura="";
                //i.next();
            }
            if (flag){
                int n=Integer.parseInt(e.getChildText("numero"));
                n=n-1;
                e.getChild("numero").setText(Integer.toString(n));
            }
        } 
        numero.remove(Found);
        updateDocument();
    }
    
    public void arrayToElement(ArrayList<Factura> facturas) throws ParseException{
        boolean removeChildren = root.removeChildren("factura");      
        ArrayList<Factura> lista=facturas;
        if (!lista.isEmpty()){
            for (Factura e:lista){
                agregarFactura(e);
            }
        }
        updateDocument();
        
    }
    
    public Factura elementToFactura(Element element) throws ParseException{
        Factura factura=new Factura(ParseFecha(element.getChildText("fecha")),parseToFloat(element.getChildText("total")),
                parseToFloat(element.getChildText("IVA")),parseToFloat(element.getChildText("subTotal")),Integer.parseInt(element.getChildText("numero")));
        return factura;
    }
    
    public ArrayList<Factura> elementToArray() throws ParseException{
        ArrayList<Factura> lista= new ArrayList<>();
        
        for (Object it:root.getChildren()){
            Element xmlElem = (Element) it;
            lista.add(elementToFactura(xmlElem));
        }
    return lista;
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
        return reportDate;
    }
    
    public Calendar ParseFecha(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        Calendar aux= new GregorianCalendar();
        try {
            fechaDate = formato.parse(fecha);
            aux.setTime(fechaDate);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return aux;
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
    }
    
    public float parseToFloat(String valor) throws ParseException {
        DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.'); 
        DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
        if (valor.contains(",00"))
            valor.replace(",00", "");
      
           
        
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
    
}
