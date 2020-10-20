package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Ubicacion;
import java.util.List;


@Repository
public interface UbicacionRepository extends CrudRepository<Ubicacion, Long> {
	List<Ubicacion> findById(Integer id);
	
	@Query("select c from Ubicacion c where c.estatus = ?1")
    List<Ubicacion> findAllRecords(Integer estatus);
}

