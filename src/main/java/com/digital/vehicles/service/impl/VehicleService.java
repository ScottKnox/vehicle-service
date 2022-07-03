package com.digital.vehicles.service.impl;

import com.digital.vehicles.domain.Vehicle;
import com.digital.vehicles.datalayer.VehicleRepository;
import com.digital.vehicles.service.IVehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService implements IVehicleService {
    Logger logger = LoggerFactory.getLogger(VehicleService.class);

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        Iterable<Vehicle> dbFacts = vehicleRepository.findAll();
        dbFacts.forEach(vehicles::add);

        return vehicles;
    }
}
