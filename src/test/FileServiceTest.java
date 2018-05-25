import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import training.supportbank.Bank;
import training.supportbank.FileService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileServiceTest {

    FileService fs = new FileService("./TestTransactions.csv");

    @Test
    public void returnsASetOfAccountNames() {
        Set<String> expected = new HashSet<String>();
        String[] names = {"Sarah T", "Laura B", "Tim L", "Jon A", "Stephen S"};
        expected.addAll(Arrays.asList(names));
        assertEquals(expected, fs.getAccountNames());
    }
    
    @Test
    public void returnsAListOfTransactions() {
       String[] transaction1 = {"01/01/2014", "Jon A", "Sarah T", "Pokemon Training", "7.8"};
       String[] transaction2 = {"04/01/2014", "Stephen S", "Tim L", "Lunch", "4.37"};
       String[] transaction3 = {"08/01/2014", "Laura B", "Stephen S", "Lunch", "5.09"};
       List<String[]> expected = new ArrayList<>();
       expected.add(transaction1);
       expected.add(transaction2);
       expected.add(transaction3);
       assertArrayEquals(expected.toArray(), fs.getTransactions().toArray());
    }
    

}
