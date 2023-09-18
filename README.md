# TP.JPA
Utilizando java en el framework Spring boot con el gestor de dependencias Gradle, con JPA y mediente 
una base de datos embebida h2 se implemento un diagrama de clases de un sistema de pedidos y facturacion 
compuesta con las siguientes clases y atributos:
CLASE Cliente
Atributos: nombre,apellido,telefono,email
CLASE Pedido
Atributo: estado,fecha,tipoEnvio,total
CLASE Domicilio
Atributo:calle,numero,localidad
CLASE Factura
Atributo:numero,fecha,descuento,formaPago,total
CLASE DetallePedido
Atributo:cantidad,subtotal
CLASE Producto
Atributo:tipo,tiempo,denominacion,precioVenta,precioCompra,stockActual,stockMinimo,unidadaMedida,receta
CLASE Rubro
Atributo:denominacion

RELACIONES: Cliente 1 a N con Pedido
            Cliente 1 a N con Domicilio
            Pedido 1 a N con Factura
            Pedido 1 a N con DetallePedido
            DetallePedido N a 1 con Producto
            Rubro 1 a N con Producto
Con JPA se persistieron todas las clases en la db embebida, creando las tablas y sus relaciones sin utilizar SQL,
a su vez en el main se crearon distintos clientes,pedidos,rubros y productos, guardandolos en la bd para asi poder 
simular su funcionamiento para posteriormente recuperarlos mediante distintas consultas y mostrarlos por consola.
