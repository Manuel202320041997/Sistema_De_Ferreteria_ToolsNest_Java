package Controller;

import java.util.Collections;
import java.util.List;

import Dao.VideosDao;
import DaoImpl.VideosDaoImpl;
import Model.Videos;

public class VideosController {
	private VideosDao videosdao = null;
	
	public VideosController() {
		videosdao = new VideosDaoImpl();
	}
	
	public List<Videos> obtenerVideos(int idEmpresa) {
	    try {
	        List<Videos> listaVideos = videosdao.obtenerVideos(idEmpresa);

	        if (!listaVideos.isEmpty()) {
	            return listaVideos;
	        } else {
	            System.err.println("VIDEOS NO ENCONTRADOS");
	            return Collections.emptyList(); // o puedes devolver null si prefieres
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        return Collections.emptyList(); // o puedes devolver null si prefieres
	    }
	}
}
