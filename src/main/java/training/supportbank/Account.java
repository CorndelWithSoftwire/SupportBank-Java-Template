package training.supportbank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    private BigDecimal bankBalance;
    private ArrayList<String> transactionLog;
    private String accountName;

    public Account(String newAccountName) {
        accountName = newAccountName;
        bankBalance = new BigDecimal("0.00");
        transactionLog = new ArrayList<String>();
    }

    public static void carryOutTransaction(Transactions currentTransactions, HashMap<String,Account> bankAccounts) { // needs to also take in a database of all the accounts
        String person1 =currentTransactions.getFrom();
        String person2 =currentTransactions.getTo();
        Account account1 = bankAccounts.get(person1);
        Account account2 = bankAccounts.get(person2);
        BigDecimal answerSending = account1.bankBalance.subtract(currentTransactions.getAmount());
        account1.setBankBalance(answerSending);
        BigDecimal answerReceiving = account2.bankBalance.add(currentTransactions.getAmount());
        account2.setBankBalance(answerReceiving);
        System.out.printf("%s sends %s £%s New balance: £%s\n", account1.accountName, account2.accountName, currentTransactions.getAmount(), account1.bankBalance);
    }

    public void setBankBalance(BigDecimal bankBalance) {
        this.bankBalance = bankBalance;
    }

    public void setTransactionLog(String transactionLog) {
        this.transactionLog.add(transactionLog);
    }

    public String toString() {
        return "Account{" +
                "bankBalance=" + bankBalance +
                ", transactionLog=" + transactionLog +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}
