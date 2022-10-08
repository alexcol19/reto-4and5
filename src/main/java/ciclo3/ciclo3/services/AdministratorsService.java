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
}
