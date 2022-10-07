package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.CategoryRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() { return categoryRepository.getAll();}
    public Optional<Category> getCostume(int id){ return categoryRepository.getCategory(id);}
    public Category save(Category p){
        if (p.getId()==null) {
            return categoryRepository.save(p);
        }else{
            Optional<Category> e = categoryRepository.getCategory(p.getId());
            if (e.isPresent()) {
                return p;
            }else{
                return categoryRepository.save(p);
            }
        }
    }
    public Category update(Category p){
        if (p.getId()!=null){
            Optional<Category> q = categoryRepository.getCategory(p.getId());
            if (q.isPresent()){
                if (p.getName()!=null){
                    q.get().setName());
                }
                categoryRepository.save(q.get());
                return q.get();
            }else {
                return p;
            }
        }else{
            return p;
        }
    }

    public boolean delete(int id){
        Boolean flag=false;
        Optional<Category>p= categoryRepository.getCategory(id);
        if(p.isPresent()){
            categoryRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }
}
