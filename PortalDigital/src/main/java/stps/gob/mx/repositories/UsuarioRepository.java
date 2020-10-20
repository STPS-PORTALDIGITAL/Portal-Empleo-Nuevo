package stps.gob.mx.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stps.gob.mx.domain.Usuario;
import java.util.List;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	List<Usuario> findById(Integer id);
	
	@Query("select c from Usuario c where c.estatus = ?1")
    List<Usuario> findAllRecords(Integer estatus);
	
	List<Usuario> findByUsuario(String usuario);
	
	
	@Query("select c from Usuario c where c.email = ?1")
    List<Usuario> findByEmail(String email);
}

