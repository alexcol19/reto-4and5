package ciclo3.ciclo3.servicios;

import ciclo3.ciclo3.Repository.DisfrazRepository;
import ciclo3.ciclo3.entidades.Disfraz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisfrazService {

    @Autowired
    private DisfrazRepository disfrazRepository;

    public List<Disfraz> getDisfraz(){
        return disfrazRepository.getDisfraz();
    }
    public Optional<Disfraz> getDisfrazId(int id){
       return disfrazRepository.getDistrazId(id);
    }
    public Disfraz guardar(Disfraz disfraz){
        if(disfraz.getID()==null){
            return disfrazRepository.guardarDisfraz(disfraz);
        }else{
            Optional<Disfraz> paux=disfrazRepository.getDistrazId(disfraz.getID());
            if(paux.isEmpty()){
                return disfrazRepository.guardarDisfraz(disfraz);
            }else
                return disfraz;
        }
    }
}
