package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.ClientRepository;
import ciclo3.ciclo3.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients(){
        return clientRepository.getClients();
    }
    public Optional<Client> getClientId(int id){
       return clientRepository.getClientId(id);
    }
    public Client saveClient(Client client){
        if(client.getID()==null){
            return clientRepository.saveClient(client);
        }else{
            Optional<Client> paux= clientRepository.getClientId(client.getID());
            if(paux.isEmpty()){
                return clientRepository.saveClient(client);
            }else
                return client;
        }
    }
}
