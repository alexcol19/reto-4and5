package ciclo3.ciclo3.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Client")
public class Client implements Serializable {

    @Id
    private Integer IdClient;
    private String  email;
    private String  password;
    private String  name;
    private Integer age;

    public Integer getIdClient() {
        return IdClient;
    }

    public void setIdClient(Integer idClient) {
        IdClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



}




