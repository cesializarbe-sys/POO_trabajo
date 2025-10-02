package vallegrade.edu.pe.model;

import vallegrade.edu.pe.database.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private static final String SQL_SELECT = "SELECT id, nombre, precio, stock FROM producto";

    // Listar todos los productos (platos)
    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_SELECT);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto p = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error en listar(): " + e.getMessage());
        }
        return lista;
    }
}