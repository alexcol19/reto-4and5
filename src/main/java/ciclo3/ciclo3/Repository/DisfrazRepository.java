package ciclo3.ciclo3.Repository;

import ciclo3.ciclo3.Repository.CrudRepositorio.DisfrazCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DisfrazRepository {

    @Autowired
    private DisfrazCrudRepository disfrazCrudRepository;
}
