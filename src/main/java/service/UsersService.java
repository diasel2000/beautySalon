package service;

import db.DataBaseConection;
import main.java.dao.UsersDAO;
import main.java.entity.Users;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersService extends DataBaseConection implements UsersDAO {
    public String add(Users users) {
        String login = users.getLogin ();
        String password = users.getPassword ();
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DataBaseConection.getConnection ();
            String query = "INSERT INTO users (login, password) VALUES ( ?, ?);";
            preparedStatement = con.prepareStatement ( query );
            preparedStatement.setString ( 1, login );
            preparedStatement.setString ( 2, password );
            int i = preparedStatement.executeUpdate ();
            if (i != 0)
                return "SUCCESS";
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return "Oops.. Something went wrong there..!";
    }

    @Override
    public String getUser(Users users) {
        String login = users.getLogin ();
        String password = users.getPassword ();

        Connection con = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";

        PreparedStatement preparedStatement = null;

        String sql ="select login,password from users where login=? and password=?";
        try
        {
            con = DataBaseConection.getConnection ();
            resultSet = preparedStatement.executeQuery(sql);
            preparedStatement = con.prepareStatement ( sql );
            preparedStatement.setString ( 1, login );
            preparedStatement.setString ( 2, password );

            while(resultSet.next())
            {
                userNameDB = resultSet.getString("login");
                passwordDB = resultSet.getString("password");

                if(login.equals(userNameDB) && password.equals(passwordDB))
                {
                    return "SUCCESS";
                }
            }
        } catch(SQLException e)
            {
                e.printStackTrace();
            }
            return "Invalid user credentials";
        }


    @Override
    public Users getAllById(Long id) {return null;
    }

    @Override
    public void update(Users users) {

    }

    @Override
    public void remove(Users users) {

    }
}
