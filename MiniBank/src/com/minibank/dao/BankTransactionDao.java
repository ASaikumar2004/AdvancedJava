package com.minibank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.minibank.model.BankTransaction;
import com.minibank.util.DbConnection;

public class BankTransactionDao {

    // SAVE TRANSACTION
    public void saveTransaction(BankTransaction transaction) throws Exception {

        Connection con = DbConnection.getConnection();

        String qry = "INSERT INTO BankTransaction "
                   + "(accno, type, amount, transaction_date) "
                   + "VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(qry);

        ps.setInt(1, transaction.getAccno());
        ps.setString(2, transaction.getType());
        ps.setDouble(3, transaction.getAmount());
        ps.setDate(4, transaction.getTransaction_date());

        int res = ps.executeUpdate();

        if (res > 0) {
            System.out.println("Transaction Saved Successfully");
        }

        ps.close();
        con.close();
    }


    // FIND TRANSACTIONS BY ACCOUNT NUMBER
    public List<BankTransaction> findByAccount(int accno) throws Exception {

        Connection con = DbConnection.getConnection();

        String qry = "SELECT * FROM BankTransaction "
                   + "WHERE accno=? "
                   + "ORDER BY transaction_id DESC";

        PreparedStatement ps = con.prepareStatement(qry);

        ps.setInt(1, accno);

        ResultSet rs = ps.executeQuery();

        List<BankTransaction> transactions = new ArrayList<>();

        while (rs.next()) {

            BankTransaction transaction = new BankTransaction();

            transaction.setTransaction_id(
                    rs.getInt("transaction_id"));

            transaction.setAccno(
                    rs.getInt("accno"));

            transaction.setType(
                    rs.getString("type"));

            transaction.setAmount(
                    rs.getDouble("amount"));

            transaction.setTransaction_date(
                    rs.getDate("transaction_date"));

            transactions.add(transaction);
        }

        rs.close();
        ps.close();
        con.close();

        return transactions;
    }


    // FIND ALL TRANSACTIONS
    public List<BankTransaction> findAll() throws Exception {

        Connection con = DbConnection.getConnection();

        String qry = "SELECT * FROM BankTransaction "
                   + "ORDER BY transaction_id DESC";

        PreparedStatement ps = con.prepareStatement(qry);

        ResultSet rs = ps.executeQuery();

        List<BankTransaction> transactions = new ArrayList<>();

        while (rs.next()) {

            BankTransaction transaction = new BankTransaction();

            transaction.setTransaction_id(
                    rs.getInt("transaction_id"));

            transaction.setAccno(
                    rs.getInt("accno"));

            transaction.setType(
                    rs.getString("type"));

            transaction.setAmount(
                    rs.getDouble("amount"));

            transaction.setTransaction_date(
                    rs.getDate("transaction_date"));

            transactions.add(transaction);
        }

        rs.close();
        ps.close();
        con.close();

        return transactions;
    }
}