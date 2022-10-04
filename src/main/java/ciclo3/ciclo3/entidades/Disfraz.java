package ciclo3.ciclo3.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "disfraz")
public class Disfraz implements Serializable {

    @Id
    private Integer id;


}
