package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String url = "jdbc:mysql://localhost:3306/dbsistemaFerreteria";
    private static final String usuario = "root";
    private static final String clave = "";
    
    
    private static Connection conexion; // Cambiado a tipo Connection
    
    // Inicialización
    private Conexion() {
        try {
            // Cargar el controlador
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Importar la biblioteca
            conexion = DriverManager.getConnection(url, usuario, clave);
            
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR AL CARGAR LA CONEXIÓN");
        }
    }

    // Método público para obtener una instancia única
    public static Connection obtenerConexion() {
        if (conexion == null) {
            new Conexion(); // Crear una nueva instancia
        }
        return conexion;
    }

    // Método para cerrar la conexión
    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close(); // Cerrar la conexión
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}