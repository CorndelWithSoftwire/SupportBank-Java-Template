package training.supportbank;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
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
            BufferedReader reader = new BufferedReader(new FileReader("Transactions2014.csv"));
            while ((line = reader.readLine()) != null){
                if (firstskipped){
                    String[] lineinput = line.split(",");
                }else {
                    firstskipped = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
