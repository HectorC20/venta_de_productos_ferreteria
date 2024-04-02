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
import M.P.DE.Transfer.Categoria;

/**
 *
 * @author Héctor
 */
public class CategoriaDaoImpl implements IDaoExtendido<Categoria>{
    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CategoriaDaoImpl() {
        this.conexion = Conexion.getInstancia();
    }    
    
    @Override
    public int obtenerId(String texto) {
         int id=-1;
         try {
            ps=conexion.conectar().prepareStatement("select id_categoria from "
                    + "categoria "
                    + "where "
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
                    + "nombre "
                    + "from categoria"
                    + " WHERE "
                    + "id_categoria=?");                   
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
    public boolean agregar(Categoria obj) {
     int r = 0;
        try {
            ps = conexion.conectar().prepareStatement(""
                    + "INSERT INTO "
                    + "categoria("
                    + " nombre,"
                    + " descripcion"
                    + ") values(?,?)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(Categoria obj) {
       int r = 0;
    try {
        ps = conexion.conectar().prepareStatement("UPDATE categoria SET"
                + " nombre=?,"
                + " descripcion=? "
                + " WHERE id_categoria=?");
           ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setInt(3, obj.getIdCategoria());
        r = ps.executeUpdate();
        return r == 1;
    } catch (SQLException ex) {
        return false;
    } finally {
        conexion.desconectar();
    }
    }

    @Override
    public boolean eliminar(Categoria obj) {
        int r=0;
        try {
        ps=conexion.conectar().prepareStatement(""
                + " DELETE FROM"
                + " categoria "
                + " WHERE "
                + " id_categoria=?");
        ps.setInt(1, obj.getIdCategoria());
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
    public List<Categoria> listar() {
              List<Categoria>lista = new ArrayList<>();
         try {
            ps=conexion.conectar().prepareStatement(""
                    + " SELECT *"
                    + " FROM "
                    + " categoria");                   
            rs=ps.executeQuery();
            while (rs.next())                     
                lista.add(new Categoria(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
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
      public List<Categoria> listar(Categoria obj) {
     List<Categoria>lista = new ArrayList<>();   
     boolean encontrado=false;
         try {
            if(obj.getIdCategoria()!=0) {
                ps=conexion.conectar().prepareStatement(""
                        + " SELECT *"
                        + " FROM "
                        + " categoria "
                        + " WHERE"
                        + " id_categoria=?");                   
                ps.setInt(1,obj.getIdCategoria());
            }
            else
            {
              ps=conexion.conectar().prepareStatement(""
                      + " SELECT * "
                      + " FROM "
                      + " categoria "
                      + " WHERE nombre"
                      + " LIKE ?");                   
              ps.setString(1,"%"+obj.getNombre()+"%");
            }
            obj=null;
            rs=ps.executeQuery();
            while(rs.next())                             
               lista.add(new Categoria(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
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
