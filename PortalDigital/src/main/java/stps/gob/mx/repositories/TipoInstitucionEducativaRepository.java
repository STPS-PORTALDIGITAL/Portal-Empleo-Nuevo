package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.TipoInstitucionEducativa;
import java.util.List;


@Repository
public interface TipoInstitucionEducativaRepository extends CrudRepository<TipoInstitucionEducativa, Long> {
	List<TipoInstitucionEducativa> findById(Integer id);
	
	@Query("select c from TipoInstitucionEducativa c where c.estatus = ?1")
    List<TipoInstitucionEducativa> findAllRecords(Integer estatus);
}

