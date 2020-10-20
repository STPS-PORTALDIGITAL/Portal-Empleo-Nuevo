package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Ciudad;
import java.util.List;


@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Long> {
	List<Ciudad> findById(Integer id);
	
	@Query("select c from Ciudad c where c.estatus = ?1")
    List<Ciudad> findAllRecords(Integer estatus);
}

