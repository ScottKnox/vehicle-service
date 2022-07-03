package com.digital.vehicles.resource;

import com.digital.vehicles.domain.Vehicle;
import com.digital.vehicles.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleResource {

    @Autowired
    private IVehicleService vehicleService;

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

}
