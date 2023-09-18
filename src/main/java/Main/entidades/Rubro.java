package Main.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Rubro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rubro {
    @Id
    private String denominacion;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Producto> productos = new ArrayList<>();

    public Rubro(String denominacion) {
        this.denominacion = denominacion;
    }
}
