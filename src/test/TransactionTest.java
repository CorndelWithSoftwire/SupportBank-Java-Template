import org.junit.jupiter.api.Test;
import training.supportbank.Transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {

    Transaction t = new Transaction("22/07/2017", "personFrom", "personTo", "narrative", "21.70");

    @Test
    public void exampleTest() {assertEquals(true, true);}
}
