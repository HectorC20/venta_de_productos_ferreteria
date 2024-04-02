package C.V.Ventas;

import M.P.DE.Dao.*;
import M.P.DE.Implements.*;
import M.P.DE.Transfer.*;
import V.I.P.Ventas.FrmDetalleVenta;
import V.I.P.Ventas.FrmMetodoPago;
import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class contMetodoPago extends JFrame implements ActionListener {

    private int idMetodoPago;
    private IDaoGenerico<MetodoPago> crudDao;
    private DefaultTableModel modelo;
    private Object[] filaDatos;
    private final FrmMetodoPago vista;

    public contMetodoPago(FrmMetodoPago vista) {
        this.vista = vista;

        grupoInit();
    }

    public void grupoInit() {
        initFilas();
        condicionalFrm();
        inicializarModelo();
        configurarEventos();
        inicializarDao();
        limpiarTabla();
        listar();
    }

    public void initFilas() {
        filaDatos = new Object[2];
    }

    public void inicializarModelo() {
        modelo = new DefaultTableModel();
    }

    public void inicializarDao() {
        crudDao = new MetodoPagoDaoImpl();
    }

    public void configurarEventos() {
        vista.btnAgregar.addActionListener(this);
        vista.btnNuevo.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        EventosExternos();
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
    }

    public void mensajeVacio() {
        vista.lblMensaje.setText("");
    }

    //Se utiliza para la funcionalidad de cerrar este formulario y no afecte a otros *//
    public void condicionalFrm() {
        vista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vista.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vista.setVisible(false);
            }
        });

        //Dimensiones del formulario*//
        vista.setSize(1350, 600);
        vista.setVisible(true);
    }

    public void limpiarTabla() {
        modelo = (DefaultTableModel) vista.tbMostrar.getModel();
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
    }

    private void listar() {
        try {
            limpiarTabla();
            modelo = (DefaultTableModel) vista.tbMostrar.getModel();
            for (MetodoPago p : crudDao.listar()) {
                filaDatos[0] = p.getIdMetodo();
                filaDatos[1] = p.getNombre();
                modelo.addRow(filaDatos);
            }
            //  tblProducto.setModel(modelo);
        } catch (Exception e) {
        }
    }

    public void buscar(java.awt.event.KeyEvent evt) {
        try {
            MetodoPago metodoPago;
            if (vista.rdbId.isSelected()) {
                metodoPago = new MetodoPago(Integer.parseInt(vista.txtBuscador.getText()));
            } else if (vista.rdbNombre.isSelected()) {
                metodoPago = new MetodoPago(vista.txtBuscador.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Seleccionar una opción para buscar");
                return;
            }
            limpiarTabla();
            int n = 0;
            if (crudDao.listar(metodoPago) != null) {
                for (MetodoPago p : crudDao.listar(metodoPago)) {
                    filaDatos[0] = p.getIdMetodo();
                    filaDatos[1] = p.getNombre();
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
            idMetodoPago = Integer.parseInt(vista.tbMostrar.getValueAt(fila, 0).toString());
            vista.txtNombre.setText(vista.tbMostrar.getValueAt(fila, 1).toString());
            vista.lblMensaje.setText("");
            if (evt.getClickCount() == 2) {
                if (fila < 0) {
                    vista.lblMensaje.setText("No hay filas para seleccionar");
                } else {
                    FrmDetalleVenta.txtMetodo.setText(vista.tbMostrar.getValueAt(fila, 1).toString());
                    vista.dispose();
                }
            }
        }

    }

    public void eliminar() {
        try {
            // Validación de entrada
            if (CondicionalCampos()) {
                MetodoPago eliminarMetodoPago = new MetodoPago(
                        idMetodoPago
                );
                //validacion de entrega
                if (crudDao.eliminar(eliminarMetodoPago)) {
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
            // Validación de entrada
            if (CondicionalCampos()) {
                MetodoPago actualizarMetodoPago = new MetodoPago(
                        idMetodoPago,
                        vista.txtNombre.getText());

                //validacion de entrega
                if (crudDao.actualizar(actualizarMetodoPago)) {
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
        } catch (Exception e) {
            // Manejo de excepciones
            vista.lblMensaje.setText("Error: " + e.getMessage());
            e.printStackTrace(); // Imprime la traza de la excepción en la consola (considera quitar esto en producción)
        }
    }

    public void agregar() {
        try {
            // Validación de entrada
            if (CondicionalCampos()) {
                MetodoPago nuevoMetodoPago = new MetodoPago(
                        vista.txtNombre.getText());
                //validacion de entrega
                if (crudDao.agregar(nuevoMetodoPago)) {
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
        } catch (Exception e) {
            // Manejo de excepciones
            vista.lblMensaje.setText("Error: " + e.getMessage());
            e.printStackTrace(); // Imprime la traza de la excepción en la consola (considera quitar esto en producción)
        }
    }

    public void limpiarTexto() {
        vista.txtNombre.setText("");

        vista.txtNombre.requestFocus();
    }

    public boolean CondicionalCampos() {
        if (campoVacio(vista.txtNombre.getText(), "Nombre")) {
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

}
