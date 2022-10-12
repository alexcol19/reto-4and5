package ciclo3.ciclo3.services;

import ciclo3.ciclo3.Repository.AdministratorsRepository;
import ciclo3.ciclo3.entities.Administrators;
import ciclo3.ciclo3.entities.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorsService {

    @Autowired
    private AdministratorsRepository administratorsRepository;

    public List<Administrators> getAdministrators(){
        return administratorsRepository.getAdministrator();
    }
    public Optional<Administrators> getAdministratorsId(int id){
       return administratorsRepository.getAdministratorId(id);
    }
    public Administrators saveAdministrators(Administrators administrators){
        if(administrators.getIdAdmin()==null){
            return administratorsRepository.saveAdministrator(administrators);
        }else{
            Optional<Administrators> paux= administratorsRepository.getAdministratorId(administrators.getIdAdmin());
            if(paux.isEmpty()){
                return administratorsRepository.saveAdministrator(administrators);
            }else
                return administrators;
        }
    }

    public Administrators update(Administrators administrators) {
        if (administrators.getIdAdmin() != null) {
            Optional<Administrators> e = administratorsRepository.getAdministratorId(administrators.getIdAdmin()); //ojo//
            if (!e.isEmpty()) {
                if (administrators.getEmail() != null) {
                    e.get().setEmail(administrators.getEmail());
                }
                if (administrators.getName() != null) {
                    e.get().setName(administrators.getName());
                }
                if (administrators.getPassword() != null) {
                    e.get().setPassword(administrators.getPassword());
                }
                administratorsRepository.saveAdministrator(e.get());
                return e.get();
            }else{
                return administrators;
            }
        }else{
            return administrators;
        }
    }
    public boolean deleteAdministrator(int id) {
        Boolean d = getAdministratorsId(id).map(administrator -> {
            administratorsRepository.deleteAdministrators(administrator);
            return true;
        }).orElse(false);
        return d;
    }
}
