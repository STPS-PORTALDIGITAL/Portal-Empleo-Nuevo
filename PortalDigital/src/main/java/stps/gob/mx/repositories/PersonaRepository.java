package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Persona;
import java.util.List;


@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {
	List<Persona> findById(Integer id);
	
	@Query("select c from Persona c where c.estatus = ?1")
    List<Persona> findAllRecords(Integer estatus);
}

