/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M.P.DE.Implements;

import M.P.DE.Dao.IDaoExtendido;
import M.P.DE.Source.Conexion;
import M.P.DE.Transfer.DetalleVenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import M.P.DE.Transfer.Empleado;

/**
 *
 * @author Héctor
 */
public class DetalleVentaDaoImpl implements IDaoExtendido<DetalleVenta>{

    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public DetalleVentaDaoImpl() {
        this.conexion = Conexion.getInstancia();
    }    
    
    @Override
    public int obtenerId(String texto) {
         int id=-1;
         try {
            ps=conexion.conectar().prepareStatement("SELECT"
                    + " id_detalle"
                    + " FROM "
                    + " detalle_venta "
                    + " WHERE "
                    + " nombres=?");                   
            ps.setString(1,texto);
            rs=ps.executeQuery();
            //if(rs.first())   
            while (rs.next())            
               id=rs.getInt(1);
            ps.close(); 
            rs.close();  
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e.getMessage());              
         }finally{            
            ps=null;
            rs=null;
            conexion.desconectar();          
          } 
        return id;    
    }

    @Override
    public String obtenerNombre(int id) {
             String nombre=null;
         try {
            ps=conexion.conectar().prepareStatement(
                    " SELECT "
                    + " id_producto "
                    + " FROM empleados"
                    + " WHERE "
                    + "id_detalle=?");                   
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next())                 
               nombre=rs.getString(1);
             ps.close(); 
             rs.close();               
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e.getMessage());              
         }finally{            
            ps=null;
            rs=null;
            conexion.desconectar();          
          } 
        return nombre;    
 
    }


    @Override
    public boolean agregar(DetalleVenta obj) {
     int r = 0;
        try {
            ps = conexion.conectar().prepareStatement(""
                    + "INSERT INTO "
                    + "detalle_venta("
                    + " id_producto,"
                    + " id_venta, "
                    + " precio_unitario,"
                    + " sub_total "
                    + ") values(?,?,?,?)");
            ps.setInt(1, obj.getIdProducto());
            ps.setInt(2, obj.getIdVenta());
            ps.setFloat(3, obj.getPrecioUnitario());
            ps.setFloat(4, obj.getSubTotal());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(DetalleVenta obj) {
       int r = 0;
    try {
        ps = conexion.conectar().prepareStatement("UPDATE detalle_venta SET"
                + " id_producto=?,"
                + " id_venta=?, "
                + " precio_unitario=?,"
                + " sub_total=? "
                + " WHERE id_detalle=?");
            ps.setInt(1, obj.getIdProducto());
            ps.setInt(2, obj.getIdVenta());
            ps.setFloat(3, obj.getPrecioUnitario());
            ps.setFloat(4, obj.getSubTotal());
            ps.setInt(5, obj.getIdDetalle());
        r = ps.executeUpdate();
        return r == 1;
    } catch (SQLException ex) {
        return false;
    } finally {
        conexion.desconectar();
    }
    }

    @Override
    public boolean eliminar(DetalleVenta obj) {
        int r=0;
        try {
        ps=conexion.conectar().prepareStatement(""
                + " DELETE FROM"
                + " detalle_venta "
                + " WHERE "
                + " id_detalle=?");
        ps.setInt(1, obj.getIdDetalle());
        r=ps.executeUpdate();
        return r==1;
       } catch (SQLException ex) {
          return false;
        }
        finally{
         conexion.desconectar();
        } 
    }

    @Override
    public List<DetalleVenta> listar() {
              List<DetalleVenta>lista = new ArrayList<>();
         try {
            ps=conexion.conectar().prepareStatement(""
                    + " SELECT *"
                    + " FROM "
                    + " detalle_venta");                   
            rs=ps.executeQuery();
            while (rs.next())                     
                lista.add(new DetalleVenta(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        rs.getInt(6)
                ));
             ps.close();
             rs.close();            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e.getMessage());
         }finally{
            ps=null;
            rs=null;
            conexion.desconectar();          
          } 
        return lista;

    }
    
   @Override
      public List<DetalleVenta> listar(DetalleVenta obj) {
     List<DetalleVenta>lista = new ArrayList<>();   
     boolean encontrado=false;
         try {
            if(obj.getIdDetalle()!=0) {
                ps=conexion.conectar().prepareStatement(""
                        + " SELECT *"
                        + " FROM "
                        + " detalle_venta "
                        + " WHERE"
                        + " id_detalle=?");                   
                ps.setInt(1,obj.getIdDetalle());
            }
            else
            {
              ps=conexion.conectar().prepareStatement(""
                      + " SELECT * "
                      + " FROM "
                      + " detalle_venta "
                      + " WHERE id_detalle"
                      + " LIKE ?");                   
              ps.setString(1,"%"+obj.getIdDetalle()+"%");
            }
            obj=null;
            rs=ps.executeQuery();
            while(rs.next())                             
               lista.add(new DetalleVenta(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                       rs.getInt(6)
                       ));                       
            ps.close();
            rs.close();            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e.getMessage());
               lista=null; 
         }finally{
            ps=null;
            rs=null;
            conexion.desconectar();          
          } 
        return lista;    
      }
    
}
