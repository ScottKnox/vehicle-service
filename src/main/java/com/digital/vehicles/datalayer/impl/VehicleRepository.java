package com.digital.vehicles.datalayer.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.digital.vehicles.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class VehicleRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public List<Vehicle> getAllVehiclesWithImageAndNotLexus() {
        HashMap<String, AttributeValue> expressionAttributeValues = new HashMap<String, AttributeValue>();
        expressionAttributeValues.put(":v1", new AttributeValue().withS("Lexus"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("brand <> :v1 AND attribute_exists(imageUrl)")
                .withExpressionAttributeValues(expressionAttributeValues);

        return dynamoDBMapper.scan(Vehicle.class, scanExpression);
    }

    // Store the order item in the database
    public void save(Vehicle vehicle) {
        dynamoDBMapper.save(vehicle);
    }

    public void delete(Vehicle vehicle) {
        dynamoDBMapper.delete(vehicle);
    }
}
