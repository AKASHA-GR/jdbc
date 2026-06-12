package com.xworkz.taxi.runner;

import com.xworkz.taxi.dao.TaxiDAO;
import com.xworkz.taxi.dao.impl.TaxiDAOImpl;
import com.xworkz.taxi.dto.TaxiDetailsDTO;

public class Runner {
    public static void main(String[] args) {
        TaxiDAO taxiDAO = new TaxiDAOImpl();
        TaxiDetailsDTO taxiDetailsDTO = new TaxiDetailsDTO();
        taxiDetailsDTO.setDriverName("Naga");
        taxiDetailsDTO.setCarModel("Hilux");
        taxiDetailsDTO.setVehicleNo(109);
        taxiDetailsDTO.setFarePerKM(50);
        taxiDetailsDTO.setLicencePlate("KA-04-5698");

        boolean saved = taxiDAO.save(taxiDetailsDTO);
        System.out.println("The details are saved:"+saved);

        TaxiDetailsDTO taxiDetailsDTO1 = new TaxiDetailsDTO();
        taxiDetailsDTO1.setCarModel("Mahendra");
        taxiDetailsDTO1.setFarePerKM(80);
        taxiDetailsDTO1.setVehicleNo(108);

        boolean updated  = taxiDAO.update(taxiDetailsDTO1);
        System.out.println("The details are updated:"+updated);

        TaxiDetailsDTO taxiDetailsDTO2 = new TaxiDetailsDTO();
        taxiDetailsDTO2.setVehicleNo(109);

        boolean deleted = taxiDAO.delete(taxiDetailsDTO2);
        System.out.println("The details are deleted:"+deleted);
    }
}
