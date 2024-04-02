package M.P.DE.Transfer;
public class Proveedor {
	private int idProveedor;
	private String nombreCompania;
	private String nombreContacto;
	private String cargoContacto;
	private String direccion;
	private String ciudad;
	private String region;
	private String codPostal;
	private String pais;
	private String telefono;
	private String fax;
	private String paginaPrincipal;

	public Proveedor(){

	}

    public Proveedor(int idProveedor, String nombreCompania, String nombreContacto, String cargoContacto, String direccion, String ciudad, String region, String codPostal, String pais, String telefono, String fax, String paginaPrincipal) {
        this.idProveedor = idProveedor;
        this.nombreCompania = nombreCompania;
        this.nombreContacto = nombreContacto;
        this.cargoContacto = cargoContacto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.region = region;
        this.codPostal = codPostal;
        this.pais = pais;
        this.telefono = telefono;
        this.fax = fax;
        this.paginaPrincipal = paginaPrincipal;
    }

    public Proveedor(String nombreCompania, String nombreContacto, String cargoContacto, String direccion, String ciudad, String region, String codPostal, String pais, String telefono, String fax, String paginaPrincipal) {
        this.nombreCompania = nombreCompania;
        this.nombreContacto = nombreContacto;
        this.cargoContacto = cargoContacto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.region = region;
        this.codPostal = codPostal;
        this.pais = pais;
        this.telefono = telefono;
        this.fax = fax;
        this.paginaPrincipal = paginaPrincipal;
    }

    public Proveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getCargoContacto() {
        return cargoContacto;
    }

    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPaginaPrincipal() {
        return paginaPrincipal;
    }

    public void setPaginaPrincipal(String paginaPrincipal) {
        this.paginaPrincipal = paginaPrincipal;
    }

	public void finalize() throws Throwable {

	}
}//end Proveedor