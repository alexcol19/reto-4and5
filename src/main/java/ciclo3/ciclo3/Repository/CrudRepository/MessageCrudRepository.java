package ciclo3.ciclo3.Repository.CrudRepository;

import ciclo3.ciclo3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
