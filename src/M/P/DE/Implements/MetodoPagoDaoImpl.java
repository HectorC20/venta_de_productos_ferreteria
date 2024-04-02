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
import M.P.DE.Transfer.MetodoPago;

/**
 *
 * @author Héctor
 */
public class MetodoPagoDaoImpl implements IDaoExtendido<MetodoPago>{
    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public MetodoPagoDaoImpl() {
        this.conexion = Conexion.getInstancia();
    }    

    @Override
    public int obtenerId(String texto) {
         int id=-1;
         try {
            ps=conexion.conectar().prepareStatement("select id_metodo "
                    + " from metodo_pago"
                    + " where nombre=?");                   
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
            ps=conexion.conectar().prepareStatement("select nombre "
                    + "from metodo_pago "
                    + "where id_metodo=?");                   
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
    public boolean agregar(MetodoPago obj) {
     int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("INSERT INTO metodo_pago("
                    + " nombre"
                    + ") values(?)");
            ps.setString(1, obj.getNombre());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(MetodoPago obj) {
       int r = 0;
    try {
        ps = conexion.conectar().prepareStatement("UPDATE metodo_pago SET"
                + " nombre=?"
                + " WHERE id_metodo=?");
            ps.setString(1, obj.getNombre());
            ps.setInt(2, obj.getIdMetodo());
        r = ps.executeUpdate();
        return r == 1;
    } catch (SQLException ex) {
        return false;
    } finally {
        conexion.desconectar();
    }
    }

    @Override
    public boolean eliminar(MetodoPago obj) {
        int r=0;
        try {
        ps=conexion.conectar().prepareStatement("delete from metodo_pago "
                + "where id_metodo=?");
        ps.setInt(1, obj.getIdMetodo());
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
    public List<MetodoPago> listar() {
              List<MetodoPago>lista = new ArrayList<>();
         try {
            ps=conexion.conectar().prepareStatement("select * from metodo_pago");                   
            rs=ps.executeQuery();
            while (rs.next())                     
                lista.add(new MetodoPago(
                        rs.getInt(1),
                        rs.getString(2)
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
    public List<MetodoPago> listar(MetodoPago obj) {
     List<MetodoPago>lista = new ArrayList<>();   
     boolean encontrado=false;
         try {
            if(obj.getIdMetodo()!=0) {
                ps=conexion.conectar().prepareStatement("select * from metodo_pago where id_metodo=?");                   
                ps.setInt(1,obj.getIdMetodo());
            }
            else
            {
              ps=conexion.conectar().prepareStatement("select * from metodo_pago where nombre like ?");                   
              ps.setString(1,"%"+obj.getNombre()+"%");
            }
            obj=null;
            rs=ps.executeQuery();
            while(rs.next())                             
               lista.add(new MetodoPago(
                        rs.getInt(1),
                        rs.getString(2)
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