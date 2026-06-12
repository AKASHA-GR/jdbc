package com.xworkz.taxi.dao;

import com.xworkz.taxi.dto.TaxiDetailsDTO;

public interface TaxiDAO {
    boolean save(TaxiDetailsDTO taxiDetailsDTO);

    boolean update(TaxiDetailsDTO taxiDetailsDTO);

    boolean delete(TaxiDetailsDTO taxiDetailsDTO);
}
