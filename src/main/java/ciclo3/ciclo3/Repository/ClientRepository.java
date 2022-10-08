package ciclo3.ciclo3.Repository;

import ciclo3.ciclo3.Repository.CrudRepository.ClientCrudRepository;
import ciclo3.ciclo3.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClientId(Integer id){
        return clientCrudRepository.findById(id);
    }
    public Client saveClient(Client client){
        return clientCrudRepository.save(client);
    }
    public void deleteClietn(Client client){
        clientCrudRepository.delete(client);
    }
}
