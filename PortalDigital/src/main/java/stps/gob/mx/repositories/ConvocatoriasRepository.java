package stps.gob.mx.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stps.gob.mx.domain.Convocatorias;




@Repository
public interface ConvocatoriasRepository extends CrudRepository<Convocatorias, Long> {
	
	@Query("select c from Convocatorias c where c.estatus = ?1")
    List<Convocatorias> findAllRecords(Integer estatus);
	

}

