package Main.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Table(name="Domicilio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String calle;
    private String localidad;

    public Domicilio(String numero, String calle, String localidad) {
        this.numero = numero;
        this.calle = calle;
        this.localidad = localidad;
    }
}
