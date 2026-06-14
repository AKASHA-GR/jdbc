package com.xworkz.hospital.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PatientDTO implements Serializable {
    private String patient_name;
    private int patient_age;
    private String p_diseaseName;
    private String p_admissionDate;
    private String p_dischargeDate;
}
