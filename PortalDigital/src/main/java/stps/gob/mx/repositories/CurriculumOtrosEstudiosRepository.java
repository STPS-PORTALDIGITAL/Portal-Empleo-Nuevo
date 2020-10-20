package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.CurriculumOtrosEstudios;
import java.util.List;


@Repository
public interface CurriculumOtrosEstudiosRepository extends CrudRepository<CurriculumOtrosEstudios, Long> {
	List<CurriculumOtrosEstudios> findById(Integer id);
	
	@Query("select c from CurriculumOtrosEstudios c where c.estatus = ?1")
    List<CurriculumOtrosEstudios> findAllRecords(Integer estatus);
}

