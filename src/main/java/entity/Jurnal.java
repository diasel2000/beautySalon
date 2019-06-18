package main.java.entity;

import java.sql.Date;
import java.util.Objects;

public class Jurnal {
    private Long id;
    private Date date;
    private Boolean compleat;
    private Long klientId;
    private Long masterId;
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getCompleat() {
        return compleat;
    }

    public void setCompleat(Boolean compleat) {
        this.compleat = compleat;
    }

    public Long getKlientId() {
        return klientId;
    }

    public void setKlientId(Long klientId) {
        this.klientId = klientId;
    }

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Jurnal jurnal = (Jurnal) o;
        return Objects.equals ( id, jurnal.id ) &&
                Objects.equals ( date, jurnal.date ) &&
                Objects.equals ( compleat, jurnal.compleat ) &&
                Objects.equals ( klientId, jurnal.klientId ) &&
                Objects.equals ( masterId, jurnal.masterId ) &&
                Objects.equals ( productId, jurnal.productId );
    }

    @Override
    public int hashCode() {

        return Objects.hash ( id, date, compleat, klientId, masterId, productId );
    }

    @Override
    public String toString() {
        return "Jurnal{" +
                "id=" + id +
                ", date=" + date +
                ", compleat=" + compleat +
                ", klientId=" + klientId +
                ", masterId=" + masterId +
                ", productId=" + productId +
                '}';
    }
}
