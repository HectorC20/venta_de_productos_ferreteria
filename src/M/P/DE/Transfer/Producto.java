/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M.P.DE.Transfer;

/**
 *
 * @author Héctor
 */
public class Producto {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private float precio;
    private float costo;
    private int existencia;
    private int idCategoria;
    private float igv_iva;
    private float precio_sub;

    public Producto() {

    }

    public Producto(int idProducto, String nombre, String descripcion, float precio, float costo, int existencia, int idCategoria, float igv_iva, float precio_sub) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.costo = costo;
        this.existencia = existencia;
        this.idCategoria = idCategoria;
        this.igv_iva = igv_iva;
        this.precio_sub = precio_sub;
    }

    public Producto(String nombre, String descripcion, float precio, float costo, int existencia, int idCategoria, float igv_iva, float precio_sub) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.costo = costo;
        this.existencia = existencia;
        this.idCategoria = idCategoria;
        this.igv_iva = igv_iva;
        this.precio_sub = precio_sub;
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public float getIgv_iva() {
        return igv_iva;
    }

    public void setIgv_iva(float igv_iva) {
        this.igv_iva = igv_iva;
    }

    public float getPrecio_sub() {
        return precio_sub;
    }

    public void setPrecio_sub(float precio_sub) {
        this.precio_sub = precio_sub;
    }


}
