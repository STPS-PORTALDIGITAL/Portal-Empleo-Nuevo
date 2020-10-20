package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Oficina;
import java.util.List;


@Repository
public interface OficinaRepository extends CrudRepository<Oficina, Long> {
	List<Oficina> findById(Integer id);
	
	@Query("select c from Oficina c where c.estatus = ?1")
    List<Oficina> findAllRecords(Integer estatus);
}

