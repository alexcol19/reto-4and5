package ciclo3.ciclo3.Repository;

import ciclo3.ciclo3.Repository.CrudRepository.LibraryCrudRepository;
import ciclo3.ciclo3.entities.Library;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LibraryRepository {

    @Autowired
    private LibraryCrudRepository libraryCrudRepository;

    public List<Library> getAll(){
        return (List<Library>) libraryCrudRepository.findAll();
    }
    public Optional<Library> getLibrary(int id){ return libraryCrudRepository.findById(id);}
    public Library save(Library c){ return libraryCrudRepository.save(c); }
    public void delete(Library c){
        libraryCrudRepository.delete(c);
    }
}
