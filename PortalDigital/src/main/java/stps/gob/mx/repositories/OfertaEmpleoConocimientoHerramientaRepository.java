package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.OfertaEmpleoConocimientoHerramienta;
import java.util.List;


@Repository
public interface OfertaEmpleoConocimientoHerramientaRepository extends CrudRepository<OfertaEmpleoConocimientoHerramienta, Long> {
	List<OfertaEmpleoConocimientoHerramienta> findById(Integer id);
	
	@Query("select c from OfertaEmpleoConocimientoHerramienta c where c.estatus = ?1")
    List<OfertaEmpleoConocimientoHerramienta> findAllRecords(Integer estatus);
}

