package ciclo3.ciclo3.controllers;

import ciclo3.ciclo3.entities.Costume;
import ciclo3.ciclo3.entities.Library;
import ciclo3.ciclo3.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Repository
@RestController
@RequestMapping("/api/Library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/all")
    public List<Library> getAll() { return libraryService.getAll();
    }
    @PostMapping("/save")
    public Library save(@RequestBody Library p) { return libraryService.save(p);
    }
}

