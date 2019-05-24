package main.java.service;

import db.DataBaseConection;
import main.java.dao.JurnalDAO;

import main.java.entity.Jurnal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JurnalService extends DataBaseConection implements JurnalDAO {

    Connection connection = getConnection ();
    @Override
    public void add(Jurnal jurnal) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql ="INSERT INTO beauty_salon.jurnal (idjurnal, data, compleat, id_klient, id_master, id_product) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            preparedStatement =connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,jurnal.getId ());
            preparedStatement.setDate ( 2,jurnal.getDate ());
            preparedStatement.setBoolean ( 3,jurnal.getCompleat ());
            preparedStatement.setLong ( 4,jurnal.getKlientId ());
            preparedStatement.setLong ( 5,jurnal.getMasterId ());
            preparedStatement.setLong ( 6,jurnal.getProductId ());
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
    public List<Jurnal> getAll() throws SQLException {
        List<Jurnal> jurnalList = new ArrayList<> (  );

        String sql ="SELECT (idjurnal, data, compleat, id_klient, id_master, id_product) FROM beauty_salon.jurnal;";
        Statement statement =null;
        try {
            statement = connection.createStatement ();
            ResultSet resultSet = statement.executeQuery ( sql );
            while (resultSet.next ()){
                Jurnal jurnal =new Jurnal ();
                jurnal.setId ( resultSet.getLong ( "idjurnal" ) );
                jurnal.setDate ( resultSet.getDate ( "data" ) );
                jurnal.setCompleat ( resultSet.getBoolean ( "compleat" ) );
                jurnal.setKlientId ( resultSet.getLong ( "id_klient" ) );
                jurnal.setMasterId ( resultSet.getLong ( "id_master" ) );
                jurnal.setProductId ( resultSet.getLong ( "id_product" ) );
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
        return jurnalList;
    }

    @Override
    public Jurnal getAllById(Long id, Long klientId, Long masterId, Long productId) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql ="SELECT (idjurnal, data, compleat, id_klient, id_master, id_product) FROM beauty_salon.jurnal WHERE idjurnal=? and id_klient=? and id_master=? and id_product=?;";

        Jurnal jurnal = new Jurnal ();
        try {
            preparedStatement = connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,id );
            preparedStatement.setLong ( 2, klientId );
            preparedStatement.setLong ( 3, masterId );
            preparedStatement.setLong ( 4, productId );

            ResultSet resultSet = preparedStatement.executeQuery ();

            jurnal.setId ( resultSet.getLong ( "idjurnal" ) );
            jurnal.setDate ( resultSet.getDate ( "data" ) );
            jurnal.setCompleat ( resultSet.getBoolean ( "compleat" ) );
            jurnal.setKlientId ( resultSet.getLong ( "id_klient" ) );
            jurnal.setMasterId ( resultSet.getLong ( "id_master" ) );
            jurnal.setProductId ( resultSet.getLong ( "id_product" ) );

            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            e.printStackTrace ();
        } if (preparedStatement !=null){
            preparedStatement.close ();
        }
        if (connection != null){
            connection.close ();
        }
        return jurnal;
    }

    @Override
    public void update(Jurnal jurnal) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql ="UPDATE beauty_salon.jurnal SET idjurnal = ?, data = ?, compleat = ?, id_klient = ?, id_master = ?, id_product = ? WHERE (idjurnal = ?);";
        try {
            preparedStatement =connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,jurnal.getId ());
            preparedStatement.setDate ( 2,jurnal.getDate ());
            preparedStatement.setBoolean ( 3,jurnal.getCompleat ());
            preparedStatement.setLong ( 4,jurnal.getKlientId ());
            preparedStatement.setLong ( 5,jurnal.getMasterId ());
            preparedStatement.setLong ( 6,jurnal.getProductId ());
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
    public void remove(Jurnal jurnal) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql ="DELETE * FROM beauty_salon.jurnal WHERE idjurnal=?;";

        try {
            preparedStatement = connection.prepareStatement ( sql );

            preparedStatement.setLong ( 1,jurnal.getId () );

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
