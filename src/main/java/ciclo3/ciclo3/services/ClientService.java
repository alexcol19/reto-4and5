package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.ClientRepository;
import ciclo3.ciclo3.entities.Category;
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
       return clientRepository.getClientId(id);
    }
    public Client saveClient(Client client){
        if(client.getIdClient()==null){
            return clientRepository.saveClient(client);
        }else{
            Optional<Client> paux= clientRepository.getClientId(client.getIdClient());
            if(paux.isEmpty()){
                return clientRepository.saveClient(client);
            }else
                return client;
        }
    }

    /*public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> e = clientRepository.getClient(client.getIdClient()); //ojo//
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                clientRepository.save(e.get()); //ojo//
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }*/

    /*public boolean deleteClient(int id){
        Boolean d = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return d;
    }*/
}
