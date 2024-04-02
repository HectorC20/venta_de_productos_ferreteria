package V.I.P.Ventas;

import C.V.Ventas.contConjuntoVenta;

public class FrmDetalleVenta extends javax.swing.JFrame {

    contConjuntoVenta cont;

    public FrmDetalleVenta() {
        initComponents();
        this.setLocationRelativeTo(null);
        cont = new contConjuntoVenta(this);
      
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgBuscar = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblMensaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        btnProducto = new javax.swing.JButton();
        txtProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTotalProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnCliente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        txtIgv_Iva = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        btnAgregarProductos = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnNuevo = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMostrar = new javax.swing.JTable();
        btnCalcular = new javax.swing.JButton();
        txtEfectivo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTotalGeneral = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMetodo = new javax.swing.JTextField();
        btnMetodo = new javax.swing.JButton();
        btnRegistrarVenta = new javax.swing.JButton();
        jlbFecha = new javax.swing.JLabel();
        jlbEmpleado = new javax.swing.JLabel();
        jlbFecha2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtImpuestoGeneral = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMensaje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 360, 20));

        jLabel1.setText("Cliente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel5.setText("SubTotal");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        txtSubTotal.setEditable(false);
        jPanel1.add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 209, -1));

        btnProducto.setText("...");
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 70, -1));

        txtProducto.setEditable(false);
        txtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoActionPerformed(evt);
            }
        });
        jPanel1.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 130, -1));

        jLabel6.setText("Cantidad");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 209, -1));

        jLabel7.setText("Total");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        txtTotalProducto.setEditable(false);
        jPanel1.add(txtTotalProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 209, -1));

        jLabel2.setText("Producto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        txtCliente.setEditable(false);
        jPanel1.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 130, -1));

        btnCliente.setText("...");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 70, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 350, 10));

        txtIgv_Iva.setEditable(false);
        jPanel1.add(txtIgv_Iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 209, -1));

        jLabel8.setText("IGV-IVA");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jLabel9.setText("Descuento");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        txtDescuento.setEditable(false);
        jPanel1.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 209, -1));

        btnAgregarProductos.setText("Agregar");
        btnAgregarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductosActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 200, 30));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 350, 10));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 280, 30));

        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 80, 30));

        jLabel13.setText("Precio Unitario");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        txtPrecio.setEditable(false);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 130, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 128, -1, 420));

        jPanel4.setBackground(new java.awt.Color(240, 240, 240));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(253, 236, 2));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setText("Venta");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(181, 181, 181))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel3)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 120));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbMostrar.setBackground(new java.awt.Color(238, 238, 243));
        tbMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Producto", "Precio Unitario", "Cantidad", "SubTotal", "Descuento", "IGV | IVA", "Total"
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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 6, 799, 377));

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        jPanel2.add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 401, 90, 50));

        txtEfectivo.setEditable(false);
        jPanel2.add(txtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 401, 100, -1));

        jLabel10.setText("Efectivo");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 401, -1, -1));

        jLabel11.setText("Cambio");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 431, -1, -1));

        txtCambio.setEditable(false);
        jPanel2.add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 431, 100, -1));

        jLabel12.setText("Impuestos");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, -1, -1));

        txtTotalGeneral.setEditable(false);
        jPanel2.add(txtTotalGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 189, -1));

        jLabel4.setText("Método de Pago");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 401, -1, -1));

        txtMetodo.setEditable(false);
        jPanel2.add(txtMetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 428, 130, -1));

        btnMetodo.setText("...");
        btnMetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMetodoActionPerformed(evt);
            }
        });
        jPanel2.add(btnMetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 428, 70, -1));

        btnRegistrarVenta.setText("Registrar Venta");
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 471, 307, 43));
        jPanel2.add(jlbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 110, 20));

        jlbEmpleado.setText("Keyla");
        jPanel2.add(jlbEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 510, 40, -1));

        jlbFecha2.setText("Fecha: ");
        jPanel2.add(jlbFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, -1, -1));

        jLabel14.setText("Total");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, -1, 20));

        txtImpuestoGeneral.setEditable(false);
        jPanel2.add(txtImpuestoGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 189, -1));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 840, 550));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed


    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed

    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void tbMostrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMostrarMouseReleased

    }//GEN-LAST:event_tbMostrarMouseReleased

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed

    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnAgregarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarProductosActionPerformed

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoActionPerformed

    private void btnMetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMetodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMetodoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmDetalleVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgBuscar;
    public javax.swing.JButton btnAgregarProductos;
    public javax.swing.JButton btnCalcular;
    public javax.swing.JButton btnCliente;
    public javax.swing.JButton btnEliminarProducto;
    public javax.swing.JButton btnMetodo;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnProducto;
    public javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JLabel jlbEmpleado;
    public javax.swing.JLabel jlbFecha;
    public javax.swing.JLabel jlbFecha2;
    public static javax.swing.JLabel lblMensaje;
    public javax.swing.JTable tbMostrar;
    public javax.swing.JTextField txtCambio;
    public static transient volatile javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtCliente;
    public static transient volatile javax.swing.JTextField txtDescuento;
    public javax.swing.JTextField txtEfectivo;
    public static transient volatile javax.swing.JTextField txtIgv_Iva;
    public javax.swing.JTextField txtImpuestoGeneral;
    public static javax.swing.JTextField txtMetodo;
    public static javax.swing.JTextField txtPrecio;
    public static javax.swing.JTextField txtProducto;
    public static transient volatile javax.swing.JTextField txtSubTotal;
    public javax.swing.JTextField txtTotalGeneral;
    public static transient volatile javax.swing.JTextField txtTotalProducto;
    // End of variables declaration//GEN-END:variables

}
