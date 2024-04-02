/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M.P.DE.Transfer;

/**
 *
 * @author Héctor
 */
public class MetodoPago {
    private int idMetodo;
    private String Nombre;
    public MetodoPago(){
        
    }

    public MetodoPago(int idMetodo, String Nombre) {
        this.idMetodo = idMetodo;
        this.Nombre = Nombre;
    }

    public MetodoPago(int idMetodo) {
        this.idMetodo = idMetodo;
    }

    public MetodoPago(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(int idMetodo) {
        this.idMetodo = idMetodo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
