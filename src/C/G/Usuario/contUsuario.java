package C.G.Usuario;

import M.P.DE.Dao.IDaoGenerico;
import M.P.DE.Implements.UsuarioDaoImpl;
import M.P.DE.Transfer.Usuario;
import V.I.P.Gerente.pnUsuario;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public final class contUsuario implements ActionListener {

    private int idUsuario;
    private IDaoGenerico<Usuario> crudDao;
    private DefaultTableModel modelo;
    private Object[] filaDatos;
    private final pnUsuario vista;

    public contUsuario(pnUsuario vista) {
        this.vista = vista;
       grupoInit();
    }

    private void grupoInit(){
         initFilas();
        inicializarModelo();
        configurarEventos();
        inicializarDao();
        limpiarTabla();
        listar();
    }
    private void configurarEventos() {
        vista.btnAgregar.addActionListener(this);
        vista.btnNuevo.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        EventosExternos();
    }
    private void initFilas(){
              filaDatos = new Object[4];
        }
    private void inicializarModelo() {
        modelo = new DefaultTableModel();
    }

    private void inicializarDao() {
        crudDao = new UsuarioDaoImpl();
    }
    
      private void EventosExternos() {

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
            // Llama al método agregar cuando se hace clic en el botón
            agregar();
        }
        if (e.getSource() == vista.btnNuevo) {
            // Llama al método nuevo cuando se hace clic en el botón
            limpiarTexto();
            mensajeVacio();
        }
        if (e.getSource() == vista.btnActualizar) {
            // Llama al método agregar cuando se hace clic en el botón
            actualizar();
        }
        if (e.getSource() == vista.btnEliminar) {
            // Llama al método agregar cuando se hace clic en el botón
            eliminar();
        }
    }
    public void mensajeVacio(){
           vista.lblMensaje.setText("");
       }

    public void limpiarTabla() {
        modelo = (DefaultTableModel) vista.tbMostrar.getModel();
        modelo.getDataVector().removeAllElements();
        vista.tbMostrar.removeAll();
    }

    public void listar() {
      
        try {
            limpiarTabla();
            modelo = (DefaultTableModel) vista.tbMostrar.getModel();
            for (Usuario p : crudDao.listar()) {
                filaDatos[0] = p.getIdUsuario();
                filaDatos[1] = p.getUsuario();
                filaDatos[2] = p.getClave();
                filaDatos[3] = p.getCargo();
                modelo.addRow(filaDatos);
            }
            //  tblProducto.setModel(modelo);
        } catch (Exception e) {
        }
    }

    public void buscar(java.awt.event.KeyEvent evt) {
        try {
            Usuario usuario;
            if (vista.rdbId.isSelected()) {
                usuario = new Usuario(Integer.parseInt(vista.txtBuscador.getText()));
            } else if (vista.rdbNombre.isSelected()) {
                usuario = new Usuario(vista.txtBuscador.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Seleccionar una opción para buscar");
                return;
            }
            limpiarTabla();
            int n = 0;
            if (crudDao.listar(usuario) != null) {
                for (Usuario p : crudDao.listar(usuario)) {
                    filaDatos[0] = p.getIdUsuario();
                    filaDatos[1] = p.getUsuario();
                    filaDatos[2] = p.getClave();
                    filaDatos[3] = p.getCargo();
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
            idUsuario = Integer.parseInt(vista.tbMostrar.getValueAt(fila, 0).toString());
            vista.txtUsuario.setText(vista.tbMostrar.getValueAt(fila, 1).toString());
            vista.txtClave.setText(vista.tbMostrar.getValueAt(fila, 2).toString());
            vista.cbxCargo.setSelectedItem(vista.tbMostrar.getValueAt(fila, 3).toString());
            vista.lblMensaje.setText("");
        }

    }

    public void eliminar() {
        try {
            // Validación de entrada
            if (CondicionalCampos()) {
                Usuario eliminarUsuario = new Usuario(
                        idUsuario
                );
                //validacion de entrega
                if (crudDao.eliminar(eliminarUsuario)) {
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
                Usuario actualizarUsuario = new Usuario(
                        idUsuario,
                        vista.txtUsuario.getText(),
                        vista.txtClave.getText(),
                        vista.cbxCargo.getSelectedItem().toString());
                //validacion de entrega
                if (crudDao.actualizar(actualizarUsuario)) {
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
                Usuario nuevoUsuario = new Usuario(
                        vista.txtUsuario.getText(),
                        vista.txtClave.getText(),
                        vista.cbxCargo.getSelectedItem().toString());
                //validacion de entrega
                if (crudDao.agregar(nuevoUsuario)) {
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
        vista.txtUsuario.setText("");
        vista.txtClave.setText("");
        vista.cbxCargo.setSelectedIndex(0);
        vista.txtUsuario.requestFocus();
    }

    public boolean CondicionalCampos() {
        if (campoVacio(vista.txtUsuario.getText(), "Usuario")
                || campoVacio(vista.txtClave.getText(), "Cargo")
                || campoVacio(vista.txtClave.getText(), "Cargo")) {
            return false;
        }

        if (vista.cbxCargo.getSelectedItem().toString().equals("SELECCIONE")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una cargo");
            return false;
        }

        return true;
    }

    protected boolean campoVacio(String valor, String nombreCampo) {
        if ("".equals(valor)) {
            JOptionPane.showMessageDialog(null, "Rellene el campo " + nombreCampo);
            return true;
        }
        return false;
    }

}
