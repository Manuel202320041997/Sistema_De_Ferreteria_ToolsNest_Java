package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Conexion;
import Dao.EmpresaDao;
import Model.Empresa;

public class EmpresaDaoImpl implements EmpresaDao {

	private PreparedStatement statement = null;
    private Connection conexion;
    private ResultSet resultSet;
    
    public EmpresaDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
	
	@Override
	public Empresa obtenerEmpresa() {
		try {
			String consulta = "SELECT * FROM empresa WHERE id = 1";
		    statement = conexion.prepareStatement(consulta);		    
		    resultSet = statement.executeQuery();
			
		    if (resultSet.next()) {
		        Empresa empresa = new Empresa();
		        empresa.setId(resultSet.getInt("id"));
	            empresa.setRuc(resultSet.getString("ruc"));
	            empresa.setRazon_social(resultSet.getString("razon_social"));
	            empresa.setTelefono(resultSet.getString("telefono"));
	            empresa.setDireccion(resultSet.getString("direccion"));
	            empresa.setLogo_login(resultSet.getString("logo_login"));
	            empresa.setLogo_inicio(resultSet.getString("logo_inicio"));
		        return empresa;
			
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; // En caso de error o si no se encuentra la categoría
	}

	@Override
	public void editarEmpresa(Empresa empresa) {
		try {
			String consulta = "UPDATE empresa SET razon_social = ?, telefono = ?, direccion = ? WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			
			statement.setString(1, empresa.getRazon_social());
			statement.setString(2, empresa.getTelefono());
			statement.setString(3, empresa.getDireccion());			
			statement.setInt(4, empresa.getId());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void cambiarLogoInicio(int idEmpresa, String rutaLogo) {
	    actualizarLogo(idEmpresa, rutaLogo, "logo_inicio");
	}

	@Override
	public void cambiarLogoLogin(int idEmpresa, String rutaLogo) {
	    actualizarLogo(idEmpresa, rutaLogo, "logo_login");
	}

	private void actualizarLogo(int idEmpresa, String rutaLogo, String columnaLogo) {
	    try {
	        String consulta = "UPDATE empresa SET " + columnaLogo + " = ? WHERE id = ?";
	        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
	            statement.setString(1, rutaLogo);
	            statement.setInt(2, idEmpresa);

	            statement.executeUpdate();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
