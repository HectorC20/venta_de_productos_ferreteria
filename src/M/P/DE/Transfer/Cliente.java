/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M.P.DE.Transfer;

/**
 *
 * @author Héctor
 */
public class Cliente {
    private int idCliente;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String dni;
    private String ruc;
    private String direccion;
    private String correo;
    private String telefono;
    private String sexo;
    public Cliente(){
        
    }

    public Cliente(int idCliente, String nombres, String apellidoPaterno, String apellidoMaterno, String dni, String ruc, String direccion, String correo, String telefono, String sexo) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.dni = dni;
        this.ruc = ruc;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.sexo = sexo;
    }

    public Cliente(String nombres, String apellidoPaterno, String apellidoMaterno, String dni, String ruc, String direccion, String correo, String telefono, String sexo) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.dni = dni;
        this.ruc = ruc;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.sexo = sexo;
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String nombres) {
        this.nombres = nombres;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
}
