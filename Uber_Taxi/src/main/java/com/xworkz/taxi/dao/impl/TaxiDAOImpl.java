package com.xworkz.taxi.dao.impl;

import com.xworkz.taxi.dao.TaxiDAO;
import com.xworkz.taxi.dto.TaxiDetailsDTO;

import java.sql.*;

public class TaxiDAOImpl implements TaxiDAO {
    @Override
    public boolean save(TaxiDetailsDTO taxiDetailsDTO) {
        System.out.println("The taxi details are saved:"+taxiDetailsDTO);
        boolean isSaved = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded successfully.");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        String sqlQuery = "Insert into taxidetails(driverName,carModel,vehicleNo,licencePlate,farePerKM) values (?,?,?,?,?)";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_db","root","root");

            PreparedStatement preparedStatement =  connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, taxiDetailsDTO.getDriverName());
            preparedStatement.setString(2, taxiDetailsDTO.getCarModel());
            preparedStatement.setInt(3, taxiDetailsDTO.getVehicleNo());
            preparedStatement.setString(4, taxiDetailsDTO.getLicencePlate());
            preparedStatement.setDouble(5, taxiDetailsDTO.getFarePerKM());

            boolean check = preparedStatement.execute();
            isSaved = check;

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

        return isSaved;
    }

    @Override
    public boolean update(TaxiDetailsDTO taxiDetailsDTO) {
        System.out.println("The taxi details are updated:"+taxiDetailsDTO);
        boolean isUpdated = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        String sqlQuery = "update taxidetails set carModel = ?, farePerKM = ? where vehicleNo = ?";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_db","root","root");
            System.out.println("The connection is Built successfully.");

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, taxiDetailsDTO.getCarModel());
            preparedStatement.setDouble(2, taxiDetailsDTO.getFarePerKM());
            preparedStatement.setInt(3, taxiDetailsDTO.getVehicleNo());

            boolean check = preparedStatement.execute();
            isUpdated = check;

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


        return isUpdated;
    }

    @Override
    public boolean delete(TaxiDetailsDTO taxiDetailsDTO) {
        System.out.println("The taxi details are delete:"+taxiDetailsDTO);
        boolean isDelete = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        String sqlQuery = "delete from taxidetails where vehicleNo = ?";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_db","root","root");
            System.out.println("The connection is Built successfully.");

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, taxiDetailsDTO.getVehicleNo());

            boolean check = preparedStatement.execute();
            isDelete = check;

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
        return isDelete;
    }
}
