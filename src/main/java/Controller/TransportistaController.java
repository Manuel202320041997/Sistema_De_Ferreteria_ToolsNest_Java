package Controller;

import Dao.TransportistaDao;
import DaoImpl.TransportistaDaoImpl;
import Model.Transportista;
import java.util.List;

public class TransportistaController {
	private TransportistaDao transportistadao = null;
	
	public TransportistaController() {
		transportistadao = new TransportistaDaoImpl();
	}
	
	public List<Transportista> listarTransportista(){
		List<Transportista> listaTransportista = null;
		listaTransportista = transportistadao.listarTransportista();
		return listaTransportista;
	}
	
	public Transportista obtenerTransportistaPorNombre(String nombreTransportista) {
        // Llama directamente al método del DAO
        return transportistadao.obtenerTransportistaPorNombre(nombreTransportista);
    }

    public Transportista obtenerTransportistaPorId(int idTransportista) {
        // Llama directamente al método del DAO
        return transportistadao.obtenerTransportistaPorId(idTransportista);
    }
	
	public void registrarTransportista(Transportista transportista) {
		transportistadao.registrarTransportista(transportista);
	}
}
