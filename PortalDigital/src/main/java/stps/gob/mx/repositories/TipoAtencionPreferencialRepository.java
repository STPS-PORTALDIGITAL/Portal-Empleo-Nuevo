package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.TipoAtencionPreferencial;
import java.util.List;


@Repository
public interface TipoAtencionPreferencialRepository extends CrudRepository<TipoAtencionPreferencial, Long> {
	List<TipoAtencionPreferencial> findById(Integer id);
	
	@Query("select c from TipoAtencionPreferencial c where c.estatus = ?1")
    List<TipoAtencionPreferencial> findAllRecords(Integer estatus);
}

