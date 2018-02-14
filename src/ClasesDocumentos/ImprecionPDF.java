/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDocumentos;

import Interfaz.menuCaja;
import ClasesDocumentos.FacturaDoc;
import Controlador.Controladora;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import org.jdom2.output.XMLOutputter;
import proyectoferreteria.Factura;


/**
 *
 * @author VícAlex
 */
public class ImprecionPDF {
     private File archivo;
     private FileOutputStream pdf;
     private Document docPDF;

    public ImprecionPDF() {
         try {
             archivo = new File("src//Archivos//Facturas.pdf");
             pdf = new FileOutputStream(archivo);
             docPDF = new Document(); 
         } catch (FileNotFoundException ex) {
             Logger.getLogger(ImprecionPDF.class.getName()).log(Level.SEVERE, null, ex);
         }
           
    }
    
    public ImprecionPDF(String NombreFactura) {
         try {
             archivo = new File("src//Archivos//" + NombreFactura + ".pdf");
             pdf = new FileOutputStream(archivo);
             docPDF = new Document(); 
         } catch (FileNotFoundException ex) {
             Logger.getLogger(ImprecionPDF.class.getName()).log(Level.SEVERE, null, ex);
         }
           
    }
     
    public void crearFacturasPDF() throws ParseException{
        try {
            PdfWriter.getInstance(docPDF, pdf);
            docPDF.open();
            try {
                //agrega el logo del local al pdf
                Image imagen = Image.getInstance("src/Imagenes/ferreluso_hammer_logo_negro.png");
                imagen.setAlignment(Element.ALIGN_CENTER);
                imagen.scaleToFit(155, 202);
                docPDF.add(imagen);
                
                //crea el titulo
                Paragraph titulo = new Paragraph(24);
                Font fuente =  new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
                titulo.add("Listado de Facturas");
                titulo.setAlignment(Element.ALIGN_CENTER);
                titulo.add(Chunk.NEWLINE);
                titulo.add(Chunk.NEWLINE);
                
                docPDF.add(titulo);
                               
                //tabla
                PdfPTable tabla = new PdfPTable(5);
                tabla.setWidthPercentage(100);
                
                
                //celdas de la primera fila
                PdfPCell celda1= new PdfPCell(new Phrase("Fecha",fuente));
                         celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
                         celda1.setBackgroundColor(BaseColor.GRAY);
                PdfPCell celda2= new PdfPCell(new Phrase("Nro Factura",fuente));
                         celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
                         celda2.setBackgroundColor(BaseColor.GRAY);
                         System.out.println(celda2.getColspan());
                PdfPCell celda3= new PdfPCell(new Phrase("Ingreso Bruto (Bs.).",fuente));
                         celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
                         celda3.setBackgroundColor(BaseColor.GRAY);
                PdfPCell celda4= new PdfPCell(new Phrase("Impuesto (Bs.)",fuente));
                         celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
                         celda4.setBackgroundColor(BaseColor.GRAY);
                PdfPCell celda5= new PdfPCell(new Phrase("Ingreso Neto (Bs.)",fuente));
                         celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
                         celda5.setBackgroundColor(BaseColor.GRAY);
                //agregas las celadas creadas a la tabla        
                tabla.addCell(celda1); 
                tabla.addCell(celda2);
                tabla.addCell(celda3);
                tabla.addCell(celda4);
                tabla.addCell(celda5);
                
                //carga las facturas en el pdf
                FacturaDoc xmlFactura =new FacturaDoc();
                ArrayList<Factura> listaFactura = new ArrayList<>(); 
                listaFactura = xmlFactura.elementToArray();
                
                for(Factura e: listaFactura ){
                    tabla.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(xmlFactura.parseToString(e.getFecha()));
                    tabla.addCell(" "+e.getNumFactura());
                    tabla.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
                    tabla.addCell(" "+xmlFactura.parseToString(e.getSubTotal()));
                    tabla.addCell(" "+xmlFactura.parseToString(e.getTotalIVA()));
                    tabla.addCell(" "+xmlFactura.parseToString(e.getPrecioT()));                    
                }
                
                //agrega la tabla al pdf               
                docPDF.add(tabla);
                               
                //cierra la edicion del pdf
                docPDF.close();
                pdf.close();
                //abre el pdf en el sistema
                Desktop.getDesktop().open(archivo);
            } catch (BadElementException ex) {
                Logger.getLogger(menuCaja.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(menuCaja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DocumentException ex) {
            Logger.getLogger(menuCaja.class.getName()).log(Level.SEVERE, null, ex);
            }   
        
    }
    
    public void crearFactura(Factura objeto, JTable tablaArticulos, int numeroFactura) throws ParseException{
    try {
            PdfWriter.getInstance(docPDF, pdf);
            docPDF.open();
            try {
                
                //crea el titulo
                Paragraph titulo = new Paragraph(24);
                Font fuente =  new Font(Font.FontFamily.TIMES_ROMAN, 8, 12, BaseColor.BLACK);
                titulo.add("                                    SENIAT "
                       + "\n                               J-400858259 "
                       + "\n       FERRETERIA Y BAZAR FERRELUSO C.A. "
                       + "\n            CALLE COLEGIO AMERICANO EDIF "
                       + "\n                  CHILA PISO 21-14 LOCAL 1"
                       + "\n             SECTOR LAS MINAS DE BARUTA"
                       + "\n                  TELEFONO: 0212-945-85-39"
                       + "\n                               FACTURA\n");
                titulo.setFont(fuente);
                
                docPDF.add(titulo);
                // crea tabla con los datos de compra
                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(50);
                table.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.setWidths(new int[]{4, 2});
                table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
                FacturaDoc xmlFactura = new FacturaDoc();
                table.addCell(xmlFactura.parseToString(objeto.getFecha()));
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
                if((objeto.getFecha().get(Calendar.MINUTE)==0) && (objeto.getFecha().get(Calendar.HOUR_OF_DAY)==0)){
                table.addCell("Hora: 12:00");     
                }else{
                table.addCell("Hora: "+  String.valueOf(objeto.getFecha().get(Calendar.HOUR_OF_DAY)+":"
                                     +(objeto.getFecha().get(Calendar.MINUTE))));
                }
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell("Factura N");
                table.addCell(Integer.toString(objeto.getNumFactura()));
                docPDF.add(table);
                titulo= new Paragraph(24);
                titulo.add("_______________________________________\n\n");
                docPDF.add(titulo);
                
                
                //crea tabla con los articulos
                table = new PdfPTable(3);
                table.setWidthPercentage(50);
                table.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.setWidths(new int[]{3, 1, 3});
                table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
                table.addCell("Descripcion");
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell("Cant");
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell("Monto");
                for(int i = 0; i< tablaArticulos.getRowCount(); i++){
                    
                    String Producto =(String)tablaArticulos.getValueAt(i, 0);
                    String Precio = "Bs. " + (String)tablaArticulos.getValueAt(i, 5) ;
                    String Cant=(String)tablaArticulos.getValueAt(i, 3);
                    if(Producto.length() >=25)
                        Producto = Producto.substring(0, 22)+"...";
                    else {
                        while(Producto.length() <25){
                            Producto = Producto + " "; 
                        } 
                    } 
                    table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(Producto);
                    table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(Cant);
                    table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(Precio);
                    
                }
                docPDF.add(table);
                docPDF.add(titulo);
                
                
                //crea tabla con montos totales
                table = new PdfPTable(2);
                table.setWidthPercentage(50);
                table.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.setWidths(new int[]{4, 3});
                table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell("Sub-Total");
                
                table.addCell("Bs. "+xmlFactura.parseToString(objeto.getSubTotal()));
                
                table.addCell("IVA:");
                
                table.addCell("Bs. "+xmlFactura.parseToString(objeto.getTotalIVA()));
                
                table.addCell("Total");
                
                table.addCell("Bs. "+xmlFactura.parseToString(objeto.getPrecioT()));
                docPDF.add(table);
                
                titulo= new Paragraph(24);
                fuente=new Font(Font.FontFamily.TIMES_ROMAN,12,Font.ITALIC);
                titulo.setFont(fuente);
                titulo.add("\n      ** No Fiscal**");
                
                docPDF.add(titulo);
                
                
                
                
                /*titulo = new Paragraph(24);
                titulo.add("FACTURA:                                " + numeroFactura + "\n"
                         + "FECHA: " + String.valueOf(objeto.getFecha().get(Calendar.DAY_OF_MONTH)+"-"
                                     +(objeto.getFecha().get(Calendar.MONTH)+1)+"-"+objeto.getFecha().get(Calendar.YEAR))
                         + "                    Hora:"+  String.valueOf(objeto.getFecha().get(Calendar.HOUR_OF_DAY)+":"
                                     +(objeto.getFecha().get(Calendar.MINUTE))) +"\n"
                         + "----------------------------------------------------------------------------------------\n");
                for(int i = 0; i< tablaArticulos.getRowCount(); i++){
                    String Producto =(String)tablaArticulos.getValueAt(i, 0);
                    String Precio = " Bs. " + (String)tablaArticulos.getValueAt(i, 5) ;
                    if(Producto.length() >=25)
                        Producto = Producto.substring(0, 22)+"...";
                    else {
                        while(Producto.length() <25){
                            Producto = Producto + " "; 
                        } 
                    }
                    Producto = "(x" + tablaArticulos.getValueAt(i, 3).toString()+")" + Producto;
                    titulo.add(Producto + "               " + Precio + "\n");   
                }
                titulo.add("----------------------------------------------------------------------------------------\n"
                         + "IVA:                                            Bs. "+objeto.getTotalIVA() +"\n");
                titulo.add("----------------------------------------------------------------------------------------\n"
                         + "Total:                                          Bs. "+objeto.getPrecioT()+"\n");
                docPDF.add(titulo);*/                              
                //cierra la edicion del pdf
                docPDF.close();
                pdf.close();
                //abre el pdf en el sistema
                Desktop.getDesktop().open(archivo);
            } catch (BadElementException ex) {
                Logger.getLogger(menuCaja.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(menuCaja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DocumentException ex) {
            Logger.getLogger(menuCaja.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }
    
    public void crearDevolucion(String numeroFactura, String Sub,String IVA,String TOTAL) throws ParseException{
    try {
            PdfWriter.getInstance(docPDF, pdf);
            docPDF.open();
            try {
                
                //crea el titulo
                Paragraph titulo = new Paragraph(24);
                Font fuente =  new Font(Font.FontFamily.TIMES_ROMAN, 8, 12, BaseColor.BLACK);
                titulo.add("                                    SENIAT "
                       + "\n                               J-400858259 "
                       + "\n       FERRETERIA Y BAZAR FERRELUSO C.A. "
                       + "\n            CALLE COLEGIO AMERICANO EDIF "
                       + "\n                  CHILA PISO 21-14 LOCAL 1"
                       + "\n             SECTOR LAS MINAS DE BARUTA"
                       + "\n                  TELEFONO: 0212-945-85-39"
                       + "\n                            DEVOLUCION\n");
                titulo.setFont(fuente);
                
                docPDF.add(titulo);
                // crea tabla con los datos de compra
                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(50);
                table.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.setWidths(new int[]{4, 2});
                table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
                FacturaDoc xmlFactura = new FacturaDoc();
                Calendar Fecha = Calendar.getInstance();
                table.addCell(xmlFactura.parseToString(Fecha));
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell("Hora: "+  String.valueOf(Fecha.get(Calendar.HOUR_OF_DAY)+":"
                                     +(Fecha.get(Calendar.MINUTE))));
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell("Factura N");
                table.addCell(numeroFactura);
                docPDF.add(table);
                titulo= new Paragraph(24);
                titulo.add("_______________________________________\n\n");
                docPDF.add(titulo);
                
                
                
                //crea tabla con montos totales
                table = new PdfPTable(2);
                table.setWidthPercentage(50);
                table.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.setWidths(new int[]{4, 3});
                table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell("Sub-Total");
                
                table.addCell("Bs. "+Sub);
                
                table.addCell("IVA:");
                
                table.addCell("Bs. "+IVA);
                
                table.addCell("Total");
                
                table.addCell("Bs. "+TOTAL);
                docPDF.add(table);
                
                titulo= new Paragraph(24);
                fuente=new Font(Font.FontFamily.TIMES_ROMAN,12,Font.ITALIC);
                titulo.setFont(fuente);
                titulo.add("\n      ** No Fiscal**");
                
                docPDF.add(titulo);
                                        
                //cierra la edicion del pdf
                docPDF.close();
                pdf.close();
                xmlFactura.eliminarFactura(numeroFactura);
                //abre el pdf en el sistema
                Desktop.getDesktop().open(archivo);
            } catch (BadElementException ex) {
                Logger.getLogger(menuCaja.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(menuCaja.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DocumentException ex) {
            Logger.getLogger(menuCaja.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }
}
