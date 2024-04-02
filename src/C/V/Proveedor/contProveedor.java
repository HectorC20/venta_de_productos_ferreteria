package C.V.Proveedor;

import M.P.DE.Dao.*;
import M.P.DE.Implements.*;
import M.P.DE.Transfer.*;
import V.I.P.Ventas.pnProveedor;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class contProveedor extends JFrame implements ActionListener {

    private int idProveedor;
    private IDaoGenerico<Proveedor> crudDao;
    private DefaultTableModel modelo;
    private Object[] filaDatos;
    private final pnProveedor vista;

    public contProveedor(pnProveedor vista) {
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
        filaDatos = new Object[12];
    }

    public void inicializarModelo() {
        modelo = new DefaultTableModel();
    }

    public void inicializarDao() {
        crudDao = new ProveedorDaoImpl();
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
            for (Proveedor p : crudDao.listar()) {
                filaDatos[0] = p.getIdProveedor();
                filaDatos[1] = p.getNombreCompania();
                filaDatos[2] = p.getNombreContacto();
                filaDatos[3] = p.getCargoContacto();
                filaDatos[4] = p.getDireccion();
                filaDatos[5] = p.getCiudad();
                filaDatos[6] = p.getRegion();
                filaDatos[7] = p.getCodPostal();
                filaDatos[8] = p.getPais();
                filaDatos[9] = p.getTelefono();
                filaDatos[10] = p.getFax();
                filaDatos[11] = p.getPaginaPrincipal();
                modelo.addRow(filaDatos);
            }
            //  tblProducto.setModel(modelo);
        } catch (Exception e) {
        }
    }

    public void buscar(java.awt.event.KeyEvent evt) {
        try {
            Proveedor proveedor;
            if (vista.rdbId.isSelected()) {
                proveedor = new Proveedor(Integer.parseInt(vista.txtBuscador.getText()));
            } else if (vista.rdbNombre.isSelected()) {
                proveedor = new Proveedor(vista.txtBuscador.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Seleccionar una opción para buscar");
                return;
            }
            limpiarTabla();
            int n = 0;
            if (crudDao.listar(proveedor) != null) {
                for (Proveedor p : crudDao.listar(proveedor)) {
                    filaDatos[0] = p.getIdProveedor();
                    filaDatos[1] = p.getNombreCompania();
                    filaDatos[2] = p.getNombreContacto();
                    filaDatos[3] = p.getCargoContacto();
                    filaDatos[4] = p.getDireccion();
                    filaDatos[5] = p.getCiudad();
                    filaDatos[6] = p.getRegion();
                    filaDatos[7] = p.getCodPostal();
                    filaDatos[8] = p.getPais();
                    filaDatos[9] = p.getTelefono();
                    filaDatos[10] = p.getFax();
                    filaDatos[11] = p.getPaginaPrincipal();
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
            idProveedor = Integer.parseInt(vista.tbMostrar.getValueAt(fila, 0).toString());
            vista.txtCompania.setText(vista.tbMostrar.getValueAt(fila, 1).toString());
            vista.txtContacto.setText(vista.tbMostrar.getValueAt(fila, 2).toString());
            vista.txtCargo.setText(vista.tbMostrar.getValueAt(fila, 3).toString());
            vista.txtDireccion.setText(vista.tbMostrar.getValueAt(fila, 4).toString());
            vista.txtCiudad.setText(vista.tbMostrar.getValueAt(fila, 5).toString());
            vista.txtRegion.setText(vista.tbMostrar.getValueAt(fila, 6).toString());
            vista.txtCodigoPostal.setText(vista.tbMostrar.getValueAt(fila, 7).toString());
            vista.cbxPais.setSelectedItem(vista.tbMostrar.getValueAt(fila, 8).toString());
            vista.txtTelefono.setText(vista.tbMostrar.getValueAt(fila, 9).toString());
            vista.txtFax.setText(vista.tbMostrar.getValueAt(fila, 10).toString());
            vista.txtPagina.setText(vista.tbMostrar.getValueAt(fila, 11).toString());
            vista.lblMensaje.setText("");
        }
    }

    public void eliminar() {
        try {
            // Validación de entrada
            if (CondicionalCampos()) {
                Proveedor eliminarProveedor = new Proveedor(
                        idProveedor
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
                Proveedor actualizarProveedor = new Proveedor(
                        idProveedor,
                        vista.txtCompania.getText(),
                        vista.txtContacto.getText(),
                        vista.txtCargo.getText(),
                        vista.txtDireccion.getText(),
                        vista.txtCiudad.getText(),
                        vista.txtRegion.getText(),
                        vista.txtCodigoPostal.getText(),
                        vista.cbxPais.getSelectedItem().toString(),
                        vista.txtTelefono.getText(),
                        vista.txtFax.getText(),
                        vista.txtPagina.getText());
                //validacion de entrega
                if (crudDao.actualizar(actualizarProveedor)) {
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
                Proveedor nuevoProveedor = new Proveedor(
                        vista.txtCompania.getText(),
                        vista.txtContacto.getText(),
                        vista.txtCargo.getText(),
                        vista.txtDireccion.getText(),
                        vista.txtCiudad.getText(),
                        vista.txtRegion.getText(),
                        vista.txtCodigoPostal.getText(),
                        vista.cbxPais.getSelectedItem().toString(),
                        vista.txtTelefono.getText(),
                        vista.txtFax.getText(),
                        vista.txtPagina.getText());
                //validacion de entrega
                if (crudDao.agregar(nuevoProveedor)) {
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
        vista.txtCompania.setText("");
        vista.txtContacto.setText("");
        vista.txtCargo.setText("");
        vista.txtDireccion.setText("");
        vista.txtCiudad.setText("");
        vista.txtRegion.setText("");
        vista.txtCodigoPostal.setText("");
        vista.cbxPais.setSelectedIndex(-1);
        vista.txtTelefono.setText("");
        vista.txtFax.setText("");
        vista.txtPagina.setText("");
        vista.txtCompania.requestFocus();
    }

    public boolean CondicionalCampos() {
        int limite9 = 9;
        int limite11 = 11;
        int limite13 = 13;
        if (campoVacio(vista.txtCompania.getText(), "Compañía")
                || campoVacio(vista.txtContacto.getText(), "Contacto")
                || campoVacio(vista.txtCargo.getText(), "Cargo")
                || campoVacio(vista.txtDireccion.getText(), "Direccion")
                || campoVacio(vista.txtCiudad.getText(), "Ciudad")
                || campoVacio(vista.txtRegion.getText(), "Region")
                || campoVacio(vista.txtCodigoPostal.getText(), "Codigo Postal")
                || campoVacio(vista.txtTelefono.getText(), "Telefono")
                || campoVacio(vista.txtFax.getText(), "Fax")
                || campoVacio(vista.txtPagina.getText(), "Pagina")) {
            return false;
        }

        if (excedeLimite(vista.txtTelefono.getText(), limite13, "Número telefónico")) {
            return false;
        }

        if (vista.cbxPais.getSelectedItem().toString().equals("SELECCIONE")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una ciudad");
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
