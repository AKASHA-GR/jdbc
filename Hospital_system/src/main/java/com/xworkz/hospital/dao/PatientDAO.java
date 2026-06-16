package com.xworkz.hospital.dao;

import com.xworkz.hospital.dto.PatientDTO;

public interface PatientDAO {
    boolean save(PatientDTO patientDTO);
    boolean update(PatientDTO patientDTO);
    boolean delete(PatientDTO patientDTO);


    int insertPatient(String patient_name,int patient_age,String p_diseaseName,String p_admissionDate,String p_dischargeDate);
    int updateByName(String patient_name,int patient_age);
    int deleteByName(String patient_name);
    PatientDTO selectPatientByAge(int patient_age);

}
