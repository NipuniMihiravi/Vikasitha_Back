package com.example.demo.Repository;

import com.example.demo.Model.Tariff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TariffRepository extends MongoRepository<Tariff, String> {
    List<Tariff> findByStatus(String status);

    // Find a tariff where a unit falls in the range
    Tariff findFirstByMinUnitLessThanEqualAndMaxUnitGreaterThanEqualAndStatus(
            Integer unit, Integer unit2, String status);

    Optional<Tariff> findTopByStatusOrderByTariffDateDesc(String status);

}
