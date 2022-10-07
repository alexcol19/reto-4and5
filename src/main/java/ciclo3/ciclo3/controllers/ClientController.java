package ciclo3.ciclo3.controllers;

import ciclo3.ciclo3.entities.Client;
import ciclo3.ciclo3.entities.Costume;
import ciclo3.ciclo3.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/all")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClientId(@PathVariable("id") int id){
        return clientService.getClientId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }
}
