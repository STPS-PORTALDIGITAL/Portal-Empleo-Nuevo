package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Notificacion;
import java.util.List;


@Repository
public interface NotificacionRepository extends CrudRepository<Notificacion, Long> {
	List<Notificacion> findById(Integer id);
	
	@Query("select c from Notificacion c where c.estatus = ?1")
    List<Notificacion> findAllRecords(Integer estatus);
}

