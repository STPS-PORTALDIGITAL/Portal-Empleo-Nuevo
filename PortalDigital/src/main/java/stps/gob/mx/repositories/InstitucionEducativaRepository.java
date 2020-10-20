package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.InstitucionEducativa;
import java.util.List;


@Repository
public interface InstitucionEducativaRepository extends CrudRepository<InstitucionEducativa, Long> {
	List<InstitucionEducativa> findById(Integer id);
	
	@Query("select c from InstitucionEducativa c where c.estatus = ?1")
    List<InstitucionEducativa> findAllRecords(Integer estatus);
}

