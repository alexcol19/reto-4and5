package ciclo3.ciclo3.entities;

import ciclo3.ciclo3.entities.Costume;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "massage")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    private List<Costume> costume;
    private List<Client> client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public List<Costume> getCostume() {
        return costume;
    }

    public void setCostume(List<Costume> costume) {
        this.costume = costume;
    }

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }
}
