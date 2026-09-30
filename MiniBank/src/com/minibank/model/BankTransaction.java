package com.minibank.model;

import java.sql.Date;

public class BankTransaction {

    private int transaction_id;
    private int accno;
    private String type;
    private double amount;
    private Date transaction_date;

    // Default constructor
    public BankTransaction() {
    }

    // Parameterized constructor
    public BankTransaction(int transaction_id, int accno, String type,
                           double amount, Date transaction_date) {
        super();
        this.transaction_id = transaction_id;
        this.accno = accno;
        this.type = type;
        this.amount = amount;
        this.transaction_date = transaction_date;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    @Override
    public String toString() {
        return "BankTransaction [transaction_id=" + transaction_id
                + ", accno=" + accno
                + ", type=" + type
                + ", amount=" + amount
                + ", transaction_date=" + transaction_date + "]";
    }
}