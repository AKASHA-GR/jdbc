package com.xworkz.dao;

import com.xworkz.dto.ExcelToDbDTO;

import java.util.List;

public interface ExcelToDbDAO {
    List<ExcelToDbDTO> readExcel(String filePath);

    boolean saveAll(List<ExcelToDbDTO> softwareList);

}
