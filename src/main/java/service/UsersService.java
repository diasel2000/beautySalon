package service;

import db.DataBaseConection;
import main.java.dao.UsersDAO;
import main.java.entity.Users;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersService extends DataBaseConection implements UsersDAO {
    private static final Logger LOG = Logger.getLogger(DataBaseConection.class);

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
            LOG.error("Some problem was occurred while registration \n" + e);
        }
        return "Oops.. Something went wrong there..!";
    }

    @Override
    public String getUser(Users users) {
//        String login = users.getLogin ();
//        String password = users.getPassword ();
//        try {
//            Connection con = getConnection ();
//            //Class.forName("org.mariadb.jdbc.Driver");
//            String sql = "SELECT * FROM beauty_salon.users where login = ? and password = ?;";
//            PreparedStatement ps = con.prepareStatement ( sql );
//            ps.setString ( 1, login );
//            ps.setString ( 2, password );
//            ResultSet rs = ps.executeQuery ();
//
//            while (rs.next ()) {
//
//                return "Login Sucses";
//            }
//        } catch (SQLException e) {
//            e.printStackTrace ();
//        }
        return "INCORECT LOGIN";
    }


    @Override
    public Users getAllById(Long id) {
        return null;
    }

    @Override
    public void update(Users users) {

    }

    @Override
    public void remove(Users users) {

    }
}
