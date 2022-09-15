package training.supportbank;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        //variables
        ArrayList<Account> Accounts = new ArrayList<Account>();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        //Load CSV
        String line = "";
        boolean firstskipped = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/training/supportbank/Transactions2014.csv"));
            while ((line = reader.readLine()) != null) {
                if (firstskipped) {
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
                            Accounts.get(i).Addbal(-1*Float.parseFloat(line[4]));
                        }
                        //check To
                        if (Objects.equals(lineinput[2], Accounts.get(i).getName())) {
                            Toexists = true;
                            Accounts.get(i).Addbal(Float.parseFloat(line[4]));
                        }
                    }
                    //add new accounts & update balances

                    if (!Fromexists) {
                        Accounts.add(new Account(lineinput[1], 0));
                        Accounts.get(Accounts.size()-1).Addbal(-1*Float.parseFloat(lineinput[4]));
                    }
                    if (!Toexists) {
                        Accounts.add(new Account(lineinput[2], 0));
                        Accounts.get(Accounts.size()-1).Addbal(Float.parseFloat(lineinput[4]));
                    }

                } else {
                    firstskipped = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < Accounts.size(); i++) {
            System.out.println(Accounts.get(i).getName());
        }
    }
}
