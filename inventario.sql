CREATE DATABASE inventario;
CREATE TABLE producto (
  `codigo` varchar(50) NOT NULL,
  `producto` varchar(50) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precioVenta` float DEFAULT NULL,
  `precioCompra` float DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  `peso` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
);

CREATE TABLE venta (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT,
  `codigoProducto` varchar(50) DEFAULT NULL,
  `fechaVenta` date DEFAULT NULL,
  `cantidadProducto` int(11) DEFAULT NULL,
  `totalVenta` float DEFAULT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `codigoProducto` (`codigoProducto`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`codigoProducto`) REFERENCES `producto` (`codigo`)
); 

CREATE TABLE corte (
  `idCorte` int(11) NOT NULL AUTO_INCREMENT,
  `fechaCorte` datetime DEFAULT NULL,
  `total` float DEFAULT NULL,
  PRIMARY KEY (`idCorte`)
);

CREATE TABLE productos_vendidos (
  `idProductoVendido` int(11) NOT NULL AUTO_INCREMENT,
  `codigoProducto` varchar(50) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precioVenta` float DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idProductoVendido`),
  KEY `codigoProducto` (`codigoProducto`),
  CONSTRAINT `productos_vendidos_ibfk_1` FOREIGN KEY (`codigoProducto`) REFERENCES `producto` (`codigo`)
); 