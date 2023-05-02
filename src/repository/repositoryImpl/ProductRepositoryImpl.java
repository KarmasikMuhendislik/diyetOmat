package repository.repositoryImpl;

import databaseconnection.DatabaseConnect;
import dto.request.ProductTypeRequest;
import dto.response.ProductResponse;
import dto.request.ProductRequest;
import dto.response.ProductTypeResponse;
import repository.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepositoryImpl implements ProductRepository {
    private Connection con = DatabaseConnect.getConn();
    @Override
    public ProductResponse productAdd(ProductRequest productRequest) {
        return null;
    }

    @Override
    public ProductTypeResponse productTypeAdd(ProductTypeRequest productTypeRequest) throws SQLException {

        String sqlCommand ="Insert INTO product_type (typeName, productTypeName) VALUES (?,?)";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setString(1, productTypeRequest.getTypeName());
            preparedStatement.setString(2, productTypeRequest.getProductTypeName());
            int rows = preparedStatement.executeUpdate();

            if (rows>1){
                return  new ProductTypeResponse( productTypeRequest.getTypeName(),productTypeRequest.getProductTypeName());
            }
            preparedStatement.close();
            con.close();
        }
        catch (SQLException ex){
            System.out.println("Ürün Eklenemedi: "+ex.getMessage());
        }

        return null;
    }


}
