package com.xworkz.hospital.dao;

import com.xworkz.hospital.dto.PatientDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDAOImpl implements PatientDAO{
    @Override
    public boolean save(PatientDTO patientDTO) {
        System.out.println("The save the patient details:"+patientDTO);
        boolean isSaved = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The Driver is loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/Hospital_db";
        String user = "root";
        String password = "root";
        String sqlQuery = "insert into patient_info(Patient_name,Patient_age,P_admissionDate,P_dischargeDate,P_diseaseName) values (?,?,?,?,?)";

        try {
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("The connection is established successfully.");

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,patientDTO.getPatient_name());
            preparedStatement.setInt(2,patientDTO.getPatient_age());
            preparedStatement.setString(3,patientDTO.getP_diseaseName());
            preparedStatement.setString(4,patientDTO.getP_admissionDate());
            preparedStatement.setString(5,patientDTO.getP_dischargeDate());

            boolean check =  preparedStatement.execute();
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
    public boolean update(PatientDTO patientDTO) {
        System.out.println("The update patient details:" + patientDTO);
        boolean isUpdate = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        String sqlQuery = "update patient_info set p_dischargeDate = ?";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_db","root","root");
            System.out.println("The connection is build successfully.");

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, patientDTO.getP_dischargeDate());

            boolean check = preparedStatement.execute();
            isUpdate = check;

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

        return isUpdate;
    }

    @Override
    public boolean delete(PatientDTO patientDTO) {
        System.out.println("The patient detail is deleted :"+patientDTO);
        boolean isDelete = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver loaded successfully.");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        String sqlQuey = "delete from patient_info where patient_name = ?";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_db","root","root");
            System.out.println("The connection is build successfully.");

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuey);
            preparedStatement.setString(1, patientDTO.getPatient_name());

            boolean check = preparedStatement.execute(sqlQuey);
            isDelete = check;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDelete;
    }
}
