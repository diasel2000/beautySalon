package service;

import db.DataBaseConection;
import main.java.dao.KlientDAO;

import main.java.entity.Klient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KlientService extends DataBaseConection implements KlientDAO {

    Connection connection = getConnection ();
    @Override
    public void add(Klient klient) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql ="INSERT INTO klient (id_klient, first_name, last_name, age, gander) VALUES (?, ?, ?, ?, ?);";
        try {
            preparedStatement =connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,klient.getId ());
            preparedStatement.setString ( 2,klient.getFirstName ());
            preparedStatement.setString ( 3,klient.getLastName ());
            preparedStatement.setShort ( 4,klient.getAge ());
            preparedStatement.setString ( 5,klient.getGander ());

        }catch (SQLException e){e.printStackTrace ();}

    }

    @Override
    public List<Klient> getAll() throws SQLException {
        List<Klient> klientList = new ArrayList<> (  );

        String sql ="SELECT * FROM klient;";
        Statement statement =null;
        try {
            statement = connection.createStatement ();
            ResultSet resultSet = statement.executeQuery ( sql );
            while (resultSet.next ()){
                Klient klient =new Klient ();
                klient.setId ( resultSet.getLong ( "id_klient" ) );
                klient.setFirstName ( resultSet.getString ( "first_name" ) );
                klient.setLastName ( resultSet.getString ( "last_name" ) );
                klient.setAge ( resultSet.getShort ( "age" ));
                klient.setGander ( resultSet.getString ( "gander" ) );

            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return klientList;

    }

    @Override
    public Klient getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql ="SELECT * FROM klient WHERE id_klient=?;";

        Klient klient = new Klient ();
        try {
            preparedStatement = connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,id );

            ResultSet resultSet = preparedStatement.executeQuery ();

            klient.setId ( resultSet.getLong ( "id_klient" ) );
            klient.setFirstName ( resultSet.getString ( "first_name" ) );
            klient.setLastName ( resultSet.getString ( "last_name" ) );
            klient.setAge ( resultSet.getShort ( "age" ));
            klient.setGander ( resultSet.getString ( "gander" ) );

            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return klient;
    }

    @Override
    public void update(Klient klient) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql ="UPDATE klient SET id_klient = ?, first_name = ?, last_name = ?, age = ?, gander = ? WHERE (id_klient = ?);";
        try {
            preparedStatement =connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,klient.getId ());
            preparedStatement.setString ( 2,klient.getFirstName ());
            preparedStatement.setString ( 3,klient.getLastName ());
            preparedStatement.setShort ( 4,klient.getAge ());
            preparedStatement.setString ( 5,klient.getGander ());
        }catch (SQLException e){e.printStackTrace ();}
    }

    @Override
    public void remove(Klient klient) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql ="DELETE FROM klient WHERE (id_klient);";

        try {
            preparedStatement = connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,klient.getId () );
            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
}
