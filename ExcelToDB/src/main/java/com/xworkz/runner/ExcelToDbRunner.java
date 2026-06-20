package com.xworkz.runner;

import com.xworkz.dao.ExcelToDbDAO;
import com.xworkz.dao.impl.ExcelToDbDAOImpl;
import com.xworkz.dto.ExcelToDbDTO;

import java.util.List;

public class ExcelToDbRunner {
    public static void main(String[] args) {
        ExcelToDbDAO dao = new ExcelToDbDAOImpl();

        List<ExcelToDbDTO> list =
                dao.readExcel("software.xlsx");

        for (ExcelToDbDTO dto : list) {
            System.out.println(dto);
        }

        System.out.println("Records Read: " + list.size());

        boolean saved = dao.saveAll(list);

        System.out.println(saved);
    }
}
