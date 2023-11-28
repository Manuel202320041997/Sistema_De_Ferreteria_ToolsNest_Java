package Dao;

import java.util.List;

import Model.Transportista;

public interface TransportistaDao {
	
	public List<Transportista> listarTransportista();
	
	public Transportista obtenerTransportistaPorNombre(String nombreTransportista);
	
	public Transportista obtenerTransportistaPorId(int idTransportista);
	
	public void registrarTransportista(Transportista transportista);
}
