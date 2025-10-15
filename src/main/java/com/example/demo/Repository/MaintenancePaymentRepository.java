package com.example.demo.Repository;

import com.example.demo.Model.MaintenancePayment;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MaintenancePaymentRepository extends MongoRepository<MaintenancePayment, String> {
    List<MaintenancePayment> findByMemberId(String memberId);
}
