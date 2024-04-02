/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M.P.DE.Transfer;

/**
 *
 * @author Héctor
 */
public class Inventario {
    private int idProducto;
    private String codigoBarras;
    private int cantidadStock;
    private int idProveedor;
    private String fechaAdquisicion;
    private int nivelRebastecimiento;
    private String nota;
    public Inventario(){
        
    }

    public Inventario(int idProducto, String codigoBarras, int cantidadStock, int idProveedor, String fechaAdquisicion, int nivelRebastecimiento, String nota) {
        this.idProducto = idProducto;
        this.codigoBarras = codigoBarras;
        this.cantidadStock = cantidadStock;
        this.idProveedor = idProveedor;
        this.fechaAdquisicion = fechaAdquisicion;
        this.nivelRebastecimiento = nivelRebastecimiento;
        this.nota = nota;
    }

    public Inventario(int idProducto) {
        this.idProducto = idProducto;
    }

    public Inventario(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public int getNivelRebastecimiento() {
        return nivelRebastecimiento;
    }

    public void setNivelRebastecimiento(int nivelRebastecimiento) {
        this.nivelRebastecimiento = nivelRebastecimiento;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
}
