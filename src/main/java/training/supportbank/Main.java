package training.supportbank;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        // Your code here!
        System.out.println("Test!");
        //variables
        ArrayList<Account> Accounts = new ArrayList<Account>();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        //Load CSV
        String line = "";
        boolean firstskipped = false;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/training/supportbank/Transactions2014.csv"));
            while ((line = reader.readLine()) != null){
                if (firstskipped){
                    //load into transactions
                    String[] lineinput = line.split(",");
                    String[] SplitDate = lineinput[0].split("/");
                    LocalDate date = LocalDate.of(Integer.valueOf(SplitDate[2]),Integer.valueOf(SplitDate[1]),Integer.valueOf(SplitDate[0]));
                    Transaction Newtrans = new Transaction(date,lineinput[1],lineinput[2],lineinput[3],Float.parseFloat(lineinput[4]));
                    transactions.add(Newtrans);
                    //check for new accounts
                    if (Arrays.stream(Accounts))
                }else {
                    firstskipped = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // generating accounts

    }
}
