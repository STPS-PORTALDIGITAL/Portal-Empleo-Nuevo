package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Curriculum;
import java.util.List;


@Repository
public interface CurriculumRepository extends CrudRepository<Curriculum, Long> {
	List<Curriculum> findById(Integer id);
	
	@Query("select c from Curriculum c where c.estatus = ?1")
    List<Curriculum> findAllRecords(Integer estatus);
}

