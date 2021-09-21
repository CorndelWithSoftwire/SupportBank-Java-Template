package training.supportbank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        // Your code here!
        //    System.out.println("Test!");
//        Scanner scanne = new Scanner()
        readFile();

    }

    public static void readFile() {
        //   Path filePath = Paths.get("Transactions/Transactions2014.csv");
        //   List<String> reader = null;

        //  String[][] data = {{""}, {""}, };
        int i = 0;
        int j = 0;
        //  data = new String[][];
        Set<String> nameSet = new HashSet<String>();
        BufferedReader reader;
        HashMap<String, Account> bankAccounts = new HashMap<String, Account>();
        ArrayList<Transactions> transactionsList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("Transactions/Transactions2014.csv"));
            String line = reader.readLine();
            line = reader.readLine();

            //   String[] splitData = line.split(",");
            //  System.out.println(splitData);


            while (line != null) {

                String[] splitData = line.split(",");
                BigDecimal newAmount = new BigDecimal(splitData[4]);
                Transactions newTran = new Transactions(splitData[0], splitData[1], splitData[2], splitData[3], newAmount);

                nameSet.add(splitData[1]);
                nameSet.add(splitData[2]);
                line = reader.readLine();
                transactionsList.add(newTran);
//                 System.out.println(newTran);
                //  System.out.println(splitData)
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(reader);
        System.out.println(nameSet);
        for (String name : nameSet) {
            bankAccounts.put(name, new Account(name));
        }
        for (int k = 0; k < transactionsList.size(); k++) {
            Account.carryOutTransaction(transactionsList.get(k),bankAccounts);
        }

        bankAccounts.

    }

}
