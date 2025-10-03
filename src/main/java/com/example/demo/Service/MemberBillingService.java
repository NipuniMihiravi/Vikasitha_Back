package com.example.demo.Service;


import com.example.demo.Model.MemberBilling;
import com.example.demo.Repository.MemberBillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberBillingService {

    @Autowired
    private MemberBillingRepository repository;

    // Add new member billing
    public MemberBilling addMemberBilling(MemberBilling memberBilling) {
        return repository.save(memberBilling);
    }

    // Update existing member billing
    public MemberBilling updateMemberBilling(String id, MemberBilling memberBilling) {
        memberBilling.setId(id);
        return repository.save(memberBilling);
    }

    // Delete member billing
    public void deleteMemberBilling(String id) {
        repository.deleteById(id);
    }

    // View all member billings
    public List<MemberBilling> getAllMemberBillings() {
        return repository.findAll();
    }


    public Optional<MemberBilling> getMemberBillingById(String id) {
        return repository.findById(id);
    }
    public List<MemberBilling> getByMemberId(String memberId) {
        return repository.findByMemberId(memberId);
    }
}
