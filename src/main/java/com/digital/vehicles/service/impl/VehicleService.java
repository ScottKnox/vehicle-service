package com.digital.vehicles.service.impl;

import com.amazonaws.util.StringUtils;
import com.digital.vehicles.domain.Vehicle;
import com.digital.vehicles.datalayer.IVehicleRepository;
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
    private IVehicleRepository IVehicleRepository;

    @Override
    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        Iterable<Vehicle> dbVehicles = IVehicleRepository.findAll();

        for (Vehicle dbVehicle : dbVehicles) {
            // Boss' orders! Only return vehicles that have a photo
            if (!StringUtils.isNullOrEmpty(dbVehicle.getImageUrl())) {
                vehicles.add(dbVehicle);
            }
        }

        return vehicles;
    }
}
