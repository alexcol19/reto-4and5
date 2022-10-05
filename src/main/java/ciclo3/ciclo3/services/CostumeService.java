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

    public List<Costume> getCostumes(){
        return costumeRepository.getCostumes();
    }
    public Optional<Costume> getCostumeId(int id){
       return costumeRepository.getCostumeId(id);
    }
    public Costume saveCostume(Costume costume){
        if(costume.getID()==null){
            return costumeRepository.saveCostume(costume);
        }else{
            Optional<Costume> paux= costumeRepository.getCostumeId(costume.getID());
            if(paux.isEmpty()){
                return costumeRepository.saveCostume(costume);
            }else
                return costume;
        }
    }
}
