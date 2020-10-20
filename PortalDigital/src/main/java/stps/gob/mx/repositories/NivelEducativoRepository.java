package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.NivelEducativo;
import java.util.List;


@Repository
public interface NivelEducativoRepository extends CrudRepository<NivelEducativo, Long> {
	List<NivelEducativo> findById(Integer id);
	
	@Query("select c from NivelEducativo c where c.estatus = ?1")
    List<NivelEducativo> findAllRecords(Integer estatus);
}

