CREATE DATABASE bd_restaurante;

USE bd_restaurante;

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
);

-- Datos de ejemplo del restaurante andino
INSERT INTO producto (nombre, precio, stock) VALUES
('Ceviche Andino', 25.00, 15),
('Pachamanca', 40.00, 10),
('Trucha Frita', 30.00, 12),
('Chicha Morada', 8.00, 50),
('Cuy al Horno', 55.00, 5);

SELECT * FROM producto;