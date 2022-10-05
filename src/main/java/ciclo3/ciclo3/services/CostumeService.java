package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.CostumeRepository;
import ciclo3.ciclo3.entities.Costume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumeService {

    @Autowired
    private CostumeRepository costumeRepository;

    public List<Costume> getDisfraces(){
        return costumeRepository.getDisfraces();
    }
    public Optional<Costume> getDisfrazId(int id){
       return costumeRepository.getDistrazId(id);
    }
    public Costume guardarDisfraz(Costume costume){
        if(costume.getID()==null){
            return costumeRepository.guardarDisfraz(costume);
        }else{
            Optional<Costume> paux= costumeRepository.getDistrazId(costume.getID());
            if(paux.isEmpty()){
                return costumeRepository.guardarDisfraz(costume);
            }else
                return costume;
        }
    }
}
