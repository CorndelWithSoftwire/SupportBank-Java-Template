package training.supportbank;

public class UserInterface {

    private final Printer printer;

    public UserInterface(Printer printer) {
        this.printer = printer;
    }

    public void displayMenu() {
        System.out.println("what would you like to do?");
        System.out.println("Type 'List All' to list all accounts");
        System.out.println("Type List <Account Name> to list transactions for a specific account");
    }

    public void processCommand(String command) {
        if (command.equals("List All")) {
            printer.printAllAccounts();
        } else if (command.startsWith("List ")) {
            String accountName = command.substring(5);
            printer.printAccountHistory(accountName);
        } else {
            System.out.println("I do not know that command");
        }
    }
}
