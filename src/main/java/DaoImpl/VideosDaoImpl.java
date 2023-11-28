package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.VideosDao;
import Model.Videos;

public class VideosDaoImpl implements VideosDao {
	private PreparedStatement statement = null;
    private Connection conexion;
    private ResultSet resultSet;
    
    public VideosDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
	@Override
	public List<Videos> obtenerVideos(int idEmpresa) {
	    List<Videos> listaVideos = new ArrayList<>();

	    try {
	        String consulta = "SELECT * FROM videos WHERE empresa_id = ?";
	        statement = conexion.prepareStatement(consulta);	    
	        statement.setInt(1, idEmpresa);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            Videos videos = new Videos();
	            videos.setId(resultSet.getInt("id"));
	            videos.setNombre(resultSet.getString("nombre"));
	            videos.setDescripcion(resultSet.getString("descripcion"));
	            videos.setUrl(resultSet.getString("url_archivo"));
	            videos.setIdEmpresa(resultSet.getInt("empresa_id"));

	            listaVideos.add(videos);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return listaVideos;
	}

}
