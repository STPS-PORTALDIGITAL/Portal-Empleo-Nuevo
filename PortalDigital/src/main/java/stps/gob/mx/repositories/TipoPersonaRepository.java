package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.TipoPersona;
import java.util.List;


@Repository
public interface TipoPersonaRepository extends CrudRepository<TipoPersona, Long> {
	List<TipoPersona> findById(Integer id);
	
	@Query("select c from TipoPersona c where c.estatus = ?1")
    List<TipoPersona> findAllRecords(Integer estatus);
}

