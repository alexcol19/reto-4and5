package ciclo3.ciclo3.Repository;

<<<<<<< HEAD
import ciclo3.ciclo3.Repository.crudRepository.DisfrazCrudRepository;
import ciclo3.ciclo3.entidades.Disfraz;
import org.springframework.beans.factory.annotation.Autowired;
=======
import ciclo3.ciclo3.Repository.CrudRepositorio.DisfrazCrudRepository;
import ciclo3.ciclo3.entidades.Disfraz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
>>>>>>> a6ccb1425d9c1cced662a1c270ab2f7d2648e755

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
=======
@Repository
>>>>>>> a6ccb1425d9c1cced662a1c270ab2f7d2648e755
public class DisfrazRepository {

    @Autowired
    private DisfrazCrudRepository disfrazCrudRepository;

<<<<<<< HEAD
    public List<Disfraz> getAll(){
        return (List<Disfraz>) disfrazCrudRepository.findAll();
    }
    public Optional<Disfraz> getDisfraz(int id){
        return disfrazCrudRepository.findById(id);
    }
    public Disfraz save(Disfraz d){
        return disfrazCrudRepository.save(d);
    }
    public void delete(Disfraz d){
        disfrazCrudRepository.delete(d);
    }

=======
    public List<Disfraz> getDisfraz(){
        return (List<Disfraz>) disfrazCrudRepository.findAll();
    }
    public Optional<Disfraz> getDistrazId(int id){
        return disfrazCrudRepository.findById(id);
    }
    public Disfraz guardarDisfraz(Disfraz disfraz){
        return disfrazCrudRepository.save(disfraz);
    }
    public void borrarDisfraz(Disfraz disfraz){
        disfrazCrudRepository.delete(disfraz);
    }
>>>>>>> a6ccb1425d9c1cced662a1c270ab2f7d2648e755
}
