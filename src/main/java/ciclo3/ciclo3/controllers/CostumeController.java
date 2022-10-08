package ciclo3.ciclo3.controllers;

import ciclo3.ciclo3.entities.Costume;
import ciclo3.ciclo3.services.CostumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Costume")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CostumeController {

    @Autowired
    private CostumeService costumeService;

    @RequestMapping("/all")
    public List<Costume> getCostumes(){
        return costumeService.getCostumes();
    }

    @GetMapping("/{id}")
    public Optional<Costume> getCostumeId(@PathVariable("id") int id){

        return costumeService.getCostumeId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume saveCostume(@RequestBody Costume costume){

        return costumeService.saveCostume(costume);
    }
}
