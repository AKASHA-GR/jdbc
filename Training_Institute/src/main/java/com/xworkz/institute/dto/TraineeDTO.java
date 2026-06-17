package com.xworkz.institute.dto;

import lombok.*;

import java.io.Serializable;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TraineeDTO implements Serializable {
    private int trainee_id;
    private String trainee_name;
    private long trainee_NO;
    private String trainee_email;
    private String trainee_dept;
}
