package com.xworkz.institute.dao.impl;

import com.xworkz.institute.dao.TraineeDAO;
import com.xworkz.institute.dto.TraineeDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TraineeDAOImpl implements TraineeDAO {

    @Override
    public String batchInsert(List<TraineeDTO> traineeDTOS) {
        System.out.println("The values are the inserted:"+traineeDTOS);

        String isInserted = null;
        Connection connection = null;
        String sqlQuery = "insert into trainee_info(trainee_id,trainee_name,trainee_NO,trainee_email,trainee_dept) values(?,?,?,?,?)";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded successfully.");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute_db","root","root");
            System.out.println("The connection is established.");

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            for(TraineeDTO ref:traineeDTOS){
                preparedStatement.setInt(1,ref.getTrainee_id());
                preparedStatement.setString(2,ref.getTrainee_name());
                preparedStatement.setLong(3,ref.getTrainee_NO());
                preparedStatement.setString(4,ref.getTrainee_email());
                preparedStatement.setString(5,ref.getTrainee_dept());
                preparedStatement.addBatch();
                System.out.println(ref.getTrainee_name()+" is Inserted.");
            }

            preparedStatement.executeBatch();



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        isInserted = "Data inserted.";

        return isInserted;
    }




    @Override
    public String batchUpdate(List<TraineeDTO> traineeDTOS) {
        System.out.println("The values are the updated:"+traineeDTOS);

        String isUpdated = null;
        Connection connection = null;
        String sqlQuery1 = "UPDATE trainee_info set trainee_email = ? where trainee_id = ?";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded successfully.");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute_db","root","root");
            System.out.println("The connection is established.");

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery1);

            for(TraineeDTO ref:traineeDTOS){
                preparedStatement.setInt(2,ref.getTrainee_id());
                preparedStatement.setString(1,ref.getTrainee_email());

                preparedStatement.addBatch();
                System.out.println("Id "+ref.getTrainee_id()+" is updated.");
            }

            preparedStatement.executeBatch();



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        isUpdated = "Data updated.";

        return isUpdated;
    }




    @Override
    public String batchDelete(List<TraineeDTO> traineeDTOS) {
        System.out.println("The values are the deleted:"+traineeDTOS);

        String isDeleted = null;
        Connection connection = null;
        String sqlQuery1 = "DELETE FROM trainee_info WHERE trainee_id = ?";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded successfully.");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute_db","root","root");
            System.out.println("The connection is established.");

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery1);

            for(TraineeDTO ref:traineeDTOS){
                preparedStatement.setInt(1,ref.getTrainee_id());

                preparedStatement.addBatch();
                System.out.println("Id "+ref.getTrainee_id()+" is Deleted.");
            }

            preparedStatement.executeBatch();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        isDeleted = "Data updated.";

        return isDeleted;
    }





    @Override
    public List<TraineeDTO> getTraineeList() {
        System.out.println("list of trainee details:");

        List<TraineeDTO> arrayList = new ArrayList<>();
        TraineeDTO traineeDTO = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute_db","root","root");
            System.out.println("The connection is established.");

            preparedStatement = connection.prepareStatement("SELECT* from trainee_info");
            System.out.println("The preparestament is created.");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                traineeDTO = new TraineeDTO();

                traineeDTO.setTrainee_id(resultSet.getInt("trainee_id"));
                traineeDTO.setTrainee_name(resultSet.getString("trainee_name"));
                traineeDTO.setTrainee_NO(resultSet.getLong("trainee_NO"));
                traineeDTO.setTrainee_email(resultSet.getString("trainee_email"));
                traineeDTO.setTrainee_dept(resultSet.getString("trainee_dept"));
                arrayList.add(traineeDTO);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return arrayList;
    }
}
