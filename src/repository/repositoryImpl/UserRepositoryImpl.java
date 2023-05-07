package repository.repositoryImpl;

import databaseconnection.DatabaseConnect;
import entity.User;
import repository.UserRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class UserRepositoryImpl implements UserRepository {
    private Connection con = DatabaseConnect.getConn();
    @Override
    public User addUser(User user) {
        String sqlCommand = "INSERT INTO public.userentity (gender, weight, height, age) VALUES(?, ?, ?, ?);";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setString(1,user.getGender());
            preparedStatement.setInt(2,user.getWeight());
            preparedStatement.setInt(3,user.getHeight());
            preparedStatement.setInt(4,user.getAge());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
