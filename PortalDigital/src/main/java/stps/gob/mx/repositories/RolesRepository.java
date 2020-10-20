package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Roles;
import java.util.List;


@Repository
public interface RolesRepository extends CrudRepository<Roles, Long> {
	List<Roles> findById(Integer id);
	
	@Query("select c from Roles c where c.estatus = ?1")
    List<Roles> findAllRecords(Integer estatus);
}

