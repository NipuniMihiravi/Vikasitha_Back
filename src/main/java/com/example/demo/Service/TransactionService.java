package com.example.demo.Service;

import com.example.demo.Model.MemberBilling;
import com.example.demo.Model.Payment;
import com.example.demo.Model.Transaction;
import com.example.demo.Repository.TransactionRepository;
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

    // ✅ Fetch all transactions for member, including late fee
    public List<Transaction> getByMemberId(String memberId) {
        List<Transaction> transactions = transactionRepository.findByMemberIdOrderByDateAsc(memberId);

        if (transactions.isEmpty()) {
            return transactions;
        }

        // Get latest transaction (last in the list)
        Transaction latestTxn = transactions.get(transactions.size() - 1);

        // If latest is a Bill and unpaid > 30 days → apply late fee
        if (latestTxn.getDescription().startsWith("Bill") && latestTxn.getBalance() > 0) {
            LocalDate billDate = latestTxn.getDate();
            LocalDate today = LocalDate.now();

            long diffInDays = ChronoUnit.DAYS.between(billDate, today);
            if (diffInDays > 30) {
                double lateFee = latestTxn.getBalance() * 0.05; // 5% of unpaid balance
                double newBalance = latestTxn.getBalance() + lateFee;

                Transaction lateFeeTxn = new Transaction();
                lateFeeTxn.setMemberId(memberId);
                lateFeeTxn.setDate(today);
                lateFeeTxn.setDescription("Late Payment Fee");
                lateFeeTxn.setDebit(lateFee);
                lateFeeTxn.setCredit(0);
                lateFeeTxn.setBalance(newBalance);

                transactionRepository.save(lateFeeTxn);
                transactions.add(lateFeeTxn);
            }
        }

        return transactions;
    }
}
