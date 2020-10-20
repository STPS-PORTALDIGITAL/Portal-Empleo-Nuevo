package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.CodigoPostal;
import java.util.List;


@Repository
public interface CodigoPostalRepository extends CrudRepository<CodigoPostal, Long> {
	List<CodigoPostal> findById(Integer id);
	
	@Query("select c from CodigoPostal c where c.estatus = ?1")
    List<CodigoPostal> findAllRecords(Integer estatus);
}

