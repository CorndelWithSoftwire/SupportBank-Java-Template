package training.supportbank;

import java.util.ArrayList;

public class Account {
    private double bankBalance;
    private String[] transactionLog;
    private String accountName;

    public Account(String newAccountName){
        accountName = newAccountName;
        bankBalance = 0.0;
        transactionLog = new ArrayList<String>;
    }
}
