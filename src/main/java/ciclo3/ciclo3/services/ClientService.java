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

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
       return clientRepository.getClient(id);
    }
    public Client saveClient(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(p);
        }else{
            Optional<Client> paux= clientRepository.getClientId(client.getIdClient());
            if(paux.isEmpty()){
                return clientRepository.saveClient(client);
            }else
                return client;
        }
    }
}
