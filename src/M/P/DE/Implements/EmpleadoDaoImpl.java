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
import M.P.DE.Transfer.Empleado;

/**
 *
 * @author Héctor
 */
public class EmpleadoDaoImpl implements IDaoExtendido<Empleado>{

    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public EmpleadoDaoImpl() {
        this.conexion = Conexion.getInstancia();
    }    
    
    @Override
    public int obtenerId(String texto) {
         int id=-1;
         try {
            ps=conexion.conectar().prepareStatement("SELECT"
                    + " id_empleado"
                    + " FROM "
                    + " empleados "
                    + " WHERE "
                    + "nombres=?");                   
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
                    + " nombres "
                    + " FROM empleados"
                    + " WHERE "
                    + "id_empleado=?");                   
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
    public boolean agregar(Empleado obj) {
     int r = 0;
        try {
            ps = conexion.conectar().prepareStatement(""
                    + "INSERT INTO "
                    + "empleados("
                    + " nombres,"
                    + " apellido_parterno,"
                    + " apellido_materno, "
                    + " dni,"
                    + " numero_telefono, "
                    + " id_usuario,"
                    + " sexo"
                    + ") values(?,?,?,?,?,?,?)");
            ps.setString(1, obj.getNombres());
            ps.setString(2, obj.getApellidoParterno());
            ps.setString(3, obj.getApellidoMaterno());
            ps.setString(4, obj.getDni());
            ps.setString(5, obj.getNumeroTelefono());
            ps.setInt(6, obj.getIdUsuario());
            ps.setString(7, obj.getSexo());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(Empleado obj) {
       int r = 0;
    try {
        ps = conexion.conectar().prepareStatement("UPDATE Empleados SET"
                + " nombres=?,"
                + " apellido_parterno=?, "
                + " apellido_materno=?,"
                + " dni=?, "
                + " numero_telefono=?, "
                + " id_usuario=?, "
                + " sexo=?"
                + " WHERE id_empleado=?");
           ps.setString(1, obj.getNombres());
            ps.setString(2, obj.getApellidoParterno());
            ps.setString(3, obj.getApellidoMaterno());
            ps.setString(4, obj.getDni());
            ps.setString(5, obj.getNumeroTelefono());
            ps.setInt(6, obj.getIdUsuario());
            ps.setString(7, obj.getSexo());
            ps.setInt(8, obj.getIdEmpleado());
        r = ps.executeUpdate();
        return r == 1;
    } catch (SQLException ex) {
        return false;
    } finally {
        conexion.desconectar();
    }
    }

    @Override
    public boolean eliminar(Empleado obj) {
        int r=0;
        try {
        ps=conexion.conectar().prepareStatement(""
                + " DELETE FROM"
                + " empleados "
                + " WHERE "
                + " id_empleado=?");
        ps.setInt(1, obj.getIdEmpleado());
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
    public List<Empleado> listar() {
              List<Empleado>lista = new ArrayList<>();
         try {
            ps=conexion.conectar().prepareStatement(""
                    + " SELECT *"
                    + " FROM "
                    + " empleados");                   
            rs=ps.executeQuery();
            while (rs.next())                     
                lista.add(new Empleado(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8)
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
      public List<Empleado> listar(Empleado obj) {
     List<Empleado>lista = new ArrayList<>();   
     boolean encontrado=false;
         try {
            if(obj.getIdEmpleado()!=0) {
                ps=conexion.conectar().prepareStatement(""
                        + " SELECT *"
                        + " FROM "
                        + " empleados "
                        + " WHERE"
                        + " id_empleado=?");                   
                ps.setInt(1,obj.getIdEmpleado());
            }
            else
            {
              ps=conexion.conectar().prepareStatement(""
                      + " SELECT * "
                      + " FROM "
                      + " empleados "
                      + " WHERE nombres"
                      + " LIKE ?");                   
              ps.setString(1,"%"+obj.getNombres()+"%");
            }
            obj=null;
            rs=ps.executeQuery();
            while(rs.next())                             
               lista.add(new Empleado(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8)
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
