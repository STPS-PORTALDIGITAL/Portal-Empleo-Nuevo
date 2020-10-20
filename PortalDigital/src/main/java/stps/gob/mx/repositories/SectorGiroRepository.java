package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.SectorGiro;
import java.util.List;


@Repository
public interface SectorGiroRepository extends CrudRepository<SectorGiro, Long> {
	List<SectorGiro> findById(Integer id);
	
	@Query("select c from SectorGiro c where c.estatus = ?1")
    List<SectorGiro> findAllRecords(Integer estatus);
}

