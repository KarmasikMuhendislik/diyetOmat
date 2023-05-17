package repository.repositoryImpl;

import databaseconnection.DatabaseConnect;
import entity.Product;
import entity.ProductFeatures;
import entity.ProductType;
import org.modelmapper.ModelMapper;
import repository.ProductRepository;

import javax.print.attribute.standard.MediaSize;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private Connection con = DatabaseConnect.getConn();
    private ModelMapper modelMapper;
    public ProductRepositoryImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public Product addProduct(Product product, ProductType productType, ProductFeatures productFeatures) {
        String sqlCommand ="INSERT INTO public.product (productname, productfee, product_type_id, product_features_id) VALUES( ?, ?, ?, ?);";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setInt(3,productType.getId());
            preparedStatement.setInt(2,product.getProductFee());
            preparedStatement.setInt(4,productFeatures.getId());
            Product entity = null;
            if(preparedStatement.executeUpdate()>0) {
                entity = new Product();
                entity.setProductName(product.getProductName());
                entity.setProductFeatures(product.getProductFeatures());
                entity.setProductFee(product.getProductFee());
                entity.setProductType(product.getProductType());
            }
            preparedStatement.close();
            con.close();
            return entity;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product>products = new ArrayList();
        String sqlCommand = "SELECT*From public.product";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setProductFee(resultSet.getInt("productfee"));
                product.setProductType(resultSet.getInt("product_type_id"));
                product.setProductFeatures(resultSet.getInt("product_features_id"));
                product.setProductName(resultSet.getString("productname"));
                products.add(product);
            }
            preparedStatement.close();
            con.close();
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Boolean deleteProduct(int id) {
        String sqlCommand = "DELETE FROM public.product Where id = ?";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setInt(1,id);
            var isTrue = (preparedStatement.executeUpdate()>0)? true : false;
            preparedStatement.close();
            con.close();
            return isTrue;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product getProduct(int id) {
        String sqlCommand = "SELECT*FROM public.product Where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            Product product = null;
            while(resultSet.next()){
                product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("productname"));
                product.setProductType(resultSet.getInt("product_type_id"));
                product.setProductFee(resultSet.getInt("productfee"));
                product.setProductFeatures(resultSet.getInt("product_features_id"));
            }
            preparedStatement.close();
            con.close();
            System.out.println(product.getProductName()+", "
                    +product.getProductType()+", " + product.getProductFee() +", "+product.getProductFeatures() );
            return product;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
