package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.TipoUsuario;
import java.util.List;


@Repository
public interface TipoUsuarioRepository extends CrudRepository<TipoUsuario, Long> {
	List<TipoUsuario> findById(Integer id);

}

