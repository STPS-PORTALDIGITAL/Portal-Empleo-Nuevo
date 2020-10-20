package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Empleador;
import java.util.List;


@Repository
public interface EmpleadorRepository extends CrudRepository<Empleador, Long> {
	List<Empleador> findById(Integer id);
	
	@Query("select c from Empleador c where c.estatus = ?1")
    List<Empleador> findAllRecords(Integer estatus);
}

