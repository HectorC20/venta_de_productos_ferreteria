/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M.P.DE.Implements;

import M.P.DE.Dao.IDaoExtendido;
import M.P.DE.Source.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import M.P.DE.Transfer.Cliente;

/**
 *
 * @author Héctor
 */
public class ClienteDaoImpl implements IDaoExtendido<Cliente> {

    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    public ClienteDaoImpl() {
        this.conexion = Conexion.getInstancia();
    }

    @Override
    public int obtenerId(String texto) {
        int id = -1;
        try {
            ps = conexion.conectar().prepareStatement("select id_cliente from "
                    + "clientes "
                    + "where "
                    + "nombres=?");
            ps.setString(1, texto);
            rs = ps.executeQuery();
            //if(rs.first())   
            while (rs.next()) {
                id = rs.getInt(1);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }
        return id;
    }

    @Override
    public String obtenerNombre(int id) {
        String nombre = null;
        try {
            ps = conexion.conectar().prepareStatement(
                    "SELECT "
                    + "nombres "
                    + "from clientes"
                    + " WHERE "
                    + "id_cliente=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                nombre = rs.getString(1);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }
        return nombre;

    }

    @Override
    public boolean agregar(Cliente obj) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement(""
                    + "INSERT INTO "
                    + "clientes("
                    + " nombres,"
                    + " apellido_paterno,"
                    + " apellido_materno,"
                    + " dni,"
                    + " ruc,"
                    + " direccion,"
                    + " correo,"
                    + " telefono,"
                    + " sexo"
                    + ") values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, obj.getNombres());
            ps.setString(2, obj.getApellidoPaterno());
            ps.setString(3, obj.getApellidoMaterno());
            ps.setString(4, obj.getDni());
            ps.setString(5, obj.getRuc());
            ps.setString(6, obj.getDireccion());
            ps.setString(7, obj.getCorreo());
            ps.setString(8, obj.getTelefono());
            ps.setString(9, obj.getSexo());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(Cliente obj) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("UPDATE clientes SET"
                    + " nombres=?,"
                    + " apellido_paterno=?,"
                    + " apellido_materno=?,"
                    + " dni=?,"
                    + " ruc=?,"
                    + " direccion=?,"
                    + " correo=?,"
                    + " telefono=?,"
                    + " sexo=?"
                    + " WHERE id_cliente=?");
            ps.setString(1, obj.getNombres());
            ps.setString(2, obj.getApellidoPaterno());
            ps.setString(3, obj.getApellidoMaterno());
            ps.setString(4, obj.getDni());
            ps.setString(5, obj.getRuc());
            ps.setString(6, obj.getDireccion());
            ps.setString(7, obj.getCorreo());
            ps.setString(8, obj.getTelefono());
            ps.setString(9, obj.getSexo());
            ps.setInt(10, obj.getIdCliente());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    // Manejar la excepción de cierre, si es necesario
                    e.printStackTrace();
                }
            }
            conexion.desconectar();
        }
    }

    @Override
    public boolean eliminar(Cliente obj) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement(""
                    + " DELETE FROM"
                    + " clientes "
                    + " WHERE "
                    + " id_cliente=?");
            ps.setInt(1, obj.getIdCliente());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement(""
                    + " SELECT *"
                    + " FROM "
                    + " clientes");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                ));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }
        return lista;

    }

    @Override
    public List<Cliente> listar(Cliente obj) {
        List<Cliente> lista = new ArrayList<>();
        boolean encontrado = false;
        try {
            if (obj.getIdCliente() != 0) {
                ps = conexion.conectar().prepareStatement(""
                        + " SELECT *"
                        + " FROM "
                        + " clientes "
                        + " WHERE"
                        + " id_cliente=?");
                ps.setInt(1, obj.getIdCliente());
            } else {
                ps = conexion.conectar().prepareStatement(""
                        + " SELECT * "
                        + " FROM "
                        + " clientes "
                        + " WHERE nombres"
                        + " LIKE ?");
                ps.setString(1, "%" + obj.getNombres() + "%");
            }
            obj = null;
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                ));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            lista = null;
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }
        return lista;
    }
}
