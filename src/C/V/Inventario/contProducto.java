package C.V.Inventario;

import M.P.DE.Dao.*;
import M.P.DE.Implements.*;
import M.P.DE.Transfer.*;
import V.I.P.Ventas.FrmCategoria;
import V.I.P.Ventas.FrmDetalleVenta;
import V.I.P.Ventas.FrmProducto;
import V.I.P.Ventas.pnInventario;
import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class contProducto extends JFrame implements ActionListener {

    private int idProducto;
    private CategoriaDaoImpl categoria;
    private IDaoGenerico<Producto> crudDao;
    private DefaultTableModel modelo;
    private Object[] filaDatos;
    private final FrmProducto vista;

    public contProducto(FrmProducto vista) {
        this.vista = vista;
        grupoInit();

    }

    private void grupoInit() {
        initFilas();
        condicionalFrm();
        inicializarModelo();
        configurarEventos();
        inicializarDao();
        inicializarDaoExternos();
        limpiarTabla();
        listar();

    }

    private void initFilas() {
        filaDatos = new Object[9];
    }

    private void inicializarModelo() {
        modelo = new DefaultTableModel();
    }

    private void inicializarDaoExternos() {
        categoria = new CategoriaDaoImpl();
    }

    private void inicializarDao() {
        crudDao = new ProductoDaoImpl();
    }

    private void configurarEventos() {
        vista.btnAgregar.addActionListener(this);
        vista.btnNuevo.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnCategoria.addActionListener(this);
        EventosExternos();
    }

    private void EventosExternos() {

        vista.tbMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mostrarTabla(evt, true);
            }
        });

        vista.txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar(evt);
            }
        });

        vista.txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculos(evt);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            agregar();
        }
        if (e.getSource() == vista.btnNuevo) {
            limpiarTexto();
            mensajeVacio();
        }
        if (e.getSource() == vista.btnActualizar) {
            actualizar();
        }
        if (e.getSource() == vista.btnEliminar) {
            eliminar();
        }
        if (e.getSource() == vista.btnCategoria) {
            frmExtensiones();
        }
    }

    public void mensajeVacio() {
        vista.lblMensaje.setText("");
    }

    public void condicionalFrm() {
        vista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vista.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vista.setVisible(false);
            }
        });

        vista.setSize(1350, 600);
        vista.setVisible(true);
    }

    public void limpiarTabla() {
        modelo = (DefaultTableModel) vista.tbMostrar.getModel();
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
    }

    public void frmExtensiones() {
        FrmCategoria ofc = new FrmCategoria();
        ofc.setVisible(true);
    }

    private void listar() {
        try {
            limpiarTabla();
            modelo = (DefaultTableModel) vista.tbMostrar.getModel();
            for (Producto p : crudDao.listar()) {
                filaDatos[0] = p.getIdProducto();
                filaDatos[1] = p.getNombre();
                filaDatos[2] = p.getDescripcion();
                filaDatos[3] = p.getPrecio();
                filaDatos[4] = p.getCosto();
                filaDatos[5] = p.getExistencia();
                filaDatos[6] = categoria.obtenerNombre(p.getIdCategoria());
                filaDatos[7] = p.getIgv_iva();
                filaDatos[8] = p.getPrecio_sub();
                modelo.addRow(filaDatos);
            }
        } catch (Exception e) {
            // Manejo de excepciones
        }
    }

    public void buscar(java.awt.event.KeyEvent evt) {
        try {
            Producto producto;
            if (vista.rdbId.isSelected()) {
                producto = new Producto(Integer.parseInt(vista.txtBuscador.getText()));
            } else if (vista.rdbNombre.isSelected()) {
                producto = new Producto(vista.txtBuscador.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Seleccionar una opción para buscar");
                return;
            }
            limpiarTabla();
            int n = 0;
            if (crudDao.listar(producto) != null) {
                for (Producto p : crudDao.listar(producto)) {
                    filaDatos[0] = p.getIdProducto();
                    filaDatos[1] = p.getNombre();
                    filaDatos[2] = p.getDescripcion();
                    filaDatos[3] = p.getPrecio();
                    filaDatos[4] = p.getCosto();
                    filaDatos[5] = p.getExistencia();
                    filaDatos[6] = p.getIdCategoria();
                    filaDatos[7] = p.getIgv_iva();
                    filaDatos[8] = p.getPrecio_sub();
                    modelo.addRow(filaDatos);
                    n++;
                }
                vista.lblMensaje.setText(n + " registro(s) encontrado(s)");
            } else {
                vista.lblMensaje.setText(n + " registro(s) encontrado(s)");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en el criterio a buscar");
            vista.lblMensaje.setText("");
            listar();
        }
    }

    public void mostrarTabla(java.awt.event.MouseEvent evt, boolean isFrmInventario) {
    int fila = vista.tbMostrar.getSelectedRow();

    if (fila == -1) {
        vista.lblMensaje.setText("No hay filas para seleccionar");
        return;
    }

    idProducto = Integer.parseInt(vista.tbMostrar.getValueAt(fila, 0).toString());
    vista.txtNombre.setText(vista.tbMostrar.getValueAt(fila, 1).toString());
    vista.txtDescripcion.setText(vista.tbMostrar.getValueAt(fila, 2).toString());
    vista.txtPrecio.setText(vista.tbMostrar.getValueAt(fila, 3).toString());
    vista.txtCosto.setText(vista.tbMostrar.getValueAt(fila, 4).toString());
    vista.txtExistencia.setText(vista.tbMostrar.getValueAt(fila, 5).toString());

    Object categoriaValue = vista.tbMostrar.getValueAt(fila, 6);
    vista.txtCategoria.setText((categoriaValue != null) ? categoriaValue.toString() : "");

    vista.txtIgv_Iva.setText(vista.tbMostrar.getValueAt(fila, 7).toString());
    vista.txtPrecioSub.setText(vista.tbMostrar.getValueAt(fila, 8).toString());
    vista.lblMensaje.setText("");

     if (isFrmInventario && evt.getClickCount() == 1) {
        FrmDetalleVenta.txtProducto.setText(vista.tbMostrar.getValueAt(fila, 1).toString());
        FrmDetalleVenta.txtSubTotal.setText(vista.tbMostrar.getValueAt(fila, 8).toString());
        FrmDetalleVenta.txtIgv_Iva.setText(vista.tbMostrar.getValueAt(fila, 7).toString());
        FrmDetalleVenta.txtTotalProducto.setText(vista.tbMostrar.getValueAt(fila, 3).toString());
        FrmDetalleVenta.txtPrecio.setText(vista.tbMostrar.getValueAt(fila, 3).toString());
        vista.dispose();
    }
    if (isFrmInventario && evt.getClickCount() == 2) {
        pnInventario.txtProducto.setText(vista.tbMostrar.getValueAt(fila, 1).toString());
        pnInventario.txtCantidadStock.setText(vista.tbMostrar.getValueAt(fila, 5).toString());
        vista.dispose();
    }
    
}

    public void eliminar() {
        try {
            // Validación de entrada
            if (CondicionalCampos()) {
                int respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿Está seguro de que desea eliminar este producto?. "
                        + "Recuerde que se eliminará el inventario que tenga el producto",
                        "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION
                );

                if (respuesta == JOptionPane.YES_OPTION) {
                    Producto eliminarProducto = new Producto(idProducto);

                    // Validación de entrega
                    if (crudDao.eliminar(eliminarProducto)) {
                        vista.lblMensaje.setText("El producto se eliminó correctamente");
                        limpiarTexto();
                        limpiarTabla();
                        listar();
                    } else {
                        vista.lblMensaje.setText("Error: No se pudo eliminar el producto");
                    }
                } else {
                    vista.lblMensaje.setText("Mensaje: Ha cancelado eliminar el producto");
                }
            } else {
                vista.lblMensaje.setText("Error: Todos los campos son obligatorios");
            }
        } catch (HeadlessException e) {
            // Manejo de excepciones
            vista.lblMensaje.setText("Error: " + e.getMessage());
        }
    }

    public void actualizar() {
        try {
            // Validación de entrada
            if (CondicionalCampos()) {
                Producto actualizarProducto = new Producto(
                        idProducto,
                        vista.txtNombre.getText(),
                        vista.txtDescripcion.getText(),
                        Float.parseFloat(vista.txtPrecio.getText()),
                        Float.parseFloat(vista.txtCosto.getText()),
                        Integer.parseInt(vista.txtExistencia.getText()),
                        categoria.obtenerId(vista.txtCategoria.getText()),
                        Float.parseFloat(vista.txtIgv_Iva.getText()),
                        Float.parseFloat(vista.txtPrecioSub.getText())
                );
                //validacion de entrega
                if (crudDao.actualizar(actualizarProducto)) {
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
            // Manejo de excepciones
            vista.lblMensaje.setText("Error: " + e.getMessage());
        }
    }

    public void agregar() {
        try {
            // Validación de entrada
            if (CondicionalCampos()) {
                Producto guardarProducto = new Producto(
                        vista.txtNombre.getText(),
                        vista.txtDescripcion.getText(),
                        Float.parseFloat(vista.txtPrecio.getText()),
                        Float.parseFloat(vista.txtCosto.getText()),
                        Integer.parseInt(vista.txtExistencia.getText()),
                        categoria.obtenerId(vista.txtCategoria.getText()),
                        Float.parseFloat(vista.txtIgv_Iva.getText()),
                        Float.parseFloat(vista.txtPrecioSub.getText())
                );
                //validacion de entrega
                if (crudDao.agregar(guardarProducto)) {
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
            // Manejo de excepciones
            vista.lblMensaje.setText("Error: " + e.getMessage());
            e.printStackTrace(); // Imprime la traza de la excepción en la consola (considera quitar esto en producción)
        }
    }

    public void limpiarTexto() {
        vista.txtNombre.setText("");
        vista.txtDescripcion.setText("");
        vista.txtPrecio.setText("");
        vista.txtCosto.setText("");
        vista.txtExistencia.setText("");
        vista.txtCategoria.setText("");
        vista.txtPrecioSub.setText("");
        vista.txtIgv_Iva.setText("");
        vista.txtPorcentaje.setText("");
        vista.txtNombre.requestFocus();
    }

    public boolean CondicionalCampos() {
        return !(campoVacio(vista.txtNombre.getText(), "Nombre")
                || campoVacio(vista.txtDescripcion.getText(), "Descripcion")
                || campoVacio(vista.txtPrecio.getText(), "Precio")
                || campoVacio(vista.txtCosto.getText(), "Costo")
                || campoVacio(vista.txtExistencia.getText(), "Existencia")
                || campoVacio(vista.txtCategoria.getText(), "Categoria"));
    }

    private boolean campoVacio(String valor, String nombreCampo) {
        if ("".equals(valor)) {
            JOptionPane.showMessageDialog(null, "Rellene el campo " + nombreCampo);
            return true;
        }
        return false;
    }

    public void calculos(java.awt.event.KeyEvent evt) {
        // Verificar si la tecla presionada es Enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                // Obtener los valores de los campos de texto como Strings
                String precioStr = vista.txtPrecio.getText();
                String porcentajeStr = vista.txtPorcentaje.getText();

                // Convertir los Strings a números flotantes
                float precio = Float.parseFloat(precioStr);
                float porcentaje = Float.parseFloat(porcentajeStr);

                // Calcular el IGV o IVA
                float igvIva = precio * (porcentaje / 100);

                // Calcular el precio sub total
                float precioSub = precio - igvIva;

                // Actualizar los campos de texto con los resultados
                vista.txtIgv_Iva.setText(String.valueOf(igvIva));
                vista.txtPrecioSub.setText(String.valueOf(precioSub));

            } catch (NumberFormatException e) {
                // Manejar la excepción si la conversión falla
                System.out.println("Error al convertir a número");
            }
        }
    }
}
