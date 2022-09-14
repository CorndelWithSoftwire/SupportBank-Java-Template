package training.supportbank;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        //variables
        ArrayList<account> accounts = new ArrayList<account>();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        //Load CSV
        String line = "";
        boolean FirstSkipped = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Transactions2014.csv"));
            while ((line = reader.readLine()) != null) {
                if (FirstSkipped){
                    //load into transactions
                    String[] LineInput = line.split(",");
                    String[] SplitDate = LineInput[0].split("/");
                    LocalDate date = LocalDate.of(Integer.valueOf(SplitDate[2]),Integer.valueOf(SplitDate[1]),Integer.valueOf(SplitDate[0]));
                    Transaction NewTrans = new Transaction(date,LineInput[1],LineInput[2],LineInput[3],Float.parseFloat(LineInput[4]));
                    transactions.add(NewTrans);
                    //check for new accounts

                }else {
                    FirstSkipped = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
