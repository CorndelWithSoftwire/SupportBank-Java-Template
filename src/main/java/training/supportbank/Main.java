package training.supportbank;
import org.apache.commons.lang3.ObjectUtils;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        //variables
        final DecimalFormat currency = new DecimalFormat("£0.00");
        ArrayList<account> accounts = new ArrayList();
        ArrayList<Transaction> transactions = new ArrayList();
        //Load CSV
        String line;
        boolean FirstSkipped = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Transactions2014.csv"));
            while ((line = reader.readLine()) != null) {
                if (FirstSkipped) {
                    //load into transactions
                    String[] LineInput = line.split(",");
                    String[] SplitDate = LineInput[0].split("/");
                    LocalDate date = LocalDate.of(Integer.parseInt(SplitDate[2]), Integer.parseInt(SplitDate[1]), Integer.parseInt(SplitDate[0]));
                    Transaction NewTrans = new Transaction(date, LineInput[1], LineInput[2], LineInput[3], Float.parseFloat(LineInput[4]));
                    transactions.add(NewTrans);
                    //check for new accounts
                    boolean ToExists = false;
                    boolean FromExists = false;
                    for (int i = 0; i < accounts.size(); i++) {
                        //check from
                        if (Objects.equals(LineInput[1], accounts.get(i).getName())) {
                            FromExists = true;
                            accounts.get(i).AddBal(-1*Float.parseFloat(LineInput[4]));
                        }
                        //check to
                        if (Objects.equals(LineInput[2], accounts.get(i).getName())) {
                            ToExists = true;
                            accounts.get(i).AddBal(Float.parseFloat(LineInput[4]));
                        }
                    }
                    //add new accounts & update balances
                    if (!FromExists) {
                        accounts.add(new account(LineInput[1], 0));
                        accounts.get(accounts.size()-1).AddBal(-1*Float.parseFloat(LineInput[4]));
                    }
                    if (!ToExists) {
                        accounts.add(new account(LineInput[2], 0));
                        accounts.get(accounts.size()-1).AddBal(Float.parseFloat(LineInput[4]));
                    }
                } else {
                    FirstSkipped = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i).getName() + " " + currency.format(accounts.get(i).getBalance()));
        }*/
        //Main menu loop
        Scanner myScan = new Scanner(System.in);
        String menuOption = "";
        boolean contLoop = true;
        while (contLoop){
            System.out.println("Input command:\n•List <account/ALL>\n•quit");
            menuOption = myScan.nextLine();
            //parse command
            String[] splitCommand = menuOption.split(" ");
            String command = splitCommand[0];
            String myArgs = "";//usually this would be a list but there's only ever going to be one arg at the moment
            for(int i = 1; i<splitCommand.length;i++){
                myArgs = myArgs + splitCommand[i];
                if(i != splitCommand.length-1){
                    myArgs = myArgs+" ";
                }
            }
            //execute command
            if (Objects.equals(command,"List")){

            } else if (Objects.equals(command, "quit")) {
                contLoop = false;
            }else{
                System.out.println("Invalid Command!");
            }
        }
    }
}
