package com.xworkz.taxi.dao;

import com.xworkz.taxi.dto.TaxiDetailsDTO;

public interface TaxiDAO {
    boolean save(TaxiDetailsDTO taxiDetailsDTO);
    boolean update(TaxiDetailsDTO taxiDetailsDTO);
    boolean delete(TaxiDetailsDTO taxiDetailsDTO);

    int insert(String driverName,String carModel,int vehicleNo,String licencePlate,int farePerKM);
    int updateByLicencePlate(String licencePlate,int farePerKm);
    int deleteByName(String driverName);
    TaxiDetailsDTO select();
}
