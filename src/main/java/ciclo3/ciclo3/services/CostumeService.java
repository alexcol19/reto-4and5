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
        if(costume.getId()==null){
            return costumeRepository.saveCostume(costume);
        }else{
            Optional<Costume> paux= costumeRepository.getCostumeId(costume.getId());
            if(paux.isEmpty()){
                return costumeRepository.saveCostume(costume);
            }else
                return costume;
        }
    }

    public Costume update(Costume costume) {
        if (costume.getId() != null) {
            Optional<Costume> e = costumeRepository.getCostumeId(costume.getId()); //ojo//
            if (!e.isEmpty()) {
                if (costume.getName() != null) {
                    e.get().setName(costume.getName());
                }
                if (costume.getBrand() != null) {
                    e.get().setBrand(costume.getBrand());
                }
                if (costume.getYear() != null) {
                    e.get().setYear(costume.getYear());
                }
                if (costume.getDescription() != null) {
                    e.get().setDescription(costume.getDescription());
                }
                if (costume.getCategory() != null) {
                    e.get().setCategory(costume.getCategory());
                }
                costumeRepository.saveCostume(e.get()); //ojo//
                return e.get();
            }else{
                return costume;
            }
        }else{
            return costume;
        }
    }


    public boolean deleteCostume(int id){
        Boolean d = getCostumeId(id).map(costume -> {
            costumeRepository.deleteCostume(costume);
            return true;
        }).orElse(false);
        return d;
    }
}
