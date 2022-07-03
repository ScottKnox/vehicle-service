package com.digital.vehicles.datalayer;

import com.digital.vehicles.domain.Vehicle;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface IVehicleRepository extends CrudRepository<Vehicle, String> {

    Optional<Vehicle> findById(String id);
}
