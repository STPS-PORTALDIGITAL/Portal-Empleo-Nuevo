package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Colonia;
import java.util.List;


@Repository
public interface ColoniaRepository extends CrudRepository<Colonia, Long> {
	List<Colonia> findById(Integer id);
	
	@Query("select c from Colonia c where c.estatus = ?1")
    List<Colonia> findAllRecords(Integer estatus);
}

