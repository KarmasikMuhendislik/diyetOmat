package repository.repositoryImpl;
import databaseconnection.DatabaseConnect;
import repository.MoneyRepository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MoneyRepositoryImpl implements MoneyRepository {
    private Connection con = DatabaseConnect.getConn();

    @Override
    public int addMoney(int moneyAmount) {
       // String sqlCommand = "INSERT INTO public.moneyentity(moneyamount)VALUES(?);";
        String sqlCommand = "UPDATE public.moneyentity SET moneyamount= ? WHERE id = 1;";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setInt(1,moneyAmount);
            preparedStatement.executeUpdate();
            con.close();
            preparedStatement.close();
            return moneyAmount;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int getMoney() {
        String sqlCommand ="SELECT*FROM public.moneyentity WHERE id = 1;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            resultSet = preparedStatement.executeQuery();
            int money =  0;
            while (resultSet.next()){
                money = resultSet.getInt("moneyamount");
            }
            con.close();
            preparedStatement.close();
            return money;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int cashOut(int moneyAmount) {
        String sqlCommand = "UPDATE public.moneyentity SET moneyamount= ? WHERE id = 1;";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setInt(1,moneyAmount);
            con.close();
            preparedStatement.close();
            return moneyAmount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
