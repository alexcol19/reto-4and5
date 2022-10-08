lpackage ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.LibraryRepository;
import ciclo3.ciclo3.entities.Category;
import ciclo3.ciclo3.entities.Costume;
import ciclo3.ciclo3.entities.Library;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getCostumes(){
        return libraryRepository.getLibrary();
    }
    public Optional<Category> getCostume(int id){
       return libraryRepository.getLibrary(id);
    }
    public Costume save(Costume costume){
        if(costume.getID()==null){
            return libraryRepository.saveCostume(costume);
        }else{
            Optional<Costume> paux= libraryRepository.getCostumeId(costume.getID());
            if(paux.isEmpty()){
                return libraryRepository.saveCostume(costume);
            }else
                return costume;
        }
    }
}
