package training.supportbank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        BufferedReader reader;
        try {
             reader = new BufferedReader(new FileReader("Transactions/Transactions2014.csv"));
             String line = reader.readLine();
             while (line != null){
                 System.out.println(line);
                 line = reader.readLine();
             }
             reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // System.out.println(reader);
    }

}
class Transactions {
    public static void Date(){

    }
    public static void To(){

    }
    public static void From(){

    }
    public static void Amount(){

    }
}