package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.MessageRepository;
import ciclo3.ciclo3.entities.Message;
import ciclo3.ciclo3.entities.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessages(){
        return messageRepository.getMessages();
    }
    public Optional<Message> getMessageId(int id){
       return messageRepository.getMessageId(id);
    }
    public Message saveMessage(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.saveMessage(message);
        }else{
            Optional<Message> paux= messageRepository.getMessageId(message.getIdMessage());
            if(paux.isEmpty()){
                return messageRepository.saveMessage(message);
            }else
                return message;
        }
    }
}
