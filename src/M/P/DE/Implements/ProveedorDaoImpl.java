package M.P.DE.Implements;

import M.P.DE.Dao.IDaoExtendido;
import M.P.DE.Source.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import M.P.DE.Transfer.Proveedor;

public class ProveedorDaoImpl implements IDaoExtendido<Proveedor>{
    private final Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    public ProveedorDaoImpl() {
        this.conexion = Conexion.getInstancia();
    }    
    @Override
    public int obtenerId(String texto) {
         int id=-1;
         try {
            ps=conexion.conectar().prepareStatement("select id_proveedor from proveedores where nombre_compania=?");                   
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
                    + "nombre_compania "
                    + "FROM "
                    + "proveedores "
                    + "WHERE "
                    + "id_proveedor=?");                   
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
    public boolean agregar(Proveedor obj) {
     int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("INSERT INTO proveedores("
                    + " nombre_compania,"
                    + " nombre_contacto,"
                    + " cargo_contacto, "
                    + " direccion,"
                    + " ciudad, "
                    + " region,"
                    + " codigo_postal,"
                    + " pais,"
                    + " telefono,"
                    + " fax,"
                    + " pagina_principal"
                    + ") values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, obj.getNombreCompania());
            ps.setString(2, obj.getNombreContacto());
            ps.setString(3, obj.getCargoContacto());
            ps.setString(4, obj.getDireccion());
            ps.setString(5, obj.getCiudad());
            ps.setString(6, obj.getRegion());
            ps.setString(7, obj.getCodPostal());
            ps.setString(8, obj.getPais());
            ps.setString(9, obj.getTelefono());
            ps.setString(10, obj.getFax());
            ps.setString(11, obj.getPaginaPrincipal());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(Proveedor obj) {
       int r = 0;
    try {
        ps = conexion.conectar().prepareStatement("UPDATE proveedores SET"
                + " nombre_compania=?,"
                + " nombre_contacto=?, "
                + " cargo_contacto=?,"
                + " direccion=?, "
                + " ciudad=?, "
                + " region=?,"
                + " codigo_postal=?,"
                + " pais=?,"
                + " telefono=?,"
                + " fax=?,"
                + " pagina_principal=?"
                + " WHERE id_proveedor=?");
           ps.setString(1, obj.getNombreCompania());
            ps.setString(2, obj.getNombreContacto());
            ps.setString(3, obj.getCargoContacto());
            ps.setString(4, obj.getDireccion());
            ps.setString(5, obj.getCiudad());
            ps.setString(6, obj.getRegion());
            ps.setString(7, obj.getCodPostal());
            ps.setString(8, obj.getPais());
            ps.setString(9, obj.getTelefono());
            ps.setString(10, obj.getFax());
            ps.setString(11, obj.getPaginaPrincipal());
            ps.setInt(12, obj.getIdProveedor());
        r = ps.executeUpdate();
        return r == 1;
    } catch (SQLException ex) {
        return false;
    } finally {
        conexion.desconectar();
    }
    }

    @Override
    public boolean eliminar(Proveedor obj) {
        int r=0;
        try {
        ps=conexion.conectar().prepareStatement("delete from proveedores where id_proveedor=?");
        ps.setInt(1, obj.getIdProveedor());
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
    public List<Proveedor> listar() {
              List<Proveedor>lista = new ArrayList<>();
         try {
            ps=conexion.conectar().prepareStatement("select * from proveedores");                   
            rs=ps.executeQuery();
            while (rs.next())                     
                lista.add(new Proveedor(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12)));
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
      public List<Proveedor> listar(Proveedor obj) {
     List<Proveedor>lista = new ArrayList<>();   
     boolean encontrado=false;
         try {
            if(obj.getIdProveedor()!=0) {
                ps=conexion.conectar().prepareStatement("select * from proveedores where id_proveedor=?");                   
                ps.setInt(1,obj.getIdProveedor());
            }
            else
            {
              ps=conexion.conectar().prepareStatement("select * from proveedores where nombre_compania like ?");                   
              ps.setString(1,"%"+obj.getNombreCompania()+"%");
            }
            obj=null;
            rs=ps.executeQuery();
            while(rs.next())                             
               lista.add(new Proveedor(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12)));                       
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
