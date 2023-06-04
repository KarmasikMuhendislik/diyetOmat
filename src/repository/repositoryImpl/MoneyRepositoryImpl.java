package repository.repositoryImpl;
import databaseconnection.DatabaseConnect;
import repository.MoneyRepository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MoneyRepositoryImpl implements MoneyRepository {
    private Connection con = null;

    @Override
    public double addMoney(double moneyAmount) {
        con = DatabaseConnect.getConn();
       // String sqlCommand = "INSERT INTO public.moneyentity(moneyamount)VALUES(?);";
        String sqlCommand = "UPDATE public.moneyentity SET moneyamount= ? WHERE id = 1;";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setDouble(1,moneyAmount);
            preparedStatement.executeUpdate();
            con.close();
            preparedStatement.close();
            return moneyAmount;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public double getMoney() {
        con = DatabaseConnect.getConn();
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
    public double cashOut(double moneyAmount) {
        con = DatabaseConnect.getConn();
        String sqlCommand = "UPDATE public.moneyentity SET moneyamount= ? WHERE id = 1;";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setDouble(1,moneyAmount);
            con.close();
            preparedStatement.close();
            return moneyAmount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
