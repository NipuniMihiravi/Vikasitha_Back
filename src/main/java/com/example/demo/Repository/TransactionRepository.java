package com.example.demo.Repository;

import com.example.demo.Model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    // ✅ Fetch all transactions for a member, ordered by date ascending
    List<Transaction> findByMemberIdOrderByDateAsc(String memberId);

    // ✅ (Optional) fetch latest transaction for balance calculation
    Transaction findTopByMemberIdOrderByDateDesc(String memberId);
}
