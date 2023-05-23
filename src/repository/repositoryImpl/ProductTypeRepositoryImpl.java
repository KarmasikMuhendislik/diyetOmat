package repository.repositoryImpl;

import databaseconnection.DatabaseConnect;
import dto.request.ProductTypeRequest;
import dto.response.ProductTypeResponse;
import entity.ProductType;
import org.modelmapper.ModelMapper;
import repository.ProductTypeRepository;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class ProductTypeRepositoryImpl implements ProductTypeRepository {
    private Connection con= null;
    private ModelMapper modelMapper;

    public  ProductTypeRepositoryImpl() {
        modelMapper = new ModelMapper();
    }
    @Override
    public ProductType addProductType(ProductType productType) {
        con= DatabaseConnect.getConn();
        String sqlCommand ="Insert INTO product_type (typename, producttypename, productprimaryname) VALUES (?,?,?)";
        PreparedStatement preparedStatement = null;
        System.out.println("Product ekleme ");
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setString(1, productType.getTypeName());
            preparedStatement.setString(2, productType.getProductTypeName());
            preparedStatement.setString(3,productType.getProductPrimaryName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
            return  productType;
        }
        catch (SQLException ex){
            System.out.println("Ürün Eklenemedi: "+ex.getMessage());
        }

        return null;    }

    @Override
    public Boolean deleteProductType(int id) {
        String sqlCommand = "DELETE FROM public.product_type Where id = ?";
        con= DatabaseConnect.getConn();

        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setInt(1,id);
            var isTrue = (preparedStatement.executeUpdate()>0)? true : false;
            preparedStatement.close();
            con.close();
            return isTrue;

        } catch (SQLException ex) {
            System.out.println("Ürün Silinemed : " + ex.getMessage());
        }
        return null;    }

    @Override
    public ProductType getProductType(int id) {
        con= DatabaseConnect.getConn();

        String sqlCommand = "SELECT*FROM public.product_type  Where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            ProductType productType = null;

            while (resultSet.next()){
                productType = new ProductType();
                productType.setId(resultSet.getInt("id"));
                productType.setTypeName(resultSet.getString("typeName"));
                productType.setProductTypeName(resultSet.getString("productTypeName"));
                productType.setProductPrimaryName(resultSet.getString("productPrimaryName"));
            }
            preparedStatement.close();
            con.close();
            return productType;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getProductPrimaryName() {
        con= DatabaseConnect.getConn();

        String sqlCommand = "SELECT DISTINCT productprimaryname FROM public.product_type;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =  null;
        List<String> productPrimaryKeyList = new ArrayList();
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String key = resultSet.getString("productprimaryname");
                productPrimaryKeyList.add(key);
            }
            con.close();
            preparedStatement.close();
            return productPrimaryKeyList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Integer> getPrimaryName(String name) {
        con= DatabaseConnect.getConn();

        String sqlCommand ="SELECT*FROM public.product_type where productprimaryname = ?;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> productIdList = new ArrayList();
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer key = resultSet.getInt("id");
                productIdList.add(key);
            }
            con.close();
            preparedStatement.close();
            return productIdList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductType getProductTypeName(String name) {
        con= DatabaseConnect.getConn();
        String sqlCommand = "SELECT * FROM public.product_type WHERE typename = ?;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            ProductType productType = null;

            while (resultSet.next()){
                productType = new ProductType();
                productType.setId(resultSet.getInt("id"));
                productType.setTypeName(resultSet.getString("typeName"));
                productType.setProductTypeName(resultSet.getString("productTypeName"));
                productType.setProductPrimaryName(resultSet.getString("productPrimaryName"));
            }
            preparedStatement.close();
            con.close();
            return productType;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
