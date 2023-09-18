package Main.repositorios;

import Main.entidades.Domicilio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends CrudRepository<Domicilio,Long> {
}
