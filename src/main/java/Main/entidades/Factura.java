package Main.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="Factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private Date fecha;
    private double descuento;
    private String formaPago;
    private int total;

    public Factura(Date fecha, double descuento, String formaPago, int total) {
        this.fecha = fecha;
        this.descuento = descuento;
        this.formaPago = formaPago;
        this.total = total;
    }
}
