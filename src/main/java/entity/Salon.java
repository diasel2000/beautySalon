package main.java.entity;

import java.util.Objects;

public class Salon {
    private Long id;
    private String salonName;
    private String adress;
    private Long jurnalId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Long getJurnalId() {
        return jurnalId;
    }

    public void setJurnalId(Long jurnalId) {
        this.jurnalId = jurnalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Salon salon = (Salon) o;
        return Objects.equals ( id, salon.id ) &&
                Objects.equals ( salonName, salon.salonName ) &&
                Objects.equals ( adress, salon.adress ) &&
                Objects.equals ( jurnalId, salon.jurnalId );
    }

    @Override
    public int hashCode() {

        return Objects.hash ( id, salonName, adress, jurnalId );
    }

    @Override
    public String toString() {
        return "Salon{" +
                "id=" + id +
                ", salonName='" + salonName + '\'' +
                ", adress='" + adress + '\'' +
                ", jurnalId=" + jurnalId +
                '}';
    }
}
