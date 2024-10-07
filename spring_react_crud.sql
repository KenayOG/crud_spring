CREATE DATABASE spring_react_crud;

USE spring_react_crud;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    edad INT,
    domicilio VARCHAR(100)
);

-- Precargar algunos registros
INSERT INTO usuario (nombre, apellido, edad, domicilio)
VALUES 
('Juan', 'Pérez', 28, 'Calle 1, Ciudad A'),
('Ana', 'Gómez', 35, 'Calle 2, Ciudad B'),
('Luis', 'Martínez', 22, 'Calle 3, Ciudad C'),
('Sofía', 'Hernández', 30, 'Calle 4, Ciudad D');



SELECT * FROM usuario;