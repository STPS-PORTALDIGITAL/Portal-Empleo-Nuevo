package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.ContactoEmpleador;
import java.util.List;


@Repository
public interface ContactoEmpleadorRepository extends CrudRepository<ContactoEmpleador, Long> {
	List<ContactoEmpleador> findById(Integer id);
	
	@Query("select c from ContactoEmpleador c where c.estatus = ?1")
    List<ContactoEmpleador> findAllRecords(Integer estatus);
}

