package com.minibank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.minibank.model.Account;
import com.minibank.util.DbConnection;

public class minibankDao {

    // CREATE ACCOUNT
    public void createAccount(Account account) throws Exception {

        Connection con = DbConnection.getConnection();

        String qry = "INSERT INTO Account VALUES(?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(qry);

        ps.setInt(1, account.getAccno());
        ps.setString(2, account.getHolder_name());
        ps.setDouble(3, account.getBalance());
        ps.setBoolean(4, account.isStatus());

        int res = ps.executeUpdate();

        if (res > 0) {
            System.out.println("Account Created Successfully");
        }

        ps.close();
        con.close();
    }


    // FIND BY ID
    public Account findById(int accno) throws Exception {

        Connection con = DbConnection.getConnection();

        String qry = "SELECT * FROM Account WHERE accno=?";

        PreparedStatement ps = con.prepareStatement(qry);

        ps.setInt(1, accno);

        ResultSet rs = ps.executeQuery();

        Account account = null;

        if (rs.next()) {

            account = new Account();

            account.setAccno(rs.getInt("accno"));
            account.setHolder_name(rs.getString("holder_name"));
            account.setBalance(rs.getDouble("balance"));
            account.setStatus(rs.getBoolean("status"));
        }

        rs.close();
        ps.close();
        con.close();

        return account;
    }


    // FIND ALL
    public List<Account> findAll() throws Exception {

        Connection con = DbConnection.getConnection();

        String qry = "SELECT * FROM Account";

        PreparedStatement ps = con.prepareStatement(qry);

        ResultSet rs = ps.executeQuery();

        List<Account> accounts = new ArrayList<>();

        while (rs.next()) {

            Account account = new Account();

            account.setAccno(rs.getInt("accno"));
            account.setHolder_name(rs.getString("holder_name"));
            account.setBalance(rs.getDouble("balance"));
            account.setStatus(rs.getBoolean("status"));

            accounts.add(account);
        }

        rs.close();
        ps.close();
        con.close();

        return accounts;
    }


    // UPDATE
    public void updateAccount(Account account) throws Exception {

        Connection con = DbConnection.getConnection();

        String qry = "UPDATE Account SET holder_name=?, balance=?, status=? WHERE accno=?";

        PreparedStatement ps = con.prepareStatement(qry);

        ps.setString(1, account.getHolder_name());
        ps.setDouble(2, account.getBalance());
        ps.setBoolean(3, account.isStatus());
        ps.setInt(4, account.getAccno());

        int res = ps.executeUpdate();

        if (res > 0) {
            System.out.println("Account Updated Successfully");
        } else {
            System.out.println("Account Not Found");
        }

        ps.close();
        con.close();
    }


    // DELETE
    public void deleteAccount(int accno) throws Exception {

        Connection con = DbConnection.getConnection();

        String qry = "DELETE FROM Account WHERE accno=?";

        PreparedStatement ps = con.prepareStatement(qry);

        ps.setInt(1, accno);

        int res = ps.executeUpdate();

        if (res > 0) {
            System.out.println("Account Deleted Successfully");
        } else {
            System.out.println("Account Not Found");
        }

        ps.close();
        con.close();
    }
}