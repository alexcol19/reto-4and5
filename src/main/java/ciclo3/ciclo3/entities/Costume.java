package ciclo3.ciclo3.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "disfraz")
public class Costume implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String BRAND;
    private Integer CATEGORY;
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

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Integer getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(Integer CATEGORY) {
        this.CATEGORY = CATEGORY;
    }
}
