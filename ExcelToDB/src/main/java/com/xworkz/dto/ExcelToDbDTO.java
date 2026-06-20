package com.xworkz.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class ExcelToDbDTO implements Serializable {
    private int id;
    private String software;
    private double current_version;
    private  int developed_year;
    private String developed_by;
    private String open_source;
}
