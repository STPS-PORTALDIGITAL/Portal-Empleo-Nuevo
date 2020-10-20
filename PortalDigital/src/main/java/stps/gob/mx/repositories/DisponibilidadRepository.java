package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Disponibilidad;
import java.util.List;


@Repository
public interface DisponibilidadRepository extends CrudRepository<Disponibilidad, Long> {
	List<Disponibilidad> findById(Integer id);
	
	@Query("select c from Disponibilidad c where c.estatus = ?1")
    List<Disponibilidad> findAllRecords(Integer estatus);
}

