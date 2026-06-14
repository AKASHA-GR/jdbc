package com.xworkz.hospital.dao;

import com.xworkz.hospital.dto.PatientDTO;

public interface PatientDAO {
    boolean save(PatientDTO patientDTO);

    boolean update(PatientDTO patientDTO);

    boolean delete(PatientDTO patientDTO);
}
