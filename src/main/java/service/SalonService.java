package main.java.service;

import db.DataBaseConection;
import main.java.dao.SalonDAO;
import main.java.entity.Master;
import main.java.entity.Salon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalonService extends DataBaseConection implements SalonDAO {
    Connection connection = getConnection ();

    @Override
    public void add(Salon salon) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO beauty_salon.salon (id_salon, salon_name, adress, id_jurnal)  VALUES (?, ?, ?, ?);";
        try {
            preparedStatement = connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1, salon.getId () );
            preparedStatement.setString ( 2, salon.getSalonName () );
            preparedStatement.setString ( 3, salon.getAdress () );
            preparedStatement.setLong ( 4, salon.getJurnalId () );


        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close ();
            }
            if (connection != null) {
                connection.close ();
            }
        }
    }

    @Override
    public List<Salon> getAll() throws SQLException {
        List<Salon> salonList = new ArrayList<> (  );

        String sql ="SELECT * FROM beauty_salon.salon;";
        Statement statement =null;
        try {
            statement = connection.createStatement ();
            ResultSet resultSet = statement.executeQuery ( sql );
            while (resultSet.next ()){
                Salon salon =new Salon ();
                salon.setId ( resultSet.getLong ( "id_salon" ) );
                salon.setSalonName ( resultSet.getString ( "salon_name" ) );
                salon.setAdress ( resultSet.getString ( "adress" ) );
                salon.setJurnalId ( resultSet.getLong ( "id_jurnal" ));

            }
        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {
            if(statement !=null){
                statement.close ();
            }
            if (connection != null){
                connection.close ();
            }
        }
        return salonList;
    }

    @Override
    public Salon getAllById(Long id, Long jurnalId) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql ="SELECT * FROM beauty_salon.salon WHERE id_salon and id_jurnal;";

        Salon salon = new Salon ();
        try {
            preparedStatement = connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,id );
            preparedStatement.setLong ( 2, jurnalId );

            ResultSet resultSet = preparedStatement.executeQuery ();

            salon.setId ( resultSet.getLong ( "id_salon" ) );
            salon.setSalonName ( resultSet.getString ( "salon_name" ) );
            salon.setAdress ( resultSet.getString ( "adress" ) );
            salon.setJurnalId ( resultSet.getLong ( "id_jurnal" ));

            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            e.printStackTrace ();
        } if (preparedStatement !=null){
            preparedStatement.close ();
        }
        if (connection != null){
            connection.close ();
        }
        return salon;
    }

    @Override
    public void update(Salon salon) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql ="UPDATE beauty_salon.salon SET id_product = ?, product_name = ?, price = ?  WHERE (idjurnal = ?);";
        try {
            preparedStatement =connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,salon.getId ());
            preparedStatement.setString ( 2,salon.getSalonName ());
            preparedStatement.setString ( 3,salon.getAdress ());
            preparedStatement.setLong ( 4,salon.getJurnalId ());

        }catch (SQLException e){e.printStackTrace ();}
        finally {
            if(preparedStatement !=null){
                preparedStatement.close ();
            }
            if (connection != null){
                connection.close ();
            }
        }
    }

    @Override
    public void remove(Salon salon) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql ="DELETE * FROM beauty_salon.salon WHERE id_salon;";

        try {
            preparedStatement = connection.prepareStatement ( sql );

            preparedStatement.setLong ( 1,salon.getId () );

            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            e.printStackTrace ();
        } if (preparedStatement !=null){
            preparedStatement.close ();
        }
        if (connection != null){
            connection.close ();
        }
    }
}
