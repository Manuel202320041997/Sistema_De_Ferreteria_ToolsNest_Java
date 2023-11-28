package Dao;

import java.util.List;

import Model.Videos;

public interface VideosDao {
	
	List<Videos> obtenerVideos(int idEmpresa);
	
}
