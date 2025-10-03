package com.example.demo.Repository;


import com.example.demo.Model.MemberBilling;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberBillingRepository extends MongoRepository<MemberBilling, String> {
    List<MemberBilling> findByMemberId(String memberId);
    MemberBilling findTopByMemberIdOrderByMeterReadingThisMonthDateDesc(String memberId);
    // Optional: custom queries
}
