package com.pong.ping.repository;

import com.pong.ping.connection.DatabaseConnection;
import com.pong.ping.model.banque;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BanqueRepository implements Interface  <banque>{

    public banque findById(int toFind) {
        String SELECT_BY_ID_QUERY = "SELECT * FROM banque WHERE id = ?";
        Connection connection = DatabaseConnection.getConnection();
        banque result = new banque();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            preparedStatement.setInt(1, toFind);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                String name = resultSet.getString("Name");
                String code = resultSet.getString("code");
                result.setName(name);
                result.setCode(code);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }


    public List<banque> findAll() {
        List<banque> banques = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String SELECT_ALL_QUERY = "SELECT * FROM banque";
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                banque banque = new banque();
                String name = resultSet.getString("Name");
                String code = resultSet.getString("code");
                banque.setName(name);
                banque.setCode(code);
                banques.add(banque);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return banques;
    }


    public List<banque> saveAll(List<banque> toSave) {
        for(banque banque : toSave){
            save(banque);
        }
        return toSave;
    }


    public banque save(banque toSave) {
        String INSERT_QUERY = "INSERT INTO banque (Name, code) VALUES (?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, toSave.getName());
            preparedStatement.setString(2, toSave.getCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return toSave;
    }

}
