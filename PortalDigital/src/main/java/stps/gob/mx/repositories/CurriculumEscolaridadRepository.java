package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.CurriculumEscolaridad;
import java.util.List;


@Repository
public interface CurriculumEscolaridadRepository extends CrudRepository<CurriculumEscolaridad, Long> {
	List<CurriculumEscolaridad> findById(Integer id);
	
	@Query("select c from CurriculumEscolaridad c where c.estatus = ?1")
    List<CurriculumEscolaridad> findAllRecords(Integer estatus);
}

