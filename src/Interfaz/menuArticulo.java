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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VícAlex
 */
public class menuArticulo extends javax.swing.JFrame {

    /**
     * Creates new form menuArticulo
     */
    Controladora control;
    Documento doc;
    menuInventario ventana;
    Documento xml;
    public menuArticulo() {
        xml= new Documento();
        doc =new Documento();
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        control = new Controladora();
        txtID.setText("ID: " + String.valueOf(doc.getNumeroArticulos()));
    }
    
    public menuArticulo(menuInventario ventana) {
        this.ventana = ventana;
        doc =ventana.getXML();
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        control = new Controladora();
        txtID.setText("ID: " + String.valueOf(doc.getNumeroArticulos()));
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
        fieldVenta = new javax.swing.JTextField();
        fieldImpuestos = new javax.swing.JTextField();
        fieldCosto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldDescripcion = new javax.swing.JTextArea();
        fieldExistencias = new javax.swing.JTextField();
        fieldCodigoBarras = new javax.swing.JTextField();
        fieldFamilia = new javax.swing.JTextField();
        fieldNombre = new javax.swing.JTextField();
        txtNombre = new javax.swing.JLabel();
        txtFamilia = new javax.swing.JLabel();
        txtCodigoBarras = new javax.swing.JLabel();
        txtExistencias = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JLabel();
        txtCosto = new javax.swing.JLabel();
        txtImpuestos = new javax.swing.JLabel();
        txtVenta = new javax.swing.JLabel();
        txtAgregarDatosArticulo = new javax.swing.JLabel();
        btnregresar = new javax.swing.JPanel();
        txtCAncelar = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JPanel();
        txtAceptar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        txtLocal = new javax.swing.JLabel();
        txtInventario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(16, 135, 60));
        jPanel1.setPreferredSize(new java.awt.Dimension(475, 540));

        jPanel2.setBackground(new java.awt.Color(10, 91, 40));
        jPanel2.setPreferredSize(new java.awt.Dimension(475, 540));

