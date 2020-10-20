package stps.gob.mx.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.LogActivity;



@Repository
public interface LogActivityRepository extends CrudRepository<LogActivity, Long> {
}
