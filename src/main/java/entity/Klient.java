package main.java.entity;

import java.util.Objects;

public class Klient {
    private Long id;
    private String firstName;
    private String lastName;
    private Short age;
    private Character gander;


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

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Character getGander() {
        return gander;
    }

    public void setGander(Character gander) {
        this.gander = gander;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Klient klient = (Klient) o;
        return Objects.equals ( id, klient.id ) &&
                Objects.equals ( firstName, klient.firstName ) &&
                Objects.equals ( lastName, klient.lastName ) &&
                Objects.equals ( age, klient.age ) &&
                Objects.equals ( gander, klient.gander );
    }

    @Override
    public int hashCode() {

        return Objects.hash ( id, firstName, lastName, age, gander);
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gander=" + gander +
                '}';
    }
}
