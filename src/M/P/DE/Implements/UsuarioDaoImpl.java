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
import M.P.DE.Transfer.Usuario;

/**
 *
 * @author Héctor
 */
public class UsuarioDaoImpl implements IDaoExtendido<Usuario>{
    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public UsuarioDaoImpl() {
        this.conexion = Conexion.getInstancia();
    }    

    @Override
    public int obtenerId(String texto) {
         int id=-1;
         try {
            ps=conexion.conectar().prepareStatement("select id_usuario from Usuarios where usuario=?");                   
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
            ps=conexion.conectar().prepareStatement("select usuario from usuarios where id_usuario=?");                   
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
    public boolean agregar(Usuario obj) {
     int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("INSERT INTO usuarios("
                    + " usuario,"
                    + " clave,"
                    + " cargo"
                    + ") values(?,?,?)");
            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getClave());
            ps.setString(3, obj.getCargo());
          
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(Usuario obj) {
       int r = 0;
    try {
        ps = conexion.conectar().prepareStatement("UPDATE usuarios SET"
                + " usuario=?,"
                + " clave=?, "
                + " cargo=?"
                + " WHERE id_usuario=?");
            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getClave());
            ps.setString(3, obj.getCargo());
            ps.setInt(4, obj.getIdUsuario());
        r = ps.executeUpdate();
        return r == 1;
    } catch (SQLException ex) {
        return false;
    } finally {
        conexion.desconectar();
    }
    }

    @Override
    public boolean eliminar(Usuario obj) {
        int r=0;
        try {
        ps=conexion.conectar().prepareStatement("delete from usuarios where id_usuario=?");
        ps.setInt(1, obj.getIdUsuario());
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
    public List<Usuario> listar() {
              List<Usuario>lista = new ArrayList<>();
         try {
            ps=conexion.conectar().prepareStatement("select * from usuarios");                   
            rs=ps.executeQuery();
            while (rs.next())                     
                lista.add(new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
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
    public List<Usuario> listar(Usuario obj) {
     List<Usuario>lista = new ArrayList<>();   
     boolean encontrado=false;
         try {
            if(obj.getIdUsuario()!=0) {
                ps=conexion.conectar().prepareStatement("select * from usuarios where id_usuario=?");                   
                ps.setInt(1,obj.getIdUsuario());
            }
            else
            {
              ps=conexion.conectar().prepareStatement("select * from usuarios where usuario like ?");                   
              ps.setString(1,"%"+obj.getUsuario()+"%");
            }
            obj=null;
            rs=ps.executeQuery();
            while(rs.next())                             
               lista.add(new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
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