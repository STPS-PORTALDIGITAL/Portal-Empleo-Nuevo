package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.TipoEmpresa;
import java.util.List;


@Repository
public interface TipoEmpresaRepository extends CrudRepository<TipoEmpresa, Long> {
	List<TipoEmpresa> findById(Integer id);
	
	@Query("select c from TipoEmpresa c where c.estatus = ?1")
    List<TipoEmpresa> findAllRecords(Integer estatus);
}

