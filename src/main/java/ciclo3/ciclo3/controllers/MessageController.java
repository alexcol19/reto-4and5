package ciclo3.ciclo3.controllers;

import ciclo3.ciclo3.entities.Message;
//import ciclo3.ciclo3.entities.Reservations;
import ciclo3.ciclo3.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/all")
    public List<Message> getMessages(){
        return messageService.getMessages();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessagesId(@PathVariable("id") int id){
        return messageService.getMessageId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message saveMessage(@RequestBody Message message){
        return messageService.saveMessage(message);
    }
}
