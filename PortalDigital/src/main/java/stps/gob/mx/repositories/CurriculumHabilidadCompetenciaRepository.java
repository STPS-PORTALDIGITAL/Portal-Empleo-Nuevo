package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.CurriculumHabilidadCompetencia;
import java.util.List;


@Repository
public interface CurriculumHabilidadCompetenciaRepository extends CrudRepository<CurriculumHabilidadCompetencia, Long> {
	List<CurriculumHabilidadCompetencia> findById(Integer id);
	
	@Query("select c from CurriculumHabilidadCompetencia c where c.estatus = ?1")
    List<CurriculumHabilidadCompetencia> findAllRecords(Integer estatus);
}

