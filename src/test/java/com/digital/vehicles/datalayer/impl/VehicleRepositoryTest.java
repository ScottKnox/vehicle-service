package com.digital.vehicles.datalayer.impl;

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

import java.util.ArrayList;
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
    }

    @Test
    public void vehicleRepository_SomeVehiclesWithImageAndNotLexus_ReturnsAppropriateVehicles() {
 
    }
}