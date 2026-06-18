package com.xworkz.institute.service;

import com.xworkz.institute.dto.TraineeDTO;

import java.util.List;

public interface TraineeService {
    public boolean batchInsert(List<TraineeDTO> traineeDTOS);
}
