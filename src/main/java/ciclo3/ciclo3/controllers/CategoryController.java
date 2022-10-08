package ciclo3.ciclo3.controllers;

import ciclo3.ciclo3.entities.Costume;
import ciclo3.ciclo3.services.CategoryService;
import ciclo3.ciclo3.services.CostumeService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/all")
    public List<Category> getCategory(){
        return categoryService.getCategoryId();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){ return categoryService.getCategoryId();
    }
    @PostMapping("/save")
    public Category save(@RequestBody Category p){
        return categoryService.saveCategory();
    }
}
