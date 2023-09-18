package Main.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Pedido")
@Data
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado;
    private Date fecha;
    private String tipoEnvio;
    private double total;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetallePedido> DetallesPedido= new ArrayList<>();

    public Pedido(String estado, Date fecha, String tipoEnvio, double total) {
        this.estado = estado;
        this.fecha = fecha;
        this.tipoEnvio = tipoEnvio;
        this.total = total;
    }

    public Pedido() {

    }
}
