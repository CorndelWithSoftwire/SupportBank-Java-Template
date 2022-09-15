package training.supportbank;
import java.time.LocalDate;
public class Transaction {
    //elements
    private LocalDate date;
    private String fromAccount;
    private String toAccount;
    private String narrative;
    private float amount;

    //constructor
    public Transaction(LocalDate date, String from, String to, String narrative, float amount) {
        this.date = date;
        this.fromAccount = from;
        this.toAccount = to;
        this.narrative = narrative;
        this.amount = amount;
    }
    //getters
    public String getFrom() {
        return fromAccount;
    }
    public String getTo() {
        return toAccount;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getNarrative() {
        return narrative;
    }
    public float getAmount() {return amount; }
}
