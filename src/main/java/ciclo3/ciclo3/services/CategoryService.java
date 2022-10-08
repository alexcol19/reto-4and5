package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.CategoryRepository;
import ciclo3.ciclo3.entities.Category;
import ciclo3.ciclo3.entities.Costume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCostumes(){
        return categoryRepository.getCategory();
    }
    public Optional<Category> getCategoryId(int id){
        return categoryRepository.getCategory(id);
    }
    public Category saveCostume(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> p= categoryRepository.getCategory(category.getId());
            if(p.isEmpty()){
                return categoryRepository.save(category);
            }else
                return category;
        }
    }

}


