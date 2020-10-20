package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Entidad;
import stps.gob.mx.domain.Municipio;

import java.util.List;


@Repository
public interface EntidadRepository extends CrudRepository<Entidad, Long> {
	List<Entidad> findById(Integer id);
	
	@Query("select c from Entidad c where c.estatus = ?1")
    List<Entidad> findAllRecords(Integer estatus);
	
	@Query("select c.descripcion from Entidad c where c.estatus = ?1")
    List<String> findAllEntidad(Integer estatus);
	
	@Query("select c from Entidad c where c.descripcion=?0 and c.estatus = ?1")
    Entidad findRecord(String descripcion, Integer estatus);
	

}

