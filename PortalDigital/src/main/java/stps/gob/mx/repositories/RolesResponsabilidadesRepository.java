package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.RolesResponsabilidades;
import java.util.List;


@Repository
public interface RolesResponsabilidadesRepository extends CrudRepository<RolesResponsabilidades, Long> {
	List<RolesResponsabilidades> findById(Integer id);
	
	@Query("select c from RolesResponsabilidades c where c.estatus = ?1")
    List<RolesResponsabilidades> findAllRecords(Integer estatus);
}

