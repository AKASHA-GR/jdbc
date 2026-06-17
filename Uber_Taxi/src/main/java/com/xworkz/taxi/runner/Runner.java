package com.xworkz.taxi.runner;

import com.xworkz.taxi.dao.TaxiDAO;
import com.xworkz.taxi.dao.impl.TaxiDAOImpl;
import com.xworkz.taxi.dto.TaxiDetailsDTO;

import java.util.ArrayList;
import java.util.List;

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


        //insert
        int isInserted = taxiDAO.insert("vivak","bullera",109,"KA-17-2093",34);
        System.out.println("The taxi details are inserted:"+isInserted);
        System.out.println();

        //updated
        int update = taxiDAO.updateByLicencePlate("KA-17-2093",45);
        System.out.println("The taxi details are updated:"+update);
        System.out.println();

        //delete
        int delete = taxiDAO.deleteByName("vivak");
        System.out.println("The taxi details are deleted:"+delete);
        System.out.println();

        //select
        TaxiDetailsDTO taxiDetailsDTO3 = taxiDAO.select();
        System.out.println(taxiDetailsDTO3);
        System.out.println();

        //insertMultiple
        List<TaxiDetailsDTO> taxiDetailsDTOS = new ArrayList<>();

        TaxiDetailsDTO taxiDetailsDTO4 = new TaxiDetailsDTO();
        taxiDetailsDTO4.setDriverName("Sai");
        taxiDetailsDTO4.setCarModel("Nano");
        taxiDetailsDTO4.setVehicleNo(109);
        taxiDetailsDTO4.setLicencePlate("KA-32-5677");
        taxiDetailsDTO4.setFarePerKM(30);

        TaxiDetailsDTO taxiDetailsDTO5 = new TaxiDetailsDTO();
        taxiDetailsDTO5.setDriverName("Prateek");
        taxiDetailsDTO5.setCarModel("Audi");
        taxiDetailsDTO5.setVehicleNo(110);
        taxiDetailsDTO5.setLicencePlate("KA-35-5934");
        taxiDetailsDTO5.setFarePerKM(300);

        taxiDetailsDTOS.add(taxiDetailsDTO4);
        taxiDetailsDTOS.add(taxiDetailsDTO5);

        taxiDAO.batchInsert(taxiDetailsDTOS);
    }
}
