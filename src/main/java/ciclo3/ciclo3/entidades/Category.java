package ciclo3.ciclo3.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    //JsonIgnoreProperties("category")
    private List<Disfraz> disfraz;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Disfraz> getDisfraz(){
        return disfraz;
    }

    public void setDisfraz(List<Disfraz> disfraz){
        this.disfraz = disfraz;
    }
}