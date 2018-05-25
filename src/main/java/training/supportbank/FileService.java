package training.supportbank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {

    private final String filePath;

    public FileService(String filePath) {
        this.filePath = filePath;
    }


    public Set<String> getAccountNames() {
        Stream<String[]> stream = parseCSV();
        Set<String> accountNames = stream
                .map(line -> line[1])
                .collect(Collectors.toSet());
        stream = parseCSV();
        Set<String> otherAccountNames = stream.map(line -> line[2])
                .collect(Collectors.toSet());
        accountNames.addAll(otherAccountNames);
        return accountNames;
    }

    public List<String[]> getTransactions() {
        List<String[]> transactions = new ArrayList<String[]>();
        Stream<String[]> data = parseCSV();
        data.forEach(line -> transactions.add(line));
        return transactions;
    }

    private Stream<String[]> parseCSV() {
        FileReader csvData = null;
        try {
            csvData = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        BufferedReader br = new BufferedReader(csvData);
        Stream<String[]> dataStream = br.lines()
                .skip(1)
                .map(line -> line.split(","));
        return dataStream;
    }
}
