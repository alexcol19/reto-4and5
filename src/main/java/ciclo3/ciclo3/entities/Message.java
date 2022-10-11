package ciclo3.ciclo3.entities;
//import ciclo3.ciclo3.entities.Costume
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
//import java.util.List.

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "costumeId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Costume costume;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;


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

    public Costume getCostume() {
        return costume;
    }

    public void setCostume(Costume costume) {
        this.costume = costume;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
