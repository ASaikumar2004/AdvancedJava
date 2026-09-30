package com.minibank.service;

import java.util.List;

import com.minibank.dao.minibankDao;
import com.minibank.model.Account;

public class MiniBankService {

    minibankDao dao = new minibankDao();

    // CREATE
    public void createAccount(Account account) throws Exception {
        dao.createAccount(account);
    }

    // FIND BY ID
    public Account findById(int accno) throws Exception {
        return dao.findById(accno);
    }

    // FIND ALL
    public List<Account> findAll() throws Exception {
        return dao.findAll();
    }

    // UPDATE
    public void updateAccount(Account account) throws Exception {
        dao.updateAccount(account);
    }

    // DELETE
    public void deleteAccount(int accno) throws Exception {
        dao.deleteAccount(accno);
    }
}