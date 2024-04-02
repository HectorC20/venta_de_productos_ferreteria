package C.V.Ventas;

import M.P.DE.Implements.*;
import M.P.DE.Implements.VentaDaoImpl;
import M.P.DE.Transfer.*;
import V.I.P.Ventas.*;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class contConjuntoVenta extends JFrame implements ActionListener {

    private ContFacturaPDF contFactura;
    private ClienteDaoImpl cliente;
    private EmpleadoDaoImpl empleado;
    private ProductoDaoImpl producto;
    private MetodoPagoDaoImpl metodo;
    private ConjuntoVentaDaoImpl conjuntoDao;
    private DefaultTableModel modelo;
    private final FrmDetalleVenta vista;

    public contConjuntoVenta(FrmDetalleVenta vista) {
        this.vista = vista;
        this.contFactura = new ContFacturaPDF(vista);
        grupoInit();
        configurarEventos();
        fechaActual();
    }

    public void grupoInit() {
        inicializarModelo();
        limpiarTabla();
        inicializarDaoExternos();
        inicializarDao();
    }

    //Eventos de botones*//
    public void configurarEventos() {
        vista.btnRegistrarVenta.addActionListener(this);
        vista.btnProducto.addActionListener(this);
        vista.btnCliente.addActionListener(this);
        vista.btnAgregarProductos.addActionListener(this);
        vista.btnMetodo.addActionListener(this);
        EventosExternos();

    }

    //Inicialización de modelo de tabla*//
    public void inicializarModelo() {
        modelo = new DefaultTableModel();
    }

    public void EventosExternos() {

        vista.txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calcularProductos(evt);
                
            }
        });

    }

    private void inicializarDaoExternos() {
        cliente = new ClienteDaoImpl();
        empleado = new EmpleadoDaoImpl();
        producto = new ProductoDaoImpl();
        metodo = new MetodoPagoDaoImpl();
        conjuntoDao = new ConjuntoVentaDaoImpl();
    }

    private void inicializarDao() {
        VentaDaoImpl ventaDaoImpl = new VentaDaoImpl();
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) vista.tbMostrar.getModel();
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnProducto) {
            // Llama al método frmExtProducto cuando se hace clic en el botón
            frmExtProducto();
        }
        if (e.getSource() == vista.btnCliente) {
            // Llama al método frmExtCliente cuando se hace clic en el botón
            frmExtCliente();
        }
        if (e.getSource() == vista.btnAgregarProductos) {
            // Llama al método agregarTabla cuando se hace clic en el botón
            agregarTabla();
        }
        if (e.getSource() == vista.btnMetodo) {
            // Llama al método frmExtMetodo cuando se hace clic en el botón
            frmExtMetodo();
        }
        if (e.getSource() == vista.btnRegistrarVenta) {
            // Llama al método frmExtMetodo cuando se hace clic en el botón
            agregar();
            ContFacturaPDF.generarFacturaPDF(vista);
        }
    }

    public void frmExtProducto() {
        FrmProducto ofp = new FrmProducto();
        ofp.setVisible(true);
    }

    public void frmExtCliente() {
        FrmCliente ofp = new FrmCliente();
        ofp.setVisible(true);
    }

    public void frmExtMetodo() {
        FrmMetodoPago ofp = new FrmMetodoPago();
        ofp.setVisible(true);
    }

    //Implementación de agregación de producto sin utilizar lista de base de datos*//
    private void agregarTabla() {
        String cliente = vista.txtCliente.getText();
        String producto = vista.txtProducto.getText();
        String precio = vista.txtPrecio.getText();
        String cantidad = vista.txtCantidad.getText();
        String subTotal = vista.txtSubTotal.getText();
        String descuento = vista.txtDescuento.getText();
        String igv_iva = vista.txtIgv_Iva.getText();
        String totalProducto = vista.txtTotalProducto.getText();

        //Requisitos o condiciones de utilidad :/ *//
        if (!cliente.isEmpty() && !producto.isEmpty() && !cantidad.isEmpty()) {
            modelo = (DefaultTableModel) vista.tbMostrar.getModel();
            modelo.addRow(new Object[]{
                producto,
                precio,
                cantidad,
                subTotal,
                descuento,
                igv_iva,
                totalProducto
            });
            vista.txtProducto.setText("");
            vista.txtPrecio.setText("");
            vista.txtCantidad.setText("");
            vista.txtSubTotal.setText("");
            vista.txtDescuento.setText("");
            vista.txtIgv_Iva.setText("");
            vista.txtTotalProducto.setText("");
            sumaTotal();
            sumaImpuestos();

        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregar() {
        try {
            // Validación de entrada
            if (CondicionalCampos()) {
                // Restablecer el valor de idCVentaRegistrada
                ConjuntoVentaDaoImpl.idCVentaRegistrada = 0;

                // Llamar al método guardarVenta y verificar si se ha guardado correctamente
                boolean ventaGuardada = conjuntoDao.guardarVenta(
                        new Venta(
                                0,
                                vista.jlbFecha.getText(),
                                Float.parseFloat(vista.txtTotalGeneral.getText()),
                                cliente.obtenerId(vista.txtCliente.getText()),
                                empleado.obtenerId(vista.jlbEmpleado.getText())
                        )
                );

                if (ventaGuardada) {
                    ConjuntoVentaDaoImpl.idCVentaRegistrada = conjuntoDao.obtenerUltimoIdVenta(); // Actualizar el ID de la venta registrada

                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        String nombreProducto = modelo.getValueAt(i, 0).toString();
                        float precio = Float.parseFloat(modelo.getValueAt(i, 1).toString());
                        float subTotal = Float.parseFloat(modelo.getValueAt(i, 3).toString());
                        int cantidad = Integer.parseInt(modelo.getValueAt(i, 2).toString());

                        DetalleVenta nuevoDetalle = new DetalleVenta(
                                producto.obtenerId(nombreProducto),
                                0, // Deja que la base de datos genere el ID
                                precio,
                                subTotal,
                                cantidad
                        );

                        Factura nuevaFactura = new Factura(
                                vista.jlbFecha.getText(),
                                cliente.obtenerId(vista.txtCliente.getText()),
                                Float.parseFloat(vista.txtTotalGeneral.getText()),
                                "pagado",
                                metodo.obtenerId(vista.txtMetodo.getText()),
                                0,
                                Float.parseFloat(vista.txtImpuestoGeneral.getText()),
                                0
                        );

                        // Llama al método guardarDetalle y verifica si se ha guardado correctamente
                        boolean detalleGuardado = conjuntoDao.guardarDetalle(nuevoDetalle) > 0;
                        boolean facturaGuardada = conjuntoDao.guardarFactura(nuevaFactura) > 0;

                        if (detalleGuardado && facturaGuardada) {
                            vista.lblMensaje.setText("El registro se agregó correctamente con ID: " + ConjuntoVentaDaoImpl.idCVentaRegistrada);
                        } else {
                            vista.lblMensaje.setText("Error al agregar el detalle o la factura.");
                        }
                    }
                } else {
                    vista.lblMensaje.setText("Error al agregar la venta.");
                }
            } else {
                vista.lblMensaje.setText("Error: Todos los campos son obligatorios");
            }
        } catch (NumberFormatException e) {
            manejarExcepcion("Error en el formato numérico de los campos: " + e.getMessage(), e);
        } catch (Exception e) {
            manejarExcepcion("Error: " + e.getMessage(), e);
        }
    }

    private void manejarExcepcion(String mensaje, Exception e) {
        vista.lblMensaje.setText(mensaje);
        e.printStackTrace(); // Imprime la traza de la excepción en la consola (considera quitar esto en producción)
    }

    //Cálculo de productos en el formulario*//
    private void calcularProductos(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            return;
        }

        try {
            // Obtén los valores de los campos
            int cantidad = Integer.parseInt(vista.txtCantidad.getText());
            float subTotal = Float.parseFloat(vista.txtSubTotal.getText());
            float igv_iva = Float.parseFloat(vista.txtIgv_Iva.getText());

            // Realiza los cálculos
            float subTotalFinal = subTotal * cantidad;
            float igv_ivaFinal = igv_iva * cantidad;
            float totalFinal = subTotalFinal + igv_ivaFinal;

            // Actualiza los campos de texto
            EventQueue.invokeLater(() -> {
                vista.txtSubTotal.setText(String.valueOf(subTotalFinal));
                vista.txtIgv_Iva.setText(String.valueOf(igv_ivaFinal));
                vista.txtTotalProducto.setText(String.valueOf(totalFinal));
            });

        } catch (NumberFormatException ex) {
            // Captura excepciones de formato numérico inválido
            JOptionPane.showMessageDialog(null, "Error en el formato numérico de los campos: " + ex.getMessage());
            vista.lblMensaje.setText("");
        }
    }

    public void fechaActual() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Formatear la fecha en el formato deseado ("yyyy-MM-dd")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaActual.format(formatter);
        vista.jlbFecha.setText(fechaFormateada);
    }

    public boolean CondicionalCampos() {
        if (campoVacio(vista.txtCliente.getText(), "Cliente") 
                ) {
            return false;
        }
        return true;
    }

    private boolean campoVacio(String valor, String nombreCampo) {
        if ("".equals(valor)) {
            JOptionPane.showMessageDialog(null, "Rellene el campo " + nombreCampo);
            return true;
        }
        return false;
    }

    private void sumaTotal() {
        try {
            double totalGeneral = 0.0;
            modelo = (DefaultTableModel) vista.tbMostrar.getModel();
            int totalColumnIndex = 6; // Asume que la columna 'Total' es la columna 5
            for (int i = 0; i < modelo.getRowCount(); i++) {
                String cellValue = modelo.getValueAt(i, totalColumnIndex).toString();
                if (cellValue != null && !cellValue.isEmpty()) {
                    totalGeneral += Double.parseDouble(cellValue);
                }
            }
            vista.txtTotalGeneral.setText(String.format("%.2f", totalGeneral));
        } catch (HeadlessException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error en el criterio a buscar");
            vista.lblMensaje.setText("");
        }
    }

    private void sumaImpuestos() {
        try {
            //La inicialización del impuesto general es de  0.0
            double impuestoGeneral = 0.0;
            modelo = (DefaultTableModel) vista.tbMostrar.getModel();
            int totalColumnIndex = 5; // Asume que la columna 'Total' es la columna 5
            for (int i = 0; i < modelo.getRowCount(); i++) {
                String cellValue = modelo.getValueAt(i, totalColumnIndex).toString();
                if (cellValue != null && !cellValue.isEmpty()) {
                    impuestoGeneral += Double.parseDouble(cellValue);
                }
            }
            vista.txtImpuestoGeneral.setText(String.format("%.2f", impuestoGeneral));
        } catch (HeadlessException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error en el criterio a buscar");
            vista.lblMensaje.setText("");
        }
    }
}
