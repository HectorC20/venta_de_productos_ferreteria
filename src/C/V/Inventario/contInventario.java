package C.V.Inventario;

import M.P.DE.Dao.*;
import M.P.DE.Implements.*;
import M.P.DE.Transfer.*;
import V.I.P.Ventas.FrmProducto;
import V.I.P.Ventas.pnInventario;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Héctor
 */
public final class contInventario implements ActionListener {

    private IDaoGenerico<Inventario> crudDao;
    private DefaultTableModel modelo;
    private Object[] filaDatos;
    private ProductoDaoImpl producto;
    private ProveedorDaoImpl proveedor;
    private final pnInventario vista;

    public contInventario(pnInventario vista) {
        this.vista = vista;
        inicializar();
        configurarEventos();
        cargarDatosIniciales();
    }

    private void inicializar() {
        initFilas();
        fechaActual();
        inicializarModelo();
        inicializarDao();
        inicializarDaoExternos();
    }

    private void configurarEventos() {
        vista.btnAgregar.addActionListener(this);
        vista.btnNuevo.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnProducto.addActionListener(this);
        EventosExternos();
    }

    private void cargarDatosIniciales() {
        limpiarTabla();
        listar();
    }

    public void EventosExternos() {

        vista.tbMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mostrarTabla(evt);
            }
        });

        vista.txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar(evt);
            }
        });
    }

    private void initFilas() {
        filaDatos = new Object[7];
    }

    private void inicializarModelo() {
        modelo = new DefaultTableModel();
    }

    private void inicializarDaoExternos() {
        producto = new ProductoDaoImpl();
        proveedor = new ProveedorDaoImpl();
        comboProveedor();
    }

    private void inicializarDao() {
        crudDao = new InventarioDaoImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            // Llama al método agregar cuando se hace clic en el botón
            agregar();
        }
        if (e.getSource() == vista.btnNuevo) {
            // Llama al método nuevo cuando se hace clic en el botón
            limpiarTexto();
            mensajeVacio();
        }
        if (e.getSource() == vista.btnActualizar) {
            // Llama al método actualizar cuando se hace clic en el botón
            actualizar();
        }
        if (e.getSource() == vista.btnEliminar) {
            // Llama al método eliuminar cuando se hace clic en el botón
            eliminar();
        }
        if (e.getSource() == vista.btnProducto) {
            // Llama al método frmExnsiones cuando se hace clic en el botón
            frmExtensiones();
        }

    }

    public void mensajeVacio() {
        vista.lblMensaje.setText("");
    }

    public void frmExtensiones() {
        FrmProducto ofp = new FrmProducto();
        ofp.setVisible(true);
    }

    private void comboProveedor() {
        IDaoExtendido<Proveedor> daoExtendido;
        daoExtendido = new ProveedorDaoImpl();
        vista.cbxProveedor.addItem("SELECCIONAR");
        for (Proveedor proveedor : daoExtendido.listar()) {
            vista.cbxProveedor.addItem(proveedor.getNombreCompania());
        }
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) vista.tbMostrar.getModel();
        modelo.getDataVector().removeAllElements();
        vista.tbMostrar.removeAll();
    }

    public void listar() {

        try {
            limpiarTabla();
            ProveedorDaoImpl proveedor = new ProveedorDaoImpl();
            ProductoDaoImpl producto = new ProductoDaoImpl();
            modelo = (DefaultTableModel) vista.tbMostrar.getModel();
            for (Inventario p : crudDao.listar()) {
                filaDatos[0] = producto.obtenerNombre(p.getIdProducto());
                filaDatos[1] = p.getCodigoBarras();
                filaDatos[2] = p.getCantidadStock();
                filaDatos[3] = proveedor.obtenerNombre(p.getIdProveedor());
                filaDatos[4] = p.getFechaAdquisicion();
                filaDatos[5] = p.getNivelRebastecimiento();
                filaDatos[6] = p.getNota();
                modelo.addRow(filaDatos);
            }
        } catch (Exception e) {
            vista.lblMensaje.setText("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void buscar(java.awt.event.KeyEvent evt) {
        try {
            Inventario inventario;
            if (vista.rdbId.isSelected()) {
                inventario = new Inventario(Integer.parseInt(vista.txtBuscador.getText()));
            } else if (vista.rdbNombre.isSelected()) {
                inventario = new Inventario(vista.txtBuscador.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Seleccionar una opción para buscar");
                return;
            }
            limpiarTabla();
            int n = 0;
            if (crudDao.listar(inventario) != null) {
                for (Inventario p : crudDao.listar(inventario)) {
                    filaDatos[0] = producto.obtenerNombre(p.getIdProducto());
                    filaDatos[1] = p.getCodigoBarras();
                    filaDatos[2] = p.getCantidadStock();
                    filaDatos[3] = proveedor.obtenerNombre(p.getIdProveedor());
                    filaDatos[4] = p.getFechaAdquisicion();
                    filaDatos[5] = p.getNivelRebastecimiento();
                    filaDatos[6] = p.getNota();
                    modelo.addRow(filaDatos);
                    n++;
                }
                vista.lblMensaje.setText(n + " registro(s) encontrado(s)");
            } else {
                vista.lblMensaje.setText(n + " registro(s) encontrado(s)");
            }
        } catch (HeadlessException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error en el criterio a buscar");
            vista.lblMensaje.setText("");
            listar();
        }
    }

    public void mostrarTabla(java.awt.event.MouseEvent evt) {
        int fila = vista.tbMostrar.getSelectedRow();
        if (fila == -1) {

        } else {

            vista.txtCodigoBarras.setText(vista.tbMostrar.getValueAt(fila, 1).toString());
            vista.txtCantidadStock.setText(vista.tbMostrar.getValueAt(fila, 2).toString());
            vista.txtNivel.setText(vista.tbMostrar.getValueAt(fila, 5).toString());
            vista.txtNota.setText(vista.tbMostrar.getValueAt(fila, 6).toString());
            String formatoFecha = vista.tbMostrar.getValueAt(fila, 4).toString();

            // Establecer el formato en el JDateChooser
            vista.dteFecha.setDateFormatString("yyyy-MM-dd");
            // Intentar convertir la cadena a un objeto Date
            try {
                Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(formatoFecha);
                // Establecer la fecha en el JDateChooser
                vista.dteFecha.setDate(fecha);
            } catch (ParseException e) {
                // Manejar cualquier excepción que pueda ocurrir al convertir la fecha
                e.printStackTrace();
                // También puedes mostrar un mensaje de error al usuario si es necesario
                vista.lblMensaje.setText("Error al obtener la fecha.");
            }
            vista.txtProducto.setText(vista.tbMostrar.getValueAt(fila, 0).toString());
            vista.cbxProveedor.setSelectedItem(vista.tbMostrar.getValueAt(fila, 3).toString());

            vista.lblMensaje.setText("");
        }
        mostrarMensajeDeNivel();
    }

    public void eliminar() {
        try {
            // Validación de entrada
            if (CondicionalCampos()) {
                Inventario eliminarProducto = new Inventario(
                        producto.obtenerId(vista.txtProducto.getText())
                );
                //validacion de entrega
                if (crudDao.eliminar(eliminarProducto)) {
                    vista.lblMensaje.setText("El registro se eliminó correctamente");
                    limpiarTexto();
                    limpiarTabla();
                    listar();
                } else {
                    vista.lblMensaje.setText("Error: No se pudo eliminar el registro");
                }
            } else {
                vista.lblMensaje.setText("Error: Todos los campos son obligatorios");
            }
        } catch (Exception e) {
            // Manejo de excepciones
            vista.lblMensaje.setText("Error: " + e.getMessage());
            e.printStackTrace(); // Imprime la traza de la excepción en la consola (considera quitar esto en producción)
        }
    }

    public void actualizar() {
        try {
            if (CondicionalCampos()) {
                // Obtener la fecha en un formato específico
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaFormateada = dateFormat.format(vista.dteFecha.getDate());
                // Obtener el ID del proveedor
                Inventario actualizarInventario = new Inventario(
                        producto.obtenerId(vista.txtProducto.getText()),
                        vista.txtCodigoBarras.getText(),
                        Integer.parseInt(vista.txtCantidadStock.getText()),
                        proveedor.obtenerId(vista.cbxProveedor.getSelectedItem().toString()),
                        fechaFormateada,
                        Integer.parseInt(vista.txtNivel.getText()),
                        vista.txtNota.getText()
                );

                // Validar la actualización
                if (crudDao.actualizar(actualizarInventario)) {
                    vista.lblMensaje.setText("El registro se actualizó correctamente");
                    limpiarTexto();
                    limpiarTabla();
                    listar();
                } else {
                    vista.lblMensaje.setText("Error: No se pudo actualizar el registro");
                }
            } else {
                vista.lblMensaje.setText("Error: Todos los campos son obligatorios");
            }
        } catch (NumberFormatException e) {
            vista.lblMensaje.setText("Error: Ingrese un valor válido para la cantidad o nivel");
        } catch (Exception e) {
            vista.lblMensaje.setText("Error: " + e.getMessage());
            e.printStackTrace(); // Imprime la traza de la excepción en la consola (considera quitar esto en producción)
        }
    }

    public void agregar() {
        try {
            if (CondicionalCampos()) {
                // Obtener la fecha en un formato específico
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaFormateada = dateFormat.format(vista.dteFecha.getDate());
                // Obtener el ID del proveedor
                Inventario agregarInventario = new Inventario(
                        producto.obtenerId(vista.txtProducto.getText()),
                        vista.txtCodigoBarras.getText(),
                        Integer.parseInt(vista.txtCantidadStock.getText()),
                        proveedor.obtenerId(vista.cbxProveedor.getSelectedItem().toString()),
                        fechaFormateada,
                        Integer.parseInt(vista.txtNivel.getText()),
                        vista.txtNota.getText()
                );

                // Validar la actualización
                if (crudDao.agregar(agregarInventario)) {
                    vista.lblMensaje.setText("El registro se agregó correctamente");
                    limpiarTexto();
                    limpiarTabla();
                    listar();
                } else {
                    vista.lblMensaje.setText("Error: No se pudo agregar el registro");
                }
            } else {
                vista.lblMensaje.setText("Error: Todos los campos son obligatorios");
            }
        } catch (NumberFormatException e) {
            vista.lblMensaje.setText("Error: Ingrese un valor válido para la cantidad o nivel");
        } catch (Exception e) {
            vista.lblMensaje.setText("Error: " + e.getMessage());
            e.printStackTrace(); // Imprime la traza de la excepción en la consola (considera quitar esto en producción)
        }
    }

    //Utilización del recursos externo(Calendario)*//
    public void fechaActual() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Formatear la fecha en el formato deseado ("yyyy-MM-dd")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaActual.format(formatter);

        // Establecer el formato en el JDateChooser
        vista.dteFecha.setDateFormatString("yyyy-MM-dd");

        // Establecer la fecha formateada en el JDateChooser
        try {
            java.util.Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFormateada);
            vista.dteFecha.setDate(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void limpiarTexto() {
        vista.txtProducto.setText("");
        vista.txtCodigoBarras.setText("");
        vista.txtCantidadStock.setText("");
        //Uso de fecha actual sin limpiar el campo fecha*// 
        fechaActual();
        vista.txtNivel.setText("");
        vista.cbxProveedor.setSelectedIndex(0);
        vista.txtNota.setText("");
        vista.txtProducto.requestFocus();
    }

    public boolean CondicionalCampos() {

        if (campoVacio(vista.txtProducto.getText(), "Producto")
                || campoVacio(vista.txtCodigoBarras.getText(), "Codigo de barras")
                || campoVacio(vista.txtCantidadStock.getText(), "Cantidad de stock")
                || campoVacio(vista.cbxProveedor.getSelectedItem().toString(), "Proveedor")
                || campoVacio(vista.dteFecha.getDateFormatString(), "Fecha")
                || campoVacio(vista.txtNivel.getText(), "Nivel")
                || campoVacio(vista.txtNota.getText(), "Nota")) {
            return false;
        }
        if (vista.cbxProveedor.getSelectedItem().toString().equals("SELECCIONAR")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un proveedor");
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

    public void mostrarMensajeDeNivel() {
        try {
            String cantidadStockStr = vista.txtCantidadStock.getText();
            String nivelStr = vista.txtNivel.getText();

            // Pars las cantidades a números
            int cantidadStock = Integer.parseInt(cantidadStockStr);
            int nivel = Integer.parseInt(nivelStr);

            if (cantidadStock <= nivel) {
                String producto = vista.txtProducto.getText();
                String mensaje = "Necesita realizar pedidos del producto " + producto;
                JOptionPane.showMessageDialog(null, mensaje);
            }
        } catch (NumberFormatException e) {
            // Ejecutar error si la entrada no es un número válido
            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numéricos válidos para la cantidad y el nivel.");
        }
    }
}
