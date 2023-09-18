package Main.repositorios;

import Main.entidades.DetallePedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository  extends CrudRepository<DetallePedido,Long> {
}
