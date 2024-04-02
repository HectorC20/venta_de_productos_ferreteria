/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M.P.DE.Transfer;

/**
 *
 * @author Héctor
 */
public class Empleado {
        private int idEmpleado;
	private String nombres;
	private String apellidoParterno;
	private String apellidoMaterno;
	private String dni;
        private String numeroTelefono;
	private int idUsuario;
        private String sexo;
    public Empleado(){

	}

    public Empleado(int idEmpleado, String nombres, String apellidoParterno, String apellidoMaterno, String dni, String numeroTelefono, int idUsuario, String sexo) {
        this.idEmpleado = idEmpleado;
        this.nombres = nombres;
        this.apellidoParterno = apellidoParterno;
        this.apellidoMaterno = apellidoMaterno;
        this.dni = dni;
        this.numeroTelefono = numeroTelefono;
        this.idUsuario = idUsuario;
        this.sexo = sexo;
    }

    public Empleado(String nombres, String apellidoParterno, String apellidoMaterno, String dni, String numeroTelefono, int idUsuario, String sexo) {
        this.nombres = nombres;
        this.apellidoParterno = apellidoParterno;
        this.apellidoMaterno = apellidoMaterno;
        this.dni = dni;
        this.numeroTelefono = numeroTelefono;
        this.idUsuario = idUsuario;
        this.sexo = sexo;
    }

    public Empleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(String nombres) {
        this.nombres = nombres;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoParterno() {
        return apellidoParterno;
    }

    public void setApellidoParterno(String apellidoParterno) {
        this.apellidoParterno = apellidoParterno;
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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

   
 
}
