package Main;

import Main.entidades.*;
import Main.repositorios.ClienteRepository;
import Main.repositorios.RubroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication (scanBasePackages = {"Main"})
public class Tp1JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp1JpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ClienteRepository Clienterepository, RubroRepository rubroRepository) {
        return (args) -> {
            //Se crean 3 clientes
            Cliente Cliente1 = new Cliente("Dalia@gmail.com", "Dalia", "Abo Sheasha", "123456789");
            Cliente Cliente2 = new Cliente("Gee@gmail.com", "Trisha", "Gee", "123456789");
            Cliente Cliente3 = new Cliente("Helen@gmail.com", "Helen", "Scott", "123456789");

            //Se crean domicilios se asocian a los cliente
            Domicilio Domicilio1 = new Domicilio("234","Belgrano","Ciudad");
            Domicilio Domicilio2 = new Domicilio("324","Colon","Ciudad");
            Domicilio Domicilio3 = new Domicilio("275","Libertad","Guaymallen");
            Domicilio Domicilio4 = new Domicilio("435","Godoy Cruz","Cuidad");
            //El cliente 3 tiene 2 domicilios asociados
            Cliente1.getDomicilios().add(Domicilio1);
            Cliente2.getDomicilios().add(Domicilio2);
            Cliente3.getDomicilios().add(Domicilio3);
            Cliente3.getDomicilios().add(Domicilio4);

            //Se crean pedidos y los asocia a los cliente
            Date fechaActual = new Date();

            Pedido Pedido1 = new Pedido("iniciado", fechaActual, "delivery", 100.00);
            Pedido Pedido2 = new Pedido("iniciado", fechaActual, "delivery", 500.00);
            Pedido Pedido3 = new Pedido("iniciado", fechaActual, "retira", 357.00);

            Cliente1.getPedidos().add(Pedido1);
            Cliente2.getPedidos().add(Pedido2);
            Cliente3.getPedidos().add(Pedido3);

            //Se crean facturas y se asocian a los pedidos
            Factura Factura1 = new Factura(fechaActual,50.00,"efectivo",150);
            Factura Factura2 = new Factura(fechaActual,40.00,"efectivo",100);
            Factura Factura3 = new Factura(fechaActual,50.00,"efectivo",435);

            Pedido1.setFactura(Factura1);
            Pedido2.setFactura(Factura2);
            Pedido3.setFactura(Factura3);

            //Se crean detalles de pedidos y se asocian al pedido
            DetallePedido DetelleP1 = new DetallePedido(5,20.00);
            DetallePedido DetelleP2 = new DetallePedido(7,15.00);
            DetallePedido DetelleP3 = new DetallePedido(1,5.00);
            DetallePedido DetelleP4 = new DetallePedido(2,10.00);
            //El Pedido3 tiene 2 detallesPedido

            Pedido1.getDetallesPedido().add(DetelleP1);
            Pedido2.getDetallesPedido().add(DetelleP2);
            Pedido3.getDetallesPedido().add(DetelleP3);
            Pedido3.getDetallesPedido().add(DetelleP4);

            //Se crean rubros y productos y se asocian
            Rubro Rubro1 = new Rubro("Comida Vegetariana");
            Rubro Rubro2 = new Rubro("Desayuno");
            Rubro Rubro3 = new Rubro("Postres");

            Producto producto1 = new Producto("insumo",15,"ensalada",400,325,5,2,"g","receta..");
            Producto producto2 = new Producto("insumo",10,"Cafe",300,150,8,2,"ml","receta..");
            Producto producto3 = new Producto("insumo",5,"Helado",150,100,7,2,"kg","receta..");

            Rubro1.getProductos().add(producto1);
            Rubro2.getProductos().add(producto2);
            Rubro3.getProductos().add(producto3);

            rubroRepository.save(Rubro1);
            rubroRepository.save(Rubro2);
            rubroRepository.save(Rubro3);

            //Se recupera los productos y se los asocia a detallepedido

            Optional<Rubro> rubro1Recuperado = rubroRepository.findById("Comida Vegetariana");
            Optional<Rubro> rubro2Recuperado = rubroRepository.findById("Desayuno");
            Optional<Rubro> rubro3Recuperado = rubroRepository.findById("Postres");

            if (rubro1Recuperado.isPresent()){
                Producto producto1Recuperado = rubro1Recuperado.get().getProductos().get(0);
                DetelleP1.setProducto(producto1Recuperado);
            }
            if (rubro2Recuperado.isPresent()){
                Producto producto2Recuperado = rubro2Recuperado.get().getProductos().get(0);
                DetelleP2.setProducto(producto2Recuperado);
            }
            if (rubro3Recuperado.isPresent()){
                Producto producto3Recuperado = rubro3Recuperado.get().getProductos().get(0);
                DetelleP3.setProducto(producto3Recuperado);
            }
            if (rubro3Recuperado.isPresent()){
                Producto producto4Recuperado = rubro1Recuperado.get().getProductos().get(0);
                DetelleP4.setProducto(producto4Recuperado);
            }

            Clienterepository.save(Cliente1);
            Clienterepository.save(Cliente2);
            Clienterepository.save(Cliente3);

            //Se recuperan los clientes registrados
            System.out.println("Clientes Registrados: ");
            for (Cliente cliente: Clienterepository.findAll()) {
                System.out.println("Nombre: "+cliente.getNombre()+" "+"Apellido: "+cliente.getApellido());
            }

            //Se recuperan los pedidos del cliente 1
            System.out.println("Datos de los pedidos del cliente 1");
            Optional<Cliente> cliente = Clienterepository.findById("Dalia@gmail.com");
            if (cliente.isPresent()){
                System.out.println(cliente.get().getPedidos());
            }

            //Se actualizan los datos del cliente 1
            if (cliente.isPresent()){
                System.out.println("Telefono Antiguo:"+cliente.get().getTelefono());
                cliente.get().setTelefono("261246375");
                System.out.println("Telefono Actual:"+cliente.get().getTelefono());
            }
        };
    }
}


