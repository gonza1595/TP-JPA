package Main.repositorios;

import Main.entidades.Rubro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository extends CrudRepository<Rubro,String> {
}
