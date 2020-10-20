package stps.gob.mx.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stps.gob.mx.domain.Candidato;




@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Long> {
	
	@Query("select c from Candidato c where c.estatus = ?1")
    List<Candidato> findAllRecords(Integer estatus);
	

}

