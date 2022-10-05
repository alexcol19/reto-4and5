package ciclo3.ciclo3.Repository;


import ciclo3.ciclo3.Repository.CrudRepository.MessageCrudRepository;
import ciclo3.ciclo3.entities.Message;
import ciclo3.ciclo3.entities.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getMessages(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    public Optional<Message> getMessageId(int id){
        return messageCrudRepository.findById(id);
    }
    public Message saveMessage(Message message){
        return messageCrudRepository.save(message);
    }
    public void deleteMessage(Message message){
        messageCrudRepository.delete(message);
    }
}
