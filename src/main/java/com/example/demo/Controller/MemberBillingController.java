package com.example.demo.Controller;

import com.example.demo.Model.MemberBilling;
import com.example.demo.Service.MemberBillingService;
import com.example.demo.Service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin(origins = "*")
public class MemberBillingController {

    private final MemberBillingService memberBillingService;
    private final TransactionService transactionService;

    public MemberBillingController(MemberBillingService memberBillingService,
                                   TransactionService transactionService) {
        this.memberBillingService = memberBillingService;
        this.transactionService = transactionService;
    }

    // GET all bills
    @GetMapping
    public List<MemberBilling> getAllBills() {
        return memberBillingService.getAllMemberBillings();
    }

    // GET bill by ID
    @GetMapping("/{id}")
    public Optional<MemberBilling> getBillById(@PathVariable String id) {
        return memberBillingService.getMemberBillingById(id);
    }

    // GET bills by Member ID
    @GetMapping("/member/{memberId}")
    public List<MemberBilling> getBillsByMemberId(@PathVariable String memberId) {
        return memberBillingService.getByMemberId(memberId);
    }

    // POST create new bill
    @PostMapping
    public MemberBilling createBill(@RequestBody MemberBilling bill) {
        MemberBilling savedBill = memberBillingService.addMemberBilling(bill);
        transactionService.createTransactionFromBill(savedBill); // ✅ no balance param
        return savedBill;
    }

    // PUT update bill
    @PutMapping("/{id}")
    public MemberBilling updateBill(@PathVariable String id, @RequestBody MemberBilling updatedBill) {
        updatedBill.setId(id);
        return memberBillingService.updateMemberBilling(id, updatedBill);
    }

    // DELETE bill
    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable String id) {
        memberBillingService.deleteMemberBilling(id);
    }
}
