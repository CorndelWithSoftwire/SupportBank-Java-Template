package training.supportbank;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String args[]) {
        // Your code here!
    //    System.out.println("Test!");
//        Scanner scanne = new Scanner()
        readFile();

    }
    public static void readFile(){
     //   Path filePath = Paths.get("Transactions/Transactions2014.csv");
     //   List<String> reader = null;

      //  String[][] data = {{""}, {""}, };
        int i = 0;
        int j = 0;
      //  data = new String[][];

        BufferedReader reader;
        try {
             reader = new BufferedReader(new FileReader("Transactions/Transactions2014.csv"));
             String line = reader.readLine();
             line = reader.readLine();

          //   String[] splitData = line.split(",");
          //  System.out.println(splitData);


             while (line != null){
             //    data[i][j] = line;
               //  System.out.println(line);

                // j++;
                 String[] splitData = line.split(",");

                 Transactions newTran = new Transactions(splitData[0], splitData[1], splitData[2], splitData[3], Double.valueOf(splitData[4]));
                 line = reader.readLine();
                 System.out.println(newTran);
               //  System.out.println(splitData);



             }
             reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // System.out.println(reader);
    }

}
