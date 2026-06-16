package com.xworkz.hospital.dao.impl;

import com.xworkz.hospital.dao.PatientDAO;
import com.xworkz.hospital.dto.PatientDTO;

import java.sql.*;

public class PatientDAOImpl implements PatientDAO {
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
        String sqlQuery = "DELETE FROM patient_info WHERE p_admissionDate = ?";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_db","root","root");
            System.out.println("The connection is build successfully.");

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, patientDTO.getP_diseaseName());

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



    @Override
    public int insertPatient(String patient_name,int patient_age,String p_diseaseName,String p_admissionDate,String p_dischargeDate) {
        System.out.println("the patient details:"+patient_name+""+patient_age+""+p_diseaseName+""+p_admissionDate+""+p_dischargeDate);
        int n = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        String sqlQuery = "insert into patient_info(patient_name,patient_age,p_diseaseName,p_admissionDate,p_dischargeDate) values (?,?,?,?,?)";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_db","root","root");
            System.out.println("The connection is build successfully.");

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,patient_name);
            preparedStatement.setInt(2,patient_age);
            preparedStatement.setString(3,p_diseaseName);
            preparedStatement.setString(4,p_admissionDate);
            preparedStatement.setString(5,p_dischargeDate);

            int check = preparedStatement.executeUpdate();
            n = check;

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

        return n;
    }



    @Override
    public int updateByName(String patient_name, int patient_age) {
        System.out.println("----update by name---");
        System.out.println("The name is:"+patient_name+""+"patient_age:"+patient_age);
        int isUpdate = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        String sqlQuery = "UPDATE patient_info set patient_age = ? where patient_name = ?";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_db","root","root");
            System.out.println("The connection is build successfully.");

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,patient_age);
            preparedStatement.setString(2,patient_name);

            int check = preparedStatement.executeUpdate();
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
    public int deleteByName(String patient_name) {
        System.out.println("------Delete by name-----");
        System.out.println("The name is:"+patient_name);

        int isDelete = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sqlQuery = "DELETE from patient_info where patient_name = ?";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_db","root","root");
            System.out.println("The connection is build successfully.");

            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,patient_name);

            int check = preparedStatement.executeUpdate();
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



    @Override
    public PatientDTO selectPatientByAge(int patient_age) {
        System.out.println("The select patient By Age:"+patient_age);

        PatientDTO patientDTO = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sqlQuery ="SELECT* From patient_info where patient_age = ?";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_db","root","root");
            System.out.println("The connection is build successfully.");

            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,"patient_age");
            resultSet = preparedStatement.executeQuery();


            if(resultSet.next()){
                patientDTO = new PatientDTO();

                patientDTO.setPatient_name(resultSet.getString("patient_name"));
                patientDTO.setPatient_age(resultSet.getInt("patient_age"));
                patientDTO.setP_diseaseName(resultSet.getString("p_diseaseName"));
                patientDTO.setP_admissionDate(resultSet.getString("p_admissionDate"));
                patientDTO.setP_dischargeDate(resultSet.getString("p_dischargeDate"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection != null & resultSet != null){
                try {
                    connection.close();
                    resultSet.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        return patientDTO;
    }
}
