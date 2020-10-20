package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.OfertaEmpleo;
import java.util.List;


@Repository
public interface OfertaEmpleoRepository extends CrudRepository<OfertaEmpleo, Long> {
	List<OfertaEmpleo> findById(Integer id);
	
	@Query("select c from OfertaEmpleo c where c.estatus = ?1")
    List<OfertaEmpleo> findAllRecords(Integer estatus);
	
	//Detalle del puesto
	@Query("select c from OfertaEmpleo c where c.puesto=?0 and c.estatus = ?1")
    List<OfertaEmpleo> busquedaDetalleEmpleoSinSesion(String puesto, Integer estatus);
	
	//Lista de todos los puestos de trabajo
	@Query("SELECT DISTINCT a.puesto FROM OfertaEmpleo a WHERE  LENGTH(a.puesto) > 0 and a.estatus = ?1")
	List<String> busquedaPuestos(Integer estatus);
	
	
	@Query("SELECT COUNT(c.id) FROM OfertaEmpleo c where c.estatus = ?1")
    int getCount(Integer estatus);
	

}

