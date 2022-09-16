package training.supportbank;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import javax.sound.sampled.Line;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        //variables
        String Line ;
        ArrayList<Account> Accounts = new ArrayList<Account>();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        final DecimalFormat currency = new DecimalFormat("£0.00");
        //Load CSV
        String line = "";
        boolean firstSkippedCSV = false;
        try {
            BufferedReader Csvreader = new BufferedReader(new FileReader("src/main/java/training/supportbank/Transactions2014.csv"));
            while ((line = Csvreader.readLine()) != null) {
                if (firstSkippedCSV) {
                    //load into transactions
                    String[] lineinput = line.split(",");
                    String[] SplitDate = lineinput[0].split("/");
                    LocalDate date = LocalDate.of(Integer.valueOf(SplitDate[2]), Integer.valueOf(SplitDate[1]), Integer.valueOf(SplitDate[0]));
                    Transaction Newtrans = new Transaction(date, lineinput[1], lineinput[2], lineinput[3], Float.parseFloat(lineinput[4]));
                    transactions.add(Newtrans);
                    //check for new accounts
                    boolean Toexists = false;
                    boolean Fromexists = false;
                    for (int i = 0; i < Accounts.size(); i++) {
                        //check from
                        if (Objects.equals(lineinput[1], Accounts.get(i).getName())) {
                            Fromexists = true;
                            Accounts.get(i).Addbal(-1 * Float.parseFloat(lineinput[4]));
                        }
                        //check To
                        if (Objects.equals(lineinput[2], Accounts.get(i).getName())) {
                            Toexists = true;
                            Accounts.get(i).Addbal(Float.parseFloat(lineinput[4]));
                        }
                    }
                    //add new accounts & update balances

                    if (!Fromexists) {
                        Accounts.add(new Account(lineinput[1], 0));
                        Accounts.get(Accounts.size() - 1).Addbal(-1 * Float.parseFloat(lineinput[4]));
                    }
                    if (!Toexists) {
                        Accounts.add(new Account(lineinput[2], 0));
                        Accounts.get(Accounts.size() - 1).Addbal(Float.parseFloat(lineinput[4]));
                    }

                } else {
                    firstSkippedCSV = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
