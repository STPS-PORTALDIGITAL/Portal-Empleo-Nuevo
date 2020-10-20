package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Pais;
import java.util.List;


@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {
	List<Pais> findById(Integer id);
	
	@Query("select c from Pais c where c.estatus = ?1")
    List<Pais> findAllRecords(Integer estatus);
}

