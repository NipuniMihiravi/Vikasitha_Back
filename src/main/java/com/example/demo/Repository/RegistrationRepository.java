package com.example.demo.Repository;

import com.example.demo.Model.MemberBilling;
import com.example.demo.Model.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends MongoRepository<Registration, String> {
    List<Registration> findByMemberId(String memberId);
}