        fieldVenta.setBackground(new java.awt.Color(16, 135, 61));
        fieldVenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fieldVenta.setForeground(new java.awt.Color(255, 255, 255));
        fieldVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 155, 81)));
        fieldVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldVentaKeyTyped(evt);
            }
        });

        fieldImpuestos.setBackground(new java.awt.Color(16, 135, 61));
        fieldImpuestos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fieldImpuestos.setForeground(new java.awt.Color(255, 255, 255));
        fieldImpuestos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 155, 81)));
        fieldImpuestos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldImpuestosKeyTyped(evt);
            }
        });

        fieldCosto.setBackground(new java.awt.Color(16, 135, 61));
        fieldCosto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fieldCosto.setForeground(new java.awt.Color(255, 255, 255));
        fieldCosto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 155, 81)));
        fieldCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCostoActionPerformed(evt);
            }
        });
        fieldCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldCostoKeyTyped(evt);
            }
        });

        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 40));

        fieldDescripcion.setBackground(new java.awt.Color(16, 135, 61));
        fieldDescripcion.setColumns(20);
        fieldDescripcion.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        fieldDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        fieldDescripcion.setRows(5);
        fieldDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 155, 81)));
        jScrollPane2.setViewportView(fieldDescripcion);

        fieldExistencias.setBackground(new java.awt.Color(16, 135, 61));
        fieldExistencias.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fieldExistencias.setForeground(new java.awt.Color(255, 255, 255));
        fieldExistencias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 155, 81)));
        fieldExistencias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldExistenciasKeyTyped(evt);
            }
        });

        fieldCodigoBarras.setBackground(new java.awt.Color(16, 135, 61));
        fieldCodigoBarras.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fieldCodigoBarras.setForeground(new java.awt.Color(255, 255, 255));
        fieldCodigoBarras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 155, 81)));
        fieldCodigoBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldCodigoBarrasKeyTyped(evt);
            }
        });

        fieldFamilia.setBackground(new java.awt.Color(16, 135, 61));
        fieldFamilia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fieldFamilia.setForeground(new java.awt.Color(255, 255, 255));
        fieldFamilia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 155, 81)));
        fieldFamilia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldFamiliaKeyTyped(evt);
            }
        });

        fieldNombre.setBackground(new java.awt.Color(16, 135, 61));
        fieldNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fieldNombre.setForeground(new java.awt.Color(255, 255, 255));
        fieldNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 155, 81)));
        fieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNombreKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setText("*Nombre:");

        txtFamilia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtFamilia.setForeground(new java.awt.Color(255, 255, 255));
        txtFamilia.setText("Familia:");

        txtCodigoBarras.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCodigoBarras.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigoBarras.setText("Codigo Barras:");

        txtExistencias.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtExistencias.setForeground(new java.awt.Color(255, 255, 255));
        txtExistencias.setText("Existencias:");

        txtDescripcion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setText("Descripcion:");

        txtCosto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCosto.setForeground(new java.awt.Color(255, 255, 255));
        txtCosto.setText("*Costo:");

        txtImpuestos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtImpuestos.setForeground(new java.awt.Color(255, 255, 255));
        txtImpuestos.setText("*Impuesto:");

        txtVenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtVenta.setForeground(new java.awt.Color(255, 255, 255));
        txtVenta.setText("* Precio Venta:");

        txtAgregarDatosArticulo.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        txtAgregarDatosArticulo.setForeground(new java.awt.Color(255, 255, 255));
        txtAgregarDatosArticulo.setText("Agregar Datos de Articulo");

        btnregresar.setBackground(new java.awt.Color(16, 135, 61));
        btnregresar.setPreferredSize(new java.awt.Dimension(96, 34));
        btnregresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnregresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnregresarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnregresarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnregresarMouseReleased(evt);
            }
        });
        btnregresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCAncelar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtCAncelar.setForeground(new java.awt.Color(255, 255, 255));
        txtCAncelar.setText("Finalizar");
        btnregresar.add(txtCAncelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        btnAceptar.setBackground(new java.awt.Color(16, 135, 61));
        btnAceptar.setPreferredSize(new java.awt.Dimension(96, 34));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAceptarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAceptarMouseReleased(evt);
            }
        });
        btnAceptar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAceptar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtAceptar.setForeground(new java.awt.Color(255, 255, 255));
        txtAceptar.setText("Aceptar");
        btnAceptar.add(txtAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Bs.");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Bs.");

        jLabel28.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("%");

        txtID.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        txtID.setText("ID:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtAgregarDatosArticulo)
                        .addGap(88, 88, 88))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtID)
                            .addComponent(txtFamilia)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCodigoBarras)
                                .addComponent(txtExistencias, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtVenta, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtImpuestos, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCosto, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(txtNombre))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNombre)
                                    .addComponent(fieldCodigoBarras, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fieldFamilia)
                                    .addComponent(fieldExistencias)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator1)
                                    .addComponent(jSeparator2)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(fieldVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel27))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(fieldCosto, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                                    .addComponent(fieldImpuestos))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel28)
                                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(btnregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAgregarDatosArticulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFamilia)
                    .addComponent(fieldFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoBarras)
                    .addComponent(fieldCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExistencias)
                    .addComponent(fieldExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcion)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCosto)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldImpuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImpuestos)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVenta)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        txtLocal.setFont(new java.awt.Font("Arial Black", 2, 24)); // NOI18N
        txtLocal.setForeground(new java.awt.Color(255, 255, 255));
        txtLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ultrpequeño-05.png"))); // NOI18N
        txtLocal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(10, 91, 40)));

        txtInventario.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        txtInventario.setForeground(new java.awt.Color(255, 255, 255));
        txtInventario.setText("Articulo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInventario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtInventario))
                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCostoActionPerformed

    private void btnregresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregresarMouseEntered
        //crea el borde del "boton"
        btnregresar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.getHSBColor(143, 30, 77)));
    }//GEN-LAST:event_btnregresarMouseEntered

    private void btnregresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregresarMouseExited
        // cuando el raton sale del boton
        btnregresar.setBorder(null);
    }//GEN-LAST:event_btnregresarMouseExited

    private void btnregresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregresarMousePressed
        // cuando se presiona el boton
        btnregresar.setBorder(null);
    }//GEN-LAST:event_btnregresarMousePressed

    private void btnregresarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregresarMouseReleased
        // cuando se suelta el boton
        // Aqui se ejecuta el codigo del boton
        btnregresar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.getHSBColor(143, 30, 77)));
        ventana.enable(true);
        dispose();
        
    }//GEN-LAST:event_btnregresarMouseReleased

    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        //crea el borde del "boton"
        btnAceptar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.getHSBColor(143, 30, 77)));
    }//GEN-LAST:event_btnAceptarMouseEntered

    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        // cuando el raton sale del boton
        btnAceptar.setBorder(null);
    }//GEN-LAST:event_btnAceptarMouseExited

    private void btnAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMousePressed
        // cuando se presiona el boton
        btnAceptar.setBorder(null);
    }//GEN-LAST:event_btnAceptarMousePressed

    private void btnAceptarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseReleased
        // cuando se suelta el boton
        // Aqui se ejecuta el codigo del boton
        int valor = control.getID();
        btnAceptar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.getHSBColor(143, 30, 77)));
        try {
            control.crearArticulo(fieldNombre,fieldCodigoBarras, fieldFamilia, fieldExistencias,
                    fieldDescripcion,fieldCosto,fieldImpuestos,fieldVenta,doc);
        } catch (ParseException ex) {
            Logger.getLogger(menuArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
       // ventana.actualizarLista();
        txtID.setText("ID: " + String.valueOf(doc.getNumeroArticulos()));
        if(valor != control.getID()){
            fieldNombre.setText("");
            fieldCodigoBarras.setText("");
            fieldFamilia.setText(""); 
            fieldExistencias.setText("");
            fieldDescripcion.setText("");
            fieldCosto.setText("");
            fieldImpuestos.setText("");
            fieldVenta.setText("");
        }
        ventana.actualizarLista();
        ventana.setEnabled(true);
        
    }//GEN-LAST:event_btnAceptarMouseReleased

    private void fieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNombreKeyTyped
        // TODO add your handling code here:
        control.validaLetra(evt);
    }//GEN-LAST:event_fieldNombreKeyTyped

    private void fieldFamiliaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldFamiliaKeyTyped
        // TODO add your handling code here:
        control.validaLetra(evt);
    }//GEN-LAST:event_fieldFamiliaKeyTyped

    private void fieldCodigoBarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCodigoBarrasKeyTyped
        // TODO add your handling code here:
        control.validaNumero(evt);
    }//GEN-LAST:event_fieldCodigoBarrasKeyTyped

    private void fieldExistenciasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldExistenciasKeyTyped
        // TODO add your handling code here:
        control.validaNumero(evt);
    }//GEN-LAST:event_fieldExistenciasKeyTyped

    private void fieldCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCostoKeyTyped
        // TODO add your handling code here:
        control.validaNumeroSigno(evt);
    }//GEN-LAST:event_fieldCostoKeyTyped

    private void fieldImpuestosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldImpuestosKeyTyped
        // TODO add your handling code here:
        control.validaNumeroSigno(evt);
    }//GEN-LAST:event_fieldImpuestosKeyTyped

    private void fieldVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldVentaKeyTyped
        // TODO add your handling code here:
        control.validaNumeroSigno(evt);
    }//GEN-LAST:event_fieldVentaKeyTyped

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
            java.util.logging.Logger.getLogger(menuArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuArticulo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAceptar;
    private javax.swing.JPanel btnregresar;
    private javax.swing.JTextField fieldCodigoBarras;
    private javax.swing.JTextField fieldCosto;
    private javax.swing.JTextArea fieldDescripcion;
    private javax.swing.JTextField fieldExistencias;
    private javax.swing.JTextField fieldFamilia;
    private javax.swing.JTextField fieldImpuestos;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldVenta;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel txtAceptar;
    private javax.swing.JLabel txtAgregarDatosArticulo;
    private javax.swing.JLabel txtCAncelar;
    private javax.swing.JLabel txtCodigoBarras;
    private javax.swing.JLabel txtCosto;
    private javax.swing.JLabel txtDescripcion;
    private javax.swing.JLabel txtExistencias;
    private javax.swing.JLabel txtFamilia;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtImpuestos;
    private javax.swing.JLabel txtInventario;
    private javax.swing.JLabel txtLocal;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtVenta;
    // End of variables declaration//GEN-END:variables


}