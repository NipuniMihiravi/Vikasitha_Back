package com.example.demo.Repository;

import com.example.demo.Model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillSummaryRepository extends MongoRepository<Transaction, String> {
    Transaction findByBillNo(String billNo);
    List<Transaction> findByMemberId(String memberId);
}
