package service;

import db.DataBaseConection;
import main.java.dao.MasterDAO;

import main.java.entity.Master;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class MasterService extends DataBaseConection implements MasterDAO {
    Connection connection = getConnection ();

    @Override
    public void add(Master master) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO master (id_master, first_name, last_name, phone_number) VALUES (?, ?, ?, ?);";
        try {
            preparedStatement = connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1, master.getId () );
            preparedStatement.setString ( 2, master.getFirstName () );
            preparedStatement.setString ( 3, master.getLastName () );
            preparedStatement.setInt ( 4, master.getPhoneNumber () );

        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    @Override
    public List<Master> getAll() throws SQLException {
        List<Master> mastersList = new ArrayList<> ();

        String sql = "SELECT * FROM master;";
        Statement statement = null;
        try {
            statement = connection.createStatement ();
            ResultSet resultSet = statement.executeQuery ( sql );
            while (resultSet.next ()) {
                Master master = new Master ();
                master.setId ( resultSet.getLong ( "id_master" ) );
                master.setFirstName ( resultSet.getString ( "first_name" ) );
                master.setLastName ( resultSet.getString ( "last_name" ) );
                master.setPhoneNumber ( resultSet.getInt ( "phone_number" ) );
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {
            if (statement != null) {
                statement.close ();
            }
            if (connection != null) {
                connection.close ();
            }
        }
        return mastersList;
    }

    @Override
    public Master getAllById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM master WHERE id_master;";

        Master master = new Master ();
        try {
            preparedStatement = connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1, id );

            ResultSet resultSet = preparedStatement.executeQuery ();
            master.setId ( resultSet.getLong ( "id_master" ) );
            master.setFirstName ( resultSet.getString ( "first_name" ) );
            master.setLastName ( resultSet.getString ( "last_name" ) );
            master.setPhoneNumber ( resultSet.getInt ( "phone_number" ) );
            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        if (preparedStatement != null) {
            preparedStatement.close ();
        }
        if (connection != null) {
            connection.close ();
        }
        return master;
    }

    @Override
    public void update(Master master) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql ="UPDATE master SET id_master = ?, first_name = ?, last_name = ?, phone_number = ? WHERE (id_master = ?);";
        try {
            preparedStatement =connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1, master.getId () );
            preparedStatement.setString ( 2, master.getFirstName () );
            preparedStatement.setString ( 3, master.getLastName () );
            preparedStatement.setInt ( 4, master.getPhoneNumber () );

        }catch (SQLException e){e.printStackTrace ();}

    }

    @Override
    public void remove(Master master) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql ="DELETE * FROM master WHERE id_master;";

        try {
            preparedStatement = connection.prepareStatement ( sql );

            preparedStatement.setLong ( 1,master.getId () );

            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
}
