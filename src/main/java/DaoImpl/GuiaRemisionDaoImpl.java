package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.Guia_RemisionDao;
import Model.Guia_Ingreso;
import Model.Guia_Remision;

public class GuiaRemisionDaoImpl implements Guia_RemisionDao {
    private PreparedStatement statement = null;
    private Connection conexion;

    public GuiaRemisionDaoImpl() {
        this.conexion = Conexion.obtenerConexion();
    }

    @Override
    public List<Guia_Remision> listarGuiaRemision() {
        List<Guia_Remision> listarGuiaRemision = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            String consulta = "SELECT * FROM guia_remision";
            statement = conexion.prepareStatement(consulta);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idguia = resultSet.getInt("id_guia");
                String partida = resultSet.getString("punto_partida");
                String llegada = resultSet.getString("punto_llegada");
                int idTransportista = resultSet.getInt("id_transportista");
                String fechaRegistro = resultSet.getString("fecha_registro");

                Guia_Remision guiaremision = new Guia_Remision();
                guiaremision.setId(id);
                guiaremision.setId_guia(idguia);
                guiaremision.setPunto_partida(partida);
                guiaremision.setPunto_llegada(llegada);
                guiaremision.setId_transportista(idTransportista);
                guiaremision.setFecha_registro(fechaRegistro);

                listarGuiaRemision.add(guiaremision);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(resultSet);
        }
        return listarGuiaRemision;
    }

    @Override
    public List<Guia_Remision> listarGuiaRemisionPorIdGuia(int idGuiaRemision) {
        // TODO: Implementar lógica para listar guías de remisión por ID de guía.
        return null;
    }

    @Override
    public void agregarGuiaRemision(Guia_Remision guiaRemision) {
    	try (PreparedStatement statement = conexion.prepareStatement(
                "INSERT INTO guia_remision (id_guia, punto_partida, punto_llegada, id_transportista) VALUES (?, ?, ?, ?)"
        )) {
            statement.setInt(1, guiaRemision.getId_guia());
            statement.setString(2, guiaRemision.getPunto_partida());
            statement.setString(3, guiaRemision.getPunto_llegada());
            statement.setInt(4, guiaRemision.getId_transportista());

            System.out.println("Query: " + statement.toString());

            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Inserción exitosa. Filas afectadas: " + filasAfectadas);
            } else {
                System.out.println("No se pudo insertar la guía de remisión. Verifica los datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para cerrar la declaración y el conjunto de resultados
    private void cerrarRecursos(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
