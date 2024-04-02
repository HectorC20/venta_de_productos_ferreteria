/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M.P.DE.Implements;

import M.P.DE.Dao.IDaoExtendido;
import M.P.DE.Source.Conexion;
import M.P.DE.Transfer.Factura;
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
public class FacturaDaoImpl implements IDaoExtendido<Factura>{

    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public FacturaDaoImpl() {
        this.conexion = Conexion.getInstancia();
    }    
    
    @Override
    public int obtenerId(String texto) {
         int id=-1;
         try {
            ps=conexion.conectar().prepareStatement("SELECT"
                    + " id_factura"
                    + " FROM "
                    + " factura "
                    + " WHERE "
                    + " id_factura=?");                   
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
                    + " id_factura "
                    + " FROM factura"
                    + " WHERE "
                    + "id_factura=?");                   
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
    public boolean agregar(Factura obj) {
     int r = 0;
        try {
            ps = conexion.conectar().prepareStatement(""
                    + "INSERT INTO "
                    + "factura("
                    + " fecha_factura,"
                    + " id_cliente, "
                    + " total_factura,"
                    + " estado,"
                    + " id_metodo,"
                    + " descuento,"
                    + " impuestos,"
                    + " id_venta "
                    + ") values(?,?,?,?,?,?,?,?)");
            ps.setString(1, obj.getFechaFactura());
            ps.setInt(2, obj.getIdCliente());
            ps.setFloat(3, obj.getTotalFactura());
            ps.setString(4, obj.getEstado());
            ps.setInt(5, obj.getIdMetodo());
            ps.setFloat(6, obj.getDescuento());
            ps.setFloat(7, obj.getImpuestos());
            ps.setInt(8, obj.getIdVenta());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(Factura obj) {
       int r = 0;
    try {
        ps = conexion.conectar().prepareStatement("UPDATE factura SET"
                + " fecha_factura=?,"
                + " id_cliente=?, "
                + " totalFactura=?,"
                + " estado=?,"
                + " id_metodo=?,"
                + " descuento=?,"
                + " impuestos=?,"
                + " id_venta=? "
                + " WHERE id_factura=?");
            ps.setString(1, obj.getFechaFactura());
            ps.setInt(2, obj.getIdCliente());
            ps.setFloat(3, obj.getTotalFactura());
            ps.setString(4, obj.getEstado());
            ps.setInt(5, obj.getIdMetodo());
            ps.setFloat(6, obj.getDescuento());
            ps.setFloat(7, obj.getImpuestos());
            ps.setInt(8, obj.getIdVenta());
            ps.setInt(9, obj.getIdFactura());
        r = ps.executeUpdate();
        return r == 1;
    } catch (SQLException ex) {
        return false;
    } finally {
        conexion.desconectar();
    }
    }

    @Override
    public boolean eliminar(Factura obj) {
        int r=0;
        try {
        ps=conexion.conectar().prepareStatement(""
                + " DELETE FROM"
                + " factura "
                + " WHERE "
                + " id_factura=?");
        ps.setInt(1, obj.getIdFactura());
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
    public List<Factura> listar() {
              List<Factura>lista = new ArrayList<>();
         try {
            ps=conexion.conectar().prepareStatement(""
                    + " SELECT *"
                    + " FROM "
                    + " factura");                   
            rs=ps.executeQuery();
            while (rs.next())                     
                lista.add(new Factura(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getFloat(8),
                        rs.getInt(9)
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
      public List<Factura> listar(Factura obj) {
     List<Factura>lista = new ArrayList<>();   
     boolean encontrado=false;
         try {
            if(obj.getIdFactura()!=0) {
                ps=conexion.conectar().prepareStatement(""
                        + " SELECT *"
                        + " FROM "
                        + " factura "
                        + " WHERE"
                        + " id_factura=?");                   
                ps.setInt(1,obj.getIdFactura());
            }
            else
            {
              ps=conexion.conectar().prepareStatement(""
                      + " SELECT * "
                      + " FROM "
                      + " factura "
                      + " WHERE id_factura"
                      + " LIKE ?");                   
              ps.setString(1,"%"+obj.getIdFactura()+"%");
            }
            obj=null;
            rs=ps.executeQuery();
            while(rs.next())                             
               lista.add(new Factura(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getFloat(7),
                        rs.getFloat(8),
                        rs.getInt(9)
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
