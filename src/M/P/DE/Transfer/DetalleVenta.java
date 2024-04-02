/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M.P.DE.Transfer;

/**
 *
 * @author Héctor
 */
public class DetalleVenta {
    private int idDetalle;
    private int idProducto;
    private int idVenta;
    private float precioUnitario;
    private float subTotal;
    private int cantidad;

    public DetalleVenta(int idDetalle, int idProducto, int idVenta, float precioUnitario, float subTotal, int cantidad) {
        this.idDetalle = idDetalle;
        this.idProducto = idProducto;
        this.idVenta = idVenta;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.cantidad = cantidad;
    }

    public DetalleVenta(int idProducto, int idVenta, float precioUnitario, float subTotal, int cantidad) {
        this.idProducto = idProducto;
        this.idVenta = idVenta;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.cantidad = cantidad;
    }

    public DetalleVenta(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
  
    
}
