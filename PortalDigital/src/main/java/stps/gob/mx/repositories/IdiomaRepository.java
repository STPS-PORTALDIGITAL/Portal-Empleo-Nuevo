package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Idioma;
import java.util.List;


@Repository
public interface IdiomaRepository extends CrudRepository<Idioma, Long> {
	List<Idioma> findById(Integer id);
	
	@Query("select c from Idioma c where c.estatus = ?1")
    List<Idioma> findAllRecords(Integer estatus);
}

