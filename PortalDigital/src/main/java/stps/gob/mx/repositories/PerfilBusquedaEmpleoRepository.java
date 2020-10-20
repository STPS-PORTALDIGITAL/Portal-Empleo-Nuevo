package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.PerfilBusquedaEmpleo;
import java.util.List;


@Repository
public interface PerfilBusquedaEmpleoRepository extends CrudRepository<PerfilBusquedaEmpleo, Long> {
	List<PerfilBusquedaEmpleo> findById(Integer id);
	
	@Query("select c from PerfilBusquedaEmpleo c where c.estatus = ?1")
    List<PerfilBusquedaEmpleo> findAllRecords(Integer estatus);
}

