package C.V.Ventas;

import M.P.DE.Dao.*;
import M.P.DE.Implements.*;
import M.P.DE.Transfer.*;
import V.I.P.Ventas.FrmCliente;
import V.I.P.Ventas.FrmDetalleVenta;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class contCliente extends JFrame implements ActionListener {

    private int idCliente;
    private IDaoGenerico<Cliente> crudDao;   
    private DefaultTableModel modelo;
    private Object[] filaDatos;
    private final FrmCliente vista;

    public contCliente(FrmCliente vista) {
        this.vista = vista;

        grupoInit();
    }

    public void grupoInit() {
        initFilas();
        inicializarModelo();
        configurarEventos();
        inicializarDao();
        limpiarTabla();
        listar();
    }

    public void initFilas() {
        filaDatos=new Object[10];
    }

    public void inicializarModelo() {
        modelo = new DefaultTableModel();
    }

    public void inicializarDao() {
        crudDao = new ClienteDaoImpl();
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
    
     public void mensajeVacio(){
           vista.lblMensaje.setText("");
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
            for (Cliente p : crudDao.listar()) {
                filaDatos[0] = p.getIdCliente();
                filaDatos[1] = p.getNombres();
                filaDatos[2] = p.getApellidoPaterno();
                filaDatos[3] = p.getApellidoMaterno();
                filaDatos[4] = p.getDni();
                filaDatos[5] = p.getRuc();
                filaDatos[6] = p.getDireccion();
                filaDatos[7] = p.getCorreo();
                filaDatos[8] = p.getTelefono();
                filaDatos[9] = p.getSexo();
                modelo.addRow(filaDatos);
            }
            //  tblProducto.setModel(modelo);
        } catch (Exception e) {
        }
    }

    public void buscar(java.awt.event.KeyEvent evt) {
        try {
            Cliente cliente;
            if (vista.rdbId.isSelected()) {
                cliente = new Cliente(Integer.parseInt(vista.txtBuscador.getText()));
            } else if (vista.rdbNombre.isSelected()) {
                cliente = new Cliente(vista.txtBuscador.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Seleccionar una opción para buscar");
                return;
            }
            limpiarTabla();
            int n = 0;
            if (crudDao.listar(cliente) != null) {
                for (Cliente p : crudDao.listar(cliente)) {
                    filaDatos[0] = p.getIdCliente();
                    filaDatos[1] = p.getNombres();
                    filaDatos[2] = p.getApellidoPaterno();
                    filaDatos[3] = p.getApellidoMaterno();
                    filaDatos[4] = p.getDni();
                    filaDatos[5] = p.getRuc();
                    filaDatos[6] = p.getDireccion();
                    filaDatos[7] = p.getCorreo();
                    filaDatos[8] = p.getTelefono();
                    filaDatos[9] = p.getSexo();
                    modelo.addRow(filaDatos);
                    n++;
                }
                vista.lblMensaje.setText(n + " registro(s) encontrado(s)");
            } else {
                vista.lblMensaje.setText(n + " registro(s) encontrado(s)");
            }
        } catch (HeadlessException | NumberFormatException ex) {
            listar();
            JOptionPane.showMessageDialog(null, "Error en el criterio a buscar");
            vista.lblMensaje.setText("");
        }
    }

    public void mostrarTabla(java.awt.event.MouseEvent evt) {
        int fila = vista.tbMostrar.getSelectedRow();
        if (fila == -1) {

        } else {
            idCliente = Integer.parseInt(vista.tbMostrar.getValueAt(fila, 0).toString());
            vista.txtNombres.setText(vista.tbMostrar.getValueAt(fila, 1).toString());
            vista.txtAPaterno.setText(vista.tbMostrar.getValueAt(fila, 2).toString());
            vista.txtAMateno.setText(vista.tbMostrar.getValueAt(fila, 3).toString());
            vista.txtDNI.setText(vista.tbMostrar.getValueAt(fila, 4).toString());
            vista.txtRUC.setText(vista.tbMostrar.getValueAt(fila, 5).toString());
            vista.txtDireccion.setText(vista.tbMostrar.getValueAt(fila, 6).toString());
            vista.txtCorreo.setText(vista.tbMostrar.getValueAt(fila, 7).toString());
            vista.txtTelefono.setText(vista.tbMostrar.getValueAt(fila, 8).toString());
            vista.cbxSexo.setSelectedItem(vista.tbMostrar.getValueAt(fila, 9).toString());
            vista.lblMensaje.setText("");
            if (evt.getClickCount() == 2) {
                if (fila < 0) {
                    vista.lblMensaje.setText("No hay filas para seleccionar");
                } else {
                    FrmDetalleVenta.txtCliente.setText(vista.tbMostrar.getValueAt(fila, 1).toString());
                    vista.dispose();
                }
            }
        }
    }

    public void eliminar() {
        try {
            // Validación de entrada
            if (CondicionalCampos()) {
                Cliente eliminarCliente = new Cliente(
                        idCliente
                );
                //validacion de entrega
                if (crudDao.eliminar(eliminarCliente)) {
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
                Cliente actualizarCliente = new Cliente(
                    idCliente,
                    vista.txtNombres.getText(),
                    vista.txtAPaterno.getText(),
                    vista.txtAMateno.getText(),
                    vista.txtDNI.getText(),
                    vista.txtRUC.getText(),
                    vista.txtDireccion.getText(),
                    vista.txtCorreo.getText(),
                    vista.txtTelefono.getText(),
                    vista.cbxSexo.getSelectedItem().toString()
                );
                //validacion de entrega
                if (crudDao.actualizar(actualizarCliente)) {
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
                Cliente nuevoCliente = new Cliente(
                    vista.txtNombres.getText(),
                    vista.txtAPaterno.getText(),
                    vista.txtAMateno.getText(),
                    vista.txtDNI.getText(),
                    vista.txtRUC.getText(),
                    vista.txtDireccion.getText(),
                    vista.txtCorreo.getText(),
                    vista.txtTelefono.getText(),
                    vista.cbxSexo.getSelectedItem().toString()
                );
                //validacion de entrega
                if (crudDao.agregar(nuevoCliente)) {
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
        vista.txtNombres.setText("");
        vista.txtAPaterno.setText("");
        vista.txtAMateno.setText("");
        vista.txtDNI.setText("");
        vista.txtRUC.setText("");
        vista.txtDireccion.setText("");
        vista.txtCorreo.setText("");
        vista.txtTelefono.setText("");
        vista.txtNombres.requestFocus();
    }

    
public boolean CondicionalCampos() {
    int limite9=9;
    int limite11=11;
    int limite13=13;
     if (
        campoVacio(vista.txtNombres.getText(), "Nombres") ||
        campoVacio(vista.txtAPaterno.getText(), "Apellido Paterno") ||
        campoVacio(vista.txtAMateno.getText(), "Apellido Materno") ||
        campoVacio(vista.txtDNI.getText(), "DNI") ||
        campoVacio(vista.txtRUC.getText(), "RUC") ||
        campoVacio(vista.txtDireccion.getText(), "Direccion") ||
        campoVacio(vista.txtCorreo.getText(), "Correo") ||
        campoVacio(vista.txtTelefono.getText(), "Telefono"))
     
     {
        return false;
    }

    if (
        excedeLimite(vista.txtTelefono.getText(), limite13, "Número telefónico")||
        excedeLimite(vista.txtDNI.getText(), limite9, "DNI")||
        excedeLimite(vista.txtRUC.getText(), limite11, "RUC")){
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
