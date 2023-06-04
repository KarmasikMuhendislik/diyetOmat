package repository.repositoryImpl;

import databaseconnection.DatabaseConnect;
import entity.HungerLevel;
import repository.HungerLevelRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HungerLevelRepositoryImpl implements HungerLevelRepository {
    private Connection con =null;
    @Override
    public HungerLevel addHungerLevel(HungerLevel hungerLevel) {
        con = DatabaseConnect.getConn();
        String sqlCommand = "INSERT INTO public.hungerlevel (name, energy)VALUES(?, ?);";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setString(1,hungerLevel.getName());
            preparedStatement.setDouble(2,hungerLevel.getEnergy());
            preparedStatement.executeUpdate();
            con.close();
            preparedStatement.close();
            return hungerLevel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean deleteHungerLevel(int id) {
        con = DatabaseConnect.getConn();
        String sqlCommand = "DELETE FROM public.hungerlevel WHERE id= ?;";
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
    public HungerLevel getHungerLevel(int id)
    {
        con = DatabaseConnect.getConn();
        //String sqlCommand = "UPDATE public.hungerlevel SET name = ?, energy = 0  WHERE id = ?;";
        String sqlCommand = "SELECT id, name, energy FROM public.hungerlevel Where id = ?;";
        PreparedStatement preparedStatement =  null;
        ResultSet resultSet = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            HungerLevel hungerLevel =null;
            while (resultSet.next()){
                hungerLevel = new HungerLevel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("energy")
                );
            }
            return hungerLevel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<HungerLevel> getAll() {
        con = DatabaseConnect.getConn();
        String sqlCommand = "SELECT*FROM public.hungerlevel;";
        List<HungerLevel> hungerLevelsList = new ArrayList();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = con.prepareStatement(sqlCommand);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                HungerLevel hungerLevel = new HungerLevel();
                hungerLevel.setId(resultSet.getInt("id"));
                hungerLevel.setName(resultSet.getString("name"));
                hungerLevel.setEnergy(resultSet.getDouble("energy"));
                hungerLevelsList.add(hungerLevel);
            }
            preparedStatement.close();
            con.close();
            return hungerLevelsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
