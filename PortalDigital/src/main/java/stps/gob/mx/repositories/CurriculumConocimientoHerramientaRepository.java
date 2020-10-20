package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.CurriculumConocimientoHerramienta;
import java.util.List;


@Repository
public interface CurriculumConocimientoHerramientaRepository extends CrudRepository<CurriculumConocimientoHerramienta, Long> {
	List<CurriculumConocimientoHerramienta> findById(Integer id);
	
	@Query("select c from CurriculumConocimientoHerramienta c where c.estatus = ?1")
    List<CurriculumConocimientoHerramienta> findAllRecords(Integer estatus);
}

