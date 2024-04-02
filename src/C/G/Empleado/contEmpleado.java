package C.G.Empleado;

import M.P.DE.Dao.IDaoExtendido;
import M.P.DE.Dao.IDaoGenerico;
import M.P.DE.Implements.EmpleadoDaoImpl;
import M.P.DE.Implements.UsuarioDaoImpl;
import M.P.DE.Transfer.Empleado;
import M.P.DE.Transfer.Usuario;
import V.I.P.Gerente.pnEmpleado;
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
public final class contEmpleado implements ActionListener {

    private int idEmpleado;
    private IDaoGenerico<Empleado> crudDao;
    private DefaultTableModel modelo;
    private Object[] filaDatos;
    private UsuarioDaoImpl usuario;
    private final pnEmpleado vista;

    public contEmpleado(pnEmpleado vista) {
        this.vista = vista;
        inicializarModelo();
        configurarEventos();
        inicializarDao();
        inicializarDaoExternos();
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

    private void inicializarModelo() {
        modelo = new DefaultTableModel();
    }

    private void inicializarDaoExternos() {
        usuario = new UsuarioDaoImpl();
        comboUsuario();
    }

    private void inicializarDao() {
        crudDao = new EmpleadoDaoImpl();
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

    public void mensajeVacio() {
        vista.lblMensaje.setText("");
    }

    private void comboUsuario() {
        IDaoExtendido<Usuario> daoExtendido;
        daoExtendido = new UsuarioDaoImpl();
        vista.cbxUsuario.addItem("SELECCIONAR");
        for (Usuario usuario : daoExtendido.listar()) {
            vista.cbxUsuario.addItem(usuario.getUsuario());
        }
    }

    public void limpiarTabla() {
        modelo = (DefaultTableModel) vista.tbMostrar.getModel();
        modelo.getDataVector().removeAllElements();
        vista.tbMostrar.removeAll();
    }

    public void listar() {
        filaDatos = new Object[8];
        try {
            limpiarTabla();
            UsuarioDaoImpl usuario = new UsuarioDaoImpl();
            modelo = (DefaultTableModel) vista.tbMostrar.getModel();
            for (Empleado p : crudDao.listar()) {
                filaDatos[0] = p.getIdEmpleado();
                filaDatos[1] = p.getNombres();
                filaDatos[2] = p.getApellidoParterno();
                filaDatos[3] = p.getApellidoMaterno();
                filaDatos[4] = p.getDni();
                filaDatos[5] = p.getNumeroTelefono();
                filaDatos[6] = usuario.obtenerNombre(p.getIdUsuario());
                filaDatos[7] = p.getSexo();
                modelo.addRow(filaDatos);
            }
            //  tblProducto.setModel(modelo);
        } catch (Exception e) {
        }
    }

    public void buscar(java.awt.event.KeyEvent evt) {
        try {
            Empleado empleado;
            if (vista.rdbId.isSelected()) {
                empleado = new Empleado(Integer.parseInt(vista.txtBuscador.getText()));
            } else if (vista.rdbNombre.isSelected()) {
                empleado = new Empleado(vista.txtBuscador.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Seleccionar una opción para buscar");
                return;
            }
            limpiarTabla();
            int n = 0;
            if (crudDao.listar(empleado) != null) {
                for (Empleado p : crudDao.listar(empleado)) {
                    filaDatos[0] = p.getIdEmpleado();
                    filaDatos[1] = p.getNombres();
                    filaDatos[2] = p.getApellidoParterno();
                    filaDatos[3] = p.getApellidoMaterno();
                    filaDatos[4] = p.getDni();
                    filaDatos[5] = p.getNumeroTelefono();
                    filaDatos[6] = p.getIdUsuario();
                    filaDatos[7] = p.getSexo();
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
            idEmpleado = Integer.parseInt(vista.tbMostrar.getValueAt(fila, 0).toString());
            vista.txtNombre.setText(vista.tbMostrar.getValueAt(fila, 1).toString());
            vista.txtApellidoPaterno.setText(vista.tbMostrar.getValueAt(fila, 2).toString());
            vista.txtApellidoMaterno.setText(vista.tbMostrar.getValueAt(fila, 3).toString());
            vista.txtDNI.setText(vista.tbMostrar.getValueAt(fila, 4).toString());
            vista.txtNumeroTelefono.setText(vista.tbMostrar.getValueAt(fila, 5).toString());
            vista.cbxUsuario.setSelectedItem(vista.tbMostrar.getValueAt(fila, 6).toString());
            vista.cbxSexo.setSelectedItem(vista.tbMostrar.getValueAt(fila, 7).toString());
            vista.lblMensaje.setText("");
        }

    }

    public void eliminar() {
        try {
            // Validación de entrada
            if (CondicionalCampos()) {
                Empleado eliminarProveedor = new Empleado(
                        idEmpleado
                );
                //validacion de entrega
                if (crudDao.eliminar(eliminarProveedor)) {
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
                //          int idUsuario = Integer.parseInt(txtIdUsuario.getText());
                Empleado actualizarEmpleado = new Empleado(
                        idEmpleado,
                        vista.txtNombre.getText(),
                        vista.txtApellidoPaterno.getText(),
                        vista.txtApellidoMaterno.getText(),
                        vista.txtDNI.getText(),
                        vista.txtNumeroTelefono.getText(),
                        usuario.obtenerId(vista.cbxUsuario.getSelectedItem().toString()),
                        vista.cbxSexo.getSelectedItem().toString()
                );
                //validacion de entrega
                if (crudDao.actualizar(actualizarEmpleado)) {
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
                //          int idUsuario = Integer.parseInt(txtIdUsuario.getText());
                Empleado agregarEmpleado = new Empleado(
                        vista.txtNombre.getText(),
                        vista.txtApellidoPaterno.getText(),
                        vista.txtApellidoMaterno.getText(),
                        vista.txtDNI.getText(),
                        vista.txtNumeroTelefono.getText(),
                        usuario.obtenerId(vista.cbxUsuario.getSelectedItem().toString()),
                        vista.cbxSexo.getSelectedItem().toString()
                );
                //validacion de entrega
                if (crudDao.agregar(agregarEmpleado)) {
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
        vista.txtApellidoPaterno.setText("");
        vista.txtApellidoMaterno.setText("");
        vista.txtDNI.setText("");
        vista.txtNumeroTelefono.setText("");
        vista.cbxUsuario.setSelectedIndex(0);
        vista.cbxSexo.setSelectedIndex(0);
        vista.txtNombre.requestFocus();
    }

    public boolean CondicionalCampos() {
        int limite9 = 9;
        int limite11 = 11;
        int limite13 = 13;
        if (campoVacio(vista.txtNombre.getText(), "Nombre")
                || campoVacio(vista.txtApellidoPaterno.getText(), "Apellido Paterno")
                || campoVacio(vista.txtApellidoMaterno.getText(), "Apellido Materno")
                || campoVacio(vista.txtDNI.getText(), "DNI")
                || campoVacio(vista.txtNumeroTelefono.getText(), "Telefono")) {
            return false;
        }

        if (excedeLimite(vista.txtDNI.getText(), limite9, "DNI")) {
            return false;
        }
        if (excedeLimite(vista.txtNumeroTelefono.getText(), limite13, "Telefono")) {
            return false;
        }
        if (vista.cbxUsuario.getSelectedItem().toString().equals("SELECCIONAR")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario");
            return false;
        }
        if (vista.cbxSexo.getSelectedItem().toString().equals("SELECCIONAR")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un sexo");
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

    private boolean excedeLimite(String valor, int limite, String nombreCampo) {
        if (valor.length() > limite) {
            JOptionPane.showMessageDialog(null, "No se puede ingresar más de " + limite + " dígitos en el " + nombreCampo);
            return true;
        }
        return false;
    }
}
