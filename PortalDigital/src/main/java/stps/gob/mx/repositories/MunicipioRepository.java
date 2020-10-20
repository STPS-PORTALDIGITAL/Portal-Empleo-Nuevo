package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Municipio;
import java.util.List;


@Repository
public interface MunicipioRepository extends CrudRepository<Municipio, Long> {
	List<Municipio> findById(Integer id);
	
	@Query("select c from Municipio c where c.estatus = ?1")
    List<Municipio> findAllRecords(Integer estatus);
	
	@Query(value = "SELECT * FROM ubicacion.municipio u WHERE u.id_entidad = ?1", 
			  nativeQuery = true)
	List<Municipio> findByEntidad (Integer id_entidad);
	

}

