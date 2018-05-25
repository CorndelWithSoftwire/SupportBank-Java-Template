package training.supportbank;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final String name;
    private List<Transaction> transactions;
    private Float balance;

    public Account(String name) {
        this.name = name;
        this.balance = Float.valueOf(0);
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Float getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void processTransaction(Transaction transaction) {
        if (name.equals(transaction.getFrom())) {
            debit(transaction.getAmount());
        } else if (name.equals(transaction.getTo())) {
            credit(transaction.getAmount());
        }
        transactions.add(transaction);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!Account.class.isAssignableFrom(other.getClass())) {
            return false;
        }
        Account otherAccount = (Account) other;
        return (name.equals(otherAccount.getName()) && balance.equals(otherAccount.getBalance()));
    }

    private void debit(Float amount) {
        balance -= amount;
    }

    private void credit(Float amount) {
        balance += amount;
    }
}
