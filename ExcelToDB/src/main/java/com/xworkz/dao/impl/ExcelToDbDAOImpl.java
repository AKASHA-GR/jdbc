package com.xworkz.dao.impl;

import org.apache.poi.ss.usermodel.Row;
import com.xworkz.dao.ExcelToDbDAO;
import com.xworkz.dto.ExcelToDbDTO;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ExcelToDbDAOImpl implements ExcelToDbDAO {
    @Override
    public List<ExcelToDbDTO> readExcel(String filePath) {
        List<ExcelToDbDTO> list = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("E:\\jdbc\\ExcelToDB\\software.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                if (row.getRowNum() == 0) {
                    continue;
                }

                int id = (int) row.getCell(0).getNumericCellValue();
                String software = row.getCell(1).getStringCellValue();
                double current_version = row.getCell(2).getNumericCellValue();
                int developed_year = (int) row.getCell(3).getNumericCellValue();
                String developed_by = row.getCell(4).getStringCellValue();
                String open_source = row.getCell(5).getStringCellValue();

                ExcelToDbDTO dto = new ExcelToDbDTO(id, software,current_version, developed_year, developed_by, open_source);

                list.add(dto);
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean saveAll(List<ExcelToDbDTO> softwareList) {

        boolean isSaved = false;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/software_db",
                            "root",
                            "root");

            String sql = "INSERT INTO software_table(id,software,current_version,developed_year,developed_by,open_source) VALUES(?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (ExcelToDbDTO dto : softwareList) {

                preparedStatement.setInt(1, dto.getId());
                preparedStatement.setString(2, dto.getSoftware());
                preparedStatement.setDouble(3, dto.getCurrent_version());
                preparedStatement.setInt(4, dto.getDeveloped_year());
                preparedStatement.setString(5, dto.getDeveloped_by());
                preparedStatement.setString(6, dto.getOpen_source());

                preparedStatement.addBatch();
            }

            int[] result = preparedStatement.executeBatch();

            if (result.length > 0) {
                isSaved = true;
            }

            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSaved;
    }
}
