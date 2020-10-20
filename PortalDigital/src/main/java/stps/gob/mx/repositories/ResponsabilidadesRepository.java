package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Responsabilidades;
import java.util.List;


@Repository
public interface ResponsabilidadesRepository extends CrudRepository<Responsabilidades, Long> {
	List<Responsabilidades> findById(Integer id);
	
	@Query("select c from Responsabilidades c where c.estatus = ?1")
    List<Responsabilidades> findAllRecords(Integer estatus);
}

