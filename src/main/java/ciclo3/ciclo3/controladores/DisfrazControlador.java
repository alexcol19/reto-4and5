package ciclo3.ciclo3.controladores;

import ciclo3.ciclo3.entidades.Disfraz;
import ciclo3.ciclo3.servicios.DisfrazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Costume")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class DisfrazControlador {

    @Autowired
    private DisfrazService disfrazService;

    @RequestMapping("/all")
    public List<Disfraz> getDisfraz(){
        return disfrazService.getDisfraz();
    }

    @GetMapping("/{id}")
    public Optional<Disfraz> getDisfraz(@PathVariable("id") int id){
        return disfrazService.getDisfrazId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Disfraz guardar(@RequestBody Disfraz disfraz){
        return disfrazService.guardar(disfraz);
    }
}
