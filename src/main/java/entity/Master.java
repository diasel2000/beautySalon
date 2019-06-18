package main.java.entity;

import java.util.Objects;

public class Master {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer phneNumber;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhneNumber() {
        return phneNumber;
    }

    public void setPhneNumber(Integer phneNumber) {
        this.phneNumber = phneNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Master master = (Master) o;
        return Objects.equals ( id, master.id ) &&
                Objects.equals ( firstName, master.firstName ) &&
                Objects.equals ( lastName, master.lastName ) &&
                Objects.equals ( phneNumber, master.phneNumber );
    }

    @Override
    public int hashCode() {

        return Objects.hash ( id, firstName, lastName, phneNumber);
    }

    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phneNumber=" + phneNumber +
                '}';
    }
}
