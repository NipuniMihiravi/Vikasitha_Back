package com.example.demo.Service;

import com.example.demo.Model.MemberBilling;
import com.example.demo.Model.Payment;
import com.example.demo.Model.Transaction;
import com.example.demo.Repository.TransactionRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // ✅ Get last balance
    public double getLastBalance(String memberId) {
        Transaction last = transactionRepository.findTopByMemberIdOrderByDateDesc(memberId);
        return (last != null) ? last.getBalance() : 0.0;
    }

    // ✅ Create transaction from Bill
    public void createTransactionFromBill(MemberBilling bill) {
        double lastBalance = getLastBalance(bill.getMemberId());
        double newBalance = lastBalance + bill.getThisMonthTotal();

        Transaction t = new Transaction();
        t.setMemberId(bill.getMemberId());
        t.setDate(bill.getMeterReadingThisMonthDate());
        t.setDescription("Bill " + bill.getBillNo());
        t.setDebit(bill.getThisMonthTotal());
        t.setCredit(0);
        t.setBalance(newBalance);
        t.setMeterReadingThisMonth(bill.getMeterReadingThisMonth());
        t.setMeterReadingRemain(bill.getMeterReadingRemain());
        t.setMonthUnit(bill.getMonthUnit());
        t.setUnit(bill.getUnit());
        t.setFixCharge(bill.getFixCharge());

        transactionRepository.save(t);
    }

    // ✅ Create transaction from Payment
    public void createTransactionFromPayment(Payment payment) {
        double lastBalance = getLastBalance(payment.getMemberId());
        double newBalance = lastBalance - payment.getPayment();

        Transaction t = new Transaction();
        t.setMemberId(payment.getMemberId());
        t.setDate(payment.getPaymentDate());
        t.setDescription("Payment");
        t.setDebit(0);
        t.setCredit(payment.getPayment());
        t.setBalance(newBalance);

        transactionRepository.save(t);
    }

    // ✅ Fetch all transactions for member (used in frontend)
    public List<Transaction> getByMemberId(String memberId) {
        return transactionRepository.findByMemberIdOrderByDateAsc(memberId);
    }

    // ✅ Main late fee logic (run once on Feb 28 or 30th of other months)
    @Scheduled(cron = "0 10 10 * * ?") // runs daily at 10:10 AM
    public void applyMonthlyLateFees() {
        LocalDate today = LocalDate.now();
        int day = today.getDayOfMonth();
        int month = today.getMonthValue();

        boolean isFeeDay = (month == 2 && day == 28) || (month != 2 && day == 14);

        if (!isFeeDay) {
            System.out.println("ℹ️ Not a late fee day (" + today + "). Skipping late fee generation.");
            return;
        }

        System.out.println("✅ Applying late payment fees for date: " + today);

        List<Transaction> allTransactions = transactionRepository.findAll();
        allTransactions.stream()
                .map(Transaction::getMemberId)
                .distinct()
                .forEach(memberId -> applyLateFeeForMember(memberId, today));
    }

    // ✅ Helper: Apply 5% late fee to a member if balance > 0
    private void applyLateFeeForMember(String memberId, LocalDate today) {
        List<Transaction> memberTxns = transactionRepository.findByMemberIdOrderByDateAsc(memberId);
        if (memberTxns.isEmpty()) return;

        Transaction latestTxn = memberTxns.get(memberTxns.size() - 1);
        if (latestTxn.getBalance() <= 0) return;

        // Check if last bill older than 30 days
        LocalDate lastBillDate = latestTxn.getDate();
        long diffDays = ChronoUnit.DAYS.between(lastBillDate, today);
        if (diffDays < 30) return;

        double lateFee = latestTxn.getBalance() * 0.05;
        double newBalance = latestTxn.getBalance() + lateFee;

        Transaction lateFeeTxn = new Transaction();
        lateFeeTxn.setMemberId(memberId);
        lateFeeTxn.setDate(today);
        lateFeeTxn.setDescription("Late Payment Fee");
        lateFeeTxn.setDebit(lateFee);
        lateFeeTxn.setCredit(0);
        lateFeeTxn.setBalance(newBalance);
        lateFeeTxn.setFixCharge(0);
        lateFeeTxn.setUnit(0);
        lateFeeTxn.setMonthUnit(0);
        lateFeeTxn.setMeterReadingThisMonth(0);
        lateFeeTxn.setMeterReadingRemain(0);

        transactionRepository.save(lateFeeTxn);
        System.out.println("💰 Late fee of " + lateFee + " applied for member " + memberId);
    }
}
