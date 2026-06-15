package com.xworkz.hospital.dao;

import com.xworkz.hospital.dto.PatientDTO;

public interface PatientDAO {
    boolean save(PatientDTO patientDTO);

    boolean update(PatientDTO patientDTO);

    boolean delete(PatientDTO patientDTO);

    int insertPatient(String patient_name,int patient_age,String p_diseaseName,String p_admissionDate,String p_dischargeDate);

    PatientDTO selectPatientByAge(int patient_age);

}
