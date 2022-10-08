package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.LibraryRepository;
import ciclo3.ciclo3.entities.Category;
import ciclo3.ciclo3.entities.Costume;
import ciclo3.ciclo3.entities.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Repository
//@org.springframework.stereotype.Service
@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAll(){ return libraryRepository.getAll(); }
    public Optional<Library> getLibrary(int id){
       return libraryRepository.getLibrary(id);
    }
    public Library save(Library library){
        if(library.getId()==null){
            return libraryRepository.save(library);
        }else{
            Optional<Library> paux= libraryRepository.getLibrary(library.getId());
            if(paux.isEmpty()){
                return libraryRepository.save(library);
            }else
                return library;
        }
    }
}
