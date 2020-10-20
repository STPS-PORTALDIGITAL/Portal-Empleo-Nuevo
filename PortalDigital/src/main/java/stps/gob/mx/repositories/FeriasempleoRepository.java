package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Feriasempleo;

import java.util.List;

@Repository
public interface FeriasempleoRepository extends CrudRepository<Feriasempleo, Long> {

    @Query("select c from Feriasempleo c where c.estatus = ?1")
    List<Feriasempleo> findAllRecords(Integer estatus);
}
