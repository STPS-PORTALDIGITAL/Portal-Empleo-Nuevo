package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.OfertaTipoDiscapacidad;
import java.util.List;


@Repository
public interface OfertaTipoDiscapacidadRepository extends CrudRepository<OfertaTipoDiscapacidad, Long> {
	List<OfertaTipoDiscapacidad> findById(Integer id);
	
	@Query("select c from OfertaTipoDiscapacidad c where c.estatus = ?1")
    List<OfertaTipoDiscapacidad> findAllRecords(Integer estatus);
}

