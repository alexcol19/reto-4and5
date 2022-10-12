package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.MessageRepository;
import ciclo3.ciclo3.entities.Category;
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

    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> e = messageRepository.getMessageId(message.getIdMessage());//ojo//
            if (!e.isEmpty()) {
                if (message.getMessageText() != null) {
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.saveMessage(e.get());//ojo//
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int id){
        Boolean d = getMessageId(id).map(message -> {
            messageRepository.deleteMessage(message);
            return true;
        }).orElse(false);
        return d;
    }
}
