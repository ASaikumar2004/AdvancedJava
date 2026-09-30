package com.minibank.start;

import java.util.List;
import java.util.Scanner;

import com.minibank.model.Account;
import com.minibank.model.BankTransaction;
import com.minibank.service.MiniBankService;
import com.minibank.service.TransactionService;

public class MiniBankApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MiniBankService accountService =
                new MiniBankService();

        TransactionService transactionService =
                new TransactionService();


        while (true) {

            System.out.println();
            System.out.println(
                    "╔══════════════════════════════════════╗");

            System.out.println(
                    "║            🏦 MINI BANK             ║");

            System.out.println(
                    "╠══════════════════════════════════════╣");

            System.out.println(
                    "║ 1. Create Account                    ║");

            System.out.println(
                    "║ 2. Find Account                      ║");

            System.out.println(
                    "║ 3. View All Accounts                 ║");

            System.out.println(
                    "║ 4. Deposit Money                     ║");

            System.out.println(
                    "║ 5. Withdraw Money                    ║");

            System.out.println(
                    "║ 6. Transaction History               ║");

            System.out.println(
                    "║ 7. Update Account                    ║");

            System.out.println(
                    "║ 8. Delete Account                    ║");

            System.out.println(
                    "║ 9. Exit                              ║");

            System.out.println(
                    "╚══════════════════════════════════════╝");

            System.out.print(
                    "Enter your choice: ");

            int choice = sc.nextInt();


            try {

                switch (choice) {


                // CREATE ACCOUNT
                case 1:

                    System.out.println();
                    System.out.println(
                            "--- CREATE ACCOUNT ---");

                    System.out.print(
                            "Enter Account Number: ");

                    int accno =
                            sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                            "Enter Holder Name: ");

                    String holderName =
                            sc.nextLine();

                    System.out.print(
                            "Enter Initial Balance: ");

                    double balance =
                            sc.nextDouble();

                    System.out.print(
                            "Enter Status (true/false): ");

                    boolean status =
                            sc.nextBoolean();


                    Account account =
                            new Account(
                                    accno,
                                    holderName,
                                    balance,
                                    status
                            );


                    accountService.createAccount(
                            account);

                    break;


                // FIND ACCOUNT
                case 2:

                    System.out.println();
                    System.out.println(
                            "--- FIND ACCOUNT ---");

                    System.out.print(
                            "Enter Account Number: ");

                    int searchAccno =
                            sc.nextInt();


                    Account foundAccount =
                            accountService.findById(
                                    searchAccno);


                    if (foundAccount == null) {

                        System.out.println(
                                "Account Not Found");

                    } else {

                        System.out.println();

                        System.out.println(
                                "---------------------------------------------------------------");

                        System.out.printf(
                                "%-10s %-20s %-15s %-10s%n",
                                "ACC NO",
                                "HOLDER NAME",
                                "BALANCE",
                                "STATUS");

                        System.out.println(
                                "---------------------------------------------------------------");

                        System.out.printf(
                                "%-10d %-20s %-15.2f %-10s%n",
                                foundAccount.getAccno(),
                                foundAccount.getHolder_name(),
                                foundAccount.getBalance(),
                                foundAccount.isStatus()
                                        ? "ACTIVE"
                                        : "INACTIVE");

                        System.out.println(
                                "---------------------------------------------------------------");
                    }

                    break;


                // FIND ALL
                case 3:

                    System.out.println();
                    System.out.println(
                            "--- ALL ACCOUNTS ---");

                    List<Account> accounts =
                            accountService.findAll();


                    if (accounts.isEmpty()) {

                        System.out.println(
                                "No Accounts Found");

                    } else {

                        System.out.println();

                        System.out.println(
                                "----------------------------------------------------------------");

                        System.out.printf(
                                "%-10s %-20s %-15s %-10s%n",
                                "ACC NO",
                                "HOLDER NAME",
                                "BALANCE",
                                "STATUS");

                        System.out.println(
                                "----------------------------------------------------------------");

                        for (Account a : accounts) {

                            System.out.printf(
                                    "%-10d %-20s %-15.2f %-10s%n",
                                    a.getAccno(),
                                    a.getHolder_name(),
                                    a.getBalance(),
                                    a.isStatus()
                                            ? "ACTIVE"
                                            : "INACTIVE");
                        }

                        System.out.println(
                                "----------------------------------------------------------------");
                    }

                    break;


                // DEPOSIT
                case 4:

                    System.out.println();
                    System.out.println(
                            "--- DEPOSIT MONEY ---");

                    System.out.print(
                            "Enter Account Number: ");

                    int depositAccno =
                            sc.nextInt();

                    System.out.print(
                            "Enter Deposit Amount: ");

                    double depositAmount =
                            sc.nextDouble();


                    transactionService.deposit(
                            depositAccno,
                            depositAmount);

                    break;


                // WITHDRAW
                case 5:

                    System.out.println();
                    System.out.println(
                            "--- WITHDRAW MONEY ---");

                    System.out.print(
                            "Enter Account Number: ");

                    int withdrawAccno =
                            sc.nextInt();

                    System.out.print(
                            "Enter Withdrawal Amount: ");

                    double withdrawAmount =
                            sc.nextDouble();


                    transactionService.withdraw(
                            withdrawAccno,
                            withdrawAmount);

                    break;


                // TRANSACTION HISTORY
                case 6:

                    System.out.println();
                    System.out.println(
                            "--- TRANSACTION HISTORY ---");

                    System.out.print(
                            "Enter Account Number: ");

                    int transactionAccno =
                            sc.nextInt();


                    List<BankTransaction> transactions =
                            transactionService
                                    .getTransactionHistory(
                                            transactionAccno);


                    if (transactions.isEmpty()) {

                        System.out.println(
                                "No Transactions Found");

                    } else {

                        System.out.println();

                        System.out.println(
                                "--------------------------------------------------------------------------");

                        System.out.printf(
                                "%-8s %-10s %-15s %-15s %-15s%n",
                                "ID",
                                "ACC NO",
                                "TYPE",
                                "AMOUNT",
                                "DATE");

                        System.out.println(
                                "--------------------------------------------------------------------------");

                        for (BankTransaction t :
                                transactions) {

                            System.out.printf(
                                    "%-8d %-10d %-15s %-15.2f %-15s%n",
                                    t.getTransaction_id(),
                                    t.getAccno(),
                                    t.getType(),
                                    t.getAmount(),
                                    t.getTransaction_date());
                        }

                        System.out.println(
                                "--------------------------------------------------------------------------");
                    }

                    break;


                // UPDATE ACCOUNT
                case 7:

                    System.out.println();
                    System.out.println(
                            "--- UPDATE ACCOUNT ---");

                    System.out.print(
                            "Enter Account Number: ");

                    int updateAccno =
                            sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                            "Enter New Holder Name: ");

                    String updateName =
                            sc.nextLine();

                    System.out.print(
                            "Enter New Balance: ");

                    double updateBalance =
                            sc.nextDouble();

                    System.out.print(
                            "Enter New Status (true/false): ");

                    boolean updateStatus =
                            sc.nextBoolean();


                    Account updateAccount =
                            new Account(
                                    updateAccno,
                                    updateName,
                                    updateBalance,
                                    updateStatus
                            );


                    accountService.updateAccount(
                            updateAccount);

                    break;


                // DELETE ACCOUNT
                case 8:

                    System.out.println();
                    System.out.println(
                            "--- DELETE ACCOUNT ---");

                    System.out.print(
                            "Enter Account Number: ");

                    int deleteAccno =
                            sc.nextInt();


                    accountService.deleteAccount(
                            deleteAccno);

                    break;


                // EXIT
                case 9:

                    System.out.println();
                    System.out.println(
                            "Thank you for using MiniBank!");

                    sc.close();

                    return;


                default:

                    System.out.println(
                            "Invalid Choice!");

                }

            } catch (Exception e) {

                System.out.println(
                        "Error: " + e.getMessage());
            }
        }
    }
}