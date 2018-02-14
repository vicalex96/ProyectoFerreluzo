/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.Controladora;
import java.awt.Color;
import javax.swing.*;
import ClasesDocumentos.Documento;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author VícAlex
 */
public class menuEditarRapido extends javax.swing.JFrame {

    private menuInventario ventana;
    private Controladora control;
    private Documento xml;
    JFormattedTextField ftf;
    //modelos: 1ro guarda todas las ediciones de tabla de manera temporal
    //         2do guarda el modelo original para comparaciones
    private DefaultTableModel modeloGuardado,modeloDefault;
    /* hacer codigo que permita detectar el articulo por defeto
    el cual sera un articulo editable en el momento de seleccionarlo*/
    public menuEditarRapido() {
        xml = new Documento();
        control = new Controladora();
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public menuEditarRapido(menuInventario ventana) {
        this.ventana = ventana;
        control = new Controladora();
        xml = ventana.getXML();
        initComponents();
        setLocationRelativeTo(null);
        //ventana.xml.cargarTablaArticulo().isCellEditable(0, 2);
        llenarTabla();
        comboBuscar.requestFocus();
        
    }
    
    private void llenarTabla(){
        tablaArticulo.setModel(ventana.getXML().cargarTablaArticuloEditar());
        
        final TableCellEditor cellEditor = new DefaultCellEditor(setFormat()){
        public boolean stopCellEditing() {
            try {
                JFormattedTextField ftf = (JFormattedTextField)getComponent();
                ftf.setText(control.parseToString(control.parseToFloat(ftf.getText())));
                ftf.commitEdit();
                
            } catch (ParseException ex) {
                Logger.getLogger(menuEditarRapido.class.getName()).log(Level.SEVERE, null, ex);
            }
            return super.stopCellEditing();
    }
        };
        tablaArticulo.setDefaultEditor(Object.class, cellEditor);
        modeloGuardado = ventana.getXML().cargarTablaArticuloEditar();
        modeloDefault = ventana.getXML().cargarTablaArticuloEditar();
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

        tablaArticulo.setRowHeight(30);
        tablaArticulo.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tablaArticulo.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
    }
    
    private void fieldCellKeyTyped(java.awt.event.KeyEvent evt){
        control.validaNumeroSigno(evt);
    }
    
    private void llenarTabla(DefaultTableModel modelo){
        tablaArticulo.setModel(modelo);
        modeloGuardado =modelo;
        modeloDefault = modelo;
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        final TableCellEditor cellEditor = new DefaultCellEditor(setFormat()){
        public boolean stopCellEditing() {
            try {
                JFormattedTextField ftf = (JFormattedTextField)getComponent();
                ftf.setText(control.parseToString(control.parseToFloat(ftf.getText())));
                ftf.commitEdit();
                
            } catch (ParseException ex) {
                Logger.getLogger(menuEditarRapido.class.getName()).log(Level.SEVERE, null, ex);
            }
            return super.stopCellEditing();
    }
        };
        
        tablaArticulo.setDefaultEditor(Object.class, cellEditor);
        tablaArticulo.setRowHeight(30);
        tablaArticulo.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tablaArticulo.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
    }
    
    public JFormattedTextField setFormat(){       
        DefaultCellEditor aux =new DefaultCellEditor(new JFormattedTextField());
        ftf=(JFormattedTextField) aux.getComponent();
                
        DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(','); simbolo.setGroupingSeparator('.'); 
        DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
        NumberFormatter intFormatter = new NumberFormatter(formateador);
        intFormatter.setFormat(formateador);
        ftf.setFormatterFactory(
                new DefaultFormatterFactory(intFormatter));
        ftf.setHorizontalAlignment(JTextField.TRAILING);
        ftf.setFocusLostBehavior(JFormattedTextField.PERSIST);
        ftf.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyTyped(java.awt.event.KeyEvent evt) {
        fieldCellKeyTyped(evt);
    }
        });
        ftf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt){
                ftf.selectAll();
            }
        }
        );
        
        ftf.getInputMap().put(KeyStroke.getKeyStroke(
                                        KeyEvent.VK_ENTER, 0),
                                        "check");
        ftf.getActionMap().put("check", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
            try {
                    ftf.setText(control.parseToString(control.parseToFloat(ftf.getText())));
                    ftf.commitEdit();
                    ftf.postActionEvent();
                } catch (ParseException ex) {
                    Logger.getLogger(menuEditarRapido.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }    
        });
        
        return ftf;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtSeleccionarArticulo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JPanel();
        txtAgregar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JPanel();
        txtCAncelar = new javax.swing.JLabel();
        fieldBuscar = new javax.swing.JTextField();
        comboBuscar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaArticulo = new javax.swing.JTable();
        txtLocal = new javax.swing.JLabel();
        txtEditarRapido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(16, 135, 60));
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 360));

        jPanel2.setBackground(new java.awt.Color(10, 91, 40));
        jPanel2.setPreferredSize(new java.awt.Dimension(640, 360));

        txtSeleccionarArticulo.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        txtSeleccionarArticulo.setForeground(new java.awt.Color(255, 255, 255));
        txtSeleccionarArticulo.setText("Seleccionar Articulo");

        btnGuardar.setBackground(new java.awt.Color(16, 135, 61));
        btnGuardar.setPreferredSize(new java.awt.Dimension(96, 34));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGuardarMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
        });
        btnGuardar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAgregar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtAgregar.setForeground(new java.awt.Color(255, 255, 255));
        txtAgregar.setText("Guardar Cambios");
        btnGuardar.add(txtAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 30));

        btnCancelar.setBackground(new java.awt.Color(16, 135, 61));
        btnCancelar.setPreferredSize(new java.awt.Dimension(96, 34));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCancelarMouseReleased(evt);
            }
        });
        btnCancelar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCAncelar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtCAncelar.setForeground(new java.awt.Color(255, 255, 255));
        txtCAncelar.setText("Finalizar");
        btnCancelar.add(txtCAncelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        fieldBuscar.setBackground(new java.awt.Color(16, 135, 61));
        fieldBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fieldBuscar.setForeground(new java.awt.Color(255, 255, 255, 150));
        fieldBuscar.setText("Buscar");
        fieldBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 155, 81)));
        fieldBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldBuscarFocusLost(evt);
            }
        });
        fieldBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fieldBuscarMouseReleased(evt);
            }
        });
        fieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldBuscarKeyReleased(evt);
            }
        });

        comboBuscar.setBackground(new java.awt.Color(16, 135, 61));
        comboBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        comboBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "ID" }));
        comboBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 155, 81)));
        comboBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBuscarActionPerformed(evt);
            }
        });
        comboBuscar.requestFocus();

        tablaArticulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tablaArticulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "ID", "Costo", "Precio"
            }
        ));
        tablaArticulo.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tablaArticuloComponentAdded(evt);
            }
        });
        tablaArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaArticuloMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tablaArticuloMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablaArticuloMouseEntered(evt);
            }
        });
        tablaArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tablaArticuloKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaArticuloKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaArticuloKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaArticulo);
        if (tablaArticulo.getColumnModel().getColumnCount() > 0) {
            tablaArticulo.getColumnModel().getColumn(0).setPreferredWidth(100);
            tablaArticulo.getColumnModel().getColumn(1).setPreferredWidth(40);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                .addComponent(txtSeleccionarArticulo)))))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSeleccionarArticulo)
                    .addComponent(comboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        txtLocal.setFont(new java.awt.Font("Arial Black", 2, 24)); // NOI18N
        txtLocal.setForeground(new java.awt.Color(255, 255, 255));
        txtLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ultrpequeño-05.png"))); // NOI18N
        txtLocal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(10, 91, 40)));

        txtEditarRapido.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        txtEditarRapido.setForeground(new java.awt.Color(255, 255, 255));
        txtEditarRapido.setText("Editar Rapido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEditarRapido)
                .addContainerGap(319, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtEditarRapido))
                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        //crea el borde del "boton"
        btnCancelar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.getHSBColor(143, 30, 77)));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        // cuando el raton sale del boton
        btnCancelar.setBorder(null);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
        // cuando se presiona el boton
     
        btnCancelar.setBorder(null);
    }//GEN-LAST:event_btnCancelarMousePressed

    private void btnCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseReleased
        // cuando se suelta el boton
        // Aqui se ejecuta el codigo del boton
        btnCancelar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.getHSBColor(143, 30, 77)));
        JTable tablaControl = new JTable();
        tablaControl.setModel(modeloDefault);
        JTable tablaGuardar = new JTable();
        tablaGuardar.setModel(modeloGuardado);       
        if(!control.revisarIgualdadTabla(tablaControl, tablaGuardar)){
             int resp = JOptionPane.showOptionDialog(
                        null,"¿Desea salir sin guardar los cambios?", "::::...Confirmación...:::",
                        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
             if(resp == 0){
             ventana.enable(true);
             dispose();
             }
        }
        else{
            ventana.enable(true);
            dispose();
        }
    }//GEN-LAST:event_btnCancelarMouseReleased

    private void comboBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBuscarActionPerformed

    private void btnGuardarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseReleased
        // cuando se suelta el boton
        // Aqui se ejecuta el codigo del boton
        //---------------------------------------------------------------------------
        //---------------------------------------------------------------------------
        JTable tablaControl = new JTable();
        tablaControl.setModel(modeloDefault);
        JTable tablaGuardar = new JTable();
        tablaGuardar.setModel(modeloGuardado);       
        if(!control.revisarIgualdadTabla(tablaControl, tablaGuardar)){
            try {
                xml.guardarTabla(tablaGuardar);
            } catch (ParseException ex) {
                Logger.getLogger(menuEditarRapido.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error");
            }
            ventana.actualizarLista();
            JOptionPane.showMessageDialog(null,"se guardaron los cambios con exito");
            modeloDefault = modeloGuardado;
        }
        else
            JOptionPane.showMessageDialog(null,"No se ha modificado ningun dato,"
                                        + "\n recuerde presionar enter al terminar de editar un precio");
        
        
        btnGuardar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.getHSBColor(143, 30, 77)));    
    }//GEN-LAST:event_btnGuardarMouseReleased

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        // cuando se presiona el boton
        btnGuardar.setBorder(null);
    }//GEN-LAST:event_btnGuardarMousePressed

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        // cuando el raton sale del boton
        btnGuardar.setBorder(null);
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        //crea el borde del "boton"
        btnGuardar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.getHSBColor(143, 30, 77)));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void tablaArticuloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaArticuloKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tablaArticuloKeyReleased

    private void tablaArticuloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaArticuloKeyTyped
    control.validaNumero(evt);
    }//GEN-LAST:event_tablaArticuloKeyTyped

    private void fieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBuscarKeyReleased
        DefaultTableModel modelo;
        JTable carga = new JTable();
        carga.setModel(ventana.getXML().cargarTablaArticuloEditar());
         
        modelo = control.filtrarTablaArticulo(carga, 
                fieldBuscar.getText(), comboBuscar.getSelectedIndex(), 2);
      
        llenarTabla(modelo);
    }//GEN-LAST:event_fieldBuscarKeyReleased

    private void tablaArticuloMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaArticuloMouseReleased

    }//GEN-LAST:event_tablaArticuloMouseReleased

    private void tablaArticuloMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaArticuloMouseEntered
        //JOptionPane.showMessageDialog(null, "se guardo");
    }//GEN-LAST:event_tablaArticuloMouseEntered

    private void tablaArticuloComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tablaArticuloComponentAdded
        //modeloGuardado = (DefaultTableModel) tablaArticulo.getModel();
        //JOptionPane.showMessageDialog(null, "se guardo");
    }//GEN-LAST:event_tablaArticuloComponentAdded

    private void tablaArticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaArticuloKeyPressed
        // TODO add your handling code here          
    }//GEN-LAST:event_tablaArticuloKeyPressed

    private void tablaArticuloMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaArticuloMouseExited

        JTable carga = new JTable(modeloGuardado);
        for(int i = 0; i<tablaArticulo.getRowCount();i++)
            for(int j = 0; j<carga.getRowCount();j++){
                if(tablaArticulo.getValueAt(i, 2) != carga.getValueAt(i, 2))
                    carga.setValueAt(tablaArticulo.getValueAt(i, 2) , i, 2);
                if(tablaArticulo.getValueAt(i, 3) !=carga.getValueAt(i, 3))
                    carga.setValueAt(tablaArticulo.getValueAt(i, 3) , i, 3);
            }
 
        //modeloGuardado = (DefaultTableModel) tablaArticulo.getModel();
        
        
    }//GEN-LAST:event_tablaArticuloMouseExited

    private void fieldBuscarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldBuscarMouseReleased
        // TODO add your handling code here:
        if("Buscar".equals(fieldBuscar.getText())){
            fieldBuscar.setText("");
            fieldBuscar.setForeground(new Color(255,255,255));
         }
    }//GEN-LAST:event_fieldBuscarMouseReleased

    private void fieldBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldBuscarFocusLost
        // TODO add your handling code here:
        if (fieldBuscar.getText().equals("")){
            fieldBuscar.setForeground(new Color(255,255,255,150));
            fieldBuscar.setText("Buscar");
        }
    }//GEN-LAST:event_fieldBuscarFocusLost


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menuEditarRapido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuEditarRapido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuEditarRapido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuEditarRapido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuEditarRapido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnCancelar;
    private javax.swing.JPanel btnGuardar;
    private javax.swing.JComboBox<String> comboBuscar;
    private javax.swing.JTextField fieldBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaArticulo;
    private javax.swing.JLabel txtAgregar;
    private javax.swing.JLabel txtCAncelar;
    private javax.swing.JLabel txtEditarRapido;
    private javax.swing.JLabel txtLocal;
    private javax.swing.JLabel txtSeleccionarArticulo;
    // End of variables declaration//GEN-END:variables

 

}
