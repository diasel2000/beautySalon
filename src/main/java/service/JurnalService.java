package main.java.service;

import main.java.dao.JurnalDAO;
import main.java.db.DataBaseConection;
import main.java.entity.Jurnal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JurnalService extends DataBaseConection implements JurnalDAO {

    Connection connection = getConnection ();
    @Override
    public void add(Jurnal jurnal) {
        PreparedStatement preparedStatement =null;

        String sql ="INSERT INTO `beauty_salon`.`jurnal` (`idjurnal`, `data`, `compleat`, `id_klient`, `id_master`, `id_product`) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            preparedStatement =connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,jurnal.getId ());
            preparedStatement.setDate ( 2,jurnal.getDate ());
            preparedStatement.setBoolean ( 3,jurnal.getCompleat ());
            preparedStatement.setLong ( 4,jurnal.getKlientId ());
            preparedStatement.setLong ( 5,jurnal.getMasterId ());
            preparedStatement.setLong ( 6,jurnal.getProductId ());
        }catch (SQLException e){e.printStackTrace ();}
    }

    @Override
    public List<Jurnal> getAll() {
        return null;
    }

    @Override
    public Jurnal getAllById(Long id, Long klientId, Long masterId, Long productId) {
        return null;
    }

    @Override
    public void update(Jurnal jurnal) {

    }

    @Override
    public void remove(Jurnal jurnal) {

    }
}
