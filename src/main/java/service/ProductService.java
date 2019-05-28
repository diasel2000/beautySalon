package main.java.service;

import db.DataBaseConection;
import main.java.dao.PrductDAO;
import main.java.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService extends DataBaseConection implements PrductDAO {
    Connection connection = getConnection ();
    @Override
    public void add(Product product) throws SQLException {
        PreparedStatement preparedStatement =null;

        String sql ="INSERT INTO beauty_salon.product (id_product, product_name, price) VALUES (?, ?, ?);";
        try {
            preparedStatement =connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,product.getId ());
            preparedStatement.setString ( 2,product.getProductName ());
            preparedStatement.setFloat ( 3,product.getPrice ());

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
    public List<Product> getAll() throws SQLException {
        List<Product> productList = new ArrayList<> (  );

        String sql ="SELECT * FROM beauty_salon.product;";
        Statement statement =null;
        try {
            statement = connection.createStatement ();
            ResultSet resultSet = statement.executeQuery ( sql );
            while (resultSet.next ()){
                Product product =new Product ();
                product.setId ( resultSet.getLong ( "id_product" ) );
                product.setProductName ( resultSet.getString ( "product_name" ) );
                product.setPrice ( resultSet.getFloat ( "price" ) );
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
        return productList;
    }

    @Override
    public Product getAllById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql ="SELECT * FROM beauty_salon.product WHERE id_product;";

        Product product = new Product ();
        try {
            preparedStatement = connection.prepareStatement ( sql );
            preparedStatement.setLong ( 1,id );

            ResultSet resultSet = preparedStatement.executeQuery ();

            product.setId ( resultSet.getLong ( "id_product" ) );
            product.setProductName ( resultSet.getString ( "product_name" ) );
            product.setPrice ( resultSet.getFloat ( "price" ) );


            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            e.printStackTrace ();
        } if (preparedStatement !=null){
            preparedStatement.close ();
        }
        if (connection != null){
            connection.close ();
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
    public void remove(Product product) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql ="DELETE * FROM beauty_salon.jurnal WHERE idjurnal;";

        try {
            preparedStatement = connection.prepareStatement ( sql );

            preparedStatement.setLong ( 1,product.getId () );

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
