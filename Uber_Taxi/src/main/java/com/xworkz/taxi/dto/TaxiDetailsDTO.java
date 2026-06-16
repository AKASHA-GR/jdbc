package com.xworkz.taxi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TaxiDetailsDTO {


    private String driverName;
    private String carModel;
    private int vehicleNo;
    private String licencePlate;
    private double farePerKM;

}
