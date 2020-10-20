package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.RolesUsuario;
import java.util.List;


@Repository
public interface RolesUsuarioRepository extends CrudRepository<RolesUsuario, Long> {
	List<RolesUsuario> findById(Integer id);
	
	@Query("select c from RolesUsuario c where c.estatus = ?1")
    List<RolesUsuario> findAllRecords(Integer estatus);
}

