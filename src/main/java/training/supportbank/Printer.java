package training.supportbank;

public class Printer {

    private final Bank bank;

    public Printer(Bank bank) {
        this.bank = bank;
    }

    public void printAllAccounts() {
        bank.getAccounts().forEach((accountName, account) -> printAccount(account));
    }

    public void printAccount(Account account) {
        System.out.println( account.getName() + ": £" + account.getBalance());
    }

    public void printAccountHistory(String accountName) {
        Account account = bank.getAccounts().get(accountName);
        account.getTransactions().forEach(transaction -> printTransaction(transaction, accountName));
    }

    public void printTransaction(Transaction transaction, String accountName) {
        String transactionType = "";
        if (accountName.equals(transaction.getFrom())) {
            transactionType = "debit";
        } else if (accountName.equals(transaction.getTo())) {
            transactionType = "credit";
        }
        System.out.println(transaction.getDate() + " " +
            transactionType + " £" +
            transaction.getAmount() + " " +
            transaction.getNarrative());
    }
}
