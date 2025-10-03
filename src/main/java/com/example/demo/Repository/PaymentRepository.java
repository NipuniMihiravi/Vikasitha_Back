package com.example.demo.Repository;

import com.example.demo.Model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
    List<Payment> findByMemberIdAndPaymentDateAfter(String memberId, LocalDate date);
    List<Payment> findByMemberId(String memberId);

}
