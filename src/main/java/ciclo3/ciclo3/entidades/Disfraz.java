package ciclo3.ciclo3.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "disfraz")
public class Disfraz implements Serializable {

    @Id
<<<<<<< HEAD
    private Integer id;


=======
    private Integer ID;
    private String BRAND;
    private Integer MODEL;
    private Integer YEAR;
    private String NAME;
    private String DESCRIPTION;

    public Integer getID() {
        return ID;
    }

    public Integer getYEAR() {
        return YEAR;
    }

    public void setYEAR(Integer YEAR) {
        this.YEAR = YEAR;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    public Integer getMODEL() {
        return MODEL;
    }

    public void setMODEL(Integer MODEL) {
        this.MODEL = MODEL;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
>>>>>>> a6ccb1425d9c1cced662a1c270ab2f7d2648e755
}
