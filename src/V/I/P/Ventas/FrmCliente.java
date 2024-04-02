package V.I.P.Ventas;
import C.V.Ventas.contCliente;

public class FrmCliente extends javax.swing.JFrame {

    contCliente cont;
    public FrmCliente() {
         initComponents();
       this.setLocationRelativeTo(null);
        cont = new contCliente(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgBuscar = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        rdbId = new javax.swing.JRadioButton();
        rdbNombre = new javax.swing.JRadioButton();
        txtBuscador = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAMateno = new javax.swing.JTextField();
        txtRUC = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtAPaterno = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMostrar = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar"));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        rdbId.setText("Id");
        rdbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbIdActionPerformed(evt);
            }
        });

        rdbNombre.setText("Nombre");
        rdbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNombreActionPerformed(evt);
            }
        });

        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdbId)
                .addGap(18, 18, 18)
                .addComponent(rdbNombre)
                .addGap(18, 18, 18)
                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbNombre)
                    .addComponent(rdbId)
                    .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 360, 60));

        lblMensaje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 374, 20));

        jLabel1.setText("Nombres");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel2.setText("Apellido Paterno");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel4.setText("Apellido Materno");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel5.setText("DNI");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel6.setText("RUC");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jLabel7.setText("Direccion");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabel8.setText("Correo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        jLabel9.setText("Teléfono");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        txtAMateno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAMatenoActionPerformed(evt);
            }
        });
        jPanel1.add(txtAMateno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 209, -1));
        jPanel1.add(txtRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 209, -1));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 209, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 209, -1));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 209, -1));

        txtAPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAPaternoActionPerformed(evt);
            }
        });
        jPanel1.add(txtAPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 209, -1));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 209, -1));
        jPanel1.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 209, -1));

        jLabel10.setText("Sexo");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "Hombre", "Mujer" }));
        jPanel1.add(cbxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 210, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, -1, 30));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, -1, 30));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, 30));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 128, -1, 470));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbMostrar.setBackground(new java.awt.Color(238, 238, 243));
        tbMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombres", "Ap.Paterno", "Ap.Materno", "DNI", "RUC", "Direccion", "Correo", "Teléfono", "Sexo"
            }
        ));
        tbMostrar.setFocusable(false);
        tbMostrar.setRowHeight(25);
        tbMostrar.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tbMostrar.getTableHeader().setReorderingAllowed(false);
        tbMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbMostrarMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbMostrar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 6, -1, 542));

        jPanel4.setBackground(new java.awt.Color(240, 240, 240));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(253, 236, 2));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setText("Clientes");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel3)
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(45, 45, 45))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 120));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbIdActionPerformed

    private void rdbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbNombreActionPerformed

    private void txtBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyReleased

    }//GEN-LAST:event_txtBuscadorKeyReleased

    private void txtAMatenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAMatenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAMatenoActionPerformed

    private void txtAPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAPaternoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
  
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tbMostrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMostrarMouseReleased
        
    }//GEN-LAST:event_tbMostrarMouseReleased

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
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgBuscar;
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblMensaje;
    public javax.swing.JRadioButton rdbId;
    public javax.swing.JRadioButton rdbNombre;
    public javax.swing.JTable tbMostrar;
    public javax.swing.JTextField txtAMateno;
    public javax.swing.JTextField txtAPaterno;
    public javax.swing.JTextField txtBuscador;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDNI;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtNombres;
    public javax.swing.JTextField txtRUC;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
