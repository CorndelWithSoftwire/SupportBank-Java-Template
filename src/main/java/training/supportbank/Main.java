package training.supportbank;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]) {
        //variables
        ArrayList<Account> Accounts = new ArrayList<Account>();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        final DecimalFormat currency = new DecimalFormat("£0.00");
        //load Json
        try {
            JsonParser jsonParser = new JsonParser();
            Stream<Transaction> jsonTrans = jsonParser.readFile("src/main/java/training/supportbank/Transactions2013.json");
            jsonTrans.forEach(Transaction -> {transactions.add(Transaction);
            });

        }catch (IOException e){
            e.printStackTrace();
        }
        //Load CSV
        boolean firstSkippedCSV = false;
        try {
            String line = "";
            BufferedReader Csvreader = new BufferedReader(new FileReader("src/main/java/training/supportbank/Transactions2014.csv"));
            while ((line = Csvreader.readLine()) != null) {
                if (firstSkippedCSV) {
                    //load into transactions
                    String[] lineinput = line.split(",");
                    String[] SplitDate = lineinput[0].split("/");
                    LocalDate date = LocalDate.of(Integer.valueOf(SplitDate[2]), Integer.valueOf(SplitDate[1]), Integer.valueOf(SplitDate[0]));
                    Transaction Newtrans = new Transaction(date, lineinput[1], lineinput[2], lineinput[3], Float.parseFloat(lineinput[4]));
                    transactions.add(Newtrans);
                } else {
                    firstSkippedCSV = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //NEW ACCOUNT CREATION:
        boolean Toexists = false;
        boolean Fromexists = false;
        for(int i = 0; i < transactions.size(); i ++){
            Toexists = false;
            Fromexists = false;
            for (int j = 0; j < Accounts.size(); j ++){
                if (!Toexists && Objects.equals(transactions.get(i).getTo(), Accounts.get(j).getName())){
                    Toexists = true;
                    Accounts.get(j).Addbal(transactions.get(i).getAmount());
                }
                if (!Fromexists && Objects.equals(transactions.get(i).getFrom(), Accounts.get(j).getName())){
                    Fromexists = true;
                    Accounts.get(j).Addbal(-1*transactions.get(i).getAmount());
                }
            }
            if (!Toexists){
                Accounts.add(new Account(transactions.get(i).getTo(),transactions.get(i).getAmount()));
            }
            if (!Fromexists){
                Accounts.add(new Account(transactions.get(i).getFrom(),-1*transactions.get(i).getAmount()));
            }
        }
        Scanner myScan = new Scanner(System.in);
        String menuOption = "";
        boolean contLoop = true;
        while (contLoop = true) {
            System.out.println("Input command:\n - List < Account/All > \n - Quit");
            menuOption = myScan.nextLine();
            // parse comment
            String[] splitCommand = menuOption.split(" ");
            String command = splitCommand[0];
            String myArgs = "";
            for (int i = 1; i < splitCommand.length; i++) {
                myArgs = myArgs + splitCommand[i];
                if (i != splitCommand.length - 1) {
                    myArgs = myArgs + " ";
                }
            }
            //execute command
            if (Objects.equals(command, "List")) {
                if (Objects.equals(myArgs, "All")) {
                    for (int i = 0; i < Accounts.size(); i++) {
                        System.out.println(Accounts.get(i).getName() + " " + currency.format(Accounts.get(i).getBalance()));
                    }
                } else {//specific account
                    for (int i = 0; i < transactions.size(); i++) {
                        if (Objects.equals(transactions.get(i).getTo(), myArgs) || Objects.equals(transactions.get(i).getFrom(), myArgs)) {
                            System.out.println(transactions.get(i).getDate() + "\t" + transactions.get(i).getFrom() + "\t" + transactions.get(i).getTo() + "\t" + transactions.get(i).getNarrative() + "\t" + transactions.get(i).getAmount());
                        }
                    }
                }
                if (Objects.equals(command, "Quit")) {
                    contLoop = false;
                } else {
                    System.out.println("invalid command");
                }
            }
        }
    }
}
