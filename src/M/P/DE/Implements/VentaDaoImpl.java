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
import M.P.DE.Transfer.Venta;

/**
 *
 * @author Héctor
 */
public class VentaDaoImpl implements IDaoExtendido<Venta>{

    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public VentaDaoImpl() {
        this.conexion = Conexion.getInstancia();
    }    
    
    @Override
    public int obtenerId(String texto) {
         int id=-1;
         try {
            ps=conexion.conectar().prepareStatement("SELECT"
                    + " id_venta"
                    + " FROM "
                    + " venta "
                    + " WHERE "
                    + " id_cliente=?");                   
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
                    + " id_cliente "
                    + " FROM venta"
                    + " WHERE "
                    + "id_venta=?");                   
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
    public boolean agregar(Venta obj) {
     int r = 0;
        try {
            ps = conexion.conectar().prepareStatement(""
                    + "INSERT INTO "
                    + "venta("
                    + " fecha,"
                    + " total, "
                    + " id_cliente,"
                    + " id_empleado "
                    + ") "
                    + "values(?,?,?,?)");
            ps.setString(1, obj.getFecha());
            ps.setDouble(2, obj.getTotal());
            ps.setInt(3, obj.getIdCliente());
            ps.setInt(4, obj.getIdEmpleado());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(Venta obj) {
       int r = 0;
    try {
        ps = conexion.conectar().prepareStatement("UPDATE venta SET"
                + " fecha=?,"
                + " total=?, "
                + " id_cliente=?,"
                + " id_empleado=? "
                + " WHERE id_venta=?");
            ps.setString(1, obj.getFecha());
            ps.setDouble(2, obj.getTotal());
            ps.setInt(3, obj.getIdCliente());
            ps.setInt(4, obj.getIdEmpleado());
            ps.setInt(5, obj.getIdVenta());
        r = ps.executeUpdate();
        return r == 1;
    } catch (SQLException ex) {
        return false;
    } finally {
        conexion.desconectar();
    }
    }

    @Override
    public boolean eliminar(Venta obj) {
        int r=0;
        try {
        ps=conexion.conectar().prepareStatement(""
                + " DELETE FROM"
                + " venta "
                + " WHERE "
                + " id_venta=?");
        ps.setInt(1, obj.getIdVenta());
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
    public List<Venta> listar() {
              List<Venta>lista = new ArrayList<>();
         try {
            ps=conexion.conectar().prepareStatement(""
                    + " SELECT *"
                    + " FROM "
                    + " venta");                   
            rs=ps.executeQuery();
            while (rs.next())                     
                lista.add(new Venta(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getInt(5)
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
      public List<Venta> listar(Venta obj) {
     List<Venta>lista = new ArrayList<>();   
     boolean encontrado=false;
         try {
            if(obj.getIdVenta()!=0) {
                ps=conexion.conectar().prepareStatement(""
                        + " SELECT *"
                        + " FROM "
                        + " detalle_venta "
                        + " WHERE"
                        + " id_detalle=?");                   
                ps.setInt(1,obj.getIdVenta());
            }
            else
            {
              ps=conexion.conectar().prepareStatement(""
                      + " SELECT * "
                      + " FROM "
                      + " venta "
                      + " WHERE id_venta"
                      + " LIKE ?");                   
              ps.setString(1,"%"+obj.getIdVenta()+"%");
            }
            obj=null;
            rs=ps.executeQuery();
            while(rs.next())                             
               lista.add(new Venta(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getInt(5)
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
