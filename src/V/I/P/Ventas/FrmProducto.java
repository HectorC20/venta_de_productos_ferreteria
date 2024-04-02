package V.I.P.Ventas;

import C.V.Inventario.contProducto;

public class FrmProducto extends javax.swing.JFrame {
   contProducto cont;

    public FrmProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        cont = new contProducto(this);
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        btnCategoria = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtExistencia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIgv_Iva = new javax.swing.JTextField();
        txtPorcentaje = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPrecioSub = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMostrar = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
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

        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel2.setText("Descripción");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel3.setText("Precio sin IGV | AVG");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 20));

        jLabel5.setText("Categoria");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, -1, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 209, -1));

        txtCategoria.setEditable(false);
        jPanel1.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 130, -1));

        lblMensaje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 374, 20));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 209, -1));

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 209, -1));

        btnCategoria.setText("...");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 70, -1));

        jLabel6.setText("Costo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 209, -1));

        jLabel7.setText("Existencia");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        txtExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExistenciaActionPerformed(evt);
            }
        });
        jPanel1.add(txtExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 209, -1));

        jLabel9.setText("%");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel10.setText("IGV | AVG");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));

        txtIgv_Iva.setEditable(false);
        txtIgv_Iva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgv_IvaActionPerformed(evt);
            }
        });
        jPanel1.add(txtIgv_Iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 140, -1));
        jPanel1.add(txtPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 60, -1));

        jLabel11.setText("Precio Final");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 20));

        txtPrecioSub.setEditable(false);
        txtPrecioSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioSubActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrecioSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 209, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 128, -1, 460));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbMostrar.setBackground(new java.awt.Color(238, 238, 243));
        tbMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripción", "Precio", "Costo", "Existencia", "Categoria", "IGV_IVA", "Precio_sub"
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
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setText("PRODUCTOS");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 42, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/V/R/Iconos/iconHerram, 95x95px.png"))); // NOI18N
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 95, 95));

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

    private void tbMostrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMostrarMouseReleased
       
    }//GEN-LAST:event_tbMostrarMouseReleased

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
             
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
 
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyReleased
       
    }//GEN-LAST:event_txtBuscadorKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExistenciaActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
         
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void txtIgv_IvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgv_IvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgv_IvaActionPerformed

    private void txtPrecioSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioSubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioSubActionPerformed

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
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgBuscar;
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCategoria;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    public javax.swing.JTextField txtBuscador;
    public static javax.swing.JTextField txtCategoria;
    public javax.swing.JTextField txtCosto;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtExistencia;
    public javax.swing.JTextField txtIgv_Iva;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPorcentaje;
    public javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtPrecioSub;
    // End of variables declaration//GEN-END:variables

}
