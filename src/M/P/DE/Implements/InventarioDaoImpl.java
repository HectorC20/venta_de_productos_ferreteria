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
import M.P.DE.Transfer.Inventario;

/**
 *
 * @author Héctor
 */
public class InventarioDaoImpl implements IDaoExtendido<Inventario>{
    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public InventarioDaoImpl() {
        this.conexion = Conexion.getInstancia();
    }    
    
    @Override
    public int obtenerId(String texto) {
         int id=-1;
         try {
            ps=conexion.conectar().prepareStatement("select id_producto from "
                    + "inventario "
                    + "WHERE "
                    + "nombre=?");                   
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
                    "SELECT "
                    + " p.nombre "
                    + " from inventario AS i"
                    + " INNER JOIN productos AS p ON p.id_producto= i.id_producto"      
                    + " WHERE "
                    + " i.id_producto=?");                   
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
    public boolean agregar(Inventario obj) {
     int r = 0;
        try {
            ps = conexion.conectar().prepareStatement(""
                    + "INSERT INTO inventario("
                    + " id_producto,"
                    + " codigo_barras,"
                    + " cantidad_stock,"
                    + " id_proveedor,"
                    + " fecha_adquisicion,"
                    + " nivel_rebastecimiento,"
                    + " nota"
                    + ") values(?,?,?,?,?,?,?)");
            ps.setInt(1, obj.getIdProducto());
            ps.setString(2, obj.getCodigoBarras());
            ps.setInt(3, obj.getCantidadStock());
            ps.setInt(4, obj.getIdProveedor());
            ps.setString(5, obj.getFechaAdquisicion());
            ps.setInt(6, obj.getNivelRebastecimiento());
            ps.setString(7, obj.getNota());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(Inventario obj) {
       int r = 0;
    try {
        ps = conexion.conectar().prepareStatement("UPDATE inventario SET"
                    + " codigo_barras=?,"
                    + " cantidad_stock=?,"
                    + " id_proveedor=?,"
                    + " fecha_adquisicion=?,"
                    + " nivel_rebastecimiento=?,"
                    + " nota=?"
                    +"WHERE id_producto=?");
            
            ps.setString(1, obj.getCodigoBarras());
            ps.setInt(2, obj.getCantidadStock());
            ps.setInt(3, obj.getIdProveedor());
            ps.setString(4, obj.getFechaAdquisicion());
            ps.setInt(5, obj.getNivelRebastecimiento());
            ps.setString(6, obj.getNota());
            ps.setInt(7, obj.getIdProducto());
            
        r = ps.executeUpdate();
        return r == 1;
    } catch (SQLException ex) {
        return false;
    } finally {
        conexion.desconectar();
    }
    }

    @Override
    public boolean eliminar(Inventario obj) {
        int r=0;
        try {
        ps=conexion.conectar().prepareStatement(""
                + " DELETE FROM"
                + " inventario "
                + " WHERE "
                + " id_producto=?");
        ps.setInt(1, obj.getIdProducto());
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
    public List<Inventario> listar() {
              List<Inventario>lista = new ArrayList<>();
         try {
            ps=conexion.conectar().prepareStatement(""
                    + " SELECT *"
                    + " FROM "
                    + " inventario");                   
            rs=ps.executeQuery();
            while (rs.next())                     
                lista.add(new Inventario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)
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
      public List<Inventario> listar(Inventario obj) {
     List<Inventario>lista = new ArrayList<>();   
       boolean encontrado=false;
         try {
            if(obj.getIdProducto()!=0) {
                ps=conexion.conectar().prepareStatement("select * "
                        + "from inventario where id_producto=?");                   
                ps.setInt(1,obj.getIdProducto());
            }
            else
            {
              ps=conexion.conectar().prepareStatement("select * "
                      + " from inventario where nombre like ?");                   
              ps.setString(1,"%"+obj.getIdProducto()+"%");
            }
            obj=null;
            rs=ps.executeQuery();
            while(rs.next())                             
               lista.add(new Inventario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)
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
