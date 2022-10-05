package ciclo3.ciclo3.Repository;

import ciclo3.ciclo3.entities.Costume;
import org.springframework.beans.factory.annotation.Autowired;
import ciclo3.ciclo3.Repository.CrudRepositorio.CostumeCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CostumeRepository {

    @Autowired
    private CostumeCrudRepository costumeCrudRepository;


    public List<Costume> getDisfraces(){
        return (List<Costume>) costumeCrudRepository.findAll();
    }
    public Optional<Costume> getDistrazId(int id){
        return costumeCrudRepository.findById(id);
    }
    public Costume guardarDisfraz(Costume costume){
        return costumeCrudRepository.save(costume);
    }
    public void borrarDisfraz(Costume costume){
        costumeCrudRepository.delete(costume);
    }

}
