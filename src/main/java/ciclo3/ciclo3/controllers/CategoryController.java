package ciclo3.ciclo3.controllers;

import ciclo3.ciclo3.entities.Category;
import ciclo3.ciclo3.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/all")
    public List<Category> getCategory(){

        return categoryService.getCategory();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryId(@PathVariable("id") int id){
        return categoryService.getCategoryId(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category saveCategory(@RequestBody Category category){

        return categoryService.saveCostume(category);
    }
}
