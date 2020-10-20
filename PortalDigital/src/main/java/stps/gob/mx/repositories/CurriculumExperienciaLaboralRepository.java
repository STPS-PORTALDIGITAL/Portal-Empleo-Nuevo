package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.CurriculumExperienciaLaboral;
import java.util.List;


@Repository
public interface CurriculumExperienciaLaboralRepository extends CrudRepository<CurriculumExperienciaLaboral, Long> {
	List<CurriculumExperienciaLaboral> findById(Integer id);
	
	@Query("select c from CurriculumExperienciaLaboral c where c.estatus = ?1")
    List<CurriculumExperienciaLaboral> findAllRecords(Integer estatus);
}

