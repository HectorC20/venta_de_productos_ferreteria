package M.P.DE.Source;
import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {                        //Servidor        ||       ||Ref. puerto||Nombre base de datos   ||  Certificación del servidor      *//
    private final String URL = "jdbc:sqlserver://HECTORC\\SQL2022\\SQL2022\\SQL2022:1433;databaseName=EnaCristina;trustServerCertificate=true";
    private final String USER = "sa";
    private final String PASSWORD = "12345";
    public static Conexion instancia;
    public Connection conexion;

    public Conexion() {
    }

    public Connection conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            return conexion;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
            return null;
        }
    }

    public void desconectar() {
        try {
            this.conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public synchronized static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

}
