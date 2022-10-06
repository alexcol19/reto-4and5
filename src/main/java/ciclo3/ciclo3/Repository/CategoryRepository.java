package ciclo3.ciclo3.Repository;

import ciclo3.ciclo3.Repository.CrudRepository.CategoryCrudRepository;
import ciclo3.ciclo3.entities.Library;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category c){
        return categoryCrudRepository.save(c);
    }
    public void delete(Category c){
        categoryCrudRepository.delete(c);
    }


}
