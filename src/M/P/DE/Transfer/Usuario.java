/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M.P.DE.Transfer;

/**
 *
 * @author Hector
 */
public class Usuario {
    private int idUsuario;
    private String usuario;
    private String clave;
     private String cargo;
    public  Usuario(){
        
    } 

    public Usuario(int idUsuario, String usuario, String clave, String cargo) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
        this.cargo = cargo;
    }

    public Usuario(String usuario, String clave, String cargo) {
        this.usuario = usuario;
        this.clave = clave;
        this.cargo = cargo;
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String usuario) {
        this.usuario = usuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
