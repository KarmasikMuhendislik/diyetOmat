package repository.repositoryImpl;

import databaseconnection.DatabaseConnect;
import dto.request.ProductFeaturesRequest;
import dto.response.ProductFeaturesResponse;
import entity.ProductFeatures;
import org.modelmapper.ModelMapper;
import repository.ProductFeaturesRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductFeaturesRepositoryImpl implements ProductFeaturesRepository {
    private Connection con = DatabaseConnect.getConn();
    private ModelMapper modelMapper;
    public ProductFeaturesRepositoryImpl() {
        modelMapper = new ModelMapper();
    }

    public ProductFeatures addProductFeatures(ProductFeatures productFeatures) {
        String sqlCommand = "INSERT INTO public.product_features (productenergy, productcarbohydrate, productprotein, productoil) VALUES(?, ?, ?, ?);";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setString(1,productFeatures.getProductEnergy());
            preparedStatement.setString(2,productFeatures.getProductCarbohydrate());
            preparedStatement.setString(3,productFeatures.getProductProtein());
            preparedStatement.setString(4,productFeatures.getProductOil());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
            return productFeatures;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean deleteProductFeatures(int id) {
        String sqlCommand = "DELETE FROM public.product_features Where id = ?";
        String getEntity = "SELECT*FROM public.product_features Where id = ?";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setInt(1,id);
            var isTrue = (preparedStatement.executeUpdate()>0)? true : false;
            con.close();
            preparedStatement.close();
            return isTrue ;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public ProductFeatures getProductFeatures(int id) {
        String sqlCommand = "SELECT*FROM public.product_features Where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            ProductFeatures productFeatures = null;

            while (resultSet.next()){
                productFeatures = new ProductFeatures();
                productFeatures.setId(resultSet.getInt("id"));
                productFeatures.setProductEnergy(resultSet.getString("productEnergy"));
                productFeatures.setProductOil(resultSet.getString("productOil"));
                productFeatures.setProductCarbohydrate(resultSet.getString("productCarbohydrate"));
                productFeatures.setProductProtein(resultSet.getString("productProtein"));
            }
            con.close();
            preparedStatement.close();
            return productFeatures;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
