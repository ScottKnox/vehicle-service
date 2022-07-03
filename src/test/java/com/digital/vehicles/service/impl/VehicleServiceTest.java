package com.digital.vehicles.service.impl;

import com.digital.vehicles.datalayer.IVehicleRepository;
import com.digital.vehicles.domain.Vehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class VehicleServiceTest {

    IVehicleRepository repository;

    VehicleService vehicleService;

    @Before
    public void setup() {
        // Let's create a mock repository class that our service will use.
        repository = Mockito.mock(IVehicleRepository.class);
        vehicleService = new VehicleService();

        // We use this to set our class under test's repository to our Mock.
        ReflectionTestUtils.setField(vehicleService, "IVehicleRepository", repository);
    }

    @Test
    public void getVehicles_SomeMissingImages_ReturnsOnlyVehiclesWithImages() {
        List<Vehicle> dbVehicles = new ArrayList<>();
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId("dbb0c2c3-997c-465b-bb06-b2efb7dad2f7");
        vehicle1.setBrand("Dodge");
        vehicle1.setModel("Charger");
        vehicle1.setImageUrl("https://images.com/dodge-charger.jpg");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setId("acc0c2c3-997c-465b-bb06-b2efb7dad2f7");
        vehicle2.setBrand("Chevy");
        vehicle2.setModel("Aveo");
        // No image is set, Boss would be mad if this vehicle was returned. :/

        dbVehicles.add(vehicle1);
        dbVehicles.add(vehicle2);

        when(repository.findAll()).thenReturn(dbVehicles);

        List<Vehicle> vehicles = vehicleService.getVehicles();

        // There should be only one vehicle, and it should definitely have an image.
        Assert.assertEquals(1, vehicles.size());
        Assert.assertNotNull(vehicle1.getImageUrl());
    }
}