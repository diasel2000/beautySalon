package service;

import db.DataBaseConection;
import main.java.dao.PrductDAO;
import main.java.entity.Product;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class ProductService extends DataBaseConection implements PrductDAO {
    private static final Logger LOG = Logger.getLogger(ProductService.class);
    Connection connection = getConnection ();

    @Override
    public void add(Product product) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql ="INSERT INTO product ( product_name, price) VALUES (?, ?);";
        try {
            preparedStatement =connection.prepareStatement ( sql );

            preparedStatement.setString ( 1,product.getProductName ());
            preparedStatement.setFloat ( 2,product.getPrice ());

        }catch (SQLException e){LOG.error("Some problem with product add \n" + e);}

    }

    @Override
    public  List<Product> getAll() throws SQLException {
        List<Product> productList = new ArrayList<> (  );

        String sql ="SELECT * FROM product;";
        Statement statement =null;
        try {
            statement = connection.createStatement ();
            ResultSet resultSet = statement.executeQuery ( sql );
            while (resultSet.next ()){
                Product product =new Product ();
                product.setProductName ( resultSet.getString ( "product_name" ) );
                product.setPrice ( resultSet.getFloat ( "price" ) );
            }
        } catch (SQLException e) {
            LOG.error("Some problem with products get \n" + e);
        }
        return productList;
    }

    @Override
    public Product getAllById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql ="SELECT * FROM product WHERE id_product;";

        Product product = new Product ();
        try {
            preparedStatement = connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,id );

            ResultSet resultSet = preparedStatement.executeQuery ();
            product.setProductName ( resultSet.getString ( "product_name" ) );
            product.setPrice ( resultSet.getFloat ( "price" ) );


           int i= preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            LOG.error("Some problem with product ID  \n" + e);
        }
        return product;
    }

    @Override
    public void update(Product product) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql ="UPDATE beauty_salon.product SET id_product = ?, product_name = ?, price = ? WHERE (id_product = ?);";
        try {
            preparedStatement =connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,product.getId ());
            preparedStatement.setString ( 2,product.getProductName ());
            preparedStatement.setFloat ( 3,product.getPrice ());
        }catch (SQLException e){LOG.error("Some problem with update in product \n" + e);}
    }

    @Override
    public void remove(Product product) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql ="DELETE * FROM jurnal WHERE idjurnal;";

        try {
            preparedStatement = connection.prepareStatement ( sql );

            preparedStatement.setLong ( 1,product.getId () );

            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            LOG.error("Some problem with delate product \n" + e);
        }
    }
}
