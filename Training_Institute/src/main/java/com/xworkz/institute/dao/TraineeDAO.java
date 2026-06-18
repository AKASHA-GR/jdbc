package com.xworkz.institute.dao;

import com.xworkz.institute.dto.TraineeDTO;

import java.util.List;

public interface TraineeDAO {
    String batchInsert(List<TraineeDTO> traineeDTOS);
    String batchUpdate(List<TraineeDTO> traineeDTOS);
    String batchDelete(List<TraineeDTO> traineeDTOS);
    List<TraineeDTO> getTraineeList();
}
