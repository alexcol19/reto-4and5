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

    public List<Category> getCategory() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategoryId(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category saveCostume(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> paux = categoryRepository.getCategory(category.getId());
            if (paux.isEmpty()) {
                return categoryRepository.save(category);
            } else
                return category;
        }
    }

    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> g = categoryRepository.getCategory(category.getId());
            if (!g.isEmpty()) {
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if (category.getName() != null) {
                    g.get().setName(category.getName());
                }
                return categoryRepository.save(g.get());
            }
        }

        return category;
    }





    /*public boolean deleteCategory(int id) {
        Boolean d = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }*/


}


