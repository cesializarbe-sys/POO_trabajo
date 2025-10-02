package vallegrade.edu.pe.view;

import vallegrade.edu.pe.controller.ProductoController;
import vallegrade.edu.pe.model.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FrmProducto extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    private ProductoController controller;

    public FrmProducto() {
        setTitle("🍲 Restaurante Andino - Gestión de Platos");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new String[]{"ID", "Plato", "Precio (S/)", "Stock"}, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Botón Actualizar
        JButton btnActualizar = new JButton("🔄 Actualizar");
        btnActualizar.addActionListener(e -> controller.cargarProductos());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnActualizar);
        add(panelBotones, BorderLayout.SOUTH);

        // Iniciar controlador
        controller = new ProductoController(this);
    }

    public void mostrarProductos(List<Producto> lista) {
        modelo.setRowCount(0); // limpiar la tabla
        for (Producto p : lista) {
            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNombre(),
                    p.getPrecio(),
                    p.getStock()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmProducto().setVisible(true));
    }
}