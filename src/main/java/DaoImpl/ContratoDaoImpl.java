package DaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.ContratoDao;
import DaoImpl.ContratoDaoImpl;
import Model.Contrato;
import Model.Empleado;

public class ContratoDaoImpl implements ContratoDao {
	private PreparedStatement statement = null;
    private Connection conexion;
    public ContratoDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
	@Override
	public List<Contrato> listarContratos() {		
	    List<Contrato> listaContrato = new ArrayList<>();

	    try {
	        String consulta = "SELECT * FROM contrato";
	        statement = conexion.prepareStatement(consulta);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            int id_empleado = resultSet.getInt("id_empleado");
	            double sueldo_mensual = resultSet.getDouble("sueldo_mensual");
	            double gratificacion = resultSet.getDouble("gratificacion");
	            double cts = resultSet.getDouble("cts");
	            String fecha_registro = resultSet.getString("fecha_registro");

	            // Imprimir datos antes de agregar a la lista
	            System.out.println("ID Empleado (antes de agregar): " + id_empleado);
	            // Agrega más líneas según los campos que quieras imprimir

	            Contrato contrato = new Contrato();
	            contrato.setId(id);
	            contrato.setId_empleado(id_empleado);
	            contrato.setSueldo_mensual(sueldo_mensual);
	            contrato.setGratificacion(gratificacion);
	            contrato.setCts(cts);
	            contrato.setFecha_registro(fecha_registro);

	            listaContrato.add(contrato);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Imprimir datos antes de devolver la lista
	    for (Contrato contrato : listaContrato) {
	        System.out.println("ID Empleado (antes de devolver): " + contrato.getId_empleado());
	        // Agrega más líneas según los campos que quieras imprimir
	    }

	    return listaContrato;
	    }
	
	@Override
	public void agregaPlanilla(Contrato contrato) {
		try {
			String consulta = "INSERT INTO contrato (id_empleado, sueldo_mensual, gratificacion, cts) VALUES (?, ?, ?, ?)";
			statement = conexion.prepareStatement(consulta);
	        
	        statement.setInt(1,  contrato.getId_empleado());
	        statement.setDouble(2, contrato.getSueldo_mensual());	
	        statement.setDouble(3, contrato.getGratificacion());
	        statement.setDouble(4, contrato.getCts());
	        
	        statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Contrato obtenerContratoPorIdEmpleado(int idEmpleado) {
		try {
			String consulta = "SELECT * FROM contrato WHERE id_empleado = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, idEmpleado);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				Contrato contrato = new Contrato();
				
				contrato.setId(resultSet.getInt("id"));
				contrato.setId_empleado(resultSet.getInt("id_empleado"));
				contrato.setSueldo_mensual(resultSet.getDouble("sueldo_mensual"));
				contrato.setGratificacion(resultSet.getDouble("gratificacion"));
				contrato.setCts(resultSet.getDouble("cts"));
				
				return contrato;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void actualizarSueldo(Contrato contrato) {
		try {
			String consulta = "UPDATE contrato SET sueldo_mensual = ?, gratificacion = ?, cts = ? WHERE id_empleado = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setDouble(1, contrato.getSueldo_mensual());
			statement.setDouble(2, contrato.getGratificacion());
			statement.setDouble(3, contrato.getCts());
			statement.setInt(4, contrato.getId_empleado());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
