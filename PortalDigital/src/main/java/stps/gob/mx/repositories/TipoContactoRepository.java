package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.TipoContacto;
import java.util.List;


@Repository
public interface TipoContactoRepository extends CrudRepository<TipoContacto, Long> {
	List<TipoContacto> findById(Integer id);
	
	@Query("select c from TipoContacto c where c.estatus = ?1")
    List<TipoContacto> findAllRecords(Integer estatus);
}

