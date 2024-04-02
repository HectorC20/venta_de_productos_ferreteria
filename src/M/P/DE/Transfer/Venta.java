/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M.P.DE.Transfer;

/**
 *
 * @author Héctor
 */
public class Venta {
    private int idVenta;
    private String fecha;
    private double total;
    private int idCliente;
    private int idEmpleado;

    public Venta(int idVenta, String fecha, double total, int idCliente, int idEmpleado) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
    }

    public Venta(String fecha, double total, int idCliente, int idEmpleado) {
        this.fecha = fecha;
        this.total = total;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
    }

    public Venta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
}
