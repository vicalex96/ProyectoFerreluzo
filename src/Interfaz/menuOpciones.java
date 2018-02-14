/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;

/**
 *
 * @author VícAlex
 */
public class menuOpciones extends javax.swing.JFrame implements Runnable{

    String  hora,minuto,segundo,ampm,dia,mes,anio;
    Thread h1;
    
    public menuOpciones() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        h1 = new Thread(this);
        h1.start();
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
        btnregresar = new javax.swing.JPanel();
        txtRegresar = new javax.swing.JLabel();
        txtReloj = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        txtLocal1 = new javax.swing.JLabel();
        txtInventario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(16, 135, 60));

        jPanel2.setBackground(new java.awt.Color(10, 91, 40));
        jPanel2.setAlignmentX(1.0F);
        jPanel2.setAlignmentY(1.0F);

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

        txtRegresar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtRegresar.setForeground(new java.awt.Color(255, 255, 255));
        txtRegresar.setText("  Regresar ");
        btnregresar.add(txtRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 90, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(823, Short.MAX_VALUE)
                .addComponent(btnregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(417, Short.MAX_VALUE)
                .addComponent(btnregresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        txtReloj.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtReloj.setForeground(new java.awt.Color(255, 255, 255));
        txtReloj.setText("Reloj");

        txtFecha.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setText("Fecha");

        txtLocal1.setFont(new java.awt.Font("Arial Black", 2, 24)); // NOI18N
        txtLocal1.setForeground(new java.awt.Color(255, 255, 255));
        txtLocal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ultrpequeño-05.png"))); // NOI18N
        txtLocal1.setText("Ferreluso");
        txtLocal1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(10, 91, 40)));

        txtInventario.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        txtInventario.setForeground(new java.awt.Color(255, 255, 255));
        txtInventario.setText("Opciones");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLocal1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtReloj)
                .addGap(24, 24, 24))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocal1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInventario)
                    .addComponent(txtReloj)
                    .addComponent(txtFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnregresarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregresarMouseReleased
        // cuando se suelta el boton
        // Aqui se ejecuta el codigo del boton
        btnregresar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.getHSBColor(143, 30, 77)));
        menuEntrada obj = new menuEntrada();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnregresarMouseReleased

    private void btnregresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregresarMousePressed
        // cuando se presiona el boton
        btnregresar.setBorder(null);
    }//GEN-LAST:event_btnregresarMousePressed

    private void btnregresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregresarMouseExited
        // cuando el raton sale del boton
        btnregresar.setBorder(null);
    }//GEN-LAST:event_btnregresarMouseExited

    private void btnregresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregresarMouseEntered
        //crea el borde del "boton"
        btnregresar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.getHSBColor(143, 30, 77)));
    }//GEN-LAST:event_btnregresarMouseEntered

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
            java.util.logging.Logger.getLogger(menuOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuOpciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnregresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtInventario;
    private javax.swing.JLabel txtLocal1;
    private javax.swing.JLabel txtRegresar;
    private javax.swing.JLabel txtReloj;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        
        while(ct == h1){
            calcula();
            txtReloj.setText("Hora: "+hora+":"+minuto+":"+segundo+" "+ampm);
            txtFecha.setText("Fecha: "+dia+"/"+mes+"/"+anio);
            try{
                Thread.sleep(1000); 
                }
            catch(InterruptedException e){
            
            }
        }

    }
    
    private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        mes=(String) String.valueOf(calendario.get(Calendar.MONTH)+1);
        anio=(String) String.valueOf(calendario.get(Calendar.YEAR));
        dia=(String) String.valueOf(calendario.get(Calendar.DAY_OF_MONTH));
        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == calendario.AM?"AM":"PM";
        
        if(ampm.equals("PM")){
            int h = calendario.get(calendario.HOUR_OF_DAY)-12;
            hora = h>9?""+h:"0"+h;
        }else{
            hora = calendario.get(calendario.HOUR_OF_DAY)>9?""+calendario.get(calendario.HOUR_OF_DAY):"0"+calendario.get(calendario.HOUR_OF_DAY);
        }
        minuto = calendario.get(calendario.MINUTE)>9?""+calendario.get(calendario.MINUTE):"0"+calendario.get(calendario.MINUTE);
        segundo = calendario.get(calendario.SECOND)>9?""+calendario.get(calendario.SECOND):"0"+calendario.get(calendario.SECOND);
    }
}