package service;

import db.DataBaseConection;
import main.java.dao.JurnalDAO;

import main.java.entity.Jurnal;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JurnalService extends DataBaseConection implements JurnalDAO {
    private static final Logger LOG = Logger.getLogger ( JurnalService.class );
    Connection connection = getConnection ();

    @Override
    public void add(Jurnal jurnal) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO jurnal (idjurnal, data, compleat, id_klient, id_master, id_product) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            preparedStatement = connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1, jurnal.getId () );
            preparedStatement.setDate ( 2, jurnal.getDate () );
            preparedStatement.setBoolean ( 3, jurnal.getCompleat () );
            preparedStatement.setLong ( 4, jurnal.getKlientId () );
            preparedStatement.setLong ( 5, jurnal.getMasterId () );
            preparedStatement.setLong ( 6, jurnal.getProductId () );
        } catch (SQLException e) {
            LOG.error("Some problem with add to jurnal \n" + e);
        }
    }

    @Override
    public List<Jurnal> getAll() throws SQLException {
        List<Jurnal> jurnalList = new ArrayList<> ();

        String sql = "SELECT (idjurnal, data, compleat, id_klient, id_master, id_product) FROM jurnal;";
        Statement statement = null;
        try {
            statement = connection.createStatement ();
            ResultSet resultSet = statement.executeQuery ( sql );
            while (resultSet.next ()) {
                Jurnal jurnal = new Jurnal ();
                jurnal.setId ( resultSet.getLong ( "idjurnal" ) );
                jurnal.setDate ( resultSet.getDate ( "data" ) );
                jurnal.setCompleat ( resultSet.getBoolean ( "compleat" ) );
                jurnal.setKlientId ( resultSet.getLong ( "id_klient" ) );
                jurnal.setMasterId ( resultSet.getLong ( "id_master" ) );
                jurnal.setProductId ( resultSet.getLong ( "id_product" ) );
            }
        } catch (SQLException e) {
            LOG.error("Some problem with get info from jurnal(DB) \n" + e);
        }
        return jurnalList;
    }

    @Override
    public Jurnal getAllById(Long id, Long klientId, Long masterId, Long productId) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT (idjurnal, data, compleat, id_klient, id_master, id_product) FROM jurnal WHERE idjurnal=? and id_klient=? and id_master=? and id_product=?;";

        Jurnal jurnal = new Jurnal ();
        try {
            preparedStatement = connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1, id );
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
            LOG.error("Some problem with ID select \n" + e);
        }
        return jurnal;
    }

    @Override
    public void update(Jurnal jurnal) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE jurnal SET idjurnal = ?, data = ?, compleat = ?, id_klient = ?, id_master = ?, id_product = ? WHERE (idjurnal = ?);";
        try {
            preparedStatement = connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1, jurnal.getId () );
            preparedStatement.setDate ( 2, jurnal.getDate () );
            preparedStatement.setBoolean ( 3, jurnal.getCompleat () );
            preparedStatement.setLong ( 4, jurnal.getKlientId () );
            preparedStatement.setLong ( 5, jurnal.getMasterId () );
            preparedStatement.setLong ( 6, jurnal.getProductId () );
        } catch (SQLException e) {
            LOG.error("Some problem with connection update jurnal \n" + e);
        }

    }

    @Override
    public void remove(Jurnal jurnal) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE * FROM jurnal WHERE idjurnal=?;";
        try {
            preparedStatement = connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1, jurnal.getId () );
            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            LOG.error("Some problem with delete from jurnal DB \n" + e);
        }
    }
}
