package com.xworkz.hospital.runner;

import com.xworkz.hospital.dao.PatientDAO;
import com.xworkz.hospital.dao.PatientDAOImpl;
import com.xworkz.hospital.dto.PatientDTO;

public class Runner {
    public static void main(String[] args) {
        PatientDAO patientDAO = new PatientDAOImpl();

        PatientDTO patientDTO = new PatientDTO();

        patientDTO.setPatient_name("Govinda");
        patientDTO.setPatient_age(36);
        patientDTO.setP_diseaseName("Kidney Stone");
        patientDTO.setP_admissionDate("8-1-2025");
        patientDTO.setP_dischargeDate("2-2-2026");

        //save
        boolean saved = patientDAO.save(patientDTO);
        System.out.println("The patient date is saved:"+saved);


        PatientDTO patientDTO1 = new PatientDTO();
        patientDTO1.setP_dischargeDate("00-00-0000");

        //update
        boolean updated = patientDAO.update(patientDTO1);
        System.out.println("The patient date is updated:"+updated);

        PatientDTO patientDTO2 = new PatientDTO();
        patientDTO2.setP_diseaseName("Kidney Stone");

        //delete
        boolean deleted = patientDAO.delete(patientDTO2);
        System.out.println("The patient date is Deleted:"+deleted);


        //exicuteUpdate

        int insertPatient = patientDAO.insertPatient("Varun",25,"Head pain","02-8-2025","04-8-2025");
        System.out.println("The patient detailes are inserted:"+insertPatient);

        //selectbyage
        PatientDTO patientDTO3 = patientDAO.selectPatientByAge(25);
        System.out.println("Patient details:"+patientDTO3);
    }
}
