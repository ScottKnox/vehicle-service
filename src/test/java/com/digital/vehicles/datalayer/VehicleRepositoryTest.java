package com.digital.vehicles.datalayer;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;

import com.digital.vehicles.VehicleApplication;
import com.digital.vehicles.domain.Vehicle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VehicleApplication.class)
@WebAppConfiguration
public class VehicleRepositoryTest {

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    VehicleRepository repository;

    private DynamoDBMapper dynamoDBMapper;

    @Before
    public void setup() {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        CreateTableRequest tableRequest = dynamoDBMapper
                .generateCreateTableRequest(Vehicle.class);
        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));

        try {
            amazonDynamoDB.createTable(tableRequest);
        } catch (Exception ignored) { }


        dynamoDBMapper.batchDelete(repository.findAll());
    }

    @Test
    public void vehicleRepository_SuccessfullySaveValidVehicle_FindsValidVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setImageUrl("https://imageurl.com");
        vehicle.setYear(2018);
        vehicle.setBrand("Dodge");
        vehicle.setModel("Challenger");
        vehicle.setColor("Red");
        vehicle.setDescription("A very fast, cool car.");
        vehicle.setPrice(25000.00);

        repository.save(vehicle);

        List<Vehicle> result = (List<Vehicle>) repository.findAll();

        Assert.assertEquals(1, result.size());
        Vehicle dbVehicle = result.get(0);

        Assert.assertEquals(2018, dbVehicle.getYear());
        Assert.assertEquals("Dodge", dbVehicle.getBrand());
        Assert.assertEquals("Challenger", dbVehicle.getModel());
        Assert.assertEquals("https://imageurl.com", dbVehicle.getImageUrl());
        Assert.assertEquals("Red", dbVehicle.getColor());
        Assert.assertEquals("A very fast, cool car.", dbVehicle.getDescription());
        Assert.assertEquals(25000.00, dbVehicle.getPrice(), 0.01);
    }
}