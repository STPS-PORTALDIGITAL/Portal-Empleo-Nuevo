package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.OfertaEmpleoHabilidadCompetencia;
import java.util.List;


@Repository
public interface OfertaEmpleoHabilidadCompetenciaRepository extends CrudRepository<OfertaEmpleoHabilidadCompetencia, Long> {
	List<OfertaEmpleoHabilidadCompetencia> findById(Integer id);
	
	@Query("select c from OfertaEmpleoHabilidadCompetencia c where c.estatus = ?1")
    List<OfertaEmpleoHabilidadCompetencia> findAllRecords(Integer estatus);
}

