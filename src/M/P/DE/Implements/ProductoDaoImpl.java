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
import M.P.DE.Transfer.Producto;

/**
 *
 * @author Héctor
 */
public class ProductoDaoImpl implements IDaoExtendido<Producto>{
    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    public ProductoDaoImpl() {
        this.conexion = Conexion.getInstancia();
    }    
    @Override
    public int obtenerId(String texto) {
         int id=-1;
         try {
            ps=conexion.conectar().prepareStatement("SELECT id_producto"
                    + " FROM productos "
                    + " WHERE nombre=?");                   
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
            ps=conexion.conectar().prepareStatement("SELECT nombre "
                    + "FROM productos "
                    + "WHERE id_producto=?");                   
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
    public boolean agregar(Producto obj) {
     int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("INSERT INTO productos("
                    + " nombre,"
                    + " descripcion,"
                    + " precio,"
                    + " costo,"
                    + " existencia, "
                    + " id_categoria, "
                    + " igv_iva,"
                    + " precio_sub "
                    + ") values(?,?,?,?,?,?,?,?)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setFloat(3, obj.getPrecio());
            ps.setFloat(4, obj.getCosto());
            ps.setInt(5, obj.getExistencia());
            ps.setInt(6, obj.getIdCategoria());
            ps.setFloat(7, obj.getIgv_iva());
            ps.setFloat(8, obj.getPrecio_sub());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(Producto obj) {
       int r = 0;
    try {
        ps = conexion.conectar().prepareStatement("UPDATE productos SET"
                + " nombre=?,"
                + " descripcion=?, "
                + " precio=?,"
                + " costo=?,"
                + " existencia=?,"
                + " id_categoria=?, "
                + " igv_iva=?,"
                + " precio_sub=? "
                + " WHERE id_producto=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setFloat(3, obj.getPrecio());
            ps.setFloat(4, obj.getCosto());
            ps.setInt(5, obj.getExistencia());
            ps.setInt(6, obj.getIdCategoria());
            ps.setFloat(7, obj.getIgv_iva());
            ps.setFloat(8, obj.getPrecio_sub());
            ps.setInt(9, obj.getIdProducto());
        r = ps.executeUpdate();
        return r == 1;
    } catch (SQLException ex) {
        return false;
    } finally {
        conexion.desconectar();
    }
    }

    @Override
    public boolean eliminar(Producto obj) {
        int r=0;
        try {
        ps=conexion.conectar().prepareStatement(""
                + " DELETE FROM"
                + " productos "
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
    public List<Producto> listar() {
              List<Producto>lista = new ArrayList<>();
         try {
            ps=conexion.conectar().prepareStatement("select * from productos");                   
            rs=ps.executeQuery();
            while (rs.next())                     
                lista.add(new Producto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getFloat(8),
                        rs.getFloat(9)
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
      public List<Producto> listar(Producto obj) {
     List<Producto>lista = new ArrayList<>();   
     boolean encontrado=false;
         try {
            if(obj.getIdProducto()!=0) {
                ps=conexion.conectar().prepareStatement("select * from productos where id_producto=?");                   
                ps.setInt(1,obj.getIdProducto());
            }
            else
            {
              ps=conexion.conectar().prepareStatement("select * from productos where nombre like ?");                   
              ps.setString(1,"%"+obj.getNombre()+"%");
            }
            obj=null;
            rs=ps.executeQuery();
            while(rs.next())                             
               lista.add(new Producto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getFloat(8),
                       rs.getFloat(9)
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
