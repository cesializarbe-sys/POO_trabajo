package vallegrade.edu.pe.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3307/bd_restaurante";
    private static final String USER = "root";
    private static final String PASS = "12345678";

    public static Connection getConexion() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Conexión exitosa a la BD Restaurante");
        } catch (Exception e) {
            System.out.println("❌ Error en la conexión: " + e.getMessage());
        }
        return con;
    }
}