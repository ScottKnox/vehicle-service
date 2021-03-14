package com.digital.iqscroll.datalayer;

import com.digital.iqscroll.domain.Fact;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface FactRepository extends CrudRepository<Fact, String> {

    Optional<Fact> findById(String id);
}
