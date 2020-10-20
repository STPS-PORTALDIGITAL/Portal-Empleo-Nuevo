package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.CitaAtencion;
import java.util.List;


@Repository
public interface CitaAtencionRepository extends CrudRepository<CitaAtencion, Long> {
	List<CitaAtencion> findById(Integer id);
	
	@Query("select c from CitaAtencion c where c.estatus = ?1")
    List<CitaAtencion> findAllRecords(Integer estatus);
}

