package com.xworkz.institute.service.imlp;

import com.xworkz.institute.dao.TraineeDAO;
import com.xworkz.institute.dto.TraineeDTO;
import com.xworkz.institute.service.TraineeService;

import java.util.List;
import java.util.Objects;

public class TraineeServiceImpl implements TraineeService {

    TraineeDAO traineeDAO;

    @Override
    public String batchInsert(List<TraineeDTO> traineeDTOS) {
        if(Objects.nonNull(traineeDAO) && traineeDTOS.getTrainee_id() > 1 && traineeDTO.getTrainee_name() != null && traineeDTO.getTrainee_NO()>=10 && traineeDTO.getTrainee_email() != null && traineeDTO.getTrainee_dept() != null){
            return traineeDAO.batchInsert(traineeDTOS);
        }
        return false;
    }
}
