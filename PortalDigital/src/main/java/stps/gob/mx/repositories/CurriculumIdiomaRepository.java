package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.CurriculumIdioma;
import java.util.List;


@Repository
public interface CurriculumIdiomaRepository extends CrudRepository<CurriculumIdioma, Long> {
	List<CurriculumIdioma> findById(Integer id);
	
	@Query("select c from CurriculumIdioma c where c.estatus = ?1")
    List<CurriculumIdioma> findAllRecords(Integer estatus);
}

