-- Creación de la base de datos
DROP DATABASE IF EXISTS dbsistemaferreteria;
CREATE DATABASE dbsistemaferreteria;
USE dbsistemaferreteria;

-- Creación de las tablas

CREATE TABLE usuario(
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni_empleado INT,
    nombre VARCHAR(50),
    clave VARCHAR(100),
    rol INT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (dni_empleado) REFERENCES empleado(dni),
    FOREIGN KEY (rol) REFERENCES rol(id)
);

DELETE FROM usuario WHERE id = 1;

CREATE TABLE rol(
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1  -- Nuevo campo
);

CREATE TABLE empleado(
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni INT UNIQUE,
    nombres VARCHAR(100),
    correo VARCHAR(70) UNIQUE,
    direccion VARCHAR(150),
    id_cargo INT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (id_cargo) REFERENCES cargo(id)
);

CREATE TABLE cargo(
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50) UNIQUE,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1  -- Nuevo campo
);

CREATE TABLE contrato(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_empleado INT,
    horas_trabajadas DECIMAL(10,2),
    sueldo_mensual DECIMAL(10,2),
    gratificacion DECIMAL(10,2),
    liquidacion DECIMAL(10,2),
    cts DECIMAL(10,2),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (id_empleado) REFERENCES empleado(id)
);
ALTER TABLE contrato DROP COLUMN liquidacion;
ALTER TABLE contrato DROP COLUMN horas_trabajadas;

CREATE TABLE cliente(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(100),
    telefono VARCHAR(9),
    direccion VARCHAR(100),
    correo VARCHAR(70),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1  -- Nuevo campo
);
ALTER TABLE cliente ADD COLUMN dni INT UNIQUE;

CREATE TABLE proveedor(
    id INT AUTO_INCREMENT PRIMARY KEY,
    razon_social VARCHAR(100),
    telefono VARCHAR(9),
    direccion VARCHAR(100),
    correo VARCHAR(70),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1  -- Nuevo campo
);

CREATE TABLE marca(
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50),
    estado BIT DEFAULT 1  -- Nuevo campo
);

CREATE TABLE categoria(
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1  -- Nuevo campo
);

CREATE TABLE subcategoria(
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50),
    id_categoria INT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (id_categoria) REFERENCES categoria(id)
);

CREATE TABLE producto(
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100),
    id_marca INT,
    precio_compra DECIMAL(10,2),
    precio_venta DECIMAL(10,2),
    stock INT,
    id_subcategoria INT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (id_marca) REFERENCES marca(id),
    FOREIGN KEY (id_subcategoria) REFERENCES subcategoria(id)
);

CREATE TABLE modo_pago(
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1  -- Nuevo campo
);

CREATE TABLE compra(
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero_compra VARCHAR(50),
    id_proveedor INT,
    total DECIMAL(10,2),	
    id_modo_pago INT,
    id_empleado INT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id),
    FOREIGN KEY (id_modo_pago) REFERENCES modo_pago(id),
    FOREIGN KEY (id_empleado) REFERENCES empleado(id)
);

CREATE TABLE detalle_compra(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_compra INT,
    id_producto INT,
    cantidad INT,
    precio_compra DECIMAL(10,2),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (id_compra) REFERENCES compra(id),
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE TABLE venta(
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero_venta VARCHAR(50),
    id_cliente INT,
    total DECIMAL(10,2),
    id_modo_pago INT,
    id_empleado INT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY (id_modo_pago) REFERENCES modo_pago(id),
    FOREIGN KEY (id_empleado) REFERENCES empleado(id)
);

CREATE TABLE detalle_venta(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT,
    id_producto INT,
    cantidad INT,
    precio_venta DECIMAL(10,2),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (id_venta) REFERENCES venta(id),
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE TABLE transportista(
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni INT,
    nombres VARCHAR(70),
    placa_vehiculo VARCHAR(6),
    modelo_vehiculo VARCHAR(60),
    brevete VARCHAR(9),
    estado BIT DEFAULT 1  -- Nuevo campo
);

CREATE TABLE guia(
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero_guia VARCHAR(50),
    id_empleado INT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (id_empleado) REFERENCES empleado(id)
);
ALTER TABLE guia ADD COLUMN motivo VARCHAR(255);

CREATE TABLE guia_detalle(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_guia INT,
    id_producto INT,
    cantidad INT,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (id_guia) REFERENCES guia(id),
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE TABLE guia_ingresos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_guia INT,
    id_proveedor INT,
    id_transportista INT,
    observacion VARCHAR(255),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (id_guia) REFERENCES guia(id),
    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id),
    FOREIGN KEY (id_transportista) REFERENCES transportista(id)
);

CREATE TABLE guia_remision(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_guia INT,
    punto_partida VARCHAR(150),
    punto_llegada VARCHAR(150),
    id_transportista INT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (id_guia) REFERENCES guia(id),
    FOREIGN KEY (id_transportista) REFERENCES transportista(id)
);

CREATE TABLE guia_salidas(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_guia INT,
    motivo VARCHAR(255),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BIT DEFAULT 1,  -- Nuevo campo
    FOREIGN KEY (id_guia) REFERENCES guia(id)
);
ALTER TABLE guia_salidas DROP COLUMN motivo;
ALTER TABLE guia_salidas ADD COLUMN destinatario VARCHAR(50);

CREATE TABLE empresa(
	id INT AUTO_INCREMENT PRIMARY KEY,
    ruc VARCHAR(11),
    razon_social VARCHAR(50),
    telefono VARCHAR(9),
    direccion VARCHAR(70),
    logo_login VARCHAR(255),
    logo_inicio VARCHAR(255)
);

CREATE TABLE videos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT,
    url_archivo VARCHAR(255) NOT NULL, -- Puedes cambiar el tipo de dato según tus necesidades
    fecha_subida TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    empresa_id INT,
    FOREIGN KEY (empresa_id) REFERENCES empresa(id)
);