package Main.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {
    @Id
    private String email;
    private String nombre;
    private String apellido;
    private String telefono;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Domicilio> domicilios= new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String email, String nombre, String apellido, String telefono) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
}
