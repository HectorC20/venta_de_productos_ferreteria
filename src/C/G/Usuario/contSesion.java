/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package C.G.Usuario;

import M.P.DE.Source.Conexion;
import V.I.M.Gerente.MenuGerente;
import V.I.M.Ventas.MenuVentas;
import V.I.S.Login.FrmSession;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Héctor
 */
public final class contSesion implements ActionListener {
    private final FrmSession vista;

    public contSesion(FrmSession vista) {
        this.vista = vista;
        configurarVentana();
        configurarEventos();
    }

     private void configurarEventos() {
        vista.btnIngresar.addActionListener(this);
     
    }
    private void configurarVentana() {
        vista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        vista.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vista.setVisible(false);
            }
        });

        vista.setSize(700, 550);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnIngresar) {
            // Llama al método agregar cuando se hace clic en el botón
            consultarUsuario();
        }
    }

    public void consultarUsuario() {
    String usuario = vista.txtUsuario.getText();
    String clave = vista.tpsClave.getText();

    Conexion db = new Conexion();
    String usuarioCorrecto = null;
    String claveCorrecto = null;
    String cargoCorrecto = null;

    try {
        Connection cn = db.conectar();
        PreparedStatement pst = cn.prepareStatement("SELECT"
                + " usuario, "
                + "clave, "
                + "cargo "
                + "FROM "
                + "usuarios "
                + "WHERE "
                + "usuario = ?");
        pst.setString(1, usuario);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            usuarioCorrecto = rs.getString("usuario");
            claveCorrecto = rs.getString("clave");
            cargoCorrecto = rs.getString("cargo");
        }

        if (usuario.equals(usuarioCorrecto) && clave.equals(claveCorrecto)) {
            mostrarMensajeBienvenida(usuario, cargoCorrecto);
        } else {
            mostrarMensajeError();
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error " + e);
    }
}

    private void mostrarMensajeBienvenida(String usuario, String cargo) {
        String mensaje = "Login correcto, Bienvenido " + usuario;
        JOptionPane.showMessageDialog(null, mensaje);

        if ("Gerente".equals(cargo)) {
            vista.dispose();
            MenuGerente ofc = new MenuGerente();
            ofc.setVisible(true);
        } else if ("Ventas".equals(cargo)) {
            vista.dispose();
            MenuVentas ofc = new MenuVentas();
            ofc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Cargo desconocido para el usuario " + usuario);
        }
    }

    private void mostrarMensajeError() {
        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
    }

}
