package M.P.DE.Dao;

import java.util.List;

public interface IDaoGenerico<T> {

	public boolean agregar(T obj);
	public boolean actualizar(T obj);
	public boolean eliminar(T obj);
	public List<T> listar();
	public List<T> listar(T obj);

}