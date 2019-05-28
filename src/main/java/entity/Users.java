package main.java.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Users {
    private Long id;
    private String login;
    private String password;

    private List<String> roles;

    public Users() {
    }

    public Users(String login, String password, String... roles) {
        this.login = login;
        this.password = password;

        this.roles = new ArrayList<String> ();
        if (roles != null) {
            for (String r : roles) {
                this.roles.add(r);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Users users = (Users) o;
        return Objects.equals ( id, users.id ) &&
                Objects.equals ( login, users.login ) &&
                Objects.equals ( password, users.password );
    }

    @Override
    public int hashCode() {

        return Objects.hash ( id, login, password );
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
