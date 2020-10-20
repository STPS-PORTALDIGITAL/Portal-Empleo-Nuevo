package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.HabilidadCompetencia;
import java.util.List;


@Repository
public interface HabilidadCompetenciaRepository extends CrudRepository<HabilidadCompetencia, Long> {
	List<HabilidadCompetencia> findById(Integer id);
	
	@Query("select c from HabilidadCompetencia c where c.estatus = ?1")
    List<HabilidadCompetencia> findAllRecords(Integer estatus);
}

