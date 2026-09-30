package com.minibank.service;

import java.sql.Date;
import java.util.List;

import com.minibank.dao.BankTransactionDao;
import com.minibank.dao.minibankDao;
import com.minibank.model.Account;
import com.minibank.model.BankTransaction;

public class TransactionService {

    private minibankDao accountDao = new minibankDao();

    private BankTransactionDao transactionDao =
            new BankTransactionDao();


    // DEPOSIT MONEY
    public void deposit(int accno, double amount) throws Exception {

        // Check amount
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0");
            return;
        }

        // Find account
        Account account = accountDao.findById(accno);

        if (account == null) {
            System.out.println("Account Not Found");
            return;
        }

        // Check account status
        if (!account.isStatus()) {
            System.out.println("Account is inactive");
            return;
        }

        // Add amount
        double oldBalance = account.getBalance();

        double newBalance = oldBalance + amount;

        account.setBalance(newBalance);

        // Update account
        accountDao.updateAccount(account);

        // Create transaction
        BankTransaction transaction = new BankTransaction();

        transaction.setAccno(accno);
        transaction.setType("DEPOSIT");
        transaction.setAmount(amount);
        transaction.setTransaction_date(
                new Date(System.currentTimeMillis()));

        // Save transaction
        transactionDao.saveTransaction(transaction);

        System.out.println();
        System.out.println("===== DEPOSIT SUCCESSFUL =====");
        System.out.println("Account Number : " + accno);
        System.out.println("Old Balance    : " + oldBalance);
        System.out.println("Deposited      : " + amount);
        System.out.println("New Balance    : " + newBalance);
    }


    // WITHDRAW MONEY
    public void withdraw(int accno, double amount) throws Exception {

        // Check amount
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0");
            return;
        }

        // Find account
        Account account = accountDao.findById(accno);

        if (account == null) {
            System.out.println("Account Not Found");
            return;
        }

        // Check account status
        if (!account.isStatus()) {
            System.out.println("Account is inactive");
            return;
        }

        // Check balance
        if (account.getBalance() < amount) {
            System.out.println("Insufficient Balance");
            return;
        }

        // Calculate new balance
        double oldBalance = account.getBalance();

        double newBalance = oldBalance - amount;

        account.setBalance(newBalance);

        // Update account
        accountDao.updateAccount(account);

        // Create transaction
        BankTransaction transaction = new BankTransaction();

        transaction.setAccno(accno);
        transaction.setType("WITHDRAW");
        transaction.setAmount(amount);
        transaction.setTransaction_date(
                new Date(System.currentTimeMillis()));

        // Save transaction
        transactionDao.saveTransaction(transaction);

        System.out.println();
        System.out.println("===== WITHDRAWAL SUCCESSFUL =====");
        System.out.println("Account Number : " + accno);
        System.out.println("Old Balance    : " + oldBalance);
        System.out.println("Withdrawn      : " + amount);
        System.out.println("New Balance    : " + newBalance);
    }


    // TRANSACTION HISTORY
    public List<BankTransaction> getTransactionHistory(
            int accno) throws Exception {

        return transactionDao.findByAccount(accno);
    }


    // ALL TRANSACTIONS
    public List<BankTransaction> getAllTransactions()
            throws Exception {

        return transactionDao.findAll();
    }
}