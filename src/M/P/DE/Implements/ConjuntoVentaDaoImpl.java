/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M.P.DE.Implements;

import M.P.DE.Source.Conexion;
import M.P.DE.Transfer.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Héctor
 */
public class ConjuntoVentaDaoImpl {

    private final Conexion conexion;
    public static int idCVentaRegistrada;
    public static int idCFacturaRegistrada;
    public static int idCabeceraRegistrada;

    public ConjuntoVentaDaoImpl() {
        this.conexion = Conexion.getInstancia();
    }

    public boolean guardarVenta(Venta venta) {
        try ( Connection connection = conexion.conectar();  PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO "
                + "venta("
                + "fecha, "
                + "total, "
                + "id_cliente, "
                + "id_empleado) "
                + "VALUES (?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, venta.getFecha());
            ps.setDouble(2, venta.getTotal());
            ps.setInt(3, venta.getIdCliente());
            ps.setInt(4, venta.getIdEmpleado());

            if (ps.executeUpdate() > 0) {
                try ( ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        idCVentaRegistrada = rs.getInt(1);
                        return true;
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al obtener clave generada: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al ejecutar la actualización.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar venta: " + e.getMessage());
        }
        return false;
    }

    public int guardarFactura(Factura obj) {
        try ( Connection connection = conexion.conectar();  PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO factura("
                + "fecha_factura, "
                + "id_cliente, "
                + "total_factura, "
                + "estado, "
                + "id_metodo, "
                + "descuento,"
                + "impuestos,"
                + "id_venta"
                + ") "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, obj.getFechaFactura());
            ps.setInt(2, obj.getIdCliente());
            ps.setFloat(3, obj.getTotalFactura());
            ps.setString(4, obj.getEstado());
            ps.setInt(5, obj.getIdMetodo());
            ps.setFloat(6, obj.getDescuento());
            ps.setFloat(7, obj.getImpuestos());
            ps.setInt(8, idCVentaRegistrada);

            if (ps.executeUpdate() > 0) {
                try ( ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    

    public int guardarDetalle(DetalleVenta obj) {
        try ( Connection connection = conexion.conectar();  PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO detalle_venta("
                + "id_producto, "
                + "id_venta, "
                + "precio_unitario, "
                + "sub_total, "
                + "cantidad) "
                + "VALUES (?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, obj.getIdProducto());
            ps.setInt(2, idCVentaRegistrada);
            ps.setFloat(3, obj.getPrecioUnitario());
            ps.setFloat(4, obj.getSubTotal());
            ps.setInt(5, obj.getCantidad());

            if (ps.executeUpdate() > 0) {
                try ( ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int obtenerUltimoIdVenta() {
        int ultimoIdVenta = -1;

        try ( Connection connection = conexion.conectar();  
                Statement statement = connection.createStatement();  
                ResultSet resultSet = statement.executeQuery("SELECT "
                + "MAX(id_venta) AS ultimoIdVenta"
                + " FROM venta")) {

            if (resultSet.next()) {
                ultimoIdVenta = resultSet.getInt("ultimoIdVenta");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ultimoIdVenta;
    }

}
