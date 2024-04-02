package C.V.Inventario;

import M.P.DE.Dao.*;
import M.P.DE.Implements.*;
import M.P.DE.Transfer.*;
import V.I.P.Ventas.FrmCategoria;
import V.I.P.Ventas.FrmProducto;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class contCategoria extends JFrame implements ActionListener {

    private FrmProducto producto;
    private int idCategoria;
    private IDaoGenerico<Categoria> crudDao;
    private DefaultTableModel modelo;
    private Object[] filaDatos;
    private final FrmCategoria vista;

    public contCategoria(FrmCategoria vista) {
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
        filaDatos = new Object[3];
    }

    public void inicializarModelo() {
        modelo = new DefaultTableModel();
    }

    public void inicializarDao() {
        crudDao = new CategoriaDaoImpl();
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

    private void listar() {
        try {
            limpiarTabla();
            modelo = (DefaultTableModel) vista.tbMostrar.getModel();
            for (Categoria p : crudDao.listar()) {
                filaDatos[0] = p.getIdCategoria();
                filaDatos[1] = p.getNombre();
                filaDatos[2] = p.getDescripcion();
                modelo.addRow(filaDatos);
            }
            //  tblProducto.setModel(modelo);
        } catch (Exception e) {
        }
    }

    public void buscar(java.awt.event.KeyEvent evt) {
        try {
            Categoria categoria;
            if (vista.rdbId.isSelected()) {
                categoria = new Categoria(Integer.parseInt(vista.txtBuscador.getText()));
            } else if (vista.rdbNombre.isSelected()) {
                categoria = new Categoria(vista.txtBuscador.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Seleccionar una opción para buscar");
                return;
            }
            limpiarTabla();
            int n = 0;
            if (crudDao.listar(categoria) != null) {
                for (Categoria p : crudDao.listar(categoria)) {
                    filaDatos[0] = p.getIdCategoria();
                    filaDatos[1] = p.getNombre();
                    filaDatos[2] = p.getDescripcion();
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
            idCategoria = Integer.parseInt(vista.tbMostrar.getValueAt(fila, 0).toString());
            vista.txtNombre.setText(vista.tbMostrar.getValueAt(fila, 1).toString());
            Object descripcionValue = vista.tbMostrar.getValueAt(fila, 2);
            if (descripcionValue != null) {
                vista.txtDescripcion.setText(descripcionValue.toString());
            } else {
                // Execpción del cato de categoría :D
                vista.txtDescripcion.setText("");
            }
            vista.lblMensaje.setText("");
            if (evt.getClickCount() == 2) {
                if (fila < 0) {
                    vista.lblMensaje.setText("No hay filas para seleccionar");
                } else {
                    FrmProducto.txtCategoria.setText(vista.tbMostrar.getValueAt(fila, 1).toString());
                    vista.dispose();
                }
            }
        }

    }

    public void eliminar() {
        try {
            // Validación de entrada
            if (CondicionalCampos()) {
                Categoria eliminarCategoria = new Categoria(
                        idCategoria
                );
                //validacion de entrega
                if (crudDao.eliminar(eliminarCategoria)) {
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
                Categoria actualizarCategoria = new Categoria(
                        idCategoria,
                        vista.txtNombre.getText(),
                        vista.txtDescripcion.getText());
                //validacion de entrega
                if (crudDao.actualizar(actualizarCategoria)) {
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
                Categoria nuevoCategoria = new Categoria(
                        vista.txtNombre.getText(),
                        vista.txtDescripcion.getText());
                //validacion de entrega
                if (crudDao.agregar(nuevoCategoria)) {
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
        vista.txtDescripcion.setText("");
        vista.txtNombre.requestFocus();
    }

    public boolean CondicionalCampos() {
        if (campoVacio(vista.txtNombre.getText(), "Nombre")
                || campoVacio(vista.txtDescripcion.getText(), "Categoria")) {
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
