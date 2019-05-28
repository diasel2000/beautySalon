package service;

import main.java.entity.Users;

public class main {
    public static void main(String[] args) {
        Users users =new Users ();
        UsersService usersService =new UsersService ();
        users.setLogin ( "admin" );
        users.setPassword ( "admin" );
        System.out.println (usersService.getUser ( users ));
    }
}
