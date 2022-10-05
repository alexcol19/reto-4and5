package ciclo3.ciclo3.Repository;

import ciclo3.ciclo3.Repository.crudRepository.DisfrazCrudRepository;
import ciclo3.ciclo3.entidades.Disfraz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository

public class DisfrazRepository{
    @Autowired
    private DisfrazCrudRepository disfrazCrudRepository;

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
}
