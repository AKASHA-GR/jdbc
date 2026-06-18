package com.xworkz.institute.runner;

import com.xworkz.institute.dao.TraineeDAO;
import com.xworkz.institute.dao.impl.TraineeDAOImpl;
import com.xworkz.institute.dto.TraineeDTO;

import java.util.ArrayList;
import java.util.List;

public class TraineeRunner {
    public static void main(String[] args) {
        TraineeDAO traineeDAO = new TraineeDAOImpl();

        List<TraineeDTO> ref = traineeDAO.getTraineeList();

        for(TraineeDTO check:ref){
            System.out.println(check);
        }

        List<TraineeDTO> traineeDTOList = new ArrayList<>();

        TraineeDTO traineeDTO = new TraineeDTO();
        traineeDTO.setTrainee_id(4);
        traineeDTO.setTrainee_name("Harish");
        traineeDTO.setTrainee_NO(4837472847L);
        traineeDTO.setTrainee_email("harish@gmail.com");
        traineeDTO.setTrainee_dept("CSE");


        TraineeDTO traineeDTO1 = new TraineeDTO();
        traineeDTO1.setTrainee_id(5);
        traineeDTO1.setTrainee_name("Nagaprjwal");
        traineeDTO1.setTrainee_NO(9340923846L);
        traineeDTO1.setTrainee_email("naga@gmail.com");
        traineeDTO1.setTrainee_dept("CSE");


        TraineeDTO traineeDTO2 = new TraineeDTO();
        traineeDTO2.setTrainee_id(6);
        traineeDTO2.setTrainee_name("varun");
        traineeDTO2.setTrainee_NO(3498672374L);
        traineeDTO2.setTrainee_email("varun@gmail.com");
        traineeDTO2.setTrainee_dept("AIML");

        traineeDTOList.add(traineeDTO);
        traineeDTOList.add(traineeDTO1);
        traineeDTOList.add(traineeDTO2);

        traineeDAO.batchInsert(traineeDTOList);


        List<TraineeDTO> traineeDTOS = new ArrayList<>();

        TraineeDTO traineeDTO3 = new TraineeDTO();
        traineeDTO3.setTrainee_id(1);
        traineeDTO3.setTrainee_email("akash@gmail.com");

        TraineeDTO traineeDTO4 = new TraineeDTO();
        traineeDTO4.setTrainee_id(2);
        traineeDTO4.setTrainee_email("krishna@gmail.com");

        TraineeDTO traineeDTO5 = new TraineeDTO();
        traineeDTO5.setTrainee_id(3);
        traineeDTO5.setTrainee_email("prateek@gmail.com");

        traineeDTOS.add(traineeDTO3);
        traineeDTOS.add(traineeDTO4);
        traineeDTOS.add(traineeDTO5);

        traineeDAO.batchUpdate(traineeDTOS);

    }
}
