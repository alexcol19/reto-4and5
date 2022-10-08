package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.CategoryRepository;
import ciclo3.ciclo3.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCostume(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c) {
        if (c.getID() == null) {
            return categoryRepository.save(c);
        } else {
            Optional<Category> paux = categoryRepository.getCategory(c.getID());
            if (paux.isPresent()) {
                return c;
            } else {
                return categoryRepository.save(c);
            }
        }
    }

    public Category update(Category c){
        if (c.getID()!=null){
            Optional<Category> q=categoryRepository.getCategory(c.getID());
            if (q.isPresent()) {
                if (c.getName()!= null) {
                    q.get().setName(c.setName(););
                }
                categoryRepository.save(q.get());
                return q.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }
    public boolean delete(int id){
        boolean flag=false
        Optional<Category>c= categoryRepository.getCategory(id);
        if(c.isPresent()){
            categoryRepository.delete(c.get());
            flag=true;
        }
        return flag
    }
}

