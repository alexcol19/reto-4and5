package ciclo3.ciclo3.Repository;

import ciclo3.ciclo3.Repository.CrudRepository.AdministratorsCrudRepository;
import ciclo3.ciclo3.entities.Administrators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdministratorsRepository {

    @Autowired
    private AdministratorsCrudRepository administratorsCrudRepository;

    public List<Administrators> getAdministrator(){
        return (List<Administrators>) administratorsCrudRepository.findAll();
    }
    public Optional<Administrators> getAdministratorId(int id){
        return administratorsCrudRepository.findById(id);
    }
    public Administrators saveAdministrator(Administrators administrators){
        return administratorsCrudRepository.save(administrators);
    }
    public void deleteAdminstrators(Administrators administrators){
        administratorsCrudRepository.delete(administrators);
    }
}
