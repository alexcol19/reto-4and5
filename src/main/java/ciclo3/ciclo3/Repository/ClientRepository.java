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
    public Optional<Client> getClientId(String id){
        return clientCrudRepository.findById(id);
    }
    public Client saveAdministrator(Client administrators){
        return clientCrudRepository.save(administrators);
    }
    public void deleteAdminstrators(Client administrators){
        clientCrudRepository.delete(administrators);
    }
}
