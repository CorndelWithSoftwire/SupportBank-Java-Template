package training.supportbank;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String args[]) {
        //variables
        ArrayList<account> accounts = new ArrayList();
        ArrayList<Transaction> transactions = new ArrayList();
        //Load CSV
        String line;
        boolean FirstSkipped = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Transactions2014.csv"));
            while ((line = reader.readLine()) != null) {
                if (FirstSkipped){
                    //load into transactions
                    String[] LineInput = line.split(",");
                    String[] SplitDate = LineInput[0].split("/");
                    LocalDate date = LocalDate.of(Integer.parseInt(SplitDate[2]),Integer.parseInt(SplitDate[1]),Integer.parseInt(SplitDate[0]));
                    Transaction NewTrans = new Transaction(date,LineInput[1],LineInput[2],LineInput[3],Float.parseFloat(LineInput[4]));
                    transactions.add(NewTrans);
                    //check for new accounts
                    boolean ToExists = false;
                    boolean FromExists = false;
                    for (int i = 0; i<accounts.size();i++){
                        //check from
                        if (Objects.equals(LineInput[1], accounts.get(i).getName())){
                            FromExists=true;
                        }
                        //check to
                        if (Objects.equals(LineInput[2], accounts.get(i).getName())){
                            ToExists=true;
                        }
                    }
                    //add new accounts
                    if (!FromExists){accounts.add(new account(LineInput[1],0));}
                    if (!ToExists){accounts.add(new account(LineInput[2],0));}
                }else {
                    FirstSkipped = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i<accounts.size(); i++){
            System.out.println(accounts.get(i).getName());
        }
    }
}
