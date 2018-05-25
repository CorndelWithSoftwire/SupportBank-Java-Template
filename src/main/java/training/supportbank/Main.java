package training.supportbank;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = new LogManager();

    public static void main(String args[]) {

        LOGGER.log(Level.FINEST, "testing logging on startup");

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        FileService fs = new FileService("./Transactions2014.csv");
        FileService dodgyfs = new FileService("./DodgyTransactions2015.csv");
        Printer p = new Printer(bank);
        UserInterface ui = new UserInterface(p);
        bank.addMultipleAccounts(fs.getAccountNames());
        bank.processMultipleTransactions(fs.getTransactions());
        bank.addMultipleAccounts(dodgyfs.getAccountNames());
        bank.processMultipleTransactions(dodgyfs.getTransactions());
        ui.displayMenu();
        String command = scanner.nextLine();
        ui.processCommand(command);
    }

}