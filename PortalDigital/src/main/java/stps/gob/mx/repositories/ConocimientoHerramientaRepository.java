package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.ConocimientoHerramienta;
import java.util.List;


@Repository
public interface ConocimientoHerramientaRepository extends CrudRepository<ConocimientoHerramienta, Long> {
	List<ConocimientoHerramienta> findById(Integer id);
	
	@Query("select c from ConocimientoHerramienta c where c.estatus = ?1")
    List<ConocimientoHerramienta> findAllRecords(Integer estatus);
}

