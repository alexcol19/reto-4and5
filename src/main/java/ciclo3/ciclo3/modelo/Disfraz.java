package ciclo3.ciclo3.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "disfraz")
public class Disfraz implements Serializable {

    @Id
    private Integer ID;
    private String BRAND;
    private Integer MODEL;
    private Integer CATEGORY_ID;
    private String NAME;

    public Integer getID() {
        return ID;
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

    public Integer getCATEGORY_ID() {
        return CATEGORY_ID;
    }

    public void setCATEGORY_ID(Integer CATEGORY_ID) {
        this.CATEGORY_ID = CATEGORY_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
}
