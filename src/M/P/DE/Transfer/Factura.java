/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M.P.DE.Transfer;

/**
 *
 * @author Héctor
 */
public class Factura {

    private int idFactura;
    private String fechaFactura;
    private int idCliente;
    private float totalFactura;
    private String estado;
    private int idMetodo;
    private float descuento;
    private float impuestos;
    private int idVenta;

    public Factura(int idFactura, String fechaFactura, int idCliente, float totalFactura, String estado, int idMetodo, float descuento, float impuestos, int idVenta) {
        this.idFactura = idFactura;
        this.fechaFactura = fechaFactura;
        this.idCliente = idCliente;
        this.totalFactura = totalFactura;
        this.estado = estado;
        this.idMetodo = idMetodo;
        this.descuento = descuento;
        this.impuestos = impuestos;
        this.idVenta = idVenta;
    }

    public Factura(String fechaFactura, int idCliente, float totalFactura, String estado, int idMetodo, float descuento, float impuestos, int idVenta) {
        this.fechaFactura = fechaFactura;
        this.idCliente = idCliente;
        this.totalFactura = totalFactura;
        this.estado = estado;
        this.idMetodo = idMetodo;
        this.descuento = descuento;
        this.impuestos = impuestos;
        this.idVenta = idVenta;
    }

    public Factura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public float getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(float totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(int idMetodo) {
        this.idMetodo = idMetodo;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(float impuestos) {
        this.impuestos = impuestos;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }


}